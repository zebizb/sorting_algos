package com.zebi.sorting_algos;

class Node {
    int data;
}

public class Main {

    public static void main(String[] args) {
	// write your code here
        Node []unsorted_array = new Node[10];
        for(int i=0; i<10;i++)
            unsorted_array[i] = new Node();
        unsorted_array[0].data = 5;
        unsorted_array[1].data = 6;
        unsorted_array[2].data = 21;
        unsorted_array[3].data = 2;
        unsorted_array[4].data = -10;
        unsorted_array[5].data = 9;
        unsorted_array[6].data = 15;
        unsorted_array[7].data = 1;
        unsorted_array[8].data = 20;
        unsorted_array[9].data = 17;

        merge_sort(unsorted_array);
        for (Node node: unsorted_array)
            System.out.print(node.data + " ");
    }

    private static Node[] merge_sort(Node[] list) {
        if(list.length <= 1) {
            return list;
        }
        else {
            Node[] first = new Node[list.length / 2];
            Node[] second = new Node[list.length - first.length];

            System.arraycopy(list, 0, first, 0, first.length);
            System.arraycopy(list, first.length, second, 0, second.length);

            merge_sort(first);
            merge_sort(second);

            merge(first, second, list);
            return list;
        }
    }

    private static void merge(Node[] first, Node[] second, Node[] result) {
        int iFirst = 0;
        int iSecond = 0;
        int iMerged = 0;

        while(iFirst < first.length && iSecond < second.length)
        {
            if(first[iFirst].data < second[iSecond].data) {
                result[iMerged] = first[iFirst];
                iFirst++;
            }
            else {
                result[iMerged] = second[iSecond];
                iSecond++;
            }
            iMerged++;
        }
        System.arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
        System.arraycopy(second, iSecond, result, iMerged, second.length - iSecond);
    }
}
