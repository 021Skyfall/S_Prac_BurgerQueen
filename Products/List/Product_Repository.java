package Products.List;

import Products.Beverages.Beverage;
import Products.Burgers.Burgers;
import Products.Product;
import Products.Sides.Side;

public class Product_Repository {

    private Product[] products = new Product[]{
            new Burgers(1, "새우버거", 3500,500),
            new Burgers(2, "치킨버거", 4000, 600),
            new Side(3,"감자튀김", 1000, 300),
            new Side(4, "어니언링", 1000, 300),
            new Beverage(5, "코카콜라", 1000, 200),
            new Beverage(6,"제로콜라", 1000, 0),
    };

    public Product[] getProducts() {
        return products;
    }

    public Product findId(int productId) {
        for(Product product : products) {
            if(product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

}
