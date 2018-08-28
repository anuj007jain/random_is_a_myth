package com.Repeat_Practice;

import java.io.*;
import java.util.Date;

/**
 * Created by anuj.jain02 on 1/8/17.
 */
public class Serializable implements java.io.Serializable {

    public Date date;

    private static final long serialVersionUID = 7984487383083088106L;

    public Serializable() {
        this.date = new Date();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Serializable serializable = new Serializable();
        String filename = "date.txt";
        FileOutputStream fos = new FileOutputStream(filename);
        ObjectOutputStream out = new ObjectOutputStream(fos);
        out.writeObject(serializable);
        out.close();

        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream objectInputStream = new ObjectInputStream(fis);
        Serializable serializable1 = (Serializable)objectInputStream.readObject();
        System.out.println(serializable1);

    }

    @Override
    public String toString() {
        return "Serializable{" +
                "date=" + date +
                '}';
    }
}
