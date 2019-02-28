package com.kali.exception;

import java.io.FileNotFoundException;

public class TestOnException extends IllegalArguments {

    @Override
    public void m1() throws RuntimeException{
        throw new RuntimeException();
    }

}
