package sk.stuba.fei.uim.oop.assignment3.Product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {


    private IProductService service;

    @Autowired
    public ProductController(IProductService service){

        this.service = service;
    }


    @GetMapping()
    public List<ProductResponse> getAllProducts(){

        var result = new ArrayList<ProductResponse>();

        for(Product p : this.service.getAll()){
            result.add(new ProductResponse(p));
        }

        return result;

    }

    @PostMapping()
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest request){

        return new ResponseEntity<>(new ProductResponse(this.service.create(request)), HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") long id){

        if(this.service.getById(id) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        ResponseEntity<ProductResponse> re = new ResponseEntity<>(new ProductResponse(this.service.getById(id)), HttpStatus.OK);

        return re;

    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(@RequestBody Product body, @PathVariable("id") long id){

        if(this.service.getById(id) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new ProductResponse(this.service.update(body, id)),HttpStatus.OK);

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ProductResponse> deleteProduct(@PathVariable("id") long id){

        if(this.service.getById(id) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.service.deleteProductById(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PostMapping("/{id}/amount")
    public ResponseEntity<AmountResponse> increaseProductAmount(@RequestBody ProductRequest request, @PathVariable("id") long id){


        if(this.service.getById(id) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.service.increaseAmount(id, request.getAmount());


        return new ResponseEntity<AmountResponse>(new AmountResponse(this.service.getById(id)),HttpStatus.OK);


    }

    @GetMapping("/{id}/amount")
    public ResponseEntity<AmountResponse> getAmountOfProduct(@PathVariable("id") long id){

        if(this.service.getById(id) == null){
            return new ResponseEntity<AmountResponse>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<AmountResponse>(new AmountResponse(this.service.getById(id)),HttpStatus.OK);

    }






}
