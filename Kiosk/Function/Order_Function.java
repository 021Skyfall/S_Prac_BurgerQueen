package Kiosk.Function;

import java.util.Scanner;

public class Order_Function {
    Cart_Function cartFunction;

    public Order_Function(Cart_Function cartFunction) {
        this.cartFunction = cartFunction;
    }

    public void makeOrder() {
        System.out.println("[📣] 주문이 완료되었습니다. ");
        System.out.println("[📣] 주문 내역은 다음과 같습니다. ");
        System.out.println("-".repeat(50));

        cartFunction.printCartItems();

        System.out.println("-".repeat(50));
        System.out.printf("금액 합계      : %d원\n",cartFunction.totalPrice());

    }
}
