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
    private List<ProductCart> shoppingList = new ArrayList<>();
    private boolean payed;


    public CartResponse(Cart cart){


        this.id = cart.getId();
        this.payed = cart.getPayed();

        for(Product element : cart.getShoppingList()){

            this.shoppingList.add(new ProductCart(element));

        }



    }


    public void setAmountById(long id, int value){

        for(ProductCart pc : this.shoppingList){

            if(pc.getProductId() == id){
                pc.setAmount(value);
                return;
            }
        }

    }
}
