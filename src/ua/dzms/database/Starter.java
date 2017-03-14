package ua.dzms.database;

import java.sql.SQLException;
import java.util.Scanner;

public class Starter {
    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("You query:");
        new DBQuery(scanner.nextLine());
    }
}
