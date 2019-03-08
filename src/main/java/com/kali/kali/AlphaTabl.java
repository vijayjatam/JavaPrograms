package com.kali.kali;

public class AlphaTabl {
	public static void main(String[] args) {
		char a[]=new char[26];
		int j=0;
		for(int i=65;i<91;i++) {
			a[j]=(char)i;
			j=j+1;
		}
		System.out.print(" |");
		for(j=97;j<=122;j++)
			System.out.print((char)j+" ");
		System.out.print("|");
		System.out.println();
		for(int i=1;i<=60;i++)
			System.out.print("-");
		System.out.println();
		j=65;
		for(int i=0;i<26;i++) {
			int dif=26-i;
			System.out.print((char)j+++"|");
			for(int k=i;k<26;k++)
				System.out.print(a[k]+" ");
			for(int k=0;k<26-dif;k++)
			    System.out.print(a[k]+" ");
			System.out.print("|");
			System.out.println();
			//j=j+1;
		}
		for(int i=1;i<=60;i++)
			System.out.print("-");
	}

}
