package org.example;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        MontyHallSimulator simulator = new MontyHallSimulator();

        Map<Integer, GameResult> results = simulator.runSimulation(1000);

        System.out.println("Результаты игры:");
        for (int i = 1; i <= 1000; i++) {
            GameResult result = results.get(i);
            if (result != null) {
                System.out.printf("%d шаг: %s\n", i, result.isWin() ? "Победа" : "Поражение");
            }
        }

        int wins = (int) results.values().stream().filter(GameResult::isWin).count();
        int losses = (int) results.values().stream().filter(r -> !r.isWin()).count();

        double winPercentage = ((double) wins / 1000) * 100;

        System.out.println("\nИтоговая статистика:");
        System.out.println("Количество побед: " + wins);
        System.out.println("Процент побед: " + String.format("%.2f%%", winPercentage));
        System.out.println("Количество поражений: " + losses);
    }
}