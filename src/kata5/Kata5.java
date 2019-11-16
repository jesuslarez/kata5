
package kata5;

public class Kata5 {

    public static void main(String[] args) {
        String URL = new String("jdbc:sqllite:C:\\Users\\Usuario\\Documents\\NetBeansProjects\\nueva.db");
        //Tambien se puede hacer con el adb en la carpeta del proyecto, ponemos solo nueva.adb
        DataBase database = new DataBase(URL);
        
        database.open();
        
   //     database.selectPEOPLE();
        
        People people = new People("Pepe","Perez","Conserjeria");
 //       database.insertPEOPLE(people);
        
        
 //       database.selectPEOPLE();
        
        database.close();
        
    }
    
}
