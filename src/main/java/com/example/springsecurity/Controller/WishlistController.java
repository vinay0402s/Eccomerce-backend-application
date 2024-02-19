package com.example.springsecurity.Controller;

import com.example.springsecurity.Model.WishlistItem;
import com.example.springsecurity.Service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishlists")
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    ///api/wishlists: GET endpoint to retrieve a user's wishlist.
    @GetMapping("/")
    public ResponseEntity<List<WishlistItem>> getUserWishlist(@PathVariable Long userId) {
        try {
            List<WishlistItem> wishlist = wishlistService.getUserWishlist(userId);
            return new ResponseEntity<>(wishlist, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

//POST endpoint to create a new wishlist item
    @PostMapping("/")
    public ResponseEntity<WishlistItem> createWishlistItem(@RequestBody WishlistItem wishlistItem) {

        try {
            WishlistItem createdItem = wishlistService.createWishlistItem(wishlistItem);
            return new ResponseEntity<>(createdItem, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    //DELETE endpoint to remove a wishlist item by ID
    @DeleteMapping("/{id}")
    public ResponseEntity deleteWishlistItem(@PathVariable Long id) {
           String response  = wishlistService.deleteWishlistItem(id);
           return new ResponseEntity(response, HttpStatus.OK);
    }

}
