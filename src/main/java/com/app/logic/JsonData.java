package com.app.logic;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class JsonData<T> {
    private static final Gson jSON = new Gson();

    public JsonData(){
    }

    public List<T> readFromFile(T t, String fileName) {
        List<T> list = new ArrayList<>();
        String filePath = String.valueOf("data/" + t.getClass().getSimpleName() + "/" + fileName + ".txt").toLowerCase();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.ready()) {
                String objStr = reader.readLine();
                T jSonObj = (T) jSON.fromJson(objStr, t.getClass());
                if (jSonObj != null) {
                    list.add(jSonObj);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void writeToFile(T t, String fileName) {
        if (t == null) {
            return;
        }

        String filePath = String.valueOf("data/" + t.getClass().getSimpleName() + "/" + fileName + ".txt").toLowerCase();

        try (FileWriter writer = new FileWriter(filePath, true)) {
            String jsonObj = jSON.toJson(t);
            writer.write(jsonObj + "\n");

        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }


    public List<T> readAllFromFolder(T t) {
        List<T> list = new ArrayList<>();
        String filePath = String.valueOf("data/" + t.getClass().getSimpleName()).toLowerCase();

        File folder = new File(filePath);
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null && listOfFiles.length > 0) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    List<T> tempList = readFromFile(t, file.getName());

                    if(!tempList.isEmpty()){
                        list.addAll(tempList);
                    }
                }
            }
        }

        return list;
    }

}
