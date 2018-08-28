package com.GeeksForGeeks.Backtracking;

import edu.princeton.cs.algs4.StdRandom;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anuj.jain02 on 11/3/17.
 */
public class Loop_The_Loop {

    static int N = 7;
    static int baseFlag = 0;
    static boolean completed = false;

    private enum Direction{
        RIGHT("RIGHT"), BOTTOM("BOTTOM"), LEFT("LEFT"), TOP("TOP");

        String code;

        Direction(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public Direction setCode(String code) {
            this.code = code;
            return this;
        }

        public static Direction fromString(String string) {
            if (string != null) {
                for (Direction b : Direction.values()) {
                    if (string.equalsIgnoreCase(b.getCode())) {
                        return b;
                    }
                }
            }
            return null;
        }
    }



    private enum Operation{
        INCREMENT, DECREMENT
    }

    public static class Edge{
        Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> vertices;
        Direction direction;

        public Edge(Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> vertices, Direction direction) {
            this.vertices = vertices;
            this.direction = direction;
        }

        public Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> getVertices() {
            return vertices;
        }

        public Edge setVertices(Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> vertices) {
            this.vertices = vertices;
            return this;
        }

        public Direction getDirection() {
            return direction;
        }

        public Edge setDirection(Direction direction) {
            this.direction = direction;
            return this;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "vertices=" + vertices +
                    ", direction=" + direction +
                    '}';
        }
    }

    static List<Edge> edges = new ArrayList<>();

    static int[][] question = {
            {+3, +2, +1, +0, +0, +0, +0},
            {+3, +2, +2, +1, +1, +1, +0},
            {+3, +0, +2, +1, +2, +2, +4},
            {+3, +4, +4, +3, +3, +2, +3},
            {+2, +2, +1, +1, +1, +4, +2},
            {+2, +3, +1, +4, +3, +4, +3},
            {+2, +2, +2, +2, +1, +2, +2}
    };

    static int[][] count = new int[N][N];

    static boolean[][] visited = new boolean[N+1][N+1];

    private static void getSolution(Pair<Integer, Integer> currentPosition){

        if(completed){
            return;
        }

        if(currentPosition.equals(new Pair<Integer, Integer>(0,0))){
            baseFlag++;
            if(baseFlag == 2){
                completed = true;
                return;
            }
        }

        int random = StdRandom.uniform(0,24);
        String[] directionOrdering = new String[4];
        switch (random){
            case 0 :
                directionOrdering = new String[]{"RIGHT", "BOTTOM", "LEFT", "TOP"};
                break;
            case 1 :
                directionOrdering = new String[]{"RIGHT", "BOTTOM", "TOP", "LEFT"};
                break;
            case 2 :
                directionOrdering = new String[]{"RIGHT", "LEFT", "BOTTOM", "TOP"};
                break;
            case 3 :
                directionOrdering = new String[]{"RIGHT", "LEFT", "TOP", "BOTTOM"};
                break;
            case 4 :
                directionOrdering = new String[]{"RIGHT", "TOP", "LEFT", "BOTTOM"};
                break;
            case 5 :
                directionOrdering = new String[]{"RIGHT", "TOP", "BOTTOM", "LEFT"};
                break;

            case 6 :
                directionOrdering = new String[]{"BOTTOM", "RIGHT", "LEFT", "TOP"};
                break;
            case 7 :
                directionOrdering = new String[]{"BOTTOM", "RIGHT", "TOP", "LEFT"};
                break;
            case 8 :
                directionOrdering = new String[]{"BOTTOM", "LEFT", "RIGHT", "TOP"};
                break;
            case 9 :
                directionOrdering = new String[]{"BOTTOM", "LEFT", "TOP", "RIGHT"};
                break;
            case 10 :
                directionOrdering = new String[]{"BOTTOM", "TOP", "RIGHT", "LEFT"};
                break;
            case 11 :
                directionOrdering = new String[]{"BOTTOM", "TOP", "LEFT", "RIGHT"};
                break;

            case 12 :
                directionOrdering = new String[]{"LEFT", "BOTTOM", "RIGHT", "TOP"};
                break;
            case 13 :
                directionOrdering = new String[]{"LEFT", "BOTTOM", "TOP", "RIGHT"};
                break;
            case 14 :
                directionOrdering = new String[]{"LEFT", "TOP", "RIGHT", "BOTTOM"};
                break;
            case 15 :
                directionOrdering = new String[]{"LEFT", "TOP", "BOTTOM", "RIGHT"};
                break;
            case 16 :
                directionOrdering = new String[]{"LEFT", "RIGHT", "BOTTOM", "TOP"};
                break;
            case 17 :
                directionOrdering = new String[]{"LEFT", "RIGHT", "TOP", "BOTTOM"};
                break;

            case 18 :
                directionOrdering = new String[]{"TOP", "BOTTOM", "LEFT", "RIGHT"};
                break;
            case 19 :
                directionOrdering = new String[]{"TOP", "BOTTOM", "RIGHT", "LEFT"};
                break;
            case 20 :
                directionOrdering = new String[]{"TOP", "LEFT", "RIGHT", "BOTTOM"};
                break;
            case 21 :
                directionOrdering = new String[]{"TOP", "LEFT", "BOTTOM", "RIGHT"};
                break;
            case 22 :
                directionOrdering = new String[]{"TOP", "RIGHT", "LEFT", "BOTTOM"};
                break;
            case 23 :
                directionOrdering = new String[]{"TOP", "RIGHT", "BOTTOM", "LEFT"};
                break;


        }

        if (!completed && check(currentPosition, Direction.fromString(directionOrdering[0]))){
            Pair<Integer, Integer> nextPosition = getNextPosition(currentPosition, Direction.fromString(directionOrdering[0]));
            Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> vertices = new Pair<>(currentPosition, nextPosition);
            edges.add(new Edge(vertices, Direction.fromString(directionOrdering[0])));
            countHandler(currentPosition, Direction.fromString(directionOrdering[0]), Operation.INCREMENT);
            visited[nextPosition.getKey()][nextPosition.getValue()] = true;
            getSolution(nextPosition);
        }

        if (!completed && check(currentPosition, Direction.fromString(directionOrdering[1]))) {
            Pair<Integer, Integer> nextPosition = getNextPosition(currentPosition, Direction.fromString(directionOrdering[1]));
            Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> vertices = new Pair<>(currentPosition, nextPosition);
            edges.add(new Edge(vertices, Direction.fromString(directionOrdering[1])));
            countHandler(currentPosition, Direction.fromString(directionOrdering[1]), Operation.INCREMENT);
            visited[nextPosition.getKey()][nextPosition.getValue()] = true;
            getSolution(nextPosition);
        }

        if (!completed && check(currentPosition, Direction.fromString(directionOrdering[2]))) {
            Pair<Integer, Integer> nextPosition = getNextPosition(currentPosition, Direction.fromString(directionOrdering[2]));
            Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> vertices = new Pair<>(currentPosition, nextPosition);
            edges.add(new Edge(vertices, Direction.fromString(directionOrdering[2])));
            countHandler(currentPosition, Direction.fromString(directionOrdering[2]), Operation.INCREMENT);
            visited[nextPosition.getKey()][nextPosition.getValue()] = true;
            getSolution(nextPosition);
        }

        if (!completed && check(currentPosition, Direction.fromString(directionOrdering[3]))) {
            Pair<Integer, Integer> nextPosition = getNextPosition(currentPosition, Direction.fromString(directionOrdering[3]));
            Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> vertices = new Pair<>(currentPosition, nextPosition);
            edges.add(new Edge(vertices, Direction.fromString(directionOrdering[3])));
            countHandler(currentPosition, Direction.fromString(directionOrdering[3]), Operation.INCREMENT);
            visited[nextPosition.getKey()][nextPosition.getValue()] = true;
            getSolution(nextPosition);
        }

        //backtrack remove edge if flag false
        if(!completed) {
            Edge edge = edges.get(edges.size() - 1);
            countHandler(edge.getVertices().getKey(), edge.direction, Operation.DECREMENT);
            edges.remove(edges.size() - 1);
            visited[edge.getVertices().getValue().getKey()][edge.getVertices().getValue().getValue()] = false;
        }

    }

    private static Pair<Integer,Integer> getNextPosition(Pair<Integer, Integer> currentPosition, Direction direction) {
        if(direction.equals(Direction.RIGHT))
            return new Pair<>(currentPosition.getKey(), currentPosition.getValue()+1);
        if(direction.equals(Direction.BOTTOM))
            return new Pair<>(currentPosition.getKey()+1, currentPosition.getValue());
        if(direction.equals(Direction.LEFT))
            return new Pair<>(currentPosition.getKey(), currentPosition.getValue()-1);
        if(direction.equals(Direction.TOP))
            return new Pair<>(currentPosition.getKey()-1 , currentPosition.getValue());
        return null;
    }

    private static boolean check(Pair<Integer, Integer> currentPosition, Direction direction){

        if(direction.equals(Direction.RIGHT)){
            if (currentPosition.getValue() == N || visited[currentPosition.getKey()][currentPosition.getValue()+1])
                return false;
            if(currentPosition.getKey() == 0){
                return count[currentPosition.getKey()][currentPosition.getValue()] < question[currentPosition.getKey()][currentPosition.getValue()];
            }
            if(currentPosition.getKey() == N){
                return count[currentPosition.getKey()-1][currentPosition.getValue()] < question[currentPosition.getKey()-1][currentPosition.getValue()];
            }
            return count[currentPosition.getKey()][currentPosition.getValue()] < question[currentPosition.getKey()][currentPosition.getValue()]
                   &&
                   count[currentPosition.getKey()-1][currentPosition.getValue()] < question[currentPosition.getKey()-1][currentPosition.getValue()];
        }

        if(direction.equals(Direction.BOTTOM)){
            if (currentPosition.getKey() == N || visited[currentPosition.getKey()+1][currentPosition.getValue()])
                return false;
            if(currentPosition.getValue() == 0){
                return count[currentPosition.getKey()][currentPosition.getValue()] < question[currentPosition.getKey()][currentPosition.getValue()];
            }
            if(currentPosition.getValue() == N){
                return count[currentPosition.getKey()][currentPosition.getValue()-1] < question[currentPosition.getKey()][currentPosition.getValue()-1];
            }
            return count[currentPosition.getKey()][currentPosition.getValue()] < question[currentPosition.getKey()][currentPosition.getValue()]
                   &&
                   count[currentPosition.getKey()][currentPosition.getValue()-1] < question[currentPosition.getKey()][currentPosition.getValue()-1];
        }

        if(direction.equals(Direction.LEFT)){
            if (currentPosition.getValue() == 0 || visited[currentPosition.getKey()][currentPosition.getValue()-1])
                return false;
            if(currentPosition.getKey() == 0){
                return count[currentPosition.getKey()][currentPosition.getValue()-1] < question[currentPosition.getKey()][currentPosition.getValue()-1];
            }
            if(currentPosition.getKey() == N){
                return count[currentPosition.getKey()-1][currentPosition.getValue()-1] < question[currentPosition.getKey()-1][currentPosition.getValue()-1];
            }
            return count[currentPosition.getKey()][currentPosition.getValue()-1] < question[currentPosition.getKey()][currentPosition.getValue()-1]
                   &&
                   count[currentPosition.getKey()-1][currentPosition.getValue()-1] < question[currentPosition.getKey()-1][currentPosition.getValue()-1];
        }

        if(direction.equals(Direction.TOP)){
            if (currentPosition.getKey() == 0 || visited[currentPosition.getKey()-1][currentPosition.getValue()])
                return false;
            if(currentPosition.getValue() == 0){
                return count[currentPosition.getKey()-1][currentPosition.getValue()] < question[currentPosition.getKey()-1][currentPosition.getValue()];
            }
            if(currentPosition.getValue() == N){
                return count[currentPosition.getKey()-1][currentPosition.getValue()-1] < question[currentPosition.getKey()-1][currentPosition.getValue()-1];
            }
            return count[currentPosition.getKey()-1][currentPosition.getValue()] < question[currentPosition.getKey()-1][currentPosition.getValue()]
                   &&
                   count[currentPosition.getKey()-1][currentPosition.getValue()-1] < question[currentPosition.getKey()-1][currentPosition.getValue()-1];
        }

        return false; //should never happen
    }

    private static void countHandler(Pair<Integer, Integer> currentPosition, Direction direction, Operation operation){

        if(direction.equals(Direction.RIGHT)){
            if(operation.equals(Operation.INCREMENT)){
                if(currentPosition.getKey() == 0){
                    count[currentPosition.getKey()][currentPosition.getValue()]++;
                }
                else if(currentPosition.getKey() == N){
                    count[currentPosition.getKey()-1][currentPosition.getValue()]++;
                }
                else {
                    count[currentPosition.getKey()-1][currentPosition.getValue()]++;
                    count[currentPosition.getKey()][currentPosition.getValue()]++;
                }
            }
            if(operation.equals(Operation.DECREMENT)){
                if(currentPosition.getKey() == 0){
                    count[currentPosition.getKey()][currentPosition.getValue()]--;
                }
                else if(currentPosition.getKey() == N){
                    count[currentPosition.getKey()-1][currentPosition.getValue()]--;
                }
                else {
                    count[currentPosition.getKey()-1][currentPosition.getValue()]--;
                    count[currentPosition.getKey()][currentPosition.getValue()]--;
                }
            }
        }

        if(direction.equals(Direction.BOTTOM)){
            if(operation.equals(Operation.INCREMENT)){
                if(currentPosition.getValue() == 0){
                    count[currentPosition.getKey()][currentPosition.getValue()]++;
                }
                else if(currentPosition.getValue() == N) {
                    count[currentPosition.getKey()][currentPosition.getValue()-1]++;
                }
                else {
                    count[currentPosition.getKey()][currentPosition.getValue()-1]++;
                    count[currentPosition.getKey()][currentPosition.getValue()]++;
                }
            }
            if(operation.equals(Operation.DECREMENT)){
                if(currentPosition.getValue() == 0){
                    count[currentPosition.getKey()][currentPosition.getValue()]--;
                }
                else if(currentPosition.getValue() == N) {
                    count[currentPosition.getKey()][currentPosition.getValue()-1]--;
                }
                else {
                    count[currentPosition.getKey()][currentPosition.getValue()-1]--;
                    count[currentPosition.getKey()][currentPosition.getValue()]--;
                }
            }
        }

        if(direction.equals(Direction.LEFT)){
            if(operation.equals(Operation.INCREMENT)){
                if(currentPosition.getKey() == 0){
                    count[currentPosition.getKey()][currentPosition.getValue()-1]++;
                }
                else if(currentPosition.getKey() == N){
                    count[currentPosition.getKey()-1][currentPosition.getValue()-1]++;
                }
                else {
                    count[currentPosition.getKey()-1][currentPosition.getValue()-1]++;
                    count[currentPosition.getKey()][currentPosition.getValue()-1]++;
                }
            }
            if(operation.equals(Operation.DECREMENT)) {
                if(currentPosition.getKey() == 0){
                    count[currentPosition.getKey()][currentPosition.getValue()-1]--;
                }
                else if(currentPosition.getKey() == N){
                    count[currentPosition.getKey()-1][currentPosition.getValue()-1]--;
                }
                else {
                    count[currentPosition.getKey()-1][currentPosition.getValue()-1]--;
                    count[currentPosition.getKey()][currentPosition.getValue()-1]--;
                }
            }
        }

        if(direction.equals(Direction.TOP)){
            if(operation.equals(Operation.INCREMENT)){
                if(currentPosition.getValue() == 0){
                    count[currentPosition.getKey()-1][currentPosition.getValue()]++;
                }
                else if(currentPosition.getValue() == N){
                    count[currentPosition.getKey()-1][currentPosition.getValue()-1]++;
                }
                else {
                    count[currentPosition.getKey()-1][currentPosition.getValue()-1]++;
                    count[currentPosition.getKey()-1][currentPosition.getValue()]++;
                }
            }
            if(operation.equals(Operation.DECREMENT)){
                if(currentPosition.getValue() == 0){
                    count[currentPosition.getKey()-1][currentPosition.getValue()]--;
                }
                else if(currentPosition.getValue() == N){
                    count[currentPosition.getKey()-1][currentPosition.getValue()-1]--;
                }
                else {
                    count[currentPosition.getKey()-1][currentPosition.getValue()-1]--;
                    count[currentPosition.getKey()-1][currentPosition.getValue()]--;
                }
            }
        }
    }

    private static boolean isDone(){
        for(int i = 0; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(question[i][j] != +4){
                    if(count[i][j] != question[i][j])
                        return false;
                }
            }
        }
        return true;
    }

    private static void reset(){
        edges = new ArrayList<>();
        count = new int[N][N];
        visited = new boolean[N+1][N+1];
        baseFlag = 0;
        completed = false;
    }

    public static void main(String[] args) {
        int tryCount = 1;
        while(!isDone()) {
            System.out.println("Trying for the: "+tryCount+++" time");
            System.out.println(edges.toString());
            reset();
            getSolution(new Pair<>(0, 0));
        }
        System.out.println(edges.toString());
    }

}
