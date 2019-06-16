package com.zebi.sorting_algos;


public class Main {

    public static void main(String[] args) {
	// write your code here
        MergeSort mergeSort = new MergeSort();
        mergeSort.initArray(15, 200);
        mergeSort.applyMergeSort();
        mergeSort.print();
    }

}
