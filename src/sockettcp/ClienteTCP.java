/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockettcp;

import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;

public class ClienteTCP { 

    private static final int _PUERTO = 1234;

    public static void main(String args[]){
        InetAddress ipServidor = null;

        try{
            ipServidor = InetAddress.getByName(args[0]);
        } catch (UnknownHostException uhe){
            System.err.println("Host no encontrado : " + uhe);
            System.exit(-1); 
        }

        Socket socketCliente = null;
        DataInputStream datosRecepcion = null;
        DataOutputStream datosEnvio = null;

        try{
            double tmp = ((-15) + Math.random() * (45 - (-15)));
            String temperatura = new DecimalFormat("##.##").format(tmp);

            double hmd = (50 + Math.random() * (100 - 50));
            String humedad = new DecimalFormat("##.##").format(hmd);

            double co2 = (700 + Math.random() * (5000 - 700));
            String nivelesCo2 = new DecimalFormat("##.##").format(co2);

            char tipo = 's';
            String data = temperatura + "," + humedad + "," + nivelesCo2;
            byte[] dataInBytes = data.getBytes(StandardCharsets.UTF_8);

            socketCliente = new Socket(ipServidor, _PUERTO);

            datosRecepcion = new DataInputStream(socketCliente.getInputStream());
            datosEnvio = new DataOutputStream(socketCliente.getOutputStream());

            datosEnvio.writeChar(tipo);
            datosEnvio.writeInt(dataInBytes.length);
            datosEnvio.write(dataInBytes);

            String resultado = datosRecepcion.readUTF();

            System.out.println("Solicitud = "+ data + "\tResultado = " + resultado);

            datosRecepcion.close();
            datosEnvio.close();                
        } catch (Exception e){
            System.err.println("Se ha producido la excepcion : " + e);
        }

        try{
            if(socketCliente != null)
            socketCliente.close();
        } catch (IOException ioe){
            System.err.println("Error al cerrar el socket : " + ioe);
        }
    }
}
