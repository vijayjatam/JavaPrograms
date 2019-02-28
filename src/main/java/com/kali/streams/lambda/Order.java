package com.kali.streams.lambda;

import java.util.List;
import java.util.stream.Stream;

public class Order {
    List<OrderItem> orderItemList;
    public Order(List<OrderItem> orderItems){
        this.orderItemList = orderItems;
    }
    public void transformAndPrint(Transaform<Stream<OrderItem>> orderTansaform){
        orderTansaform.transform(orderItemList.stream()).forEach(System.out::println);
    }
}
