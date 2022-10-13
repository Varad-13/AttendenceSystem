package com.miniproject.attendencesystem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dbGetStudentDetails {
    dbUser db = new dbUser();
    int rollNo;
    static String name;
    static int year;
    static String division;
    static String department;
    public static int attn1, attn2, attn3, attn4, attn5;
    private static final String Authenticate = "SELECT * FROM attendence WHERE faceData = MD5(?)";
    private static final String RollNo = "SELECT * FROM attendence WHERE rollNo = ?";
    private static final String UPDATE1 = "UPDATE attendence SET attendence1 = ? WHERE faceData = MD5(?);";
    private static final String UPDATE2 = "UPDATE attendence SET attendence2 = ? WHERE faceData = MD5(?);";
    private static final String UPDATE3 = "UPDATE attendence SET attendence3 = ? WHERE faceData = MD5(?);";
    private static final String UPDATE4 = "UPDATE attendence SET attendence4 = ? WHERE faceData = MD5(?);";
    private static final String UPDATE5 = "UPDATE attendence SET attendence5 = ? WHERE faceData = MD5(?);";
    private static final String SET_MAX_ATTENDENCE = "UPDATE attendence SET attendence1 = ?, attendence2 = ?, attendence3 = ?, attendence4 = ?, attendence5 = ? WHERE rollNo = 1;";

    private static final String UPDATE_STUDENT = "UPDATE attendence set (name, division, year, department) VALUES (?, ?, ?, ?)";

    public void getStudent(String faceData) throws SQLException {
        try (Connection connection = db.connectDatabase();
             PreparedStatement preparedStatement = connection.prepareStatement(Authenticate)) {
            preparedStatement.setString(1, faceData);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                rollNo = rs.getInt("rollNo");
                name = rs.getString("name");
                year = rs.getInt("year");
                division = rs.getString("division");
                department = rs.getString("Department");
                attn1 = rs.getInt("attendence1");
                attn2 = rs.getInt("attendence2");
                attn3 = rs.getInt("attendence3");
                attn4 = rs.getInt("attendence4");
                attn5 = rs.getInt("attendence5");
            }
        }
    }
    public void rollNo(int rollNo) throws SQLException {
        try (Connection connection = db.connectDatabase();
             PreparedStatement preparedStatement = connection.prepareStatement(RollNo)) {
            preparedStatement.setInt(1, rollNo);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                name = rs.getString("name");
                year = rs.getInt("year");
                division = rs.getString("division");
                department = rs.getString("Department");
                attn1 = rs.getInt("attendence1");
                attn2 = rs.getInt("attendence2");
                attn3 = rs.getInt("attendence3");
                attn4 = rs.getInt("attendence4");
                attn5 = rs.getInt("attendence5");
            }
        }
    }

    public void Updateattn1(int a1, String face) throws SQLException {
        try (Connection connection = db.connectDatabase();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE1)) {
            preparedStatement.setInt(1, a1);
            preparedStatement.setString(2, face);
            preparedStatement.executeUpdate();
        }
    }
    public void Updateattn2(int a1, String face) throws SQLException {
        try (Connection connection = db.connectDatabase();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE2)) {
            preparedStatement.setInt(1, a1);
            preparedStatement.setString(2, face);
            preparedStatement.executeUpdate();
        }
    }
    public void Updateattn3(int a1, String face) throws SQLException {
        try (Connection connection = db.connectDatabase();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE3)) {
            preparedStatement.setInt(1, a1);
            preparedStatement.setString(2, face);
            preparedStatement.executeUpdate();
        }
    }
    public void Updateattn4(int a1, String face) throws SQLException {
        try (Connection connection = db.connectDatabase();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE4)) {
            preparedStatement.setInt(1, a1);
            preparedStatement.setString(2, face);
            preparedStatement.executeUpdate();
        }
    }
    public void Updateattn5(int a1, String face) throws SQLException {
        try (Connection connection = db.connectDatabase();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE5)) {
            preparedStatement.setInt(1, a1);
            preparedStatement.setString(2, face);
            preparedStatement.executeUpdate();
        }
    }
    public void updateMaxAttendence(int s1, int s2, int s3, int s4, int s5) throws SQLException {
        try (Connection connection = db.connectDatabase();
             PreparedStatement preparedStatement = connection.prepareStatement(SET_MAX_ATTENDENCE)) {
            preparedStatement.setInt(1, s1);
            preparedStatement.setInt(2, s2);
            preparedStatement.setInt(3, s3);
            preparedStatement.setInt(4, s4);
            preparedStatement.setInt(5, s5);
            preparedStatement.executeUpdate();
        }
    }
    public void updateStudentDetails(String name, String division, int year, String department) throws IOException, SQLException {
        try (Connection connection = db.connectDatabase();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, division);
            preparedStatement.setInt(3, year);
            preparedStatement.setString(4, department);
            preparedStatement.executeUpdate();
            alertController alert = new alertController();
            alert.launch("Updated successfully", "Success");
        }
    }
}

