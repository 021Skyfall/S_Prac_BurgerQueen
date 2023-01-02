package Products.Beverages;

import Products.Product;

public class Beverage extends Product {

    boolean straw;

    public Beverage(int id, String name, int price, int kcal) {
        super(id, name, price, kcal);
        this.straw = straw;
    }

    public boolean Straw() {
        return straw;
    }

    public void setStraw(boolean straw) {
        this.straw = straw;
    }
}
