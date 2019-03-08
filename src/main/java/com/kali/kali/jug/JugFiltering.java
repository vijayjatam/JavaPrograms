package com.kali.kali.jug;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class JugFiltering {
	public static void main(String[] args) {
		File file = new File("C:/Users/palavell/Desktop/JugStatus.txt");
		readDataAndExecute(file);
	}
	public static void readDataAndExecute(File file) {
		 BufferedReader bufferRead = null;
		 StringBuffer sBuffer1 = new StringBuffer();
		 StringBuffer sBuffer2 = new StringBuffer();
		try {
			
			// Read the Data from given File
			bufferRead = new BufferedReader(new InputStreamReader( new FileInputStream(file)));
			String inputLine; 
			while ((inputLine = bufferRead.readLine()) != null) {
				if(inputLine.contains("Both odds") && inputLine.contains("value odd") && inputLine.contains("middle")) {
					if(inputLine.contains("small"))
						sBuffer1.append(inputLine+"\n");
					else
						sBuffer2.append(inputLine+"\n");
//					System.out.println(inputLine);
				}
			}
			System.out.println(sBuffer1+"\n\n"+sBuffer2);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
	}
}
