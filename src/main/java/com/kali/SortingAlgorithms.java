package com.kali;

//Final Project: SortingAlgorithms.java

import java.util.Random;
import java.util.Scanner;
import java.util.NoSuchElementException;

/**
 * @author mahan.k.palavelli
 */
public class SortingAlgorithms {
    private int[] data; // array of values
    private static final Random generator = new Random();

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int option; // store user's option

        // create object to perform sorting
        SortingAlgorithms sortArray = new SortingAlgorithms(5);

        //show menu options
        do {
            System.out.println(" Choose the sorting algorithm to perform on data: \n");
            System.out.println(" 1) Selection sort");
            System.out.println(" 2) Insertion sort");
            System.out.println(" 3) Merge sort");
            System.out.println(" 4) Bubble sort");
            System.out.println(" 5) Bucket sort");
            System.out.println(" 6) Quick sort");
            System.out.print(" Option: ");


            try {
                option = input.nextInt();
                if (option >= 1 && option <= 6)
                    break;
                else
                    System.err.println(" Invalid input. Please try again.");
            } catch (NoSuchElementException elementException) {
                System.err.println(" Invalid input. Please try again.");
                input.nextLine();
            }
        } while (true); // repeat as necesary until user enters proper input


        // print unsorted array
        System.out.println("Unsorted:" + sortArray + "\n");

        switch (option) {
            case 1:
                System.out.println(" Executing Selection sort ... \n\n");
                sortArray.selectionSort(); // sort array using selection sort
                break;

            case 2:
                System.out.println(" Executing Insertion sort ... \n\n");
                sortArray.insertionSort(); // sort array using insertion sort
                break;

            case 3:
                System.out.println(" Executing Merge sort ... \n\n");
                sortArray.mergeSort(); // sort array using merge sort
                break;

            case 4:
                System.out.println(" Executing Bubble sort ... \n\n");
                sortArray.bubbleSort();
                break;

            case 5:
                System.out.println(" Executing Bucket sort ... \n\n");
                sortArray.bucketSort();
                break;

            case 6:
                System.out.println(" Executing Quick sort ... \n\n");
                sortArray.quickSort();
                break;

        }

        // print sorted array
        System.out.println("Sorted:  " + sortArray);
    } // end main

    // create array of given size and fill with random integers
    public SortingAlgorithms(int size) {
        data = new int[size]; // create space for array

        data = new int[]{6, 5, 2, 1, 3};

        // fill array with random ints in range 10-999
       /* for (int i = 0; i < size; i++)
            data[i] = 10 + generator.nextInt(990);*/
    } // end SortingAlgorithms constructor

    public void selectionSort() {
        int smallest; // index of smallest element

        // loop over data.length - 1 elements
        for (int i = 0; i < data.length - 1; i++) {
            smallest = i; // first index of remaining array

            // loop to find index of smallest element
            for (int index = i + 1; index < data.length; index++)
                if (data[index] < data[smallest])
                    smallest = index;

            swap(i, smallest); // swap smallest element into position
        } // end outer for
    } // end method selection


    // sort array using bubblesort
    public void bubbleSort() {
        int count = 0;
        // loop over data.length - 1 elements
        for (int next = 0; next < data.length; next++) {
            count++;
            for (int bubble = 1; bubble < data.length - next; bubble++) {
                count++;
                if (data[bubble - 1] > data[bubble])
                    swap(bubble - 1, bubble);
            }
        } // end for
        System.out.println("count: " + count);
    } // end method sort


    // sort array using bubblesort
    public void quickSort() {
        int biggest;
        int biggestIndex;

        // loop over data.length - 1 elements
        for (int next = data.length - 1; next >= 0; next--) {
            biggest = data[0];
            biggestIndex = 0;

            for (int quick = 1; quick <= next; quick++) {
                if (data[quick] > data[biggestIndex]) {
                    biggest = data[quick];
                    biggestIndex = quick;
                }
            }

            //swap
            data[biggestIndex] = data[next];
            data[next] = biggest;

        } // end for
    } // end method sort


    // sort array using bubblesort
    public void bucketSort() {
        int[][] buckets = new int[10][data.length]; // create space for array
        int bucketspot = 0;

        // loop over for ones, tens then hundreds
        for (int next = 10; next <= 1000; next *= 10) {

            int[] bucketcount = new int[10];

            //loop over all the elements in the data array
            for (int bucket = 0; bucket < data.length; bucket++) {
                //extract ones, tens or hundreds using  ( number mod TENS ) then divide by TENS/10 to get the number
                bucketspot = (data[bucket] % next) / (next / 10);
                buckets[bucketspot][bucketcount[bucketspot]] = data[bucket];
                bucketcount[bucketspot]++;
            }

            //copy back the array to the main array
            int arrayspot = 0;
            for (int bucketback = 0; bucketback < 10; bucketback++) {
                for (int arrayback = 0; arrayback < bucketcount[bucketback]; arrayback++) {
                    if (buckets[bucketback][arrayback] != 0) {
                        data[arrayspot] = buckets[bucketback][arrayback];
                        arrayspot++;
                    }
                }
            }

        } // end for
    } // end method sort


    // sort array using insertion sort
    public void insertionSort() {
        int insert; // temporary variable to hold element to insert

        // loop over data.length - 1 elements
        for (int next = 1; next < data.length; next++) {
            // store value in current element
            insert = data[next];

            // initialize location to place element
            int moveItem = next;

            // search for place to put current element
            while (moveItem > 0 && data[moveItem - 1] > insert) {
                // shift element right one slot
                data[moveItem] = data[moveItem - 1];
                moveItem--;
            } // end while

            data[moveItem] = insert; // place inserted element
        } // end for
    } // end method sort

    // helper method to swap values in two elements
    private void swap(int first, int second) {
        int temporary = data[first]; // store first in temporary
        data[first] = data[second]; // replace first with second
        data[second] = temporary; // put temporary in second
    } // end method swap

    // calls recursive split method to begin merge sorting
    public void mergeSort() {
        splitArray(0, data.length - 1); // split entire array
    } // end method sort

    // splits array, sorts subarrays and merges subarrays into sorted array
    private void splitArray(int low, int high) {
        // test base case; size of array equals 1
        if ((high - low) >= 1) // if not base case
        {
            int middle1 = (low + high) / 2; // calculate middle of array
            int middle2 = middle1 + 1; // calculate next element over

            // split array in half; sort each half (recursive calls)
            splitArray(low, middle1); // first half of array
            splitArray(middle2, high); // second half of array

            // merge two sorted arrays after split calls return
            merge(low, middle1, middle2, high);
        } // end if
    } // end method sortArray

    // merge two sorted subarrays into one sorted subarray
    private void merge(int left, int middle1, int middle2, int right) {
        int leftIndex = left; // index into left subarray
        int rightIndex = middle2; // index into right subarray
        int combinedIndex = left; // index into temporary working array
        int[] combined = new int[data.length]; // working array

        // merge arrays until reaching end of either
        while (leftIndex <= middle1 && rightIndex <= right) {
            // place smaller of two current elements into result
            // and move to next space in arrays
            if (data[leftIndex] <= data[rightIndex])
                combined[combinedIndex++] = data[leftIndex++];
            else
                combined[combinedIndex++] = data[rightIndex++];
        } // end while

        // if left array is empty
        if (leftIndex == middle2)
            // copy in rest of right array
            while (rightIndex <= right)
                combined[combinedIndex++] = data[rightIndex++];
        else // right array is empty
            // copy in rest of left array
            while (leftIndex <= middle1)
                combined[combinedIndex++] = data[leftIndex++];

        // copy values back into original array
        for (int i = left; i <= right; i++)
            data[i] = combined[i];

    } // end method merge

    // method to output certain values in array
    private String subarray(int low, int high) {
        StringBuilder temporary = new StringBuilder();

        // output spaces for alignment
        for (int i = 0; i < low; i++)
            temporary.append("   ");

        // output elements left in array
        for (int i = low; i <= high; i++)
            temporary.append(" " + data[i]);

        return temporary.toString();
    } // end method subarray

    // method to output values in array
    public String toString() {
        return subarray(0, data.length - 1);
    } // end method toString


} // end class SortingAlgorithms






















