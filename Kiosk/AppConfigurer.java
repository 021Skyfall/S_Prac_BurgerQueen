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

public class AppConfigurer {
    public Product_Repository productRepository = new Product_Repository();
    public Menu_Function menuFunction = new Menu_Function(productRepository().getProducts());
    public Cart_Function cartFunction = new Cart_Function(productRepository(),menuFunction());
    public Discount discount = new Discount(new DS_Condition[]{
            new Coz(new FixedRate(10)),
            new Kid(new FixedAmount(500))});
    public Product_Repository productRepository() {
        return productRepository;
    }
    public Menu_Function menuFunction() {
        return menuFunction;
    }
    public Cart_Function cartFunction() {
        return cartFunction;
    }
    public Discount discount() {
        return discount;
    }
    public Order_Function orderFunction () {
        return new Order_Function(cartFunction(),discount());
    }
}
