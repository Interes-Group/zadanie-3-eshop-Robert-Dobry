package sk.stuba.fei.uim.oop.assignment3.Cart;


import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.Product.Product;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Number price;

    @ManyToMany
    private List<Product> shoppingList = new ArrayList<>();


    private boolean payed;

    public boolean getPayed(){
        return this.payed;
    }

    public void addToList(Product product){

        this.shoppingList.add(product);

    }

    public Product getByProductById(long id){

        for(Product p : this.shoppingList){

            if(p.getId() == id){

                return p;
            }
        }

        return null;
    }



}
