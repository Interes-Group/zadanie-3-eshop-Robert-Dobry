package sk.stuba.fei.uim.oop.assignment3.Cart;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.Product.IProductService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {


    private ICartService service;
    private IProductService productService;


    @Autowired
    public CartController(ICartService service, IProductService productService ){

        this.service = service;
        this.productService = productService;
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

    @GetMapping("/get-all-carts")
    public List<CartResponse> getAllCarts(){

        var result = new ArrayList<CartResponse>();
        for(Cart c : this.service.getAll()){
            result.add(new CartResponse(c));
        }

        return result;

    }

    @PostMapping("/{id}/add")
    public ResponseEntity<CartResponse> addToCart(@PathVariable("id") long cartId, @RequestBody ProductCartRequest request){

        if(this.service.getById(cartId) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else if((this.productService.getById(request.getProductId())) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else if (this.productService.getById(request.getProductId()).getAmount() < request.getAmount()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else if(this.service.getById(cartId).getPayed()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{


        this.service.addProduct(cartId, request);

        CartResponse response = new CartResponse(this.service.getById(cartId));
        response.setAmountById(request.getProductId(), request.getAmount());

        return new ResponseEntity<CartResponse>(response, HttpStatus.OK);
        }

    }


    @GetMapping("/{id}/pay")
    public ResponseEntity<String> payCart(@PathVariable("id") long id) {


        if(this.service.getById(id) == null){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else if(this.service.getById(id).getPayed()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<String>(this.service.payCartById(id), HttpStatus.OK);
        }
    }


}
