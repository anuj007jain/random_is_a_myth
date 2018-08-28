package com.Algorithms_2_Coursera.Week2.MinimumSpanningTrees;

/**
 * Created by anuj.jain02 on 3/6/18.
 */
public class IndexMinPQ<Key extends Comparable> {

    int[] pq;
    Key[] keys;
    int[] qp;
    int size;

    public IndexMinPQ(int N) {
        pq = new int[N+1];
        keys = (Key[]) new Comparable[N+1];
        qp = new int[N+1];
        for(int i = 0 ; i <= N ; i++) {
            qp[i] = -1;
        }
        size = 0;
    }

    public void insert(int i, Key key) { //insert (0,A)
        pq[++size] = i;
        keys[i] = key;
        qp[i] = size;
        swim(size);

    }

    public void decreaseKey(int i, Key key) {
        if(contains(i)) {
            keys[i] = key;
            swim(qp[i]); // here you will realize the importance of qp
                         // because we want to know the position of the key on heap
        }
    }

    public void increaseKey(int i, Key key) {
        if(contains(i)) {
            keys[i] = key;
            sink(qp[i]);
        }
    }

    public void changeKey(int i, Key key) {
        if(contains(i)) {
            keys[i] = key;
            swim(qp[i]);
            sink(qp[i]);
        }
    }

    public boolean contains(int i) {
        return qp[i] != -1;
    }

    public Key get(int i) {
        if(!contains(i)) {
            return null;
        }
        return keys[i];
    }

    public int delMin() {
        int deletedKeyIndex = pq[1];
        swap(1, size--);
        sink(1);
        pq[size()+1] = -1;
        qp[deletedKeyIndex] = -1;
        keys[deletedKeyIndex] = null;
        return deletedKeyIndex;
    }

    public int getMin() {
        return pq[1];
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }

    public void swim(int k) {
        while (k/2 > 0 && less(k, k/2)) {
            swap(k,k/2);
            k = k/2;
        }
    }

    public void sink(int k) {
        while (k*2 <= size()) {
            int leftChildPosition = k*2;
            int smallestChildPosition = leftChildPosition;
            if(k*2 < size()) {
                int rightChildPosition = k*2+1;
                if(less(rightChildPosition, leftChildPosition)) {
                    smallestChildPosition = rightChildPosition;
                }
            }
            if(less(smallestChildPosition, k)) {
                swap(smallestChildPosition, k);
                k = smallestChildPosition;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    private boolean less(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) < 0;
    }

}
