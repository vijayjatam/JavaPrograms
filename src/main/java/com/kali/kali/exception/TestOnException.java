package com.kali.kali.exception;

import com.kali.exception.IllegalArguments;

import java.io.FileNotFoundException;

public class TestOnException extends IllegalArguments {

    @Override
    public void m1() throws RuntimeException{
        throw new RuntimeException();
    }

}
