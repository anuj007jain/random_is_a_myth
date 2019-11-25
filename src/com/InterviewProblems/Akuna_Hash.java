package com.InterviewProblems;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Akuna_Hash {

    public static class HashTable {

        List<Event> events;
        Instant watermark = Instant.ofEpochMilli(0);
        Map<String, String> table;

        class Event implements Comparable{
            String epoch;
            String type;
            String key;
            String value;

            public Event(String epoch, String type, String key, String value) {
                this.epoch = epoch;
                this.type = type;
                this.key = key;
                this.value = value;
            }

            @Override
            public int compareTo(Object o) {
                return this.epoch.compareTo(((Event)o).epoch);
            }
        }

        public HashTable(ArrayList<String> rawEvents) {
            events = new ArrayList<>();
            for (String event: rawEvents) {
                String[] eventElems = event.split("\\|");
                events.add(new Event(eventElems[0], eventElems[1], eventElems[2], eventElems[3]));
            }
            Collections.sort(events);

            table = new HashMap<>();
            for (Event event : events) {
                watermark = Instant.ofEpochMilli(Long.parseLong(event.epoch));
                if (event.type.equalsIgnoreCase("INSERT")) {
                    if (!table.containsKey(event.key)) {
                        table.put(event.key, event.value);
                    }
                }
                else if (event.type.equalsIgnoreCase("UPSERT")) {
                    table.put(event.key, event.value);
                }
                else {
                    if (table.containsKey(event.key)) {
                        table.remove(event.key);
                    }
                }
            }
        }

        /**
         * Retrieve the state of the HashTable after applying all input events
         *
         * @return a Map representing the Keys and Values of the current state
         */
        public Map<String, String> getTable() {
            return table;
        }

        /**
         * Retrieve the high-watermark of the HashTable as the millisecond epoch timestamp
         * of the latest event read or Instant.EPOCH in the case where no event occurred.
         *
         * @return an Instant representing the high watermark
         */
        public Instant getHighWatermark() {
            return watermark;  // TODO
        }

//        public static void main(String[] args) {
//            List<String>  list = new ArrayList<>();
//            list.add("1563454984001|INSERT|test|123");
//            list.add("1563454984003|INSERT|test_2|234");
//            list.add("1563454984002|INSERT|test_3|345");
//            HashTable ht = new HashTable((ArrayList<String>) list);
//            System.out.println(ht.getTable());
//            System.out.println(ht.getHighWatermark());
//        }

        public static void printReport(HashTable table) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                    .withZone(ZoneId.of("UTC"));
            System.out.println("High Watermark: " + formatter.format(table.getHighWatermark()));
            System.out.println("\nTable State:");
            TreeMap<String, String> sortedTable = new TreeMap<>(table.getTable());
            if (!sortedTable.isEmpty()) {
                sortedTable.forEach((x, y) -> System.out.println("\t" + x + ": " + y));
            }
        }

        public static ArrayList<String> getStdin() {
            Scanner s = new Scanner(System.in);
            ArrayList<String> rawEvents = new ArrayList<String>();
            while (s.hasNext()){
                rawEvents.add(s.next());
            }
            s.close();

            return rawEvents;
        }

        public static void main(String args[] ) throws Exception {
            List<String>  list = new ArrayList<>();
            list.add("1563454984001|INSERT|test|123");
            list.add("1563454984003|INSERT|test_2|234");
            list.add("1563454984002|INSERT|test_3|345");
            HashTable table = new HashTable((ArrayList<String>) list);
            printReport(table);
        }
    }

}
