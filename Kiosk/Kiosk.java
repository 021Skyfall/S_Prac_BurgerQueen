package Kiosk;

import Discounts.Condition.Coz;
import Discounts.Condition.Kid;
import Discounts.DS_Condition;
import Discounts.Discount;
import Discounts.Policy.FixedAmount;
import Discounts.Policy.FixedRate;
import Kiosk.Function.Cart_Function;
import Kiosk.Function.Menu_Function;
import Kiosk.Function.Order_Function;
import Products.List.Product_Repository;
import Products.Product;

import java.util.Scanner;

public class Kiosk {
    private Product_Repository productRepository;
    private Menu_Function menuFunction;
    private Cart_Function cartFunction;
    private Order_Function orderFunction;

    public Kiosk(Product_Repository productRepository, Menu_Function menuFunction, Cart_Function cartFunction, Order_Function orderFunction) {
        this.productRepository = productRepository;
        this.menuFunction = menuFunction;
        this.cartFunction = cartFunction;
        this.orderFunction = orderFunction;
    }

    public void start(){

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
                else if (1 <= menuNumber && menuNumber <= productRepository.getProducts().length) {
                    cartFunction.addToCart(menuNumber);
                }
            }
        }
    }
}
