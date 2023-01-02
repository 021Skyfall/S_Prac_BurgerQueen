package Kiosk.Function;

import Products.Beverages.Beverage;
import Products.Burgers.Burgers;
import Products.Burgers.Burgers_Set;
import Products.List.Product_Repository;
import Products.Product;
import Products.Sides.Side;

import java.util.Scanner;

public class Cart_Function {
    private Product[] items = new Product[0];
    private Scanner scanner = new Scanner(System.in);
    private Product_Repository productRepository;

    public Cart_Function(Product_Repository productRepository) {
        this.productRepository = productRepository;
    }

    public void addToCart(int productId) {
        Product product = productRepository.findId(productId);
    }

    public void chooseOption(Product product){
        String input;
        if (product instanceof Burgers) {
            System.out.printf("단품으로 주문하시겠습니까? (1)_단품(%d) (2)_세트(%d원)\n"
            ,product.getPrice(),((Burgers) product).getBurgerSetPrice());
            input = scanner.nextLine();
            if (input == "2"){
                ((Burgers) product).setBurgerSet(true);
            }
        } else if (product instanceof Side) {
            System.out.printf("케첩은 몇 개 필요하십니까?\n");
            input = scanner.nextLine();
            ((Side) product).setKetchup(Integer.parseInt(input));
        } else if (product instanceof Beverage) {
            System.out.printf("빨대가 필요하십니까? (1)_예 (2)_아니오\n"
            , input = scanner.nextLine());
            if (input == "2") {
                ((Beverage) product).setStraw(false);
            }
        }
    }

    public void composeSet(){}

    public void printCart(){
        System.out.println("🧺 장바구니");
        System.out.println("-".repeat(50));

        System.out.println("-".repeat(50));
        System.out.println("합계 : %d원\n");

        System.out.println("이전으로 돌아가려면 엔터를 누르세요. ");
        scanner.nextLine();
    }

    public void printCartItems() {
        for(Product products : items) {
            if (products instanceof Burgers_Set) {
                Burgers_Set burgersSet =  (Burgers_Set) products;
                System.out.printf(" %s %6d원 (%s(케첩 %d개), %(빨대 %s))\n"
                , products.getName(), products.getPrice(),
                        burgersSet.getSide().getKetchup(),
                        burgersSet.getBeverage().getName(),
                        burgersSet.getBeverage().Straw() ? "있음" : "없음");
            } else if (products instanceof Burgers) {
                System.out.printf(" %-8s, %6d원 (단품)\n"
                , products.getName(),
                        products.getPrice());
            } else if (products instanceof Side) {
                System.out.printf(" %-8s %6d원 (케첩 %d개)\n"
                ,products.getName()
                ,products.getPrice()
                ,((Side)products).getKetchup());
            } else if (products instanceof Beverage) {
                System.out.printf(" %-8s, %6d원\n"
                ,products.getName()
                ,products.getPrice()
                ,((Beverage) products).Straw() ? "있음" : "없음");
            }
        }
    }
    private int totalPrice() {
        int totalPrice = 0;
        for (Product product : items) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}
