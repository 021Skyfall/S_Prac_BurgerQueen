package Products.Burgers;

import Products.Beverages.Beverage;
import Products.Product;
import Products.Sides.Side;

public class Burgers_Set extends Product {

    private Burgers burgers;
    private Beverage beverage;
    private Side side;

    public Burgers_Set(String name, int price, int kcal, Burgers burgers, Beverage beverage, Side side) {
        super(name, price, kcal);
        this.burgers = burgers;
        this.beverage = beverage;
        this.side = side;
    }

    public Burgers_Set(int id, String name, int price, int kcal) {
        super(id, name, price, kcal);

    }

    public Burgers getBurgers() {
        return burgers;
    }

    public Beverage getBeverage() {
        return beverage;
    }

    public Side getSide() {
        return side;
    }

}
