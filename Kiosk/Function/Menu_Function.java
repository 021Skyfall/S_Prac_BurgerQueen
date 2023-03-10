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
        System.out.println("[๐ป] ๋ฉ๋ด");
        System.out.println("-".repeat(50));

        PrintBurger(true);

        System.out.println();
        PrintSide(true);

        System.out.println();
        PrintBeverage(true);

        System.out.println();

        System.out.println("๐งบ (0) ์ฅ๋ฐ๊ตฌ๋");
        System.out.println("๐ฆ (+) ์ฃผ๋ฌธํ๊ธฐ");
        System.out.println("-".repeat(50));
        System.out.print("[๐ฃ] ๋ฉ๋ด๋ฅผ ์ ํํด์ฃผ์ธ์ : ");
    }

    void PrintBeverage(boolean printPrice) {
        System.out.println("\uD83E\uDD64 ์๋ฃ");
        for (Product product : products) {
            if(product instanceof Beverage) {
                ex_printMenu(product, printPrice);
            }
        }
    }

    void PrintSide(boolean printPrice) {
        System.out.println("๐ ์ฌ์ด๋");
        for(Product product : products) {
            if(product instanceof Side) {
                ex_printMenu(product, printPrice);
            }
        }
    }

    void PrintBurger(boolean printPrice) {
        System.out.println("๐ ํ๋ฒ๊ฑฐ");
        for(Product product : products) {
            if(product instanceof Burgers) {
                ex_printMenu(product, printPrice);
            }
        }
    }

    private void ex_printMenu(Product product, boolean printPrice) {
        if (printPrice) {
            System.out.printf(
                    "   (%d) %s %5dKcal %5d์\n",
                    product.getId(), product.getName(), product.getKcal(), product.getPrice());
        } else {
            System.out.printf("  (%d) %s %5dKcal\n",
                    product.getId(),product.getName(),product.getKcal());
        }
    }
}
