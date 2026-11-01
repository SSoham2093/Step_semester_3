package encapsulation.class_problems;

public final class NameTag {
    private final String firstName;
    private final String lastName;

    public NameTag(String fullName) {
        String[] parts = fullName.split(" ");
        this.firstName = parts[0];
        this.lastName = parts[1];
    }

    public String getNickname() {
        return firstName + " " + lastName.charAt(0) + ".";
    }

    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        NameTag same = new NameTag("Maria Gomez");
        System.out.println("getNickname() -> " + tag.getNickname());
        System.out.println("same nickname: " + tag.getNickname().equals(same.getNickname()));
        System.out.println("same object: " + (tag == same));
    }
}
