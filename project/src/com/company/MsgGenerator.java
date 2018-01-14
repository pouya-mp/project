package com.company;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Pouya on 1/2/2018.
 */
public class MsgGenerator {
    public LinkedBlockingQueue<String> run(int fileNum, int lines) {
        LinkedBlockingQueue<String> msgList = new LinkedBlockingQueue<>(fileNum * lines);

        for (int i = 0; i < fileNum * lines; i++) {
            String message = generateMsg();
            msgList.add(message);
        }
        return msgList;
    }

    private String generateMsg() {
        CellNumberGenerate cellNumberGenerate = new CellNumberGenerate();
        SendTimeGenerate sendTimeGenerate = new SendTimeGenerate();
        MsgBodyGenerate msgBodyGenerate = new MsgBodyGenerate();

        long msgId = ThreadLocalRandom.current().nextLong(10000000000000L, 99999999999999L);
        int msgType = ThreadLocalRandom.current().nextInt(3, 9);
        String sender = cellNumberGenerate.run(989);
        String receiver = cellNumberGenerate.run(989);
        String sendTime = sendTimeGenerate.run();
        String msgBody = msgBodyGenerate.run();

        String message = msgId + "," + sender + "," + receiver + "," + msgType + "," + sendTime + "," + msgBody;
        return message;
    }

}
