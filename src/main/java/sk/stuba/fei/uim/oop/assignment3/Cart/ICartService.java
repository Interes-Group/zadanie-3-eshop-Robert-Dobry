package sk.stuba.fei.uim.oop.assignment3.Cart;

import sk.stuba.fei.uim.oop.assignment3.Product.IProductRepository;
import sk.stuba.fei.uim.oop.assignment3.Product.Product;

import java.util.List;

public interface ICartService {

    public Cart createCart();

    public List<Cart> getAll();

    public Cart getById(long id);

    public void deleteCartById(long id);




}
