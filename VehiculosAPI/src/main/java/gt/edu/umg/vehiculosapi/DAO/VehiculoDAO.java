/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.vehiculosapi.DAO;

import gt.edu.umg.vehiculosapi.util.MySqlConexion;
import gt.edu.umg.vehiculosapi.DTO.VehiculoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author 50231
 */
public class VehiculoDAO {
    
    public List<VehiculoDTO> getVehiculos(){
        List<VehiculoDTO> productosList = new ArrayList<VehiculoDTO>();
        Connection cn = MySqlConexion.obtenerConexion();
        try {
            String query = "SELECT * FROM vehiculos";
            PreparedStatement ps = cn.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            VehiculoDTO v;
            while (rs.next()) {
                v = new VehiculoDTO(rs.getInt(1),
                                    rs.getString(2), 
                                    rs.getString(3), 
                                    rs.getString(4), 
                                    rs.getInt(5));
                productosList.add(v);
            }
        } catch (SQLException e) {
            System.out.println("[VehiculoDAO] Error al intentar obtener la información: " + e);
        }
        return productosList;
    }

    public int updateVehiculo(VehiculoDTO vehiculo) {
        int resultado = 0;
        String sql = "UPDATE vehiculos SET placa = ?, modelo = ?, color = ?, puertas = ? where id = ?";
        Connection cn = MySqlConexion.obtenerConexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, vehiculo.getPlaca());
            ps.setString(2, vehiculo.getModelo());
            ps.setString(3, vehiculo.getColor());
            ps.setInt(4, vehiculo.getPuertas());
            ps.setInt(5, vehiculo.getId());
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("[VehiculoDAO] Error al intentar actualizar la información: " + e);
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException ex) {
                System.out.println("[VehiculoDAO] Error al intentar cerrar la conexión: " + ex.getMessage());
            }
        }
        return resultado;
    }

    public int setVehiculo(VehiculoDTO vehiculo) {
        int resultado = 0;
        String sql = "INSERT INTO vehiculos(placa, modelo, color, puertas) VALUES(?, ?, ?, ?)";
        Connection cn = MySqlConexion.obtenerConexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, vehiculo.getPlaca());
            ps.setString(2, vehiculo.getModelo());
            ps.setString(3, vehiculo.getColor());
            ps.setInt(4, vehiculo.getPuertas());
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("[VehiculoDAO] Error al intentar ingresar la información: " + e);
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException ex) {
                System.out.println("[VehiculoDAO] Error al intentar cerrar la conexión: " + ex.getMessage());
            }
        }
        return resultado;
    }
}
