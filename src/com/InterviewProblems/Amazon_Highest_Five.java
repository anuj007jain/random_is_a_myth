package com.InterviewProblems;

import java.util.*;

/**
 *
 */
public class Amazon_Highest_Five
{

    public static void main(String[] args) {
        List<PageRenderTime> list = new ArrayList<>();
        list.add(new PageRenderTime(1, 40));
        list.add(new PageRenderTime(2, 90));
        list.add(new PageRenderTime(1, 50));
        list.add(new PageRenderTime(2, 80));
        list.add(new PageRenderTime(2, 85));
        list.add(new PageRenderTime(1, 60));
        list.add(new PageRenderTime(1, 70));
        list.add(new PageRenderTime(1, 80));
        list.add(new PageRenderTime(1, 90));
        list.add(new PageRenderTime(1, 100));
        list.add(new PageRenderTime(2, 95));
        list.add(new PageRenderTime(2, 100));
        list.add(new PageRenderTime(2, 50));
        System.out.println(calculateHighestFive(13, list));
        System.out.println(calculateHighestFive2(13, list));
    }

    static class PageRenderTime {
        public int pageId;
        public double renderTime;

        public PageRenderTime(int id, double value) {
            this.pageId = id;
            this.renderTime = value;
        }
    }

    //METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    static Map<Integer, Double> calculateHighestFive(int renderCount,
                                              List<PageRenderTime> renderTimeOfPages)
    {
        Map<Integer, MinPriorityQueue> pageIdToWorstRenderingTimes = new HashMap<>();
        for(PageRenderTime pageRenderTime: renderTimeOfPages) {
            if(pageIdToWorstRenderingTimes.get(pageRenderTime.pageId) == null) {
                MinPriorityQueue minHeap = new MinPriorityQueue();
                minHeap.insert(pageRenderTime.renderTime);
                pageIdToWorstRenderingTimes.put(pageRenderTime.pageId, minHeap);
            } else {
                MinPriorityQueue minHeap = pageIdToWorstRenderingTimes.get(pageRenderTime.pageId);
                if(minHeap.size < 5) {
                    minHeap.insert(pageRenderTime.renderTime);
                } else {
                    if ((double)minHeap.min() < pageRenderTime.renderTime) {
                        minHeap.delMin();
                        minHeap.insert(pageRenderTime.renderTime);
                    }
                }
            }
        }
        Map<Integer, Double> solutionMap = new HashMap<>();
        for (Map.Entry<Integer, MinPriorityQueue> entry : pageIdToWorstRenderingTimes.entrySet()) {
            MinPriorityQueue minHeap = entry.getValue();
            double sum = 0;
            for(int i = 1 ; i <= minHeap.size ; i++) {
                sum += (double) minHeap.queue[i];
            }
            solutionMap.put(entry.getKey(), sum / 5);

        }
        return solutionMap;
    }

    public static class MinPriorityQueue{

        public double[] queue;
        public int size;

        public MinPriorityQueue() {
            queue = new double[1];
            size = 0;
        }

        public double min() {
            return queue[1];
        }

        public void swim(int k) {
            while (k/2 > 0) {
                double parent = queue[k/2];
                if(parent > (queue[k])) {
                    swap(k/2, k);
                    k = k/2;
                } else {
                    break;
                }
            }
        }

        public void sink(int k) {
            while (k <= size/2) {
                int child1position = k*2;
                int child2position = k*2+1;
                int smallerChild = k*2;
                if(k*2 < size) { // to check if child2 exists (null check)
                    if(less(child2position, child1position)) {
                        smallerChild = k*2+1;
                    }
                }
                if(less(smallerChild, k)) {
                    swap(smallerChild, k);
                    k = smallerChild;
                } else {
                    break;
                }
            }
        }

        public void insert(double k) {
            if(queue.length == size+1) {
                resize(queue.length*2);
            }
            queue[++size] = k;
            swim(size);
        }

        private void resize(int newSize) {
            double[] temp = new double[newSize];
            for(int i = 0 ; i <= size() ; i++) {
                temp[i] = queue[i];
            }
            queue = temp;
        }

        public double delMin() {
            double deletedKey = queue[1];
            swap(1, size--);
            sink(1);
            //queue[size+1] = null;
            if(size > 0 && size < queue.length/4) {
                resize(queue.length/2);
            }
            return deletedKey;
        }

        private void swap(int i, int j) {
            double temp = queue[i];
            queue[i] = queue[j];
            queue[j] = temp;
        }

        public int size() {
            return size;
        }

        public boolean less(int i, int j) {
            return queue[i]< (queue[j]);
        }
    }
    // METHOD SIGNATURE ENDS


    static Map<Integer, Double> calculateHighestFive2(int renderCount,
                                                     List<PageRenderTime> renderTimeOfPages)
    {
        Map<Integer, PriorityQueue> pageIdToWorstRenderingTimes = new HashMap<>();
        for(PageRenderTime pageRenderTime: renderTimeOfPages) {
            if(pageIdToWorstRenderingTimes.get(pageRenderTime.pageId) == null) {
                //MinPriorityQueue minHeap = new MinPriorityQueue();
                PriorityQueue minHeap = new PriorityQueue();
                minHeap.add(pageRenderTime.renderTime);
                pageIdToWorstRenderingTimes.put(pageRenderTime.pageId, minHeap);
            } else {
                PriorityQueue minHeap = pageIdToWorstRenderingTimes.get(pageRenderTime.pageId);
                if(minHeap.size() < 5) {
                    minHeap.add(pageRenderTime.renderTime);
                } else {
                    if ((double)minHeap.peek() < pageRenderTime.renderTime) {
                        minHeap.poll();
                        minHeap.add(pageRenderTime.renderTime);
                    }
                }
            }
        }
        Map<Integer, Double> solutionMap = new HashMap<>();
        for (Map.Entry<Integer, PriorityQueue> entry : pageIdToWorstRenderingTimes.entrySet()) {
            PriorityQueue minHeap = entry.getValue();
            double sum = 0;
            Iterator iterator = minHeap.iterator();
            while (iterator.hasNext()) {
                sum += (Double)iterator.next();
            }
            solutionMap.put(entry.getKey(), sum / 5);

        }
        return solutionMap;
    }

}
