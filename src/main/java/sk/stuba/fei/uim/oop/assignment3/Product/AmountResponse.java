package sk.stuba.fei.uim.oop.assignment3.Product;

import lombok.Getter;

@Getter
public class AmountResponse {    // trieda na odpoved kde sa pytame cisto na amount nejakeho produktu

    private int amount;


    public AmountResponse(Product product){

        this.amount = product.getAmount();

    }


}
