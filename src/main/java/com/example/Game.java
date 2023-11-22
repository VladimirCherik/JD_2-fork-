package com.example;

import java.util.Scanner;

public class Game {

    private static final char X_CHAR = 'X';
    private static final char O_CHAR = 'O';
    private static final char BLANK_CHAR = ' ';

    private static final byte WINNER_MARKER = 1;
    private static final byte LOSER_MARKER = 2;
    private static final byte DRAW_MARKER = 3;
    private static final int[][] TARGET_COMBINATION = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7},
            {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    private final Scanner scan = new Scanner(System.in);
    byte input;
    byte rand;
    byte i;
    boolean boxAvailable;
    byte winner;
    char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    PrintService printService;

    public Game() {
        printService = new PrintService();

    }

    @SuppressWarnings({"java:S3776", "java:S135"})

    public void startGame() {

        //Start the game.

        printService.printStartMessage();

        boolean boxReadyToGame = false;

        while (true) {

            printService.printDesk(box);

            //Cleaning the box after presentation
            if(!boxReadyToGame){
                for(i = 0; i < 9; i++) {
                    box[i] = ' ';
                }
                boxReadyToGame = true;
            }

            // Checking if the game is over
            if(isGameOver()){
                break;
            }

            //Reading and writing a new character from gamer
            while (true) {
                input = scan.nextByte();
                if (input > 0 && input < 10) {
                    if (box[input - 1] != BLANK_CHAR)
                        printService.printThisOneAlreadyUsed();
                    else {
                        box[input - 1] = X_CHAR;
                        break;
                    }
                }
                else {
                    printService.printInvalidInput();
                }
            }

            // Checking if have had the winning combination
            if(isCompletedCombination(X_CHAR)){
                winner = WINNER_MARKER;
                continue;
            }

            // Checking if have had the draw combination
            boxAvailable = false;
            for(i=0; i<9; i++){
                if(box[i] == BLANK_CHAR){
                    boxAvailable = true;
                    break;
                }
            }
            if(!boxAvailable){
                winner = DRAW_MARKER;
                continue;
            }

            // Computer's move
            while (true) {
                rand = (byte) (Math.random() * 9 + 1);
                if (box[rand - 1] == BLANK_CHAR) {
                    box[rand - 1] = O_CHAR;
                    break;
                }
            }
            // Checking if have had the losing combination
            if(isCompletedCombination(O_CHAR)){
                winner = LOSER_MARKER;
            }
        }

    }
    private boolean isCompletedCombination(char characterToCheck){

        boolean isCombination = false;

        for (int[] combinations : TARGET_COMBINATION) {
            if(box[combinations[0]]==characterToCheck && box[combinations[1]]==characterToCheck
                    && box[combinations[2]]==characterToCheck){
                isCombination = true;
                break;
            }
        }
        return isCombination;

    }

    private boolean isGameOver(){

        boolean gameOver = false;

        if(winner == WINNER_MARKER){
            printService.printResultGameWin();
            gameOver = true;

        } else if(winner == LOSER_MARKER){
            printService.printResultGameLoser();
            gameOver = true;

        } else if(winner == DRAW_MARKER){
            printService.printResultGameDraw();
            gameOver = true;
        }
        return gameOver;

    }
}