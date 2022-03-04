/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockettcp;

/**
 *
 * @author asunawesker
 */
public class RespuestaPojo {
    long id;
    String fecha;
    String hora;
    String ipcliente;
    String puerto;
    String tmpcliente;
    String hmdcliente;
    String co2client;
    String tmpnotificacion;
    String hmdnotificacion;
    String co2notificacion;

    public RespuestaPojo(String fecha, String hora, String ipcliente, String puerto, String tmpcliente, String hmdcliente, String co2client, String tmpnotificacion, String hmdnotificacion, String co2notificacion) {
        this.fecha = fecha;
        this.hora = hora;
        this.ipcliente = ipcliente;
        this.puerto = puerto;
        this.tmpcliente = tmpcliente;
        this.hmdcliente = hmdcliente;
        this.co2client = co2client;
        this.tmpnotificacion = tmpnotificacion;
        this.hmdnotificacion = hmdnotificacion;
        this.co2notificacion = co2notificacion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getIpcliente() {
        return ipcliente;
    }

    public void setIpcliente(String ipcliente) {
        this.ipcliente = ipcliente;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public String getTmpcliente() {
        return tmpcliente;
    }

    public void setTmpcliente(String tmpcliente) {
        this.tmpcliente = tmpcliente;
    }

    public String getHmdcliente() {
        return hmdcliente;
    }

    public void setHmdcliente(String hmdcliente) {
        this.hmdcliente = hmdcliente;
    }

    public String getCo2client() {
        return co2client;
    }

    public void setCo2client(String co2client) {
        this.co2client = co2client;
    }

    public String getTmpnotificacion() {
        return tmpnotificacion;
    }

    public void setTmpnotificacion(String tmpnotificacion) {
        this.tmpnotificacion = tmpnotificacion;
    }

    public String getHmdnotificacion() {
        return hmdnotificacion;
    }

    public void setHmdnotificacion(String hmdnotificacion) {
        this.hmdnotificacion = hmdnotificacion;
    }

    public String getCo2notificacion() {
        return co2notificacion;
    }

    public void setCo2notificacion(String co2notificacion) {
        this.co2notificacion = co2notificacion;
    }
    
    
}
