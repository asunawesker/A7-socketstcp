/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockettcp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asunawesker
 */
public class DaoRespuesta {
    private Connection cx;
    private PreparedStatement preQuery;
    
    public DaoRespuesta() { cx = Conexion.getSingletonInstancia().getConnection(); }
    
    public void guardar(RespuestaPojo pojo){
        try {
            preQuery = cx.prepareStatement("INSERT INTO registro ("
                    + "fecha, hora, ipCliente, puerto, tmpCliente, hmdCliente, co2Cliente, tmpNotificacion, hmdNotificacion, co2Notificacion)"
                    + " VALUES ( ?, ? , ?, ?, ?, ?, ?, ?, ?, ? )");
            
            preQuery.setString(1, pojo.getFecha());
            preQuery.setString(2, pojo.getHora());
            preQuery.setString(3, pojo.getIpcliente());
            preQuery.setString(4, pojo.getPuerto());
            preQuery.setString(5, pojo.getTmpcliente());
            preQuery.setString(6, pojo.getHmdcliente());
            preQuery.setString(7, pojo.getCo2client());
            preQuery.setString(8, pojo.getTmpnotificacion());
            preQuery.setString(9, pojo.getHmdnotificacion());
            preQuery.setString(10, pojo.getCo2notificacion());
            
            preQuery.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DaoRespuesta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
