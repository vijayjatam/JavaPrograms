package com.kali.kali.streams.lambda;

import com.kali.streams.lambda.Order;
import com.kali.streams.lambda.OrderItem;
import com.kali.streams.lambda.Transaform;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class MainClass {
    public static void main(String[] args) {
        com.kali.streams.lambda.Order order = new Order(Arrays.asList(
                new OrderItem(1,10),
                new OrderItem(2,20),
                new OrderItem(3,30.45),
                new OrderItem(4,30)
        ));
        order.transformAndPrint(new Transaform<Stream<OrderItem>>() {
            @Override
            public Stream<OrderItem> transform(Stream<OrderItem> input) {
               return input.sorted(Comparator.comparing(OrderItem::getPrice));
            }
        });
        System.out.println("-------------------------------------------");
        order.transformAndPrint(k -> k.sorted(Comparator.comparing(OrderItem::getPrice)));
    }
}
