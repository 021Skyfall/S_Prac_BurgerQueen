package Products.Sides;

import Products.Product;

public class Side extends Product {

    int ketchup;

    public Side(int id, String name, int price, int kcal) {
        super(id, name, price, kcal);
    }

    public int getKetchup() {
        return ketchup;
    }

    public void setKetchup(int ketchup) {
        this.ketchup = ketchup;
    }
}
