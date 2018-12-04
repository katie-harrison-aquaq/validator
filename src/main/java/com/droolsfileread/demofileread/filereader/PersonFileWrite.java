package com.droolsfileread.demofileread.filereader;

import com.droolsfileread.demofileread.people.Person;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;

public class PersonFileWrite {

    private static final String WRITTEN_FILE_NAME = "C:\\Users\\Katie.Harrison\\Programming\\demofileread\\src\\main\\resources\\register.csv";

    public static void writeToFile(Person person) {
    System.out.println("First name: "+person.getFirstName());
    System.out.println("Last name: "+person.getLastName());
    System.out.println("Email: "+person.getEmail());
    System.out.println("House number: "+person.getHouseNumber());
    System.out.println("Phone code: "+person.getPhoneCode());
    System.out.println("Number of pets: "+person.getPetsTotal());
        try {
            File file = new File(WRITTEN_FILE_NAME);
            if(!file.exists()){
                System.out.println("Creating new file");
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            Date generatedDate = new Date();
                printWriter.write(person.getFirstName()+","+
                        person.getLastName()+","+person.getEmail()+","+
                        person.getHouseNumber()+","+
                        person.getPhoneCode()+","+
                        person.getPetsTotal()+","+
                        generatedDate+"\n");
            printWriter.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
