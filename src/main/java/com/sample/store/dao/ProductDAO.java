package com.sample.store.dao;

import com.sample.store.entity.Product;

import java.util.List;

public interface ProductDAO {
 public void add_product(Product aProduct);

 public void delete_product(Product aProduct);
 public void modify_product(Product aProduct);
 public Product get_product(Product aProduct);
 
 
 public List<Product> getList();
 //public List<Product> getReorderList();
 //public List<Product> getAvailableList();

 // public Product get(Product aProduct);
}