package Discounts;

public class Discount {
    private DS_Condition[] dsConditions;

    public Discount(DS_Condition[] dsConditions) {
        this.dsConditions = dsConditions;
    }

    public void checkAllDiscounts() {
        for (DS_Condition dsCondition : dsConditions) {
            dsCondition.checkDiscountCondition();
        }
    }

    public int discount(int price) {

        int discountPrice = price;

        for (DS_Condition dsCondition : dsConditions) {
            if (dsCondition.isSatisfied()) discountPrice = dsCondition.applyDiscount(discountPrice);
        }
        return discountPrice;
    }
}
