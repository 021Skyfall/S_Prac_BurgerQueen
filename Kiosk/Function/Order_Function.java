package Kiosk.Function;

import Discounts.Discount;

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

        System.out.println("[ð£] ì£¼ë¬¸ì´ ìë£ëììµëë¤. ");
        System.out.println("[ð£] ì£¼ë¬¸ ë´ì­ì ë¤ìê³¼ ê°ìµëë¤. ");
        System.out.println("-".repeat(50));

        cartFunction.printCartItems();

        System.out.println("-".repeat(50));
        System.out.printf("ê¸ì¡ í©ê³     : %dì\n",totalPrice);
        System.out.printf("í ì¸ ì ì© ê¸ì¡ : %dì\n", finalPrice);

    }
}
