package com.kali.kali.streams.lambda;

import com.kali.streams.lambda.OrderItem;
import com.kali.streams.lambda.Transaform;

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
