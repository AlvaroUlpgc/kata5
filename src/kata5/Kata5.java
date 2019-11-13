package kata5;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kata5 {

    private Connection connection;  
    
    public static void main(String[] args) {
        String URL_BD_SQLite = new String("jdbc:sqlite:C:\\Users\\Usuario\\Documents\\NetBeansProjects\\DB_SQLite\\miercoles.db");
        Connection connection = connect(URL_BD_SQLite);
        selectData_PEOPLE(connection);
    }

    private static Connection connect(String URL_BD_SQLite) {
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(URL_BD_SQLite);
            System.out.println("Base de datos conectada");
            return connection;
        } 
        catch (SQLException exception) {
            System.out.println("ERROR Kata5:: connect (SQLException)" + exception.getMessage());
        }

        return connection;
    }
    
    private static void selectData_PEOPLE(Connection connection) {
        String SQL = "SELECT * FROM PEOPLE";
        try{
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery(SQL);
            System.out.println("ID \t NAME \t APELLIDOS \t DEPARTAMENTO");
            while(resultset.next()){
                System.out.println(resultset.getInt("ID") + "\t " 
                                    + resultset.getString("NAME") + "\t " 
                                    + resultset.getString("APELLIDOS") + "\t "
                                    + resultset.getString("DEPARTAMENTO"));
            }
        }
        catch (SQLException exception){
            System.out.println("ERROR Kata5:: connect (SQLException)" + exception.getMessage());
        }
    }
    
}
