package Products.Burgers;

import Products.Product;

public class Burgers extends Product {

    boolean isBurgerSet;
    int burgerSetPrice;

    public Burgers(int id, String name, int price, int kcal, boolean isBurgerSet, int burgerSetPrice) {
        super(id, name, price, kcal);
        this.isBurgerSet = isBurgerSet;
        this.burgerSetPrice = burgerSetPrice;
    }

    public boolean isBurgerSet() {
        return isBurgerSet;
    }
    public void setBurgerSet(boolean isBurgerSet) {
        this.isBurgerSet = isBurgerSet;
    }
    public int getBurgerSetPrice() {
        return burgerSetPrice;
    }
    public void setBurgerSetPrice(boolean burgerSetPrice) {
        this.burgerSetPrice = burgerSetPrice;
    }
}
