package com.kali.kali.test.test;

import cern.colt.matrix.impl.SparseDoubleMatrix1D;
import cern.colt.matrix.impl.SparseDoubleMatrix2D;
import cern.colt.matrix.impl.SparseObjectMatrix1D;
import cern.colt.matrix.impl.SparseObjectMatrix2D;

public class WorkingOnArray {
    public static void main(String[] args) {
        SparseObjectMatrix2D paperToAbMatrix = new SparseObjectMatrix2D(2,2);
        SparseObjectMatrix1D oneD = new SparseObjectMatrix1D(2);
        oneD.set(0,1.0);
        oneD.set(1,2.0);
        int[] array = new int[]{1,2};
        //oneD.set(,array);
        /*int[][] twoD = new int[10][];
        int[] oneD = new int[2];
        oneD[0] = 1;oneD[1] = 2;
        twoD[9] = oneD;
        System.out.println(twoD.length);*/
    }
}
