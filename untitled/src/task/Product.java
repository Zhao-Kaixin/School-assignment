package task;

public class Product {
    private String name;
    private double price;
    private int stock;

    // 构造方法
    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    // Getter 方法（提供外部访问）
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }

    // Setter 方法（修改库存）
    public void setStock(int stock) { this.stock = stock; }

    @Override
    public String toString() {
        return name + "（价格：" + price + " 元，库存：" + stock + "）";
    }
}
