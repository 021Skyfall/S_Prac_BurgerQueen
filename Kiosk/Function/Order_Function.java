package Kiosk.Function;

import Discounts.Condition.Coz;
import Discounts.Condition.Kid;
import Discounts.DS_Condition;
import Discounts.Discount;
import Discounts.Policy.FixedAmount;
import Discounts.Policy.FixedRate;

public class Order_Function {
    Cart_Function cartFunction;
    private Discount discount;

    public Order_Function(Cart_Function cartFunction, Discount discount) {
        this.cartFunction = cartFunction;
        this.discount = discount;
    }

    public void makeOrder() {
        discount.checkAllDiscounts();

        int totalPrice = cartFunction.totalPrice();
        int finalPrice = discount.discount(totalPrice);

        System.out.println("[📣] 주문이 완료되었습니다. ");
        System.out.println("[📣] 주문 내역은 다음과 같습니다. ");
        System.out.println("-".repeat(50));

        cartFunction.printCartItems();

        System.out.println("-".repeat(50));
        System.out.printf("금액 합계     : %d원\n",totalPrice);
        System.out.printf("할인 적용 금액 : %d원\n", finalPrice);

    }
}
