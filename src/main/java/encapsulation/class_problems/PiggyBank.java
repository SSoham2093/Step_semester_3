package encapsulation.class_problems;

public class PiggyBank {
    private double savings;
    private final String id;

    public PiggyBank(String id) {
        this.id = id;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit rejected: amount must be positive");
            return;
        }
        savings += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0 || amount > savings) {
            System.out.println("Withdraw rejected: savings stay " + savings);
            return;
        }
        savings -= amount;
    }

    public double getSavings() {
        return savings;
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        System.out.println("New piggy bank " + pb.getId() + " -> savings = " + pb.getSavings());
        pb.deposit(100);
        System.out.println("deposit(100) -> savings = " + pb.getSavings());
        pb.withdraw(30);
        System.out.println("withdraw(30) -> savings = " + pb.getSavings());
        pb.withdraw(500);
        System.out.println("withdraw(500) -> savings = " + pb.getSavings());
    }
}
