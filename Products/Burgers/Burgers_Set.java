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
    public Burgers_Set (Burgers_Set burgersSet) {
        super(burgersSet.getName(), burgersSet.getPrice(), burgersSet.getKcal());
        this.burgers = new Burgers(burgersSet.burgers);
        this.side = new Side(burgersSet.side);
        this.beverage = new Beverage(burgersSet.beverage);
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
