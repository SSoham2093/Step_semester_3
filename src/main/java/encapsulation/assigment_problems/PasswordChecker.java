package encapsulation.assigment_problems;

public class PasswordChecker {
    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        int length = password.length();
        if (length < 6) return "Weak";
        if (length < 10) return "Medium";
        return "Strong";
    }

    public static void main(String[] args) {
        System.out.println(new PasswordChecker("abcd").getStrength());
        System.out.println(new PasswordChecker("abcdefgh").getStrength());
        System.out.println(new PasswordChecker("abcdefghijkl").getStrength());
    }
}
