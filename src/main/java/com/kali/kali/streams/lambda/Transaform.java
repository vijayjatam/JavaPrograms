package com.kali.kali.streams.lambda;


public interface Transaform<T> {
    T transform(T input);
}
