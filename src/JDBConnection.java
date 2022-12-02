import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.Statement;

public class JDBConnection {
    public static void main(String[] args) {

        AllTables();





            try {

                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/airportdb", "root", "taco");

                System.out.println("Connection Sucessful!.......");

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



    }




}
