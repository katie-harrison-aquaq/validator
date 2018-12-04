package com.droolsfileread.demofileread.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.droolsfileread.demofileread.people.Person;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {

    private final KieContainer kieContainer;

    @Autowired
    public UserService(KieContainer kieContainer){
        this.kieContainer=kieContainer;
    }

    public Person getKieSession(Person person){
        List list = new ArrayList();
        KieSession kieSession = kieContainer.newKieSession("rulesSession");
        kieSession.setGlobal("myGlobalRulesList", list);
        kieSession.insert(person);
        kieSession.fireAllRules();
        kieSession.dispose();
        return person;
    }
}

