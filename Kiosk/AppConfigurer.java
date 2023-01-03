package Kiosk;

import Discounts.Condition.Coz;
import Discounts.Condition.Kid;
import Discounts.DS_Condition;
import Discounts.Discount;
import Discounts.Policy.FixedAmount;
import Discounts.Policy.FixedRate;
import Kiosk.Function.Cart_Function;
import Kiosk.Function.Menu_Function;
import Kiosk.Function.Order_Function;
import Products.List.Product_Repository;

public class AppConfigurer {
    public Product_Repository productRepository = new Product_Repository();
    
    public Menu_Function menuFunction = new Menu_Function(productRepository().getProducts());
    
    public Cart_Function cartFunction = new Cart_Function(productRepository(),menuFunction());
    
    public Discount discount = new Discount(new DS_Condition[]{
            new Coz(new FixedRate(10)),
            new Kid(new FixedAmount(500))});
    
    public Product_Repository productRepository() {
        return productRepository;
    }
    
    public Menu_Function menuFunction() {
        return menuFunction;
    }
    
    public Cart_Function cartFunction() {
        return cartFunction;
    }
   
    public Discount discount() {
        return discount;
    }
    public Order_Function orderFunction () {
        return new Order_Function(cartFunction(),discount());
    }
}
// cart() 호출시 New Cart 생성
// Order의 매개변수로 cart 또 생성
// >> 즉 Cart의 참조가 두 번 이뤄짐 > 참조변수의 주소가 두 곳이라는 뜻
// 지금 처럼 바꿔주면 메인에서 인스턴스화 될 때 지금 여기서 초기화가 이뤄짐 > 주소값이 한 곳임
// 아래의 return으로 그 한번만 만들어진 객체를 불러옴
// >> 이게 싱글톤 패턴임