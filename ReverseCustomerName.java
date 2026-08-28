public class ReverseCustomerName {

    public static void main(String[] args) {
        String[] testNames = {"Sunil", "Priya", "Alexander", "Java"};

        for (String customerName : testNames) {
            String reversedName = reverseCustomerName(customerName);

            System.out.println("Original Name: " + customerName);
            System.out.println("Reversed Name: " + reversedName);
            System.out.println("---------------------------------");
        }
    }

    public static String reverseCustomerName(String customerName) {
        char[] nameChars = customerName.toCharArray();
        char[] reversedChars = new char[nameChars.length];

        for (int i = 0; i < nameChars.length; i++) {
            reversedChars[i] = nameChars[nameChars.length - 1 - i];
        }

        return new String(reversedChars);
    }
}