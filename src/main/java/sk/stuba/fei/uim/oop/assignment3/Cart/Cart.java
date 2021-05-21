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

    private double price = 0;

    @ManyToMany
    private List<Product> shoppingList = new ArrayList<>();


    private boolean payed;

    public boolean getPayed(){
        return this.payed;
    }


    public void increasePrice(double value){

        this.price += value;

    }

    public void increaseAmountById(long id, int value){

        for(Product p : this.shoppingList){

            if(p.getId() == id){
                p.setAmount(p.getAmount() + value);
            }


        }

    }

}
