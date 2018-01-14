package com.company;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Pouya on 1/6/2018.
 */
public class CellNumberGenerate {
    public String run(int cellCountryCode){
        StringBuilder sbCellNumber = new StringBuilder();
        sbCellNumber.append(cellCountryCode);
        sbCellNumber.append(ThreadLocalRandom.current().nextInt(100000000, 999999999));
        String cellNumber = sbCellNumber.toString();
        return cellNumber;
    }
}
