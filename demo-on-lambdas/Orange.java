public class Orange extends Fruit {
    Orange(String f_type, double weight, double price_per_kg, int quantity) {
        super(f_type, weight, price_per_kg, quantity);
    }
    @Override
    void whoAmI() {
        System.out.println("I am an orange!\n");
    }
}