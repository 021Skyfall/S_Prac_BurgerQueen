package Products.Beverages;

import Products.Product;

public class Beverage extends Product {

    private boolean hasStraw;

    public Beverage(int id, String name, int price, int kcal, boolean hasStraw) {
        super(id, name, price, kcal);
        this.hasStraw = hasStraw;
    }

    public boolean hasStraw() {
        return hasStraw;
    }

    public void setHasStraw(boolean hasStraw) {
        this.hasStraw = hasStraw;
    }
}
