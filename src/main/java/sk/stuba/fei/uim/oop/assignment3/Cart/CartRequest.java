package sk.stuba.fei.uim.oop.assignment3.Cart;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.Product.Product;

import java.util.List;


@Getter
@Setter
public class CartRequest {

    private long id;
    private List<Product> shoppingList;
    private boolean payed;

}
