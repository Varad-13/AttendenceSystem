package com.miniproject.attendencesystem;
import java.io.IOException;
import java.sql.*;


public class dbUser {
    private static final String DATABASE_URL = "jdbc:mysql://database-1.cj5xtfkwqhiq.ap-south-1.rds.amazonaws.com/mini_project";
    private static final String DATABASE_USERNAME = "admin";
    private static final String DATABASE_PASSWORD = "genius123";
    private static final String INSERT_LOGIN = "INSERT INTO attendence (name, division, year, department, faceData) VALUES (?, ?, ?, ?, MD5(?))";
    private static final String CREATE_ADMIN = "INSERT INTO adminData (password) VALUES (MD5(?))";
    private static final String ADMIN_LOGIN = "SELECT * FROM adminData WHERE password = MD5(?)";
    private static final String Authenticate = "Select * FROM attendence WHERE faceData = MD5(?)";
    private static final String RollNo = "Select * FROM attendence WHERE rollNo = ?";

    public Connection connectDatabase() throws SQLException {
        try {
            System.out.println("Connected");
            return DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public boolean checkConnection()  {
        try {
            connectDatabase();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    public void insertAdminDetails(String password) throws SQLException {
        try (Connection connection = connectDatabase();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_ADMIN)) {
            preparedStatement.setString(1, password);
            preparedStatement.executeUpdate();
        }
    }
    public void insertLoginDetails(String name, String division, int year, String department, String faceData) throws IOException, SQLException {
        try (Connection connection = connectDatabase();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LOGIN)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, division);
            preparedStatement.setInt(3, year);
            preparedStatement.setString(4, department);
            preparedStatement.setString(5, faceData);
            preparedStatement.executeUpdate();
            System.out.println("User registration successful");
        }
    }

    public boolean authenticate(String faceData) throws SQLException {
        try (Connection connection = connectDatabase();
             PreparedStatement preparedStatement = connection.prepareStatement(Authenticate)) {
            preparedStatement.setString(1, faceData);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return true;
            }
        }
        return false;
    }
    public boolean admin_login(String password) throws SQLException {
        System.out.println(password);
        try (Connection connection = connectDatabase();
             PreparedStatement preparedStatement = connection.prepareStatement(ADMIN_LOGIN)) {
            preparedStatement.setString(1, password);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return true;
            }
            return false;
        }
    }
    public int getRollno(String faceData) throws SQLException {
        try (Connection connection = connectDatabase();
             PreparedStatement preparedStatement = connection.prepareStatement(Authenticate)) {
            preparedStatement.setString(1, faceData);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                int rollNo;
                rollNo = rs.getInt("rollNo");
                return rollNo;
            }
        }
        return 0;
    }
    public boolean rollNo(int rollNo) throws SQLException {
        try (Connection connection = connectDatabase();
             PreparedStatement preparedStatement = connection.prepareStatement(RollNo)) {
            preparedStatement.setInt(1, rollNo);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return true;
            }
        }
        return false;
    }
}