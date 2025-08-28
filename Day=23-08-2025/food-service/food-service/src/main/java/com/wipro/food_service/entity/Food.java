package com.wipro.food_service.entity;

import java.math.BigDecimal;
import java.time.Instant;
import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name="food")
@Data
public class Food {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;
  private String name;
  private String category;
  private BigDecimal price;
  private Boolean available;
  @Column(name="image_url")
  private String imageUrl;
}