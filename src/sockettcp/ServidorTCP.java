/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockettcp;

import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author judit
 */
public class ServidorTCP {
    
    private static final String _IP = "25.72.27.24";
    private static final int _PUERTO = 1234;
    private static final int _BACKLOG = 50;

    public static void main(String args[]) throws UnknownHostException {
        InetAddress ip = InetAddress.getByName(_IP);

        SimpleDateFormat fecha = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat hora = new SimpleDateFormat("HH:mm:ss");

        System.out.println("\nEscuchando en: ");
        System.out.println("IP Host = " + ip.getHostAddress());
        System.out.println("Puerto = " + _PUERTO);
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(_PUERTO,_BACKLOG,ip);
        }catch (IOException ioe){
            System.err.println("Error aal abrir el socket de servidor : " + ioe);
            System.exit(-1);
        }
        while (true){
            try{
                Socket socketPeticion = serverSocket.accept();

                DataInputStream datosEntrada = new DataInputStream( new BufferedInputStream(socketPeticion.getInputStream()));
                DataOutputStream datosSalida = new DataOutputStream(socketPeticion.getOutputStream());

                int puertoRemitente = socketPeticion.getPort();

                InetAddress ipRemitente = socketPeticion.getInetAddress();

                char tipoDato = datosEntrada.readChar();

                int longitud = datosEntrada.readInt();

                if (tipoDato == 's'){
                    byte[] bytesDatos = new byte[longitud];

                    boolean finData = false;

                    StringBuilder dataEnMensaje = new StringBuilder(longitud);

                    int totalBytesLeidos = 0;

                    while (!finData){
                        int bytesActualesLeidos = datosEntrada.read(bytesDatos);

                        totalBytesLeidos = bytesActualesLeidos + totalBytesLeidos;

                        if (totalBytesLeidos <= longitud){
                            dataEnMensaje.append(new String(bytesDatos, 0, bytesActualesLeidos, StandardCharsets.UTF_8));
                        } else {
                            dataEnMensaje.append(new String(bytesDatos, 0, longitud - totalBytesLeidos + bytesActualesLeidos, StandardCharsets.UTF_8));
                        }
                        if (dataEnMensaje.length() >= longitud)
                        finData = true;
                    }
                    
                String[] lstEntradaServidor = dataEnMensaje.toString().split(",");                
                double tmpCliente = Double.valueOf(lstEntradaServidor[0]);
                double hmdCliente = Double.valueOf(lstEntradaServidor[1]);
                double co2Cliente = Double.valueOf(lstEntradaServidor[2]);
                
                String resultadoTmp = "false";
                String resultadoHmd = "false";
                String resultadoCo2 = "false";
                
                if(tmpCliente<16 || tmpCliente>39){
                    resultadoTmp = "true";
                }

                if(hmdCliente>80){
                    resultadoHmd = "true";
                }

                if(co2Cliente>3000){
                    resultadoCo2 = "true";
                }           
                
                DaoRespuesta dao = new DaoRespuesta();
                
                dao.guardar(new RespuestaPojo(
                        fecha.format(new Date()), hora.format(new Date()), ipRemitente.toString(), 
                        String.valueOf(puertoRemitente) , String.valueOf(tmpCliente), 
                        String.valueOf(hmdCliente), String.valueOf(co2Cliente), String.valueOf(resultadoTmp), 
                        String.valueOf(resultadoHmd), String.valueOf(resultadoCo2))
                );
                
                String salida = resultadoTmp + "," + resultadoHmd + "," + resultadoCo2;;
                                
                datosSalida.writeUTF(salida);
                
                System.out.println("Fecha = " + fecha.format(new Date()) + "\tHora =" + hora.format(new Date()) + "\tCliente = " + ipRemitente + ":" + puertoRemitente 
                                       + "\tEntrada = " + tmpCliente + ", " + hmdCliente + ", " + co2Cliente 
                                        + "\tSalida = " + resultadoTmp + ", " + resultadoHmd + ", " + resultadoCo2);
                }                               
                
                datosEntrada.close();
                datosSalida.close();
                socketPeticion.close();
            } catch (Exception e){
                System.err.println("Se ha producido la excepcion : " + e);
            }
        }

    }
}
