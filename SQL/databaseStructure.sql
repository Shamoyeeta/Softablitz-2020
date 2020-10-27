-- Create database : foodpile
CREATE DATABASE foodpile;

-- Use the created database
USE foodpile;

-- Create table : user
CREATE TABLE `foodpile`.`user` (
  `username` VARCHAR(30) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `name` VARCHAR(32) NOT NULL,
  PRIMARY KEY (`username`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE);
  
-- Create table : product
CREATE TABLE `foodpile`.`product` (
  `id` VARCHAR(5) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `category` VARCHAR(30) NOT NULL,
  `price` DOUBLE NOT NULL,
  `quantity` DOUBLE NOT NULL,
  `threshold_value` DOUBLE NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);
  
-- Create table : product_log
CREATE TABLE `foodpile`.`product_log` (
  `product_ID` VARCHAR(5) NOT NULL,
  `username` VARCHAR(30) NOT NULL,
  `changes` VARCHAR(45) NOT NULL,
  INDEX `id_idx` (`product_ID` ASC) VISIBLE,
  INDEX `user_idx` (`username` ASC) VISIBLE,
  CONSTRAINT `product_id`
    FOREIGN KEY (`product_ID`)
    REFERENCES `foodpile`.`product` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `user`
    FOREIGN KEY (`username`)
    REFERENCES `foodpile`.`user` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

