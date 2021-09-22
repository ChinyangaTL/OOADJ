package org.chinyangatl.controller;

import org.chinyangatl.Manager;
import org.chinyangatl.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
    public static final String DB_NAME = "eplv1";
    public static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/" + DB_NAME;
    public static final String USERNAME = "root";
    public static final String PASSWORD = "1234";


    public static final String TABLE_MANAGER = "manager";
    public static final String COLUMN_MANAGER_FNAME = "first_name";
    public static final String COLUMN_MANAGER_LNAME = "last_name";
    public static final String COLUMN_MANAGER_COACHING_LICENSE = "coaching_license";
    public static final String COLUMN_MANAGER_BIRTH_DATE = "birth_date";
    public static final String COLUMN_MANAGER_CURRENT_CLUB = "club_id";

    public static final String TABLE_CLUB = "club";
    public static final String COLUMN_CLUB_NAME = "club_name";
    public static final String COLUMN_CLUB_ID = "club_id";
//    public static final String COLUMN_MANAGER_COACHING_LICENSE = "coaching_license";
//    public static final String COLUMN_MANAGER_BIRTH_DATE = "birth_date";
//    public static final String COLUMN_MANAGER_CURRENT_CLUB = "club_id";

    public static final int ORDER_BY_NONE = 1;
    public static final int ORDER_BY_ASC = 2;
    public static final int ORDER_BY_DESC = 3;

    public static final String QUERY_MANAGERS_START =
            "SELECT * FROM " + TABLE_MANAGER + " ";
    public static final String QUERY_MANAGER_SORT =
            "ORDER BY " + TABLE_MANAGER + "." + COLUMN_MANAGER_LNAME + " ";

    public static final String QUERY_CLUB_MANAGER =
            "SELECT " + TABLE_MANAGER + "." + COLUMN_MANAGER_LNAME + ", " +
            TABLE_CLUB + "." + COLUMN_CLUB_NAME + " FROM " + TABLE_MANAGER + " JOIN " + TABLE_CLUB +
            " ON " + TABLE_MANAGER + "." + COLUMN_MANAGER_CURRENT_CLUB + " = "
            + TABLE_CLUB + "." + COLUMN_CLUB_ID;


    private Connection connection;
    public boolean open() {
        try {
        connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
            System.out.println("Connected to " + CONNECTION_STRING + USERNAME + PASSWORD);
            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to db " + e.getMessage());
        return false;
        }
    }

    public void close() {
        try {
            if(connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Couldn't close connection " + e.getMessage());
        }
    }

    public List<Manager> queryManagers(int sortOrder) {
        StringBuilder query = new StringBuilder(QUERY_MANAGERS_START);
//        StringBuilder stringBuilder = new StringBuilder(QUERY_MANAGERS_START);
//        System.out.println(stringBuilder.toString());



        if (sortOrder != ORDER_BY_NONE) {
            query.append(QUERY_MANAGER_SORT);
            if (sortOrder == ORDER_BY_DESC)
                query.append("DESC");
            else
                query.append("ASC");
        }

            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query.toString())) {

                List<Manager> managers = new ArrayList<>();
                while (resultSet.next()) {
                    Manager manager = new Manager();
                    manager.setCoachingLicense(resultSet.getString(1));
                    manager.setFirstName(resultSet.getString(2));
                    manager.setLastName(resultSet.getString(3));
                    manager.setCurrentClub(resultSet.getString(5));
                    managers.add(manager);
                }
                return managers;

            } catch (SQLException e) {
                System.out.println("Query failed " + e.getMessage());
                return null;
            }
        }

    public String queryClubManager(String clubName) {
        StringBuilder stringBuilder = new StringBuilder(QUERY_CLUB_MANAGER);
        stringBuilder.append(" WHERE " + TABLE_CLUB + "." + COLUMN_CLUB_NAME + " = " + "'" + clubName + "'");

        System.out.println(stringBuilder.toString());

        try(Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(stringBuilder.toString());
                Manager manager = new Manager();
            while (result.next()) {
                manager.setLastName(result.getString(1));
            }

               return clubName + "'s manager: " + manager.getLastName();
           } catch (SQLException e) {
            System.out.println(e.getMessage());
        return null;
        }
    }


}
