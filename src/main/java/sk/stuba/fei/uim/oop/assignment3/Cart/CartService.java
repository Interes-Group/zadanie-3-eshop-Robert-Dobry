package sk.stuba.fei.uim.oop.assignment3.Cart;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.Product.IProductRepository;
import sk.stuba.fei.uim.oop.assignment3.Product.IProductService;
import sk.stuba.fei.uim.oop.assignment3.Product.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService implements ICartService{


    private ICartRepository repository;
    private IProductService productService;

    @Autowired
    public CartService(ICartRepository repository, IProductService productService ){
        this.repository = repository;
        this.productService = productService;

    }





    @Override
    public Cart createCart(){

        Cart newCart = new Cart();
        newCart.setPayed(false);
        return this.repository.save(newCart);

    }

    @Override
    public ArrayList<Cart> getAll(){

        return new ArrayList<Cart>(this.repository.findAll());

    }

    @Override
    public Cart getById(long id){

        return this.repository.findById(id);

    }

    @Override
    public void deleteCartById(long id){

        this.repository.delete(this.repository.findById(id));

    }

    @Override
    public void addProduct(long cartId, ProductCartRequest request){

            Product product = this.productService.getById(request.getProductId());

            this.repository.findById(cartId).addToList(product);

            product.setAmount(product.getAmount() - request.getAmount());

            this.repository.save(this.repository.findById(cartId));

    }


}
