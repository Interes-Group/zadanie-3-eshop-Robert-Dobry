package sk.stuba.fei.uim.oop.assignment3.Product;

import java.util.List;

public interface IProductService {

    List<Product> getAll();

    Product create(ProductRequest request);

    Product getById(long id);

    Product update(Product body, long id);

    public void deleteProductById(long id);

    public void increaseAmount(long id, int value);


}
