package com.learn.Ecommerce.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orderDetails")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID) // uuid is responsible to generate id 
	private String orderId;
	@CreationTimestamp
	private LocalDateTime createdAT;
	@UpdateTimestamp
	private LocalDateTime updateAt;
	@ManyToOne
	private User user; 
	@ManyToMany
	private List<Product>products;
	

}
