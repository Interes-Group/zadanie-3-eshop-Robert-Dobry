package sk.stuba.fei.uim.oop.assignment3.Cart;


import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.Product.Product;



@Getter
@Setter

public class ProductCart {

    private long productId;

    private int amount;


    ProductCart(Product p){

        this.productId = p.getId();
        this.amount = p.getAmount();



    }







}
