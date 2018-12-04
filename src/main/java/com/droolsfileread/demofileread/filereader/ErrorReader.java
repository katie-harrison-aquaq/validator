package com.droolsfileread.demofileread.filereader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ErrorReader {

    private static final String RULES_FILEPATH = "C:\\Users\\Katie.Harrison\\Programming\\demofileread\\src\\main\\resources\\firedrules.csv";
    static String errorLine;
    public String parseErrors() {
        File file = new File(RULES_FILEPATH);
        try {
            Scanner errorScanner = new Scanner(file);
            while (errorScanner.hasNextLine()) {
                errorLine += errorScanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return errorLine;
    }
}