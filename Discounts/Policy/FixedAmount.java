package Discounts.Policy;

public class FixedAmount {
    private int discountAmount;

    public FixedAmount(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    public int calDiscountPrice (int price) {
        return price - discountAmount;
    }
}
