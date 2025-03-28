package task;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 创建一些商品
        Product apple = new Product("苹果", 5.0, 30);
        Product banana = new Product("香蕉", 3.0, 20);
        Product orange = new Product("橙子", 4.0, 25);

        // 购物车实例
        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n======= 购物车系统 =======");
            System.out.println("1. 添加商品");
            System.out.println("2. 移除商品");
            System.out.println("3. 查看购物车");
            System.out.println("4. 退出");
            System.out.print("请输入你的选择（1-4）：");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 处理换行符

            switch (choice) {
                case 1:
                    System.out.println("选择要添加的商品：1. 苹果  2. 香蕉  3. 橙子");
                    int productChoice = scanner.nextInt();
                    System.out.print("请输入数量：");
                    int quantity = scanner.nextInt();

                    if (productChoice == 1) cart.addProduct(apple, quantity);
                    else if (productChoice == 2) cart.addProduct(banana, quantity);
                    else if (productChoice == 3) cart.addProduct(orange, quantity);
                    else System.out.println("无效选择！");
                    break;

                case 2:
                    System.out.print("请输入要移除的商品名称：");
                    String removeName = scanner.next();
                    System.out.print("请输入要减少的数量：");
                    int removeQuantity = scanner.nextInt();
                    cart.removeProduct(removeName, removeQuantity);
                    break;

                case 3:
                    cart.viewCart();
                    break;

                case 4:
                    System.out.println("退出系统！");
                    scanner.close();
                    return;

                default:
                    System.out.println("无效输入，请重新选择！");
            }
        }
    }
}
