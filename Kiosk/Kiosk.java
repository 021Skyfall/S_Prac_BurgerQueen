package Kiosk;

import Kiosk.Function.Cart_Function;
import Kiosk.Function.Menu_Function;
import Kiosk.Function.Order_Function;
import Products.List.Product_Repository;
import Products.Product;

import java.util.Scanner;

public class Kiosk {

    public void start(){

        Product_Repository productRepository = new Product_Repository();
        Product[] products = productRepository.getProducts();
        Menu_Function menuFunction = new Menu_Function(products);
        Scanner scanner = new Scanner(System.in);

        System.out.println("🍔 BurgerQueen Order Service");

        while(true) {
            menuFunction.printMenu();
            int option = Integer.parseInt(scanner.nextLine());
            if (option == 1) {
                //주문 내역 출력
                break;
            } else if (option == 0) {
                // 장바구니 출력
            } else {

            }
        }
    }

}
