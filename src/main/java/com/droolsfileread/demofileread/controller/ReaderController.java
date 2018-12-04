package com.droolsfileread.demofileread.controller;

import com.droolsfileread.demofileread.filereader.CsvFileRead;
import com.droolsfileread.demofileread.filereader.ErrorReader;
import com.droolsfileread.demofileread.filereader.PersonFileWrite;
import com.droolsfileread.demofileread.people.Person;
import com.droolsfileread.demofileread.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@RestController
public class ReaderController {

    private static final String FIRED_RULES_LOCATION = "C:\\Users\\Katie.Harrison\\Programming\\demofileread\\src\\main\\resources\\firedrules.csv";
    static Person person = new Person();
    CsvFileRead csvRead= new CsvFileRead();
    ErrorReader errorReader = new ErrorReader();
    private final UserService userService;

    @Autowired
    public ReaderController(UserService userService) {
        this.userService = userService;
    }


    /*
    @GetMapping(value="/getUsers", params = {"firstName", "lastName","email"})
    public void getUserInputString(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email,
                                   @RequestParam String houseNum, @RequestParam String phoneCode, @RequestParam String pets) {
        Random rand = new Random();
        int n = rand.nextInt(50)+1;
        person.setUniqueID(n);

        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setEmail(email);
        person.setHouseNumber(houseNum);
        person.setPhoneCode(phoneCode);
        person.setPetsTotal(pets);
        userService.getKieSession(person);
        PersonFileWrite personFileWrite = new PersonFileWrite();
        personFileWrite.writeToFile(person);
    }
*/

    public static String printRules(String rulesListString) {
        try {
            File file = new File(FIRED_RULES_LOCATION);
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(file, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.write(rulesListString);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rulesListString;
    }

    @GetMapping(value = "/showUsers")
    public String showAllRegistrants() {
    return"<h1>"+csvRead.parseToBean()+"</h1>"+
            "<p></p>"+
            "<h1></h1>";
    }

    @GetMapping(value = "/showFiredRules")
    public String showAllRulesFired(){
       return "<table class='table'><thead><tr>"+
               "<th>User ID</th>"+
               "<th>Rule violated</th>"+
               "<th>Ticket ID</th>"+
               "<th>Ticket generated</th>"+
               "<th>Resolution status</th>"+
               "</tr></thead><tbody>"+ errorReader.parseErrors() +
               "</tbody></table>";
    }
}
