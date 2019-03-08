package com.kali.kali;

import java.util.*;
class MatrixMultiplication{

    public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.println("Enter size of the A matrix");
    int n=input.nextInt();
    int m=input.nextInt();
    System.out.println("Enter B matrix Column only");
    int o=input.nextInt();
    int[][] A = new int[n][m];
int[][] B = new int[m][o];
int[][] C = new int[n][o];
System.out.println("Enter elements for matrix A : ");
for (int i=0 ; i < A.length ; i++)
for  (int j=0 ; j < A[i].length ; j++){
A[i][j] = input.nextInt();
}
System.out.println("Enter elements for matrix B : ");
for (int i=0 ; i < B.length ; i++)
for  (int j=0 ; j < B[i].length ; j++){
B[i][j] = input.nextInt();
}
System.out.println("Matrix A: ");
        for (int i=0 ; i < A.length ; i++){
            System.out.println();
            for  (int j=0 ; j < A[i].length ; j++){
                System.out.print(A[i][j]+" ");
                  }
        }
System.out.println();
System.out.println();
System.out.println("Matrix B: ");
        for (int i=0 ; i < B.length ; i++){    
            System.out.println();
            for  (int j=0 ; j < B[i].length ; j++){
                System.out.print(B[i][j]+" ");
                  }
        }
System.out.println();
System.out.println();
System.out.println("Result is: ");
System.out.println();

for(int i=0;i<n;i++){
for(int j=0;j<o;j++){
for(int k=0;k<m;k++){
C[i][j]+=A[i][k]*B[k][j];
}
}
}
for(int i=0;i<n;i++){
for(int j=0;j<o;j++){
System.out.print(+C[i][j]+" ");
}
System.out.println();
} 
}
}