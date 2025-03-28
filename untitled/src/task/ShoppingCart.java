package task;

import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Product> cart; // 购物车中的商品列表
    private double totalAmount; // 总金额

    public ShoppingCart() {
        this.cart = new ArrayList<>();
        this.totalAmount = 0;
    }

    // 添加商品到购物车
    public void addProduct(Product product, int quantity) {
        if (product.getStock() >= quantity) {
            // 检查购物车中是否已有该商品
            boolean exists = false;
            for (Product p : cart) {
                if (p.getName().equals(product.getName())) {
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                cart.add(new Product(product.getName(), product.getPrice(), quantity));
            } else {
                for (Product p : cart) {
                    if (p.getName().equals(product.getName())) {
                        p.setStock(p.getStock() + quantity);
                        break;
                    }
                }
            }

            product.setStock(product.getStock() - quantity); // 减少库存
            totalAmount += product.getPrice() * quantity;
            System.out.println("已添加 " + quantity + " 个 " + product.getName() + " 到购物车！");
        } else {
            System.out.println("库存不足！");
        }
    }

    // 从购物车移除商品
    public void removeProduct(String productName, int quantity) {
        for (int i = 0; i < cart.size(); i++) {
            Product p = cart.get(i);
            if (p.getName().equals(productName)) {
                if (p.getStock() > quantity) {
                    p.setStock(p.getStock() - quantity);
                    totalAmount -= p.getPrice() * quantity;
                    System.out.println("减少 " + quantity + " 个 " + productName);
                } else {
                    totalAmount -= p.getPrice() * p.getStock();
                    cart.remove(i);
                    System.out.println(productName + " 已从购物车移除！");
                }
                return;
            }
        }
        System.out.println("购物车中没有该商品！");
    }

    // 查看购物车
    public void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("购物车为空！");
        } else {
            System.out.println("\n购物车内容：");
            for (Product p : cart) {
                System.out.println(p);
            }
            System.out.println("总金额：" + totalAmount + " 元");
        }
    }
}

