package com.example.architectureproject;

import java.sql.*;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
public class LoginSignupExample {


    public static void main(String[] args) {
        //SpringApplication.run(LoginSignupExample.class, args);
        String connectionString = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "Seisagatova20082020^^";

        try {
            Connection connection = DriverManager.getConnection(connectionString, username, password);
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter username for signup: ");
            String signupUsername = scanner.nextLine();
            System.out.print("Enter password for signup: ");
            String signupPassword = scanner.nextLine();
            signup(connection, signupUsername, signupPassword);

            // Perform login
            System.out.print("\nEnter username for login: ");
            String loginUsername = scanner.nextLine();
            System.out.print("Enter password for login: ");
            String loginPassword = scanner.nextLine();
            boolean loggedIn = login(connection, loginUsername, loginPassword);
            if (loggedIn) {
                System.out.println("\nLogin successful!");
            } else {
                System.out.println("\nInvalid username or password.");
            }
            connection.close();
            scanner.close();
        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
        }
    }

    // Method for signup
    private static void signup(Connection connection, String username, String password) throws SQLException {
        String signupSQL = "INSERT INTO database (username, password) VALUES ( ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(signupSQL)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
            System.out.println("Signup successful!");
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Username already exists. Please choose a different username.");
        }
    }

    // Method for login
    private static boolean login(Connection connection, String username, String password) throws SQLException {
        String loginSQL = "SELECT * FROM database WHERE username = ? AND password = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(loginSQL)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        }
    }
}

