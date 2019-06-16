package com.zebi.sorting_algos;

import java.util.Random;

class MergeSort {
    public Node [] nodes;

    public MergeSort() { }

    public MergeSort(Node[] nodes) {
        this.nodes = nodes;
    }

    public void initArray(int size, int maxBound) {
        Random random = new Random();
        nodes = new Node[size];
        for(int i=0;i<size;i++) {
            nodes[i] = new Node(random.nextInt(maxBound));
        }
    }

    public void print() {
        for(Node node: nodes) {
            System.out.print(node.data + " ");
        }
    }

    public void applyMergeSort()
    {
        mergeSort(nodes);
    }
    private Node[] mergeSort(Node[] list) {
        if(list.length <= 1) {
            return list;
        }
        else {
            Node[] first = new Node[list.length / 2];
            Node[] second = new Node[list.length - first.length];

            System.arraycopy(list, 0, first, 0, first.length);
            System.arraycopy(list, first.length, second, 0, second.length);

            mergeSort(first);
            mergeSort(second);

            merge(first, second, list);
            return list;
        }
    }
    private void merge(Node[] first, Node[] second, Node[] result) {
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
