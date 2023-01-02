package Kiosk.Function;

import Products.Beverages.Beverage;
import Products.Burgers.Burgers;
import Products.Product;
import Products.Sides.Side;

public class Menu_Function {
    private Product[] products;

    public Menu_Function(Product[] products) {
        this.products = products;
    }

    public void printMenu() {
        System.out.println("[🔻] 메뉴");
        System.out.println("-".repeat(50));

        PrintBurger();

        System.out.println();
        PrintSide();

        System.out.println();
        PrintBeverage();

        System.out.println();

        System.out.println("🧺 (0) 장바구니");
        System.out.println("📦 (+) 주문하기");
        System.out.println("-".repeat(50));
        System.out.print("[📣] 메뉴를 선택해주세요 : ");
    }

    private void PrintBeverage() {
        System.out.println("\uD83E\uDD64 음료");
        for (Product product : products) {
            if(product instanceof Beverage) {
                ex_printMenu(product);
            }
        }
    }

    private void PrintSide() {
        System.out.println("🍟 사이드");
        for(Product product : products) {
            if(product instanceof Side) {
                ex_printMenu(product);
            }
        }
    }

    private void PrintBurger() {
        System.out.println("🍔 햄버거");
        for(Product product : products) {
            if(product instanceof Burgers) {
                ex_printMenu(product);
            }
        }
    }

    private static void ex_printMenu(Product product) {
        System.out.printf(
                "   (%d) %s %5dKcal %5d원\n",
                product.getId(), product.getName(), product.getKcal(), product.getPrice()
        );
    }
}
