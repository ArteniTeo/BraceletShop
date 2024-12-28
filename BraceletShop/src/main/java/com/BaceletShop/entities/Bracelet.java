package com.BaceletShop.entities;

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
@Table(name = "bracelet")
public class Bracelet {

    @Id
    private Long id;
    private String name;
    private String description;
    private Long price;
    @Column(name = "img_url")
    private String imageUrl;
    private String category;

}
