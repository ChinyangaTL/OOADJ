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

    public static final String QUERY_CLUB_MANAGER_PREP =
            "SELECT " + TABLE_MANAGER + "." + COLUMN_MANAGER_LNAME + ", " +
                    TABLE_CLUB + "." + COLUMN_CLUB_NAME + " FROM " + TABLE_MANAGER + " JOIN " + TABLE_CLUB +
                    " ON " + TABLE_MANAGER + "." + COLUMN_MANAGER_CURRENT_CLUB + " = "
                    + TABLE_CLUB + "." + COLUMN_CLUB_ID + " WHERE " + TABLE_CLUB + "." + COLUMN_CLUB_NAME + " = ?";

    // check if values to be inserted already exist
    public static final String QUERY_CLUB = "SELECT " +
            COLUMN_CLUB_ID + " FROM " + TABLE_CLUB + " WHERE "
            + COLUMN_CLUB_NAME + " = ?";

    // statemetns needed to insert a manager
    public static final String INSERT_CLUB =
            "INSERT INTO " + TABLE_CLUB + '(' + COLUMN_CLUB_NAME + ") VALUES(?)";

    public static final String INSERT_MANAGER =
            "INSERT INTO " + TABLE_MANAGER +
                    '(' + COLUMN_MANAGER_FNAME + ", " + COLUMN_MANAGER_LNAME + ", " + COLUMN_MANAGER_CURRENT_CLUB + ") " +
                    "VALUES(?, ?, ?)";

    private Connection connection;
    private PreparedStatement queryClubManager;

    private PreparedStatement queryClub;

    private PreparedStatement insertIntoClub;
    private PreparedStatement insertIntoManager;

    public boolean open() {
        try {
        connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
        queryClubManager = connection.prepareStatement(QUERY_CLUB_MANAGER_PREP);
        insertIntoClub = connection.prepareStatement(INSERT_CLUB, Statement.RETURN_GENERATED_KEYS);
        queryClub = connection.prepareStatement(QUERY_CLUB);
        insertIntoManager = connection.prepareStatement(INSERT_MANAGER);
            System.out.println("Connected to " + CONNECTION_STRING + USERNAME + PASSWORD);
            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to db " + e.getMessage());
        return false;
        }
    }

    public void close() {
        try {
            if(queryClubManager != null) {
                queryClubManager.close();
            }
            if(insertIntoClub != null) {
                insertIntoClub.close();
            }
            if(insertIntoManager != null) {
                insertIntoManager.close();
            }
            if(queryClub != null) {
                queryClub.close();
            }
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

//    public String queryClubManager(String clubName) {
//        StringBuilder stringBuilder = new StringBuilder(QUERY_CLUB_MANAGER);
//        stringBuilder.append(" WHERE " + TABLE_CLUB + "." + COLUMN_CLUB_NAME + " = " + "'" + clubName + "'");
//
//        System.out.println(stringBuilder.toString());
//
//        try(Statement statement = connection.createStatement()) {
//            ResultSet result = statement.executeQuery(stringBuilder.toString());
//                Manager manager = new Manager();
//            while (result.next()) {
//                manager.setLastName(result.getString(1));
//            }
//
//               return clubName + "'s manager: " + manager.getLastName();
//           } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        return null;
//        }
//    }

    public String queryClubManager(String clubName) {
        try{
            queryClubManager.setString(1, clubName);
            ResultSet result = queryClubManager.executeQuery();;
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

    private int insertClub(String clubName) throws SQLException{
        queryClub.setString(1, clubName);
        ResultSet resultSet = queryClub.executeQuery();
        // club already exists, ie found in db, return that id
        if(resultSet.next()) {
            return resultSet.getInt(1);
        } else {
            // club doesnt exist,
            insertIntoClub.setString(1, clubName);
            int affectedRows = insertIntoClub.executeUpdate();

            if(affectedRows != 1) {
                throw new SQLException("Couldn't insert club");
            }

            // get the id returned
            ResultSet generatedKeys = insertIntoClub.getGeneratedKeys();
            if(generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Couldnt get id for club");
            }
        }
    }

    public void insertManager(String fName, String lName, String clubName) {
        try {
            connection.setAutoCommit(false);
            int clubId = insertClub(clubName);
            insertIntoManager.setString(1, fName);
            insertIntoManager.setString(2, lName);
            insertIntoManager.setInt(3, clubId);
            System.out.println(fName + ", " + lName + ", " + clubId);

            int affectedRows = insertIntoClub.executeUpdate();
            if(affectedRows == 1) {
//                success
                connection.commit();
            } else {
                throw new SQLException("Couldn't insert song " );
            }
        } catch (SQLException e) {
            System.out.println("Insert Manager exception: " + e.getMessage());
        } finally {
            try {
                System.out.println("Reset default commit behaviour");
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println("Couldn't reset auto commit " + e.getMessage());
            }
        }
    }


}
