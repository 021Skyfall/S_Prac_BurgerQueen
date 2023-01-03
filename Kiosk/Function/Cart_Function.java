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
    private Menu_Function menu;

    public Cart_Function(Product_Repository productRepository, Menu_Function menu) {
        this.productRepository = productRepository;
        this.menu = menu;
    }

    public void addToCart(int productId) {
        Product product = productRepository.findId(productId);
        chooseOption(product);

        if (product instanceof Burgers) {
            Burgers burgers = (Burgers) product;
            if (burgers.isBurgerSet()) {
                product = composeSet(burgers);
            }
        }

        Product newProduct;
        if (product instanceof Burgers) newProduct = new Burgers((Burgers) product);
        else if (product instanceof Side) newProduct = new Side((Side) product);
        else if (product instanceof Beverage) newProduct = new Beverage((Beverage) product);
        else newProduct = new Burgers_Set ((Burgers_Set) product);


        Product[] newItems = new Product[items.length + 1];
        System.arraycopy(items, 0, newItems, 0, items.length);
        newItems[newItems.length - 1] = newProduct;
        items = newItems;

        System.out.printf("[\uD83D\uDCE3] %s를(을) 장바구니에 담았습니다.\n", product.getName());

    }

    private void chooseOption(Product product){
        String input;
        if (product instanceof Burgers) {
            System.out.printf("단품으로 주문하시겠습니까? (1)_단품(%d) (2)_세트(%d원)\n"
            ,product.getPrice(),((Burgers) product).getBurgerSetPrice());
            input = scanner.nextLine();
            if (input.equals("2")){
                ((Burgers) product).setIsBurgerSet(true);
            }
        } else if (product instanceof Side) {
            System.out.println("케첩은 몇 개 필요하십니까?");
            input = scanner.nextLine();
            ((Side) product).setKetchup(Integer.parseInt(input));
        } else if (product instanceof Beverage) {
            System.out.println("빨대가 필요하십니까? (1)_예 (2)_아니오");
            input = scanner.nextLine();
            if (input.equals("2")) {
                ((Beverage) product).setHasStraw(false);
            }
        }
    }

    private Burgers_Set composeSet(Burgers burgers) {

        System.out.println("사이드를 골라주세요!");
        menu.PrintSide(false);

        String sideId = scanner.nextLine();
        Side side = (Side) productRepository.findId(Integer.parseInt(sideId));
        chooseOption(side);

        System.out.println("음료를 골라주세요!");
        menu.PrintBeverage(false);

        String beverageId = scanner.nextLine();
        Beverage beverage = (Beverage) productRepository.findId(Integer.parseInt(beverageId));
        chooseOption(beverage);

        String name = burgers.getName() + "세트";
        int price = burgers.getBurgerSetPrice();
        int kcal = burgers.getKcal() + side.getKcal() + beverage.getKcal();

        return new Burgers_Set(name,price,kcal,burgers, beverage, side);

    }

    public void printCart(){
        System.out.println("🧺 장바구니");
        System.out.println("-".repeat(50));
        printCartItems();
        System.out.println("-".repeat(50));
        System.out.printf("합계 : %d원\n",totalPrice());

        System.out.println("이전으로 돌아가려면 엔터를 누르세요.");
        scanner.nextLine();
    }

    void printCartItems() {
        for(Product products : items) {
            if (products instanceof Burgers_Set) {
                Burgers_Set burgersSet =  (Burgers_Set) products;
                System.out.printf(" %s %6d원 (%s(케첩 %d개) %s(빨대 %s))\n"
                , products.getName(), products.getPrice(),
                        burgersSet.getSide().getName(),
                        burgersSet.getSide().getKetchup(),
                        burgersSet.getBeverage().getName(),
                        burgersSet.getBeverage().hasStraw() ? "있음" : "없음");
            } else if (products instanceof Burgers) {
                System.out.printf(" %-8s %6d원 (단품)\n"
                , products.getName(),
                        products.getPrice());
            } else if (products instanceof Side) {
                System.out.printf(" %-8s %6d원 (케첩 %d개)\n"
                ,products.getName()
                ,products.getPrice()
                ,((Side)products).getKetchup());
            } else if (products instanceof Beverage) {
                System.out.printf(" %-8s %6d원 (빨대 %s)\n"
                ,products.getName()
                ,products.getPrice()
                ,((Beverage) products).hasStraw() ? "있음" : "없음");
            }
        }
    }

    int totalPrice() {
        int totalPrice = 0;
        for (Product product : items) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }


}
