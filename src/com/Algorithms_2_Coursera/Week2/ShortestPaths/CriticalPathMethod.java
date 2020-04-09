package com.Algorithms_2_Coursera.Week2.ShortestPaths;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CriticalPathMethod {

    int[] pathFrom;
    double[] pathLen;

    public CriticalPathMethod(List<Job> jobs) {
        pathFrom = new int[jobs.size()+2];
        pathLen = new double[jobs.size()+2];
        for (int i = 1 ; i < jobs.size()+2 ; i++) {
            pathLen[i] = Double.POSITIVE_INFINITY;
        }
        DirectedWeightedGraph G = createGraphFromJobs(jobs);
        TopologicalSort topSort = new TopologicalSort(G); //G is an acyclic graph here
        //Iterable<Integer> order = topSort.order();
        //System.out.println(order);
        for (int i = 0 ; i < G.V() ; i++) {
            int v = topSort.stack.pop();
            for (DirectedWeightedEdge edge : G.adj(v)) {
                relaxEdge(edge);
            }
        }
    }

    private void relaxEdge(DirectedWeightedEdge edge) {
        int from = edge.from();
        int to = edge.to();
        if (pathLen[to] > pathLen[from] + edge.weight()) {
            pathFrom[to] = pathFrom[from];
            pathLen[to] = pathLen[from] + edge.weight();
        }
    }

    private class TopologicalSort {

        Stack<Integer> stack = new Stack<>();
        boolean[] marked;

        public TopologicalSort(DirectedWeightedGraph G) {
            marked = new boolean[G.V()];
            visit(G, 0);
        }

        private void visit(DirectedWeightedGraph G, int v) {
            marked[v] = true;
            for (DirectedWeightedEdge edge : G.adj(v)) {
                if (!marked[edge.to()]) {
                    visit(G, edge.to());
                }
            }
            stack.push(v);
        }

        public Iterable<Integer> order() {
            return stack;
        }
    }


    private DirectedWeightedGraph createGraphFromJobs(List<Job> jobs) { // jobs.size() = 10

        boolean[] isJobDependent = new boolean[jobs.size()];
        DirectedWeightedGraph G = new DirectedWeightedGraph(jobs.size() + 2); //12 0-11 arr
        for (Job job : jobs) {
            if (job.mustCompleteBefore.size() > 0) {
                for (int dependentJob : job.mustCompleteBefore) {
                    isJobDependent[dependentJob] = true;
                    G.addEdge(new DirectedWeightedEdge(job.jobId + 1, dependentJob + 1, job.duration * -1));
                }
            } else {
                G.addEdge(new DirectedWeightedEdge(job.jobId + 1, jobs.size() + 1, job.duration * -1));
            }
        }
        for (int i = 0 ; i < jobs.size() ; i++) {
            if (!isJobDependent[i]) {
                G.addEdge(new DirectedWeightedEdge(0, i+1, 0));
            }
        }

        return G;
    }

    private static class Job {

        private int jobId;
        private double duration;
        private List<Integer> mustCompleteBefore;

        public Job(int jobId, double duration, List<Integer> mustCompleteBefore) {
            this.jobId = jobId;
            this.duration = duration;
            this.mustCompleteBefore = mustCompleteBefore;
        }
    }

    public static void main(String[] args) {

        Job j0 = new Job(0, 41.0, Arrays.asList(1, 7, 9));
        Job j1 = new Job(1, 51.0, Arrays.asList(2));
        Job j2 = new Job(2, 50.0, Arrays.asList());
        Job j3 = new Job(3, 36.0, Arrays.asList());
        Job j4 = new Job(4, 38.0, Arrays.asList());
        Job j5 = new Job(5, 45.0, Arrays.asList());
        Job j6 = new Job(6, 21.0, Arrays.asList(3, 8));
        Job j7 = new Job(7, 32.0, Arrays.asList(3, 8));
        Job j8 = new Job(8, 32.0, Arrays.asList(2));
        Job j9 = new Job(9, 29.0, Arrays.asList(4, 6));

        CriticalPathMethod cpm = new CriticalPathMethod(Arrays.asList(j0, j1, j2, j3, j4, j5, j6, j7, j8, j9));
        System.out.println("CPM length: " + cpm.pathLen[cpm.pathLen.length - 1] * -1);


    }

}
