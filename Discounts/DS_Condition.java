package Discounts;

public interface DS_Condition {
    void checkDiscountCondition ();
    int applyDiscount(int price);
    boolean isSatisfied();
}
