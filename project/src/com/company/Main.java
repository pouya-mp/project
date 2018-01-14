package com.company;

import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static void main(String[] args) {

        int[] inputResult = Input.readFile();
        int fileNum = inputResult[0];
        int lines = inputResult[1];
        MsgGenerator msgGenerator = new MsgGenerator();
        LinkedBlockingQueue<String> msgList = msgGenerator.run(fileNum, lines);
        Output output = new Output(fileNum, lines);
        output.generateOutput(msgList);
    }

}
