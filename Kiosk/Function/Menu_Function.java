package Kiosk.Function;

import Products.Beverages.Beverage;
import Products.Burgers.Burgers;
import Products.Product;
import Products.Sides.Side;

public class Menu_Function {
    private Product[] products;
    private boolean printPrice;

    public Menu_Function(Product[] products) {
        this.products = products;
    }

    public void printMenu() {
        System.out.println("[🔻] 메뉴");
        System.out.println("-".repeat(50));

        PrintBurger(true);

        System.out.println();
        PrintSide(true);

        System.out.println();
        PrintBeverage(true);

        System.out.println();

        System.out.println("🧺 (0) 장바구니");
        System.out.println("📦 (+) 주문하기");
        System.out.println("-".repeat(50));
        System.out.print("[📣] 메뉴를 선택해주세요 : ");
    }

    void PrintBeverage(boolean printPrice) {
        System.out.println("\uD83E\uDD64 음료");
        for (Product product : products) {
            if(product instanceof Beverage) {
                ex_printMenu(product, printPrice);
            }
        }
    }

    void PrintSide(boolean printPrice) {
        System.out.println("🍟 사이드");
        for(Product product : products) {
            if(product instanceof Side) {
                ex_printMenu(product, printPrice);
            }
        }
    }

    void PrintBurger(boolean printPrice) {
        System.out.println("🍔 햄버거");
        for(Product product : products) {
            if(product instanceof Burgers) {
                ex_printMenu(product, printPrice);
            }
        }
    }

    private void ex_printMenu(Product product, boolean printPrice) {
        if (printPrice) {
            System.out.printf(
                    "   (%d) %s %5dKcal %5d원\n",
                    product.getId(), product.getName(), product.getKcal(), product.getPrice());
        } else {
            System.out.printf("  (%d) %s %5dKcal\n",
                    product.getId(),product.getName(),product.getKcal());
        }
    }
}
