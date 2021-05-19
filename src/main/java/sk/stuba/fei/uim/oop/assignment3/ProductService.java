package sk.stuba.fei.uim.oop.assignment3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService{

    @Autowired
    private IProductRepository repository;

    public ProductService(IProductRepository repository){

        this.repository = repository;

        Product p1 = new Product();
        p1.setName("Chlieb");
        p1.setDescription("Psenicny");
        p1.setAmount(1);
        p1.setUnit("kus");
        p1.setPrice(0.35);
        this.repository.save(p1);

    }


    @Override
    public List<Product> getAll(){
        return new ArrayList<Product>(this.repository.findAll());
    }


    @Override
    public Product create(ProductRequest request){

        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setUnit(request.getUnit());
        product.setDescription(request.getDescription());

        return this.repository.save(product);


    }

    @Override
    public Product getById(long id){

         return this.repository.findById(id);

    }

    @Override
    public Product update(Product body, long id){

    this.repository.findById(id).setName(body.getName());
    this.repository.findById(id).setDescription(body.getDescription());
    this.repository.save(this.repository.findById(id));

    return this.repository.findById(id);


    }



}
