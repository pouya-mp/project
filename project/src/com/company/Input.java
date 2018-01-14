package com.company;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by Pouya on 1/2/2018.
 */
public class Input {

    public static int[] readFile() {
            int fileNum =0;
            int lines = 0;
        try {
            Scanner in = new Scanner(new FileReader("Input.txt"));
            in.useDelimiter(",");
            fileNum = in.nextInt();
            in.skip(in.delimiter());
             lines = in.nextInt();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int[] result = {fileNum,lines};
        return result;
    }

}
