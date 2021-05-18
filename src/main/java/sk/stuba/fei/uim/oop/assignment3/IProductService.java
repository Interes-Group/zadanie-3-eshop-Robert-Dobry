package sk.stuba.fei.uim.oop.assignment3;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    List<Product> getAll();

    Product create(ProductRequest request);

    Product getById(long id);

}
