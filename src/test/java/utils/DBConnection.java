package utils;

import java.sql.*;

public class DBConnection {
    private Connection connect = null;
    private Statement statement = null;

    public void connect(){
        try {
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/qa09?"
                                + "user=root&password=password02&useSSL=true&serverTimezone=GMT");
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ResultSet selectFrom(String tableName) {
        try {
            return statement
                    .executeQuery(String.format("select * from %s", tableName));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public ResultSet select(String query) {
        try {
            return statement
                    .executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    public static void writeResultSet(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("full_name");
            System.out.println("ID: " + id);
            System.out.println("NAME: " + name);
        }
    }

    // You need to close the resultSet
    public void close() {
        try {

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        }catch (Exception ignored) {
        }
    }

}
