package org.example;

public class Printer {

    public void printMenu() {

        System.out.println("[1]. adott ország városainak listázása a városok nevével és lélekszámával, az utóbbi szerinti csökkenő sorrendben");
        System.out.println("[2]. adott kontinens vagy kontinensek országainak és fővárosainak listázása. A kontinens megadható dzsókeresen."
                + "\n" + " Elsődlegesen a kontinensek, másodlagosan az országok neve szerinti ábécé sorrendben");
        System.out.println("[3]. adott város vagy városok listázása a város nevével, az ország nevével, a lakosságának részarányával a országéhoz képest,"+ "\n" +
                "valamint annak jelzésével, hogy a város főváros-e. A város megadható dzsókeresen. A városok neve szerinti ábécé sorrendben");
        System.out.println("[4]. adott nyelvet beszélő országok listázása az országok nevével, a nyelvet beszélők számával, valamint annak jelzésével, hogy a nyelv ott hivatalos-e." + "\n" +
                "Elsődlegesen az utóbbi szerint, másodlagosan a beszélők száma szerint csökkenő sorrendbe rendezve");
        System.out.println("[5]. adott számot meghaladó beszélővel rendelkező nyelvek listázása, benne a nyelv neve, az országok száma, valamint a beszélők száma."+ "\n" +
                " Az utóbbi szerinti csökkenő sorrendbe rendezve");
        System.out.println("[6]. a kontinensek listázása az átlagos egy főre eső GNP adattal. A listán ne szerepeljen a lényegében lakatlan"+ "\n" +
                " (ill. nagyon alacsony teljes GNP-vel rendelkező) Antarktisz. A sorrend legyen a listázott GNP per capita számok csökkenő sorrendje. " +
                "\n" +"A program a listát követően nyomtassa ki a GNP világátlagot is");
    }
}
