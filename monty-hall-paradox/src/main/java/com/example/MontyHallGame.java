package com.example;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Random;

@Getter
@Setter
public class MontyHallGame {

    private final Random random = new Random();
    private final HashMap<Integer, String> results = new HashMap<>();

    public void playGame(int rounds) {
        int winsSwitch = 0;
        int winsStay = 0;

        for (int i = 1; i <= rounds; i++) {
            boolean resultSwitch = playRound(true);
            boolean resultStay = playRound(false);

            if (resultSwitch) {
                winsSwitch++;
            }
            if (resultStay) {
                winsStay++;
            }

            results.put(i, String.format("Round %d: Switch Win: %b, Stay Win: %b", i, resultSwitch, resultStay));
        }

        System.out.println("Total Wins by Switching: " + winsSwitch);
        System.out.println("Total Wins by Staying: " + winsStay);
    }

    private boolean playRound(boolean switchChoice) {
        // 0 - goat, 1 - goat, 2 - car
        int[] doors = {0, 0, 1};
        shuffleArray(doors);

        // Player makes a choice
        int playerChoice = random.nextInt(3);

        // Monty opens a door
        int montyOpens = openDoor(doors, playerChoice);

        // If the player switches, change the choice
        if (switchChoice) {
            playerChoice = switchDoor(playerChoice, montyOpens);
        }

        // Return true if the player wins the car
        return doors[playerChoice] == 1;
    }

    private int openDoor(int[] doors, int playerChoice) {
        for (int i = 0; i < doors.length; i++) {
            if (i != playerChoice && doors[i] == 0) {
                return i; // Monty opens a door with a goat
            }
        }
        return -1; // Should never reach here
    }

    private int switchDoor(int playerChoice, int montyOpens) {
        for (int i = 0; i < 3; i++) {
            if (i != playerChoice && i != montyOpens) {
                return i; // Switch to the remaining door
            }
        }
        return -1; // Should never reach here
    }

    private void shuffleArray(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            // Simple swap
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
    public HashMap<Integer, String> getResults(){
        return results;
    }

}
