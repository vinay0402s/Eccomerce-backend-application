package com.example.springsecurity.Service;


import com.example.springsecurity.Model.User;
import com.example.springsecurity.Model.WishlistItem;
import com.example.springsecurity.Repository.UserRepository;
import com.example.springsecurity.Repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WishlistService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WishlistRepository wishlistRepository;

    public List<WishlistItem> getUserWishlist(Long userId) throws Exception {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return wishlistRepository.findByUser_Id(user.getId());
        } else {
            throw new Exception("User not found");
        }
    }
    public WishlistItem createWishlistItem(WishlistItem wishlistItem) {
        return wishlistRepository.save(wishlistItem);
    }

    public String deleteWishlistItem(Long id) {
        Optional<WishlistItem> wishlistItem = wishlistRepository.findById(id);

        if(wishlistItem.isEmpty())
            return "Item not present";

        wishlistRepository.deleteById(id);
        return "item deleted successfully" ;
    }




}
