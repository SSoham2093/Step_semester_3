package encapsulation.assigment_problems;

public class TrafficLight {
    private String color = "RED";
    private final String id;

    public TrafficLight(String id) {
        this.id = id;
    }

    public String next() {
        if (color.equals("RED")) color = "GREEN";
        else if (color.equals("GREEN")) color = "YELLOW";
        else color = "RED";
        return color;
    }

    public String getColor() {
        return color;
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println("getColor() -> " + t.getColor());
        for (int i = 0; i < 4; i++) {
            System.out.println("next() -> " + t.next());
        }
    }
}
