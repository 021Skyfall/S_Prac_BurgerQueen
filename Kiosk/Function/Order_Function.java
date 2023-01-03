package Kiosk.Function;

import Discounts.Condition.Coz;
import Discounts.Condition.Kid;

import java.util.Scanner;

public class Order_Function {
    Cart_Function cartFunction;

    public Order_Function(Cart_Function cartFunction) {
        this.cartFunction = cartFunction;
    }

    public void makeOrder() {
        Coz coz = new Coz();
        Kid kid = new Kid();
        coz.checkDiscountCondition();
        kid.checkDiscountCondition();

        int totalPrice = cartFunction.totalPrice();

        int finalPrice = totalPrice;

        if(coz.isSatisfied()) finalPrice = coz.applyDiscount(finalPrice);
        if(kid.isSatisfied()) finalPrice = kid.applyDiscount(finalPrice);


        System.out.println("[📣] 주문이 완료되었습니다. ");
        System.out.println("[📣] 주문 내역은 다음과 같습니다. ");
        System.out.println("-".repeat(50));

        cartFunction.printCartItems();

        System.out.println("-".repeat(50));
        System.out.printf("금액 합계     : %d원\n",totalPrice);
        System.out.printf("할인 적용 금액 : %d원\n", finalPrice);

    }
}
