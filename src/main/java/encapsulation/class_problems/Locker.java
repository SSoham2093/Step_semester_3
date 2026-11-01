package encapsulation.class_problems;

public class Locker {
    private String code;
    private final int lockerNumber;

    public Locker(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (!code.equals(currentCode)) {
            return false;
        }
        code = newCode;
        return true;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        System.out.println("changeCode(1234 -> 5678): " + (l.changeCode("1234", "5678") ? "success" : "rejected"));
        System.out.println("changeCode(0000 -> 9999): " + (l.changeCode("0000", "9999") ? "success" : "rejected, code is still unchanged"));
        System.out.println("changeCode(5678 -> 4321): " + (l.changeCode("5678", "4321") ? "success" : "rejected"));
    }
}
