package polymorphism.class_problems;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExamQuestionGrader {

    static abstract class Question {
        String type;
        String text;
        String correctAnswer;
        String studentAnswer;
        int points;

        Question(String type, String text, String correctAnswer, String studentAnswer, int points) {
            this.type = type;
            this.text = text;
            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }

        abstract double score();
    }

    static class McqQuestion extends Question {
        McqQuestion(String text, String correctAnswer, String studentAnswer, int points) {
            super("MCQ", text, correctAnswer, studentAnswer, points);
        }

        double score() {
            return studentAnswer.equals(correctAnswer) ? points : 0;
        }
    }

    static class TrueFalseQuestion extends Question {
        TrueFalseQuestion(String text, String correctAnswer, String studentAnswer, int points) {
            super("TF", text, correctAnswer, studentAnswer, points);
        }

        double score() {
            return studentAnswer.equals(correctAnswer) ? points : 0;
        }
    }

    static class EssayQuestion extends Question {
        EssayQuestion(String text, String correctAnswer, String studentAnswer, int points) {
            super("ESSAY", text, correctAnswer, studentAnswer, points);
        }

        double score() {
            String answer = studentAnswer.toLowerCase();
            int matched = 0;
            for (String keyword : correctAnswer.split(",")) {
                String k = keyword.trim().toLowerCase();
                if (!k.isEmpty() && answer.contains(k)) matched++;
            }
            if (matched >= 2) return points * 0.75;
            if (matched == 1) return points * 0.50;
            return 0;
        }
    }

    static Question create(String type, String text, String correct, String student, int points) {
        switch (type) {
            case "MCQ": return new McqQuestion(text, correct, student, points);
            case "TF": return new TrueFalseQuestion(text, correct, student, points);
            case "ESSAY": return new EssayQuestion(text, correct, student, points);
            default: throw new IllegalArgumentException("Unknown question type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pattern line = Pattern.compile("^(\\w+)\\s+\"(.*?)\"\\s+\"(.*?)\"\\s+\"(.*?)\"\\s+(\\d+)$");
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            Matcher m = line.matcher(sc.nextLine().trim());
            if (!m.matches()) throw new IllegalArgumentException("Invalid question line");
            Question q = create(m.group(1), m.group(2), m.group(3), m.group(4), Integer.parseInt(m.group(5)));
            double score = q.score();
            total += score;
            System.out.println(String.format(Locale.US, "%s: %.2f", q.type, score));
        }
        System.out.println(String.format(Locale.US, "Total Score: %.2f", total));
    }
}
