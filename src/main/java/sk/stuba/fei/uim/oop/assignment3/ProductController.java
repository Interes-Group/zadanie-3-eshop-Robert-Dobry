package sk.stuba.fei.uim.oop.assignment3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService service;


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

        Product pr = this.service.getById(id);

        if(pr == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        ResponseEntity<ProductResponse> re = new ResponseEntity<>(new ProductResponse(pr), HttpStatus.OK);

        return re;

    }






}
