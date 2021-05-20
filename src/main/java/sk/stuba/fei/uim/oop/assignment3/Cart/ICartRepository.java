package sk.stuba.fei.uim.oop.assignment3.Cart;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.stuba.fei.uim.oop.assignment3.Product.Product;

import java.util.List;

@Repository
public interface ICartRepository extends CrudRepository<Cart, Long> {

    List<Cart> findAll();

    Cart findById(long id);



}
