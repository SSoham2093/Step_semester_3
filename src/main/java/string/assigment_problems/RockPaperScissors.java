package string.assigment_problems;

import java.util.*;

public class RockPaperScissors {
    public static String playRound(String player, String computer) {
        if (player.equals(computer)) return "Draw";
        if ((player.equals("Rock") && computer.equals("Scissors")) ||
            (player.equals("Paper") && computer.equals("Rock")) ||
            (player.equals("Scissors") && computer.equals("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }

    public static void main(String[] args) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        Random rand = new Random();
        int wins = 0, losses = 0, draws = 0;

        System.out.println("Round | Player Move | Computer Move | Result");
        for (int i = 0; i < playerMoves.length; i++) {
            String computer = moves[rand.nextInt(3)];
            String result = playRound(playerMoves[i], computer);
            System.out.println((i + 1) + " | " + playerMoves[i] + " | " + computer + " | " + result);
            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;
        }

        double winPercent = (wins * 100.0) / playerMoves.length;
        System.out.println("Wins: " + wins + " | Losses: " + losses + " | Draws: " + draws + " | Win % = " + winPercent + "%");
    }
}