package com.example;

public class Main {
    public static void main(String[] args) {
        MontyHallGame game = new MontyHallGame();
        game.playGame(1000);

        // Вывод результатов по каждому раунду
        game.getResults().forEach((round, result) -> System.out.println(result));
    }
}
