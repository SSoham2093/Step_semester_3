import java.util.Random;

public class RockPaperScissors {

    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};

    public static void main(String[] args) {
        int rounds = 5;

        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};

        String[] roundPlayerMoves = new String[rounds];
        String[] roundComputerMoves = new String[rounds];
        String[] roundResults = new String[rounds];

        int wins = 0, losses = 0, draws = 0;

        Random random = new Random();

        for (int i = 0; i < rounds; i++) {
            String playerMove = playerMoves[i % playerMoves.length];
            String computerMove = MOVES[random.nextInt(MOVES.length)];

            String result = playRound(playerMove, computerMove);

            roundPlayerMoves[i] = playerMove;
            roundComputerMoves[i] = computerMove;
            roundResults[i] = result;

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        printSummaryTable(roundPlayerMoves, roundComputerMoves, roundResults);
        printFinalStats(wins, losses, draws);
    }

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        boolean playerWins =
                (playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
                (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
                (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"));

        return playerWins ? "Player Wins" : "Computer Wins";
    }

    private static void printSummaryTable(String[] playerMoves, String[] computerMoves, String[] results) {
        System.out.println("=========================================================");
        System.out.printf("%-8s%-15s%-18s%-15s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("=========================================================");

        for (int i = 0; i < playerMoves.length; i++) {
            System.out.printf("%-8d%-15s%-18s%-15s%n",
                    (i + 1), playerMoves[i], computerMoves[i], results[i]);
        }
        System.out.println("=========================================================");
    }

    private static void printFinalStats(int wins, int losses, int draws) {
        int totalRounds = wins + losses + draws;
        double winPercentage = (totalRounds == 0) ? 0.0 : (wins * 100.0) / totalRounds;

        System.out.println();
        System.out.println("Final Summary (after " + totalRounds + " rounds)");
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                wins, losses, draws, winPercentage);
    }
}