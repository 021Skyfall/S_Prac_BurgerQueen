package Discounts.Policy;

public class FixedRate implements Policy{
    private int dicountRate;

    public FixedRate(int dicountRate) {
        this.dicountRate = dicountRate;
    }
    public int calDiscountPrice (int price) {
        return price - (price * dicountRate / 100);
    }
}
