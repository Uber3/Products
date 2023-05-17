package com.example.demo.OrderRepository;/*
 * @author Dzmitry Rusak
 * @link
 */

import com.example.demo.Produkty.Order;
import com.example.demo.Produkty.Produkt;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class OrderRepository {
    private List<Order> orders;

    public OrderRepository(final List<Order> orders) {
        this.orders = orders;
    }

    public Order create(int id, List<Produkt> products) {
        Order order = new Order();
        order.setId(id);
        order.setProducts(products);
        orders.add(order);

        return order;
    }

   /* public void delete(int id) throws Exception {
        for (Order order : orders) {
            if (order.getId() == id) {
                orders.remove(id);
            } else throw new Exception("ID is not found:" + id);
        }
    }*/

    public void delete(int id) throws Exception {
        var itemIndex = IntStream.range(0, orders.size())
                .filter(i -> orders.get(i).getId() == id)
                .findFirst()
                .orElse(-1);

        if (itemIndex != -1) {
            orders.remove(itemIndex);
        } else {
            throw new Exception("ID is not found: " + id);
        }

    }

    public List<Order> getAll() {
        return orders;
    }

   /* public Order getById(int id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                return orders.get(id);
            }
        }
        return null;
    }*/

    public Order getById(int id) {
        var index = IntStream.range(0, orders.size())
                .filter(i -> orders.get(i).getId() == id)
                .findFirst()
                .orElse(-1);

        return (index != -1) ? orders.get(id) : null;
    }

}

