package sk.stuba.fei.uim.oop.assignment3.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductService implements IProductService{


    private IProductRepository repository;

    @Autowired
    public ProductService(IProductRepository repository){

        this.repository = repository;


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
        product.setAmount(request.getAmount());

        return this.repository.save(product);

    }

    @Override
    public Product getById(long id){

         return this.repository.findById(id);

    }

    @Override
    public Product update(Product body, long id){

        if(body.getName() != null ){

            this.repository.findById(id).setName(body.getName());}

        if(body.getDescription() != null ){
            this.repository.findById(id).setDescription(body.getDescription());
            }

            this.repository.save(this.repository.findById(id));


        return this.repository.findById(id);


    }

    @Override
    public void deleteProductById(long id){

        this.repository.delete(this.repository.findById(id));


    }

    @Override
    public void increaseAmount(long id, int value){

        this.repository.findById(id).setAmount(value);
        this.repository.save(this.repository.findById(id));


    }






}
