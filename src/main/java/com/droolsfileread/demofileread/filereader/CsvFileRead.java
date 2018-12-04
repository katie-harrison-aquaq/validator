package com.droolsfileread.demofileread.filereader;

import com.droolsfileread.demofileread.people.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvFileRead {

    private static final String CSV_FILEPATH = "C:\\Users\\Katie.Harrison\\Programming\\demofileread\\src\\main\\resources\\register.csv";
    static String line;

    public static String parseToBean() {
        List<String> holder = new ArrayList<>();

        Person person = new Person();
        File file = new File(CSV_FILEPATH);
        line="<table class='table'>" +
            "<thead>"+
            "<tr>"+
                "<th>Current records within spreadsheet</th>"+
                "</tr>"+
                "</thead>"+
                "<tbody>"+
                "<tr>";
        try {
            Scanner scanner = new Scanner(file);
            System.out.println("splitting read string");
            String readLine =scanner.nextLine();
            while (scanner.hasNextLine()) {
                String[] fieldMatcher = readLine.split(",");
                holder.add("FN:"+fieldMatcher[0]);
                holder.add("LN:"+fieldMatcher[1]);
                holder.add("E:"+fieldMatcher[2]);
                fieldMatcher=new String[fieldMatcher.length];
                //person.setFirstName("FN:"+fieldMatcher[0]);
                //holder.add(person.getFirstName());
               // person.setLastName("LN:"+fieldMatcher[2]);
               // holder.add(person.getLastName());
                /*
                person.setEmail("E:"+fieldMatcher[2]);
                holder.add(person.getEmail());
                person.setHouseNumber("HN:"+fieldMatcher[3]);
                holder.add(person.getHouseNumber());
                person.setPhoneCode("PC:"+fieldMatcher[4]);
                holder.add(person.getPhoneCode());
                person.setPetsTotal("PT:"+fieldMatcher[5]);
                holder.add(person.getPetsTotal());
*/

                line += "<td>"+scanner.nextLine() +"</td></tr>"+"\n";

                //System.out.println(person.getFirstName()+" "+person.getLastName()+" "+person.getHouseNumber());
            }
            for(int i=0; i<holder.size(); i++){
                System.out.println(holder.get(i));
            }
            line+= "</tbody>"+
                    "</table>";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return line;
    }
}
