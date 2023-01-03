package Products.Burgers;

import Products.Product;

public class Burgers extends Product {

    private boolean isBurgerSet;
    private int burgerSetPrice;

    public Burgers(int id, String name, int price, int kcal, boolean isBurgerSet, int burgerSetPrice) {
        super(id, name, price, kcal);
        this.isBurgerSet = isBurgerSet;
        this.burgerSetPrice = burgerSetPrice;
    }
    public Burgers (Burgers burgers) {
        super(burgers.getName(), burgers.getPrice(), burgers.getKcal());
        this.isBurgerSet = burgers.isBurgerSet();
        this.burgerSetPrice = getBurgerSetPrice();
    }

    public boolean isBurgerSet() {
        return isBurgerSet;
    }
    public void setIsBurgerSet(boolean isBurgerSet) {
        this.isBurgerSet = isBurgerSet;
    }
    public int getBurgerSetPrice() {
        return burgerSetPrice;
    }
    public void setBurgerSetPrice() {this.burgerSetPrice = burgerSetPrice;}
}
