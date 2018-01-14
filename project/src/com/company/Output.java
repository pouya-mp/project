package com.company;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Pouya on 1/2/2018.
 */
public class Output {
    private int fileNum;
    private int lines;

    public Output(int fileNum, int lines) {
        this.fileNum = fileNum;
        this.lines = lines;
        deleteExistsAndRun();
    }

    public void generateOutput(LinkedBlockingQueue<String> msgList) {
        for (int i = 0; i < fileNum; i++) {
            try {
                FileWriter fileWriter = new FileWriter("output" + i + ".txt");
                for (int j = 0; j < lines; j++) {
                    fileWriter.write(msgList.take() + "\r\n");
                }
                fileWriter.close();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void deleteExistsAndRun() {
        try {
            Scanner in = new Scanner(new FileReader("ExistFileNum.txt"));
            in.useDelimiter(",");

            int existsNum = in.nextInt();
            for (int i = 0; i < existsNum; i++) {
                File file = new File("output" + i + ".txt");
                file.delete();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                FileWriter fileWriter = new FileWriter("ExistFileNum.txt");
                fileWriter.write("," + fileNum);
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
