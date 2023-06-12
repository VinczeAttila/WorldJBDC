package org.example;

import java.util.Scanner;

public class UserInput {

    Scanner scanner = new Scanner(System.in);

    public int chooseMainMenu (){
        String userChoiceString = "";
        do {
            System.out.print("Kérlek válassz a menüből: ");

            userChoiceString = scanner.nextLine();

        } while (!(userChoiceString.equals("1") || userChoiceString.equals("2") || userChoiceString.equals("3") ||
        userChoiceString.equals("4") ||  userChoiceString.equals("5") || userChoiceString.equals("6")));

        return Integer.parseInt(userChoiceString);
    }


    public String chooseCountry(){

    System.out.print("Kérlek válassz egy országot: ");
    String country = scanner.nextLine();

    return country;
    }


    public String chooseContinent(){

        System.out.print("Kérlek válassz egy Kontinenst: ");
        String continent = scanner.nextLine();

        return continent;
    }
    public String chooseCity(){

        System.out.print("Kérlek adj meg egy városnevet: ");
        String city = scanner.nextLine();

        return city;
    }

    public String chooseLanguage(){

        System.out.print("Kérlek adj meg egy nyelvet: ");
        String language = scanner.nextLine();

        return language;
    }
    public Integer chooseNumberOfLanguageSpeaker (){

        System.out.print("Kérlek ad meg minimum lélekszámot: ");
        Integer number = scanner.nextInt();

        return number;
    }

}
