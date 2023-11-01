/*
 * Clase conexión a base de datos MySQL
 */
package gt.edu.umg.vehiculosapi.util;
 
import java.sql.Connection;
import java.sql.DriverManager;
 
public class MySqlConexion {
        
    static {
        try {
            // CARGAR EL CONTROLADOR DE BD
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("[MySqlConexion] Error al cargar el driver de conexión");
            e.printStackTrace();
        }
    }
 
    // Glassfish 4.2.1 y MYSQL 8.0 (que ahora tiene caching_sha2_password) no son compatible entre sí. Actualice su versión de Glassfish o use Apache
    // https://stackoverflow.com/questions/51586401/glassfish-keystore-error-after-adding-mysql-connector/52129961
    public static Connection obtenerConexion() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/vehiculos?useTimezone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false", "root", "");
        } catch (Exception e) {
            System.out.println("[MySqlConexion] Error al obtener la conexión: ");
            e.printStackTrace();
        }
        return con;
    }
     
}