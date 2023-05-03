package utilities;

import org.checkerframework.checker.units.qual.C;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtilities {

    private static final String URL = Config.getValue("dbUrl");
    private static final String USER = Config.getValue("dbUsername");
    private static final String PASSWORD = Config.getValue("dbPassword");

    /**
     * Establish  a connection to the database
     *
     * @return a Connection
     */
    public static Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
    /**
     * Executes a SQL query and returns the first cell value of the result set.
     *
     * @param query the SQL query
     * @return the first cell value
     */

    public static Object getSingleCellValue(String query,String column){
        Object result = null;
        try(Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)){
            if(resultSet.next()){
                result = resultSet.getObject(column);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }return  result;
    }

    public  static List<List<String>> getQueryResultAsListOfList(String query){
        List<List<String>> resultList = new ArrayList<>();
        ResultSet resultSet = getResultSet(query);

        try{
            while(resultSet.next()){
                List<String> rowList = new ArrayList<>();
                for(int i =1; i <= resultSet.getMetaData().getColumnCount();i++){
                    rowList.add(resultSet.getString(i));
                }
                resultList.add(rowList);
            }

        }catch (SQLException e){
            e.printStackTrace();

        }

        return resultList;
    }

    /**
     *  This method accepts String query, runs it and returns the output
     * @param query
     * @return
     */


    public static ResultSet  getResultSet(String query){
        ResultSet resultSet = null;

        try{
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return resultSet;
    }

    /**
     *
     * @param query
     * prints all results from the given query
     */
    public static void printResults( String query){
        List<List<String>> results = getQueryResultAsListOfList(query);
        for(List<String> rows:results){
            System.out.println(rows);
        }
}
























}
