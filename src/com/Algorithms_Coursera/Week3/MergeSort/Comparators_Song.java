package com.Algorithms_Coursera.Week3.MergeSort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by anuj.jain02 on 28/2/17.
 */
public class Comparators_Song {

    public static Comparator ByName = new ByName();
    public static Comparator ByArtist = new ByArtist();
    public static Comparator ByDuration = new ByDuration();

    String name;
    String artist;
    Double duration;

    public Comparators_Song(String name, String artist, Double duration) {
        this.name = name;
        this.artist = artist;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Comparators_Song{" +
                "name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", duration=" + duration +
                '}';
    }

    public static class ByName implements Comparator<Comparators_Song> {

        @Override
        public int compare(Comparators_Song o1, Comparators_Song o2) {
            return o1.name.compareTo(o2.name);
        }
    }

    public static class ByArtist implements Comparator<Comparators_Song>{

        @Override
        public int compare(Comparators_Song o1, Comparators_Song o2) {
            return o1.artist.compareTo(o2.artist);
        }
    }

    public static class ByDuration implements Comparator<Comparators_Song>{

        @Override
        public int compare(Comparators_Song o1, Comparators_Song o2) {
            return o1.duration.compareTo(o2.duration);
        }
    }

    public static void main(String[] args) {

        Comparators_Song song1 = new Comparators_Song("Zaalima","Arijit Singh", 4.59);
        Comparators_Song song2 = new Comparators_Song("Badri Ki Dulhaniya","Neha Kakkar", 3.26);
        Comparators_Song song3 = new Comparators_Song("Kaabil Hoon","Jubin Nautiyal", 5.14);
        Comparators_Song song4 = new Comparators_Song("Tamma Tamma","Bappi Lahiri", 3.19);
        Comparators_Song song5 = new Comparators_Song("The Humma Song","A.R.Rehman", 3.00);
        Comparators_Song song6 = new Comparators_Song("Kun Faaya Kun","A.R.Rehman", 7.08);

        Comparators_Song[] songs = {song1, song2, song3, song4, song5, song6};
        Comparators_InsertionSort insertionSort = new Comparators_InsertionSort();
        insertionSort.sort(songs, Comparators_Song.ByName);
        System.out.println(Arrays.asList(songs));
        insertionSort.sort(songs, Comparators_Song.ByArtist);
        System.out.println(Arrays.asList(songs));
        insertionSort.sort(songs, Comparators_Song.ByDuration);
        System.out.println(Arrays.asList(songs));

    }
}
