package encapsulation.assigment_problems;

public class Cart {
    private final String cartId;
    private final double[] prices;
    private int count;

    public Cart(String cartId, int maxItems) {
        this.cartId = cartId;
        this.prices = new double[maxItems];
    }

    public void addItem(double price) {
        if (price <= 0) {
            System.out.println("Item rejected: price must be positive");
            return;
        }
        if (count == prices.length) {
            System.out.println("Cart is full");
            return;
        }
        prices[count++] = price;
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += prices[i];
        }
        return total;
    }

    public int getItemCount() {
        return count;
    }

    public String getCartId() {
        return cartId;
    }

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);
        System.out.println("getTotal() -> " + cart.getTotal());
        System.out.println("getItemCount() -> " + cart.getItemCount());
    }
}
