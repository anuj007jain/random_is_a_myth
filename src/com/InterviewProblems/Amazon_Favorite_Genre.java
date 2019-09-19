package com.InterviewProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Amazon_Favorite_Genre {

    HashMap<String, List<String>> favoriteVideoGenre(int numUsers,
                                                     HashMap<String, List<String>> userVideosWatched,
                                                     int numGenres,
                                                     HashMap<String, List<String>> videoGenres)
    {
        //pre process information
        Map<String, String> movieToGenreMap = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : videoGenres.entrySet()) {
            String genre = entry.getKey();
            for (String movie : entry.getValue()) {
                movieToGenreMap.put(movie, genre);
            }
        }

        Map<String, List<String>> favoriteVideoGenre = new HashMap<>();

        for (Map.Entry<String, List<String>> entry : userVideosWatched.entrySet()) {
            String user = entry.getKey();
            Map<String, Integer> genreToCountMap = new HashMap<>();
            int maxCommonCount = 0;
            for (String movie : entry.getValue()) {
                String genre = movieToGenreMap.get(movie);
                Integer count = genreToCountMap.getOrDefault(genre, 0);
                genreToCountMap.put(genre, count + 1);
                if (maxCommonCount < count + 1) {
                    maxCommonCount = count + 1;
                }
            }
            List<String> mostCommonGenres = new ArrayList<>();
            for (Map.Entry<String, Integer> entry1 : genreToCountMap.entrySet()) {
                if (entry1.getValue() == maxCommonCount) {
                    mostCommonGenres.add(entry1.getKey());
                }
            }
            favoriteVideoGenre.put(user, mostCommonGenres);
        }
        return (HashMap<String, List<String>>) favoriteVideoGenre;
    }

    public static void main(String[] args) {

    }

}
