
package cs;

import java.sql.*;
import datos.Conexion;

public class TestFunciones {

    public static void main(String[] args) {
        
        int empleadoId = 100;
        try {
            Connection conn = Conexion.getConnection();
            CallableStatement cstmt = null;
            double salarioMensual;
            
            cstmt = conn.prepareCall("{ ? = call get_employee_salary(?) }");
            
            cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
            
            cstmt.setInt(2, empleadoId);
            cstmt.execute();
            salarioMensual = cstmt.getDouble(1);
            cstmt.close();
            System.out.println("Empleado con id: " + empleadoId);
            System.out.println("Salario $: " + salarioMensual);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
