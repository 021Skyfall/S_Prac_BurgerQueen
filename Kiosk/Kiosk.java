package Kiosk;

import Discounts.Condition.Coz;
import Discounts.Condition.Kid;
import Discounts.DS_Condition;
import Discounts.Policy.FixedAmount;
import Discounts.Policy.FixedRate;
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
        Cart_Function cartFunction = new Cart_Function(productRepository,menuFunction);
        Order_Function orderFunction = new Order_Function(cartFunction,new DS_Condition[]{
                new Coz(new FixedRate(10)),
                new Kid(new FixedAmount(500))
        });

        Scanner scanner = new Scanner(System.in);

        System.out.println("🍔 BurgerQueen Order Service");

        while(true) {
            menuFunction.printMenu();
            String option = scanner.nextLine();

            if (option.equals("+")) {
                orderFunction.makeOrder();
                break;
            } else {
                int menuNumber = Integer.parseInt(option);

                if (menuNumber == 0) cartFunction.printCart();
                else if (1 <= menuNumber && menuNumber <= products.length) {
                    cartFunction.addToCart(menuNumber);
                }
            }
        }
    }
}
