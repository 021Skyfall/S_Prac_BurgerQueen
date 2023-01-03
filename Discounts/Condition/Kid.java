package Discounts.Condition;

import Discounts.Policy.FixedAmount;

import java.util.Scanner;

public class Kid {
    private boolean isSatisfied;
    private FixedAmount fixedAmount = new FixedAmount(500);

    public boolean isSatisfied() {
        return isSatisfied;
    }

    private void setSatisfied(boolean satisfied) {
        isSatisfied = satisfied;
    }

    public void checkDiscountCondition() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("나이가 어떻게 되십니까?");
        int input = Integer.parseInt(scanner.nextLine());

        setSatisfied(input < 20);
    }
    public int applyDiscount(int price) {
        return fixedAmount.calDiscountPrice(price);
    }
}
