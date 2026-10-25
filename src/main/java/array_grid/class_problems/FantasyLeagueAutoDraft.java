package array_grid.class_problems;

import java.util.Arrays;

public class FantasyLeagueAutoDraft {

    static class Player implements Comparable<Player> {
        String name;
        int matchesPlayed;
        double battingAverage;
        boolean injured;

        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        static boolean isDraftable(int matchesPlayed) {
            return matchesPlayed >= 10;
        }

        static boolean isDraftable(int matchesPlayed, boolean injured) {
            return matchesPlayed >= 5 && !injured;
        }

        @Override
        public int compareTo(Player other) {
            return Double.compare(other.battingAverage, this.battingAverage);
        }
    }

    static String draftAndRank(Player[] players) {
        int count = 0;
        for (int i = 0; i < players.length; i++) {
            if (Player.isDraftable(players[i].matchesPlayed) ||
                Player.isDraftable(players[i].matchesPlayed, players[i].injured)) {
                count++;
            }
        }

        Player[] draftable = new Player[count];
        int idx = 0;
        for (int i = 0; i < players.length; i++) {
            if (Player.isDraftable(players[i].matchesPlayed) ||
                Player.isDraftable(players[i].matchesPlayed, players[i].injured)) {
                draftable[idx++] = players[i];
            }
        }

        Arrays.sort(draftable);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < draftable.length; i++) {
            if (i > 0) sb.append(" | ");
            sb.append(i + 1).append(". ").append(draftable[i].name);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };
        System.out.println(draftAndRank(players));
    }
}