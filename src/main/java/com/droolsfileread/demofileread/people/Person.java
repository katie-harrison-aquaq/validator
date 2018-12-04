package com.droolsfileread.demofileread.people;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {

    private int uniqueID;
    private  String firstName;
    private  String lastName;
    private  String email;
    private String errorDesc;
    private boolean resolutionStatus;
    private String houseNumber;
    private String phoneCode;
    private String petsTotal;

    public Person() {
    }

}
