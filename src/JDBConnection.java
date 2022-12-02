import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.Statement;

public class JDBConnection {
    public static void main(String[] args) {

        AllTables();
        ReadColumn();



        }

        public static void ReadColumn(){

            try {

                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/airportdb", "root", "taco");
                //Line 20 is a custom based on your local database. Remove "airportdb" and replace with the db that your using. Likewise, use the username and password you used when setting up your database connection.

              //  System.out.println("Connection Sucessful!.......");

                Statement statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery("select * from airport");

                while (resultSet.next()) {
                    System.out.println(resultSet.getString("Country"));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }



        public static void AllTables(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/airportdb", "root", "taco");

            System.out.println("Connection Sucessful!.......");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("Show tables");
            System.out.println("Tables in the current database: ");
            while(resultSet.next()) {
                System.out.print(resultSet.getString(1));
                System.out.println();
            }
            }catch (Exception e) {
                e.printStackTrace();
            }

        System.out.println("-------------------------");
    }




}
