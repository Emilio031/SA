package com.sample.store.entity;

public class Product {
  int product_id;

 private String product_name;

 private int price;

 String condition1;//狀態z

 public int getProduct_id() {
  return product_id;
 }

 public void setProduct_id(int product_id) {
  this.product_id = product_id;
 }

 public String getProduct_name() {
  return product_name;
 }

 public void setProduct_name(String product_name) {
  this.product_name = product_name;
 }

 public int getPrice() {
  return price;
 }

 public void setPrice(int price) {
  this.price = price;
 }

 public String getCondition1() {
  return condition1;
 }

 public void setCondition1(String condition) {
  this.condition1 = condition;
 }

 
// public Product(int id, String name, int price, boolean condition){
//  this.product_id = id;
//  this.product_name = name;
//  this.price = price;
//  this.condition = condition;
//  
// }
 
}


