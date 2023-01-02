package Kiosk;

import Kiosk.Function.Cart_Function;
import Kiosk.Function.Menu_Function;
import Kiosk.Function.Order_Function;
import Products.List.Product_Repository;
import Products.Product;

import java.util.Scanner;

public class Kiosk {

    Product_Repository productRepository = new Product_Repository();
    Product[] products = productRepository.getProducts();
    Menu_Function menuFunction = new Menu_Function(products);
    Cart_Function cartFunction = new Cart_Function(productRepository,menuFunction);

    public void start(){
        System.out.println("🍔 BurgerQueen Order Service");
        Scanner scanner = new Scanner(System.in);

        while(true) {
            menuFunction.printMenu();
            String option = scanner.nextLine();
            if (option.equals("+")) {
                //주문 내역 출력
                break;
            } else {
                int menuNumber = Integer.parseInt(option);
                if (menuNumber == 0) cartFunction.printCart();
                else if (1 <= menuNumber && menuNumber <= productRepository.getProducts().length) {
                    cartFunction.addToCart(menuNumber);
                }

            }
        }
    }

}
