import java.util.*;
import java.util.function.Predicate;

enum FruitType {
    APPLE("apple"),
    ORANGE("orange"),
    BANANA("banana"),
    UNKNOWN("unknown");

    private String name;
    private FruitType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
public class Fruit {
    protected FruitType f_type;
    protected double weight;
    protected double price_per_kg;
    protected int quantity;

    public Fruit(String f_type, double weight, double price_per_kg, int quantity) {
        this.weight = weight;
        this.price_per_kg = price_per_kg;
        this.quantity = quantity;
        switch(f_type.toLowerCase()) {
            case "apple":
                this.f_type = FruitType.APPLE;
                break;
            case "orange":
                this.f_type = FruitType.ORANGE;
                break;
            case "banana":
                this.f_type = FruitType.BANANA;
                break;
            default:
                this.f_type = FruitType.UNKNOWN;
        }
    }

    public FruitType getF_type() {
        return f_type;
    }

    public void setF_type(FruitType f_type) {
        this.f_type = f_type;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice_per_kg() {
        return price_per_kg;
    }

    public void setPrice_per_kg(double price_per_kg) {
        this.price_per_kg = price_per_kg;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getWeight() {
        return weight;
    }

    public void setQuantity(int quantity) {
		this.quantity = quantity;
    }

    void whoAmI() {
        System.out.println("I am a fruit!\n");
    }

    static void addFruit(List<Fruit> fruit_list, Fruit f) {
        fruit_list.add(f);
    }

    static void printFruitList(List<Fruit> fruit_list) {
        if (fruit_list == null) return;
        System.out.printf("fruit list len %d\n", fruit_list.size());
        for (Fruit f : fruit_list) {
            assert(f != null);
            System.out.printf("name: %s weight: %.0f\n", 
                                f.getF_type().toString(), 
                                f.getWeight());
        }
    }

    public static <T> List<T> filter(List<T> i_list, Predicate<T> pred) {
        if (i_list == null) return null;
        List<T> o_list = new LinkedList<>();
        for (T itemT : i_list) {
            if(pred.test(itemT)) {
                o_list.add(itemT);
            }
        }
        return o_list;
    }


    static void test1() {
        List<Fruit> fruit_list = new LinkedList<>();
        int fruit_num = 10;
        Random rand = new Random();
        for (int i = 0; i < fruit_num; i++) {
            int rand_int = rand.nextInt(100);
            addFruit(fruit_list, new Apple("apple", rand_int, rand_int, rand_int));
        }

        for (int i = 0; i < fruit_num; i++) {
            int rand_int = rand.nextInt(100);
            addFruit(fruit_list, new Orange("orange", rand_int, rand_int, rand_int));
        }
        printFruitList(fruit_list);
        // keep the fruit with weight above 20
        Predicate<Fruit> weight_filter = (Fruit f) -> f.getWeight() > 20;
        List<Fruit> heavy_fruits = filter(fruit_list, weight_filter);
        System.out.printf("heavy_fruits size: %d original fruit list %d\n", 
                            heavy_fruits.size(), 
                            fruit_list.size());
        
        System.out.println("before sorting based on the weight\n");
        printFruitList(heavy_fruits);
        heavy_fruits.sort(Comparator.comparing(Fruit::getWeight));
        System.out.println("after sorting based on the weight\n");
        printFruitList(heavy_fruits);
    }
    
    public static void main(String[] args) {
        Fruit.test1();
    }
}

    