package com.kali.kali.exception;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UncheckedIOException;

public class IllegalArguments extends Exception{

	public void m1() throws FileNotFoundException {
		throw new FileNotFoundException();
	}
}
