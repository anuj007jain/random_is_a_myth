package com.GeeksForGeeks.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by anuj on 27/4/16.
 */


public class Graph {

    public void BFS(List<Vertex> vertices,List<Edge> edges, Vertex source){
        Queue<Vertex> queue = new ArrayDeque<>();
        boolean[] visited= new boolean[vertices.size()];
        queue.add(source);
        visited[source.id] = true;
        while(queue.size()!=0){
            Vertex elem = (Vertex) queue.remove();
            int element = elem.id;
            System.out.println(element);
            for(int i = 0; i < edges.size() ; i++){
                if(edges.get(i).vera.id == elem.id || edges.get(i).verb.id == elem.id){
                    if(edges.get(i).vera.id == elem.id && visited[edges.get(i).verb.id]==false)
                    {
                        queue.add(edges.get(i).verb);
                        visited[edges.get(i).verb.id]=true;
                    }
                    else if(edges.get(i).verb.id == elem.id && visited[edges.get(i).vera.id]==false) {
                        queue.add(edges.get(i).vera);
                        visited[edges.get(i).vera.id]=true;
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        List<Edge> edges = new ArrayList<>();
        List<Vertex> vertices = new ArrayList<>();
        Vertex a = new Vertex(0);
        Vertex b = new Vertex(1);
        Vertex c = new Vertex(2);
        Vertex d = new Vertex(3);
        Vertex e = new Vertex(4);
        Vertex f = new Vertex(5);
        vertices.add(a);
        vertices.add(b);
        vertices.add(c);
        vertices.add(d);
        vertices.add(e);
        vertices.add(f);
        edges.add(new Edge(a,b));
        edges.add(new Edge(a,c));
        edges.add(new Edge(a,d));
        edges.add(new Edge(c,e));
        edges.add(new Edge(c,f));
        edges.add(new Edge(b,f));
        graph.BFS(vertices,edges,a);
    }
}
