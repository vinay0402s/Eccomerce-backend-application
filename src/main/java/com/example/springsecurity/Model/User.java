package com.example.springsecurity.Model;




import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column
    private String password;

    // other user details and fields

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<WishlistItem> wishlistItems;
}
