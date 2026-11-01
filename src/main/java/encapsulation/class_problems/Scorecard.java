package encapsulation.class_problems;

public class Scorecard {
    private final boolean[] results;
    private int recorded;

    public Scorecard(int totalQuestions) {
        results = new boolean[totalQuestions];
    }

    public void recordAnswer(boolean correct) {
        if (recorded == results.length) {
            System.out.println("Answer ignored: all " + results.length + " questions already recorded");
            return;
        }
        results[recorded++] = correct;
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < recorded; i++) {
            if (results[i]) score++;
        }
        return score;
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        System.out.println("getScore() -> " + sc.getScore());
        sc.recordAnswer(true);
        System.out.println("getScore() -> " + sc.getScore());
    }
}
