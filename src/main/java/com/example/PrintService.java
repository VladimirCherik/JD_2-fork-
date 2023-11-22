package com.example;

@SuppressWarnings("java:S106")

public class PrintService {

    public void printDesk (char[] box){

        System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");

    }



    public  void printResultGameWin() {
        System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
    }
    public  void printResultGameLoser() {
        System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
    }
    public  void printResultGameDraw() {
        System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
    }
    public void printStartMessage() {
        System.out.println("Enter box number to select. Enjoy!\n");
    }
    public void printThisOneAlreadyUsed(){
        System.out.println("That one is already in use. Enter another.");
    }
    public void printInvalidInput(){
        System.out.println("Invalid input. Enter again.");
    }

}
