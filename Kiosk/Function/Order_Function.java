package Kiosk.Function;

import Discounts.Condition.Coz;
import Discounts.Condition.Kid;
import Discounts.DS_Condition;
import Discounts.Policy.FixedAmount;
import Discounts.Policy.FixedRate;

public class Order_Function {
    Cart_Function cartFunction;
    private DS_Condition[] dsConditions;

    public Order_Function(Cart_Function cartFunction,DS_Condition[] dsCondition) {
        this.cartFunction = cartFunction;
        this.dsConditions = dsCondition;
    }

    public void makeOrder() {

        int totalPrice = cartFunction.totalPrice();
        int finalPrice = totalPrice;

        for (DS_Condition dsCondition : dsConditions) {
            dsCondition.checkDiscountCondition();
            if (dsCondition.isSatisfied()) finalPrice = dsCondition.applyDiscount(finalPrice);
        }

        System.out.println("[📣] 주문이 완료되었습니다. ");
        System.out.println("[📣] 주문 내역은 다음과 같습니다. ");
        System.out.println("-".repeat(50));

        cartFunction.printCartItems();

        System.out.println("-".repeat(50));
        System.out.printf("금액 합계     : %d원\n",totalPrice);
        System.out.printf("할인 적용 금액 : %d원\n", finalPrice);

    }
}
