package com.GeeksForGeeks.Graph;

/**
 * Created by anuj on 27/4/16.
 */
public class Edge {
    Vertex vera;
    Vertex verb;
    int weight;

    Edge(Vertex a, Vertex b){
        vera = a;
        verb = b;

    }

    Edge(Vertex a, Vertex b, int wei){
        vera = a;
        verb = b;
        weight = wei;
    }
}
