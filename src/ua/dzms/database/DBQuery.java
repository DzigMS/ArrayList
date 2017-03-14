package ua.dzms.database;

import com.mysql.jdbc.*;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBQuery {

    public DBQuery(String query) throws SQLException {
        Connection dbConnection = getConnection();
        Statement statement = (Statement) dbConnection.createStatement();
        StringBuilder answerDB = new StringBuilder();

        if (statement.execute(query)) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int count = resultSet.getMetaData().getColumnCount();
                for (int i = 1; i <= count; i++) {
                    String temp = resultSet.getMetaData().getColumnName(i);
                    answerDB.append(temp + "=" + resultSet.getString(temp) + ", ");
                }
                answerDB.append("\n");
            }
            resultSet.close();
        }else {
            answerDB.append("All is OK");
        }
        statement.close();
        dbConnection.close();
        System.out.print(answerDB);

    }

    private Connection getConnection() throws SQLException {
        return (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false",
                "root", "admin");
    }
}
