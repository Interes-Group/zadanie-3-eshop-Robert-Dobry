package sk.stuba.fei.uim.oop.assignment3.Cart;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.Product.IProductService;
import sk.stuba.fei.uim.oop.assignment3.Product.Product;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {


    private ICartService service;


    public CartController(ICartService service){
        this.service = service;
    }


    @PostMapping()
    public ResponseEntity<CartResponse>addCart(){

        return new ResponseEntity<CartResponse>(new CartResponse(this.service.createCart()),HttpStatus.CREATED);

    }


    @GetMapping("/{id}")
    public ResponseEntity<CartResponse> getCartById(@PathVariable("id") long id){


        if(this.service.getById(id) == null){
            return new ResponseEntity<CartResponse>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<CartResponse>(new CartResponse(this.service.getById(id)), HttpStatus.OK);


    }

    @DeleteMapping("/{id}")
    public ResponseEntity <CartResponse>deleteCart(@PathVariable("id") long id){

        if(this.service.getById(id) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.service.deleteCartById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/getAll")
    public List<CartResponse> getAllCarts(){

        var result = new ArrayList<CartResponse>();
        for(Cart c : this.service.getAll()){
            result.add(new CartResponse(c));
        }

        return result;

    }

    @PostMapping("/{id}/add")
    public CartResponse addToCart(@PathVariable("id") long cartId, @RequestBody ProductCartRequest request){

        this.service.addProduct(cartId, request);

        CartResponse response = new CartResponse(this.service.getById(cartId));
        response.setAmountById(request.getProductId(), request.getAmount());

        return response;

    }



}
