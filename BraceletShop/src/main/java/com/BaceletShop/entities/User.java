package com.BaceletShop.entities;

import com.BaceletShop.common.UserRoles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    public static final String RESOURCE_NAME = "user";

    @Id
    @SequenceGenerator(
            name = "users_id_seq",
            sequenceName = "users_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "users_id_seq"
    )
    private Long id;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String username;
    private String password;
    private String address;
    private String role = UserRoles.CLIENT;

    public User(Long id) {
        this.id = id;
    }

    public boolean isAddressEmpty() {
        return address == null || address.isEmpty();
    }
}
