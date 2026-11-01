package classes_and_objects.assigment_problems;

public class MessWalletManagement {
    static class MessWallet {
        private double balance;

        public MessWallet(double balance) {
            if (balance < 0) {
                System.out.println("Warning: negative opening balance, starting at 0");
                this.balance = 0;
            } else {
                this.balance = balance;
            }
        }

        public void topUp(double amount) {
            if (amount <= 0) {
                System.out.println("Top-up rejected: amount must be positive");
                return;
            }
            balance += amount;
        }

        public void deduct(double amount) {
            if (amount > balance) {
                System.out.println("Deduct rejected: insufficient balance");
                return;
            }
            balance -= amount;
        }

        public double getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) {
        MessWallet w = new MessWallet(500);
        w.topUp(200);
        System.out.println("Balance after top-up: " + w.getBalance());
        w.deduct(1000);
        System.out.println("Final balance: " + w.getBalance());
    }
}
