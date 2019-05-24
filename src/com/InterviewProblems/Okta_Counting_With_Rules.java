package com.InterviewProblems;


import javafx.util.Pair;

import java.util.*;

public class Okta_Counting_With_Rules {

    /**
     * Class containing Client with their Timestamp
     */
    public static class ClientTimestamp implements Comparable{
        public String client;
        public Integer timestamp;

        public ClientTimestamp(String client, Integer timestamp) {
            this.client = client;
            this.timestamp = timestamp;
        }

        /**
         * Comparator that compares client, and then threshold to have a sorted order
         */
        @Override
        public int compareTo(Object o) {
            if (this.client.compareTo(((ClientTimestamp)o).client) == 0) {
                return this.timestamp.compareTo(((ClientTimestamp)o).timestamp);
            }
            return this.client.compareTo(((ClientTimestamp)o).client);
        }
    }

    /**
     * Class containing the Client Timestamp map in the the interval (stored as a string concatenating start time and end time with a hyphen)
     */
    public static class IntervalClientTimestamp implements Comparable{
        public String interval;
        public Map<String, Integer> clientTimestampMap;

        public IntervalClientTimestamp(String interval, Map<String, Integer> clientTimestampMap) {
            this.interval = interval;
            this.clientTimestampMap = clientTimestampMap;
        }

        /**
         * Comparator that compares the starting time of intervals
         */
        @Override
        public int compareTo(Object o) {
            Integer start1 = Integer.parseInt(this.interval.split("-")[0]);
            Integer start2 = (Integer.parseInt(((IntervalClientTimestamp)o).interval.split("-")[0]));
            return start1.compareTo(start2);
        }
    }

    public static String[] solution(String[] A, int Y) {

        List<ClientTimestamp> clientTimestampList = new ArrayList<>();
        for (String a: A) {
            String[] clientTimestamp = a.split(" ");
            clientTimestampList.add(new ClientTimestamp(clientTimestamp[0], Integer.parseInt(clientTimestamp[1])));
        }
        Collections.sort(clientTimestampList); //O(M*logM)
        int startTime = 0, endTime = 59; //base case
        String currentClient = clientTimestampList.get(0).client;
        Map<String, Map<String, Integer>> intervalToClientToAllowedRequestsMap = new HashMap<>();
        for (ClientTimestamp clientTimestamp : clientTimestampList) {
            if (!clientTimestamp.client.equals(currentClient)) { //client has changes ; so re-initializing
                startTime = 0;
                endTime = 59;
                currentClient = clientTimestamp.client;
            }
            while(clientTimestamp.timestamp > endTime) { //looping if timestamps scattered
                startTime = endTime + 1;
                endTime = startTime + 59;
            }
            if(intervalToClientToAllowedRequestsMap.get(startTime+"-"+endTime) == null) {
                Map<String, Integer> clientToAllowedRequestsMap = new HashMap<>();
                clientToAllowedRequestsMap.put(clientTimestamp.client, 1);
                intervalToClientToAllowedRequestsMap.put(startTime+"-"+endTime, clientToAllowedRequestsMap);
            } else {
                Map<String, Integer> clientToAllowedRequestsMap = intervalToClientToAllowedRequestsMap.get(startTime+"-"+endTime);
                if (clientToAllowedRequestsMap.get(clientTimestamp.client) == null) {
                    clientToAllowedRequestsMap.put(clientTimestamp.client, 1);
                } else {
                    if (clientToAllowedRequestsMap.get(clientTimestamp.client) != Y) { //if max limit not reached
                        clientToAllowedRequestsMap.put(clientTimestamp.client, clientToAllowedRequestsMap.get(clientTimestamp.client) + 1);
                    }
                }
            }
        }

        List<IntervalClientTimestamp> listOfMapOfAllowedRequests = new ArrayList<>();
        for (Map.Entry<String, Map<String, Integer>> entry : intervalToClientToAllowedRequestsMap.entrySet()) {
            listOfMapOfAllowedRequests.add(new IntervalClientTimestamp(entry.getKey(), entry.getValue()));
        }
        Collections.sort(listOfMapOfAllowedRequests);
        for (int i = 0 ; i < listOfMapOfAllowedRequests.size() ; i++) {

            int sTime = Integer.parseInt(listOfMapOfAllowedRequests.get(i).interval.split("-")[0]);

            for (String client_n : listOfMapOfAllowedRequests.get(i).clientTimestampMap.keySet()) {
                int totalRequests = 0;
                int clientRequests = 0;
                if (i < 5) { // if there are less than 5 intervals before the current interval
                    for (int j = 0; j <= i; j++) {
                        for (Map.Entry<String, Integer> entry : listOfMapOfAllowedRequests.get(j).clientTimestampMap.entrySet()) {
                            totalRequests += entry.getValue();
                            if (entry.getKey().equals(client_n)) {
                                clientRequests += entry.getValue();
                            }
                        }
                    }
                } else {
                    for (int j = i - 1; j >= i - 5; j--) {
                        if (Integer.parseInt(listOfMapOfAllowedRequests.get(j).interval.split("-")[0]) < sTime - 300) { //logic to check if this interval lies within 5 mins
                            break; //can break because we are maintaining sorted order
                        }
                        for (Map.Entry<String, Integer> entry : listOfMapOfAllowedRequests.get(j).clientTimestampMap.entrySet()) {
                            totalRequests += entry.getValue();
                            if (entry.getKey().equals(client_n)) {
                                clientRequests += entry.getValue();
                            }
                        }
                    }
                }
                if(totalRequests >= 10 && clientRequests > 0.5* totalRequests) { // blocking conditions
                    if (listOfMapOfAllowedRequests.size() > i+1) { // trying to block the next min
                        if(Integer.parseInt(listOfMapOfAllowedRequests.get(i+1).interval.split("-")[0]) == sTime + 60) {
                            listOfMapOfAllowedRequests.get(i+1).clientTimestampMap.remove(client_n);
                        }
                    }
                    if (listOfMapOfAllowedRequests.size() > i+2) { // trying to block the 2nd min
                        if(Integer.parseInt(listOfMapOfAllowedRequests.get(i+2).interval.split("-")[0]) == sTime + 120) {
                            listOfMapOfAllowedRequests.get(i+2).clientTimestampMap.remove(client_n);
                        }
                    }
                }
            }
        }
        //generating the solution
        Map<String, Integer> solution = new HashMap<>();
        for (IntervalClientTimestamp intervalClientTimestamp : listOfMapOfAllowedRequests) {
            for (Map.Entry<String, Integer> entry : intervalClientTimestamp.clientTimestampMap.entrySet()) {
                if(solution.get(entry.getKey()) == null) {
                    solution.put(entry.getKey(), entry.getValue());
                } else {
                    solution.put(entry.getKey(), solution.get(entry.getKey()) + entry.getValue());
                }
            }
        }
        List<String> solut = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : solution.entrySet()) {
            solut.add(entry.getKey()+" "+entry.getValue());
        }
        Collections.sort(solut);
        return solut.stream().toArray(String[]::new);

    }

    public static void main(String[] args) {
        String[] A = {
                "bella 0",
                "bella 15",
                "bella 59",
                "bella 59",
                "bella 60",
                "bella 62",
                "bella 80",
                "bella 120",
                "bella 180",
                "bella 240",
                "erica 0",
                "erica 60",
                "erica 120",
                "erica 180",
                "erica 240",
                "erica 320"
                };
        System.out.println(Arrays.toString(solution(A, 3)));
    }

}
/**
 *
 */
