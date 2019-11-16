
package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

class DataBase {
    private final String URL;
    private Connection connection = null;
    
    DataBase(String URL) {
        this.URL=URL;
        
    }

    void open() {
        try {
            this.connection = DriverManager.getConnection(this.URL);
            System.out.println("Base de datos Abierta");
        } catch (SQLException ex) {
            System.out.println("ERROR database open error exception");
        }
    }

    void close() {
            try {
                if(this.connection != null){
                    this.connection.close();
                    System.out.println("Base de datos cerrada");
                }
            } catch (SQLException ex) {
                System.out.println("ERROR database close error exception");
            }
        
    }

    void selectPEOPLE() {
        String SQL = "SELECT * FROM PEOPLE";
        try {
            Statement statement= this.connection.createStatement(); //Crea la sentencia
            ResultSet resultset= statement.executeQuery(SQL);     //ejecuta la sentencia pasandole el STRING
            System.out.println("ID \t NAME \t surname \t department");
            while(resultset.next()){
                System.out.println(resultset.getInt("ID") + " \t" + 
                                    resultset.getString("name") + " \t" + 
                                    resultset.getString("surname") + " \t" + 
                                    resultset.getString("department") + " \t");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void insertPEOPLE(People people) {
        String SQL= "INSERT INTO PEOPLE(name, surmane, department) VALUES (?,?,?)";
        
        try {
            PreparedStatement preparedstatement = this.connection.prepareStatement(SQL);
            preparedstatement.setString(1, people.getName());
            preparedstatement.setString(2, people.getSurname());
            preparedstatement.setString(3, people.getDepartment());
            preparedstatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
