package co.ecomerce.domain.entity;

import co.ecomerce.domain.valueobject.Money;
import co.ecomerce.domain.valueobject.ProductId;

public class Product extends BaseEntity<ProductId>{
    private String name;
    private Money price;

    public Product(ProductId productId) {
        super.setId(productId);
    }

    public Product(ProductId productId, String name, Money price) {
        super.setId(productId);
        this.name = name;
        this.price = price;
    }


    // update with confirmed name and price from products of business
    public void updateWithConfirmedNameAndPrice(String name, Money price) {
        this.name = name;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public Money getPrice() {
        return price;
    }
}
