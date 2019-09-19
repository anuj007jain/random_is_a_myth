package com.LeetCode;

import java.util.*;

public class LC_0347_Top_K_Frequent_Elements {

    static class HeapNode implements Comparable{
        int count;
        int key;

        public HeapNode(int count, int key) {
            this.count = count;
            this.key = key;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            HeapNode heapNode = (HeapNode) o;
            return count == heapNode.count;
        }

        @Override
        public int hashCode() {
            return Objects.hash(count);
        }


        @Override
        public int compareTo(Object o) {
            if (this.count < ((HeapNode)o).count) {
                return -1;
            } else if (this.count > ((HeapNode)o).count) {
                return +1;
            } return 0;
        }
    }

    static class Heap {
        HeapNode[] heap;
        int size;

        public Heap(int N) {
            heap = new HeapNode[N+1];
            size = 0;
        }

        public void insert(HeapNode node) {
            heap[++size] = node;
            swim(size);
        }

        private void swim(int loc) {
            int parentLoc = loc/2;
            while (parentLoc > 0) {
                if (heap[parentLoc].compareTo(heap[loc]) > 0) {
                    swap(parentLoc, loc);
                    loc = parentLoc;
                    parentLoc = loc/2;
                } else {
                    break;
                }
            }
        }

        private HeapNode delMin() {
            if (size == 0) {
                return null;
            }
            HeapNode min = heap[1];
            swap(1, size--);
            sink(1);
            return min;
        }

        private void sink(int loc) {
            int smallerChildLoc = 2*loc;
            while (smallerChildLoc <= size) {
                HeapNode smallerChild = heap[2*loc];
                if (2*loc < size) {
                    HeapNode rightChild = heap[2*loc+1];
                    if (rightChild.compareTo(smallerChild) < 0) {
                        smallerChild = rightChild;
                        smallerChildLoc = 2*loc+1;
                    }
                }
                if (smallerChild.compareTo(heap[loc]) < 0) {
                    swap(smallerChildLoc, loc);
                    loc = smallerChildLoc;
                    smallerChildLoc = 2*loc;
                } else {
                    break;
                }
            }
        }

        private void swap(int i, int j) {
            HeapNode temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

        public void update(HeapNode node) {
            updateInternal(node, heap[1], 1);
        }

        private void updateInternal(HeapNode node, HeapNode curr, int currLoc) {
            if (curr.equals(node) && curr.key == node.key) {
                curr.count = curr.count+1;
                sink(currLoc);
                return;
            }
            if (currLoc * 2 <= size && heap[currLoc*2].compareTo(node) <= 0) {
                updateInternal(node, heap[currLoc*2], currLoc*2);
            }
            if (currLoc * 2 + 1 <= size && heap[currLoc*2+1].compareTo(node) <= 0) {
                updateInternal(node, heap[currLoc*2+1], currLoc*2+1);
            }
        }
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        Heap heap = new Heap(k);
        Map<Integer, Integer> keyToCount = new HashMap<>();
        Set<Integer> elemsInHeap = new HashSet<>();
        for (int i = 0 ; i < nums.length ; i++) {
            boolean found = elemsInHeap.contains(nums[i]);
            Integer count = keyToCount.get(nums[i]);
            if (count == null) {
                count = 0;
                keyToCount.put(nums[i], 1);
            } else {
                keyToCount.put(nums[i], count+1);
            }
            if (heap.size < k && !found) {
                elemsInHeap.add(nums[i]);
                heap.insert(new HeapNode(1, nums[i]));
            } else {
                if (found) {
                    heap.update(new HeapNode(count, nums[i])); // +1
                } else {
                    if (heap.heap[1].count < count+1) {
                        HeapNode deletedNode = heap.delMin();
                        elemsInHeap.remove(deletedNode.key);
                        heap.insert(new HeapNode(count+1, nums[i]));
                        elemsInHeap.add(nums[i]);
                    }
                }
            }
        }
        List<Integer> sol = new ArrayList<>();
        for(int i = 0 ; i < k ; i++) {
            sol.add(heap.delMin().key);
        }
        return sol;
    }

    public static void main(String[] args) {
        System.out.println(topKFrequent(new int[]{-1,1,4,-4,3,5,4,-2,3,-1}, 3));
        System.out.println(topKFrequent(new int[]{1,1,1,2,2,3}, 2));
        System.out.println(topKFrequent(new int[]{1}, 1));
    }

}
