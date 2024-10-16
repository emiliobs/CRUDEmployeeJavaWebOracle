
package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Emilio
 */
public class ConnectioDB
{

    public Connection getConnection()
    {
        Connection connection = null;
        String user = "c##Emilio_Barrera";
        String password = "eabs";
        String url = "jdbc:oracle:thin:@localhost:1521:free";

        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(url, user, password);
            if (connection != null)
            {
                System.out.println("Successful Connection.");
            }
            else
            {
                System.out.println("Connection Error.");
            }
        }
        catch (ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Connection Error: " + e.getMessage());
        }

        return connection;
    }

    public static void main(String[] args)
    {
        ConnectioDB connectioDB = new ConnectioDB();
        connectioDB.getConnection();
    }
}
