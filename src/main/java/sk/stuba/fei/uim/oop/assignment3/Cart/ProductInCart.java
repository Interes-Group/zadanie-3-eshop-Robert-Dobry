package sk.stuba.fei.uim.oop.assignment3.Cart;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.Product.Product;

@Getter
@Setter
public class ProductInCart {


    private long id;
    private int amount;


    public ProductInCart(Product product){

        this.id = product.getId();
        this.amount = product.getAmount();

    }



}
