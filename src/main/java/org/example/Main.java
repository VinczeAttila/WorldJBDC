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
        Operation operation = new Operation();
        int userChoice = userInput.chooseMainMenu();
        if (userChoice == 1) {
        operation.firstQueryCall();
        } else if (userChoice == 2){
            operation.secondQueryCall();
        }else if (userChoice == 3){
            operation.thirdQueryCall();
        }else if (userChoice == 4){
            operation.fourthQueryCall();
        }else if (userChoice == 5){
            operation.fifthQueryCall();
        }else if (userChoice == 6){
            operation.sixthQueryCall();
        }
    }
}

