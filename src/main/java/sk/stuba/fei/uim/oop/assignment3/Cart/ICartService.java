package sk.stuba.fei.uim.oop.assignment3.Cart;

import java.util.List;

public interface ICartService {

     Cart createCart();

     List<Cart> getAll();

     Cart getById(long id);

     void deleteCartById(long id);

     void addProduct(long cartId, ProductCartRequest request);

     String payCartById(long id);




}
