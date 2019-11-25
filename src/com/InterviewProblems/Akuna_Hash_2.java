package com.InterviewProblems;


import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Akuna_Hash_2 {
    /**
     * A class which wraps a raw binary WAL and reconstructs DML Events.
     */
    public static class WAL {

        List<String> sol = new ArrayList<>();

        /**
         * Construct the WAL
         *
         * @param input the raw binary WAL
         */
        public WAL(byte[] input) {

            int i = 0;
            while (i < input.length) {
                byte[] epoch = new byte[8];
                for (int j = 0; j < 8; j++) {
                    epoch[j] = input[i++];
                }
                ByteBuffer wrapp = ByteBuffer.wrap(epoch);
                long ep = wrapp.getLong();

                byte[] mid = new byte[1];
                mid[0] = input[i++];
                wrapp = ByteBuffer.wrap(mid);
                int type = wrapp.get();

                byte[] keylen = new byte[2];
                keylen[0] = input[i++];
                keylen[1] = input[i++];
                wrapp = ByteBuffer.wrap(keylen);
                short keyl = wrapp.getShort();

                byte[] keyArr = new byte[keyl];
                for (int j = 0; j < keyl; j++) {
                    keyArr[j] = input[i++];
                }
                String key = new String(keyArr);

                String val = "";
                if (type != 2) {
                    byte[] valLenArr = new byte[2];
                    valLenArr[0] = input[i++];
                    valLenArr[1] = input[i++];
                    wrapp = ByteBuffer.wrap(valLenArr);
                    short valLen = wrapp.getShort();

                    byte[] valArr = new byte[valLen];
                    for (int j = 0; j < valLen; j++) {
                        valArr[j] = input[i++];
                    }
                    val = new String(valArr);
                }
                String ty;
                if (type == 0) {
                    ty = "INSERT";
                    val = "|" + val;
                } else if (type == 1) {
                    ty = "UPSERT";
                    val = "|" + val;
                } else {
                    ty = "DELETE";
                }
                String event = String.valueOf(ep) + "|" + ty + "|" + key + val;
                sol.add(event);
            }
        }

        /**
         * Retrieve all events contained within the WAL as their string values in time order
         * DML Event String Format: "<epoch_milli>|<message_name>|<key>|<value>"
         *
         * @return a time-ordered sequence of DML Event strings
         */
        public ArrayList<String> getEvents() {
            // TODO
            return (ArrayList<String>) sol;
        }
    }



    public static class InputParser {
        private byte[] hex2bytes(String hex) {
            int len = hex.length();
            byte[] data = new byte[len / 2];
            for (int i = 0; i < len; i += 2) {
                data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
                        + Character.digit(hex.charAt(i + 1), 16));
            }
            return data;
        }
    }


        public static void main(String args[]) throws Exception {
            byte[] input = new InputParser().hex2bytes("0000016c052dcf4100000e746573745f6b65795f30393831320010746573745f76616c75655f3132383736");
            WAL wal = new WAL(input);
            System.out.println("Events:");
            System.out.println(String.join("\n", wal.getEvents()));
        }
}
