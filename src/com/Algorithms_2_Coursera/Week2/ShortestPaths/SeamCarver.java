package com.Algorithms_2_Coursera.Week2.ShortestPaths;

import edu.princeton.cs.algs4.AcyclicSP;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.Picture;

import java.awt.Color;

public class SeamCarver {

    private Picture picture;
    private EdgeWeightedDigraph verticalG;
    private EdgeWeightedDigraph horizontalG;

    // create a seam carver object based on the given picture
    public SeamCarver(Picture picture) {
        if (picture == null) {
            throw new IllegalArgumentException();
        }
        this.picture = picture;
    }

    private void createHorizontalG() {
        horizontalG = new EdgeWeightedDigraph(height() * width() + 2);
        int horizontalSourceId = height() * width();
        int horizontalSinkId = height() * width() + 1;
        for (int row = 0 ; row < height() ; row++) {
            horizontalG.addEdge(new DirectedEdge(horizontalSourceId, getGraphNodeId(row, 0), 0));
            horizontalG.addEdge(new DirectedEdge(getGraphNodeId(row, width() - 1), horizontalSinkId, 0));
        }
        for (int row = 0 ; row < height() ; row++) {
            for (int col = 0 ; col < width() - 1 ; col++) {
                horizontalG.addEdge(new DirectedEdge(getGraphNodeId(row, col), getGraphNodeId(row, col + 1), energy(col + 1, row)));
                if (row != 0) {
                    horizontalG.addEdge(new DirectedEdge(getGraphNodeId(row, col), getGraphNodeId(row - 1, col + 1), energy(col + 1, row - 1)));
                }
                if (row != height() - 1) {
                    horizontalG.addEdge(new DirectedEdge(getGraphNodeId(row, col), getGraphNodeId(row + 1, col + 1), energy(col + 1, row + 1)));
                }
            }
        }
    }

    private void createVerticalG() {
        verticalG = new EdgeWeightedDigraph(height() * width() + 2);
        int verticalSourceId = height() * width();
        int verticalSinkId = height() * width() + 1;
        for (int col = 0 ; col < width() ; col++) {
            verticalG.addEdge(new DirectedEdge(verticalSourceId, getGraphNodeId(0, col), 0));
            verticalG.addEdge(new DirectedEdge(getGraphNodeId(height() - 1, col), verticalSinkId, 0));
        }
        for (int col = 0 ; col < width() ; col++) {
            for (int row = 0 ; row < height() - 1 ; row++) {
                verticalG.addEdge(new DirectedEdge(getGraphNodeId(row, col), getGraphNodeId(row + 1, col), energy(col, row + 1)));
                if (col != 0) {
                    verticalG.addEdge(new DirectedEdge(getGraphNodeId(row, col), getGraphNodeId(row + 1, col - 1), energy(col - 1, row + 1)));
                }
                if (col != width() - 1) {
                    verticalG.addEdge(new DirectedEdge(getGraphNodeId(row, col), getGraphNodeId(row + 1, col + 1), energy(col + 1, row + 1)));
                }
            }
        }
    }

    private int getGraphNodeId(int row, int col) {
        return row * width() + col;
    }

    // current picture
    public Picture picture() {
        return this.picture;
    }

    // width of current picture
    public int width() {
        return picture().width();
    }

    // height of current picture
    public int height() {
        return picture().height();
    }

    // energy of pixel at column x and row y
    public double energy(int x, int y) {
        if (x < 0 || x >= width() || y < 0 || y >= height()) {
            throw new IllegalArgumentException();
        }
        // handle corners
        if (x == 0 || y == 0 || x == width() - 1 || y == height() - 1) {
            return 1000;
        }
        double Rx = new Color(picture().getRGB(x+1, y)).getRed() - new Color(picture().getRGB(x-1, y)).getRed();
        double Gx = new Color(picture().getRGB(x+1, y)).getGreen() - new Color(picture().getRGB(x-1, y)).getGreen();
        double Bx = new Color(picture().getRGB(x+1, y)).getBlue() - new Color(picture().getRGB(x-1, y)).getBlue();
        double deltax = Math.pow(Rx, 2) + Math.pow(Gx, 2) + Math.pow(Bx, 2);
        double Ry = new Color(picture().getRGB(x, y+1)).getRed() - new Color(picture().getRGB(x, y-1)).getRed();
        double Gy = new Color(picture().getRGB(x, y+1)).getGreen() - new Color(picture().getRGB(x, y-1)).getGreen();
        double By = new Color(picture().getRGB(x, y+1)).getBlue() - new Color(picture().getRGB(x, y-1)).getBlue();
        double deltay = Math.pow(Ry, 2) + Math.pow(Gy, 2) + Math.pow(By, 2);
        return Math.pow(deltax + deltay, 0.5);
    }

    // sequence of indices for horizontal seam
    public int[] findHorizontalSeam() {
        createHorizontalG();
        AcyclicSP acyclicSP = new AcyclicSP(horizontalG, height() * width());
        int[] horizontalSeam = new int[width()];
        int k = 0;
        for (DirectedEdge edge: acyclicSP.pathTo(height() * width() + 1)) {
            if (k == width()) {
                break;
            }
            horizontalSeam[k++] = getRow(edge.to());
        }
        return horizontalSeam;
    }

    // sequence of indices for vertical seam
    public int[] findVerticalSeam() {
        createVerticalG();
        AcyclicSP acyclicSP = new AcyclicSP(verticalG, height() * width());
        int[] verticalSeam = new int[height()];
        int k = 0;
        for (DirectedEdge edge: acyclicSP.pathTo(height() * width() + 1)) {
            if (k == height()) {
                break;
            }
            verticalSeam[k++] = getCol(edge.to());
        }
        return verticalSeam;
    }

    // remove horizontal seam from current picture
    public void removeHorizontalSeam(int[] seam) {
        if (seam == null || seam.length != width() || height() <= 1) {
            throw new IllegalArgumentException();
        }
        Picture picture1 = new Picture(width(), height() - 1);
        for (int col = 0 ; col < width() ; col++) {
            int seamIdx = seam[col];
            if (seamIdx < 0 || seamIdx >= height()) {
                throw new IllegalArgumentException();
            }
            if (col > 0 && ((seam[col] - seam[col-1]) * (seam[col] - seam[col-1])) > 1) {
                throw new IllegalArgumentException();
            }
            for (int row = 0 ; row < seamIdx ; row++) {
                picture1.set(col, row, picture.get(col, row));
            }
            for (int row = seamIdx + 1 ; row < height() ; row++) {
                picture1.set(col, row - 1, picture.get(col, row));
            }
        }
        picture = picture1;
    }

    private int getRow(int graphNodeId) {
        return graphNodeId / width();
    }

    // remove vertical seam from current picture
    public void removeVerticalSeam(int[] seam) {
        if (seam == null || seam.length != height() || width() <= 1) {
            throw new IllegalArgumentException();
        }
        Picture picture1 = new Picture(width() - 1, height());
        for (int row = 0 ; row < height() ; row++) {
            int seamIdx = seam[row];
            if (seamIdx < 0 || seamIdx >= width()) {
                throw new IllegalArgumentException();
            }
            if (row > 0 && ((seam[row] - seam[row-1]) * (seam[row] - seam[row-1])) > 1) {
                throw new IllegalArgumentException();
            }
            for (int col = 0 ; col < seamIdx ; col++) {
                picture1.set(col, row, picture.get(col, row));
            }
            for (int col = seamIdx + 1 ; col < width() ; col++) {
                picture1.set(col - 1, row, picture.get(col, row));
            }
        }
        picture = picture1;
    }

    private int getCol(int graphNodeId) {
        return graphNodeId % width();
    }

    private void removeVerticalSeamWithColor(int[] seam) {
        if (seam == null || seam.length != height() || height() <= 1) {
            throw new IllegalArgumentException();
        }
        Picture picture1 = new Picture(width(), height());
        for (int row = 0 ; row < height() ; row++) {
            int seamIdx = seam[row];
            if (seamIdx < 0 || seamIdx >= width()) {
                throw new IllegalArgumentException();
            }
            if (row > 0 && ((seam[row] - seam[row-1]) * (seam[row] - seam[row-1])) > 1) {
                throw new IllegalArgumentException();
            }
            for (int col = 0 ; col < seamIdx ; col++) {
                picture1.set(col, row, picture.get(col, row));
            }
            picture1.set(seamIdx, row, Color.RED);
            for (int col = seamIdx + 1 ; col < width() ; col++) {
                picture1.set(col, row, picture.get(col, row));
            }
        }
        picture = picture1;
    }

    //  unit testing (optional)
    public static void main(String[] args) {
        Picture picture1 = new Picture("/com/Algorithms_2_Coursera/Week2/ShortestPaths/6x5.png");
        Picture picture2 = new Picture("/com/Algorithms_2_Coursera/Week2/ShortestPaths/Chicago.jpg");
        Picture picture3 = new Picture("/com/Algorithms_2_Coursera/Week2/ShortestPaths/Broadway_Tower.jpg");
        SeamCarver seamCarver = new SeamCarver(picture3);
        for (int i = 0 ; i < 600 ; i++) {
            System.out.println(i);
            seamCarver.removeVerticalSeam(seamCarver.findVerticalSeam());
        }
        seamCarver.picture().save("Broadway_Tower_Carved.jpg");
    }
}
