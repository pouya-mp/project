package com.company;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Pouya on 1/6/2018.
 */
public class MsgBodyGenerate {
    public String run(){
        StringBuilder sbMsgBody = new StringBuilder();
        String enWords = "abcdefghijklmnopqrstuvwxyz";
        String faWords = "ابپتثجچحخدذرزژسشصضطظعغفقکگلمنوهی";
        int msgBodyLength = ThreadLocalRandom.current().nextInt(1, 161);
        int lang = ThreadLocalRandom.current().nextInt(1, 3);
        while (sbMsgBody.length() < msgBodyLength) {
            switch (lang) {
                case 1:
                    sbMsgBody.append(enWords.charAt(ThreadLocalRandom.current().nextInt(0, 26)));
                    break;
                case 2:
                    sbMsgBody.append(faWords.charAt(ThreadLocalRandom.current().nextInt(0, 32)));
                    break;
            }
        }
        String msgBody = sbMsgBody.toString();
        return msgBody;
    }
}
