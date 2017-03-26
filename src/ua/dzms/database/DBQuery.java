package ua.dzms.database;

import com.mysql.jdbc.Connection;

import java.sql.*;

public class DBQuery {

    public DBQuery(String query) throws SQLException {
        executeQuery(query);
    }

    private void executeQuery(String query) {
        Connection dbConnection = getConnection();
        try {
            Statement statement = dbConnection.createStatement();
            if (statement.execute(query)) {
                print(statement.getResultSet());

            } else {
                System.out.print("You query is done");
            }
            statement.close();
            dbConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private Connection getConnection() {
        Connection connection = null;
        try {
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?",
                    "root", "admin");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private void print(ResultSet resultSet) {
        StringBuilder answerDB = new StringBuilder();
        try {
            while (resultSet.next()) {
                int count = resultSet.getMetaData().getColumnCount();
                for (int i = 1; i <= count; i++) {
                    String temp = resultSet.getMetaData().getColumnName(i);
                    answerDB.append(temp);
                    answerDB.append(" = ");
                    answerDB.append(resultSet.getString(temp));
                    answerDB.append(", ");
                }
                answerDB.append("\n");
            }
            System.out.print(answerDB);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
