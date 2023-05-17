package com.example.demo.Produkty;
/*
 * @author Dzmitry Rusak
 * @link
 */

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Order {

    private int id;
    private List<Produkt> products;
    private BigDecimal totalSum;
    private final LocalDateTime created;
    private LocalDateTime updated;

    public Order() {
        this.products = new ArrayList<>();
        this.totalSum = BigDecimal.ZERO;
        this.created = LocalDateTime.now();
        this.updated = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }
    public void setId(final int id) {
        this.id = id;
    }

    public List<Produkt> getProducts() {
        return products;
    }

    public void setProducts(List<Produkt> products) {
        this.products = products;
        calculateTotalSum();
        updateUpdatedTime();
    }


    public void add (Produkt product){
        products.add(product);
        calculateTotalSum();
        updateUpdatedTime();
    }

    public BigDecimal getTotalSum() {
        return totalSum;
    }

    public LocalDateTime getCreatedTime() {
        return created;
    }

    public LocalDateTime getUpdatedTime() {
        return updated;
    }

    private void calculateTotalSum() {
        totalSum = BigDecimal.ZERO;
        IntStream.range(0, products.size())
                .forEach(i -> totalSum = totalSum.add(products.get(i).getPrice()));
    }

    private void updateUpdatedTime() {
        updated = LocalDateTime.now();
    }

}

