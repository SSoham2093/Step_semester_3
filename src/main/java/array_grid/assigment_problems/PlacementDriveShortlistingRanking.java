package array_grid.assigment_problems;

import java.util.Arrays;

public class PlacementDriveShortlistingRanking {

    static class Candidate implements Comparable<Candidate> {
        String name;
        double cgpa;
        int codingScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        double compositeScore() {
            return cgpa * 10 + codingScore * 0.5;
        }

        static boolean isEligible(double cgpa) {
            return cgpa >= 7.5;
        }

        static boolean isEligible(double cgpa, int codingScore) {
            return cgpa >= 6.5 && codingScore >= 60;
        }

        @Override
        public int compareTo(Candidate other) {
            return Double.compare(other.compositeScore(), this.compositeScore());
        }
    }

    static String shortlistAndRank(Candidate[] candidates) {
        int count = 0;
        for (int i = 0; i < candidates.length; i++) {
            if (Candidate.isEligible(candidates[i].cgpa) ||
                Candidate.isEligible(candidates[i].cgpa, candidates[i].codingScore)) {
                count++;
            }
        }

        Candidate[] shortlisted = new Candidate[count];
        int idx = 0;
        for (int i = 0; i < candidates.length; i++) {
            if (Candidate.isEligible(candidates[i].cgpa) ||
                Candidate.isEligible(candidates[i].cgpa, candidates[i].codingScore)) {
                shortlisted[idx++] = candidates[i];
            }
        }

        Arrays.sort(shortlisted);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shortlisted.length; i++) {
            if (i > 0) sb.append(" | ");
            sb.append(i + 1).append(". ").append(shortlisted[i].name)
              .append(" (").append(shortlisted[i].compositeScore()).append(")");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };
        System.out.println(shortlistAndRank(candidates));
    }
}
