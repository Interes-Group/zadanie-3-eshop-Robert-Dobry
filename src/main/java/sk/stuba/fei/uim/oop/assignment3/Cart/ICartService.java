package sk.stuba.fei.uim.oop.assignment3.Cart;


import java.util.List;

public interface ICartService {

    public Cart createCart();

    public List<Cart> getAll();

    public Cart getById(long id);

    public void deleteCartById(long id);

    public void addProduct(long cartId, ProductCartRequest request);

    public String payCartById(long id);



}
