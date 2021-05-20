package sk.stuba.fei.uim.oop.assignment3.Cart;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.Product.Product;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class CartResponse {

    private long id;
    private List<ProductInCart> shoppingList;
    private boolean payed;

    public CartResponse(Cart cart) {

        shoppingList = new ArrayList<>();
        this.id = cart.getId();
        this.payed = cart.getPayed();

    }

}
