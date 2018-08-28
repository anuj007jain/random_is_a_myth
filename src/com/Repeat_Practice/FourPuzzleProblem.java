package com.Repeat_Practice;

import java.util.*;

//add solvability
//convert this problem to N Puzzle Problem later, also start finding the best path.
//array deep equals / deep hashcode
public class FourPuzzleProblem {

    public enum Steps {
        UP, DOWN, LEFT, RIGHT
    }

    private List<Steps> findSolution(Tile initialTile, Tile goalTile) {
        Coords emptyLocation = findEmptyLocation(initialTile);
        Set<Tile> visitedTiles = new HashSet<>();
        visitedTiles.add(new Tile(initialTile));
        return findSolutionInternal(initialTile, goalTile, emptyLocation, new ArrayList<>(), visitedTiles);
    }

    private List<Steps> findSolutionInternal(Tile currentTile, Tile goalTile, Coords emptyLocation,
                                             List<Steps> steps, Set<Tile> visitedTiles) {
        if(currentTile.equals(goalTile)) {
            System.out.println(steps);
            return steps;
        }
        if(movementAllowed(Steps.UP, currentTile, visitedTiles)) {
            steps.add(Steps.UP);
            swap(currentTile, emptyLocation, new Coords(emptyLocation.getX()-1, emptyLocation.getY()));
            emptyLocation.setX(emptyLocation.getX()-1);
            visitedTiles.add(new Tile(currentTile));
            findSolutionInternal(currentTile, goalTile, emptyLocation, steps, visitedTiles);
        }
        if(movementAllowed(Steps.DOWN, currentTile, visitedTiles)) {
            steps.add(Steps.DOWN);
            swap(currentTile, emptyLocation, new Coords(emptyLocation.getX()+1, emptyLocation.getY()));
            emptyLocation.setX(emptyLocation.getX()+1);
            visitedTiles.add(new Tile(currentTile));
            findSolutionInternal(currentTile, goalTile, emptyLocation, steps, visitedTiles);
        }
        if(movementAllowed(Steps.LEFT, currentTile, visitedTiles)) {
            steps.add(Steps.LEFT);
            swap(currentTile, emptyLocation, new Coords(emptyLocation.getX(), emptyLocation.getY()-1));
            emptyLocation.setY(emptyLocation.getY()-1);
            visitedTiles.add(new Tile(currentTile));
            findSolutionInternal(currentTile, goalTile, emptyLocation, steps, visitedTiles);
        }
        if(movementAllowed(Steps.RIGHT, currentTile, visitedTiles)) {
            swap(currentTile, emptyLocation, new Coords(emptyLocation.getX(), emptyLocation.getY()+1));
            steps.add(Steps.RIGHT);
            emptyLocation.setY(emptyLocation.getY()+1);
            visitedTiles.add(new Tile(currentTile));
            findSolutionInternal(currentTile, goalTile, emptyLocation, steps, visitedTiles);
        }
        //backtracking
        return null;
    }

    private void swap(Tile currentTile, Coords emptyLocation, Coords swappingLocation) {
        int temp = currentTile.configuration[emptyLocation.getX()][emptyLocation.getY()];
        currentTile.configuration[emptyLocation.getX()][emptyLocation.getY()] =
                currentTile.configuration[swappingLocation.getX()][swappingLocation.getY()];
        currentTile.configuration[swappingLocation.getX()][swappingLocation.getY()] = temp;
    }

    private boolean movementAllowed(Steps steps, Tile currentTile, Set<Tile> visitedTiles) {
        Tile copyCurrentTile = new Tile(currentTile);
        Coords emptyLocation = findEmptyLocation(copyCurrentTile);
        boolean movementAllowed = false;
        switch (steps) {
            case UP:
                if(emptyLocation.getX()==0)
                    return false;
                swap(copyCurrentTile, emptyLocation, new Coords(emptyLocation.getX()-1, emptyLocation.getY()));
                if(visitedTiles.contains(copyCurrentTile))
                    return false;
                movementAllowed = true;
                break;
            case DOWN:
                if(emptyLocation.getX()==1)
                    return false;
                swap(copyCurrentTile, emptyLocation, new Coords(emptyLocation.getX()+1, emptyLocation.getY()));
                if(visitedTiles.contains(copyCurrentTile))
                    return false;
                movementAllowed = true;
                break;
            case LEFT:
                if(emptyLocation.getY()==0)
                    return false;
                swap(copyCurrentTile, emptyLocation, new Coords(emptyLocation.getX(), emptyLocation.getY()-1));
                if(visitedTiles.contains(copyCurrentTile))
                    return false;
                movementAllowed = true;
                break;
            case RIGHT:
                if(emptyLocation.getY()==1)
                    return false;
                swap(copyCurrentTile, emptyLocation, new Coords(emptyLocation.getX(), emptyLocation.getY()+1));
                if(visitedTiles.contains(copyCurrentTile))
                    return false;
                movementAllowed = true;
        }
        return movementAllowed;
    }

    private Coords findEmptyLocation(Tile currentTile) {
        for(int row = 0 ; row < currentTile.configuration.length ; row++) {
            for (int column = 0 ; column < (currentTile.configuration)[row].length ; column++) {
                if(currentTile.configuration[row][column] == 0) {
                    return new Coords(row, column);
                }
            }
        }
        return null;
    }

    public class Coords {

        public Coords(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }

        private Integer x;
        private Integer y;

        public Integer getX() {
            return x;
        }

        public void setX(Integer x) {
            this.x = x;
        }

        public Integer getY() {
            return y;
        }

        public void setY(Integer y) {
            this.y = y;
        }
    }

    public static class Tile {

        int[][] configuration;

        public Tile(int[][] configuration) {
            this.configuration = configuration;
        }

        public Tile(Tile tile) {
            this.configuration = new int[tile.configuration.length][tile.configuration.length];
            this.configuration[0] = tile.configuration[0].clone();
            this.configuration[1] = tile.configuration[1].clone();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tile tile = (Tile) o;
            if(this.configuration.length != tile.configuration.length)
                return false;
            for(int row = 0 ; row < this.configuration.length ; row++) {
                if(this.configuration[row].length != tile.configuration[row].length)
                    return false;
                for(int column = 0 ; column < this.configuration[row].length ; column++) {
                    if(this.configuration[row][column] != tile.configuration[row][column])
                        return false;
                }
            }
            return true;
        }

        @Override
        public int hashCode() {
            return Arrays.deepHashCode(configuration);
        }
    }

    public static void main(String[] args) {
        FourPuzzleProblem fpp = new FourPuzzleProblem();
        int[][] initialTile1 = {{1,2},{3,0}};
        int[][] initialTile2 = {{1,2},{0,3}};
        int[][] goalTile = {{1,2},{3,0}};
        System.out.println(fpp.findSolution(new Tile(initialTile2), new Tile(goalTile)));
    }
}
