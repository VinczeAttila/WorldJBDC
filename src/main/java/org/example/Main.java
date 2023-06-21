package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        new Main().run();
    }

    public void run() {

        Printer printer = new Printer();
        printer.printMenu();
        UserInput userInput = new UserInput();
        int userChoice = userInput.chooseMainMenu();
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5436/ak", "root", "root");) {
            Operation operation = new Operation(connection, userInput);

            switch (userChoice) {
                case 1 -> {
                    operation.firstQueryCall();
                }
                case 2 -> {
                    operation.secondQueryCall();
                }
                case 3 -> {
                    operation.thirdQueryCall();
                }
                case 4 -> {
                    operation.fourthQueryCall();
                }
                case 5 -> {
                    operation.fifthQueryCall();
                }
                case 6 -> {
                    operation.sixthQueryCall();

                }
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}

