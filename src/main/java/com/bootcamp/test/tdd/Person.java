package com.bootcamp.test.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {


    private String name;
    private Gender gender;
    private Person father;
    private Person mother;
    private List<Person> children;
    private Person spouse;

    public Person(String name, Gender gender){
        this.name = name;
        this.gender = gender;
        this.children = new ArrayList<>();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getFather()  {
        if(father==null){
            throw new RecordNotFoundForMember();
        }
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public Person getMother() {
        if(mother==null){
            throw new RecordNotFoundForMember();
        }
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    public Person getSpouse() {
        if(spouse==null){
            throw new RecordNotFoundForMember();
        }
        return spouse;
    }



    public void getMarriedTo(Person marriedTo) {
        if(this.spouse==null){
            this.spouse = marriedTo;
            this.spouse.getMarriedTo(this);
        }
    }

    public void giveBirthTo(Person child){
       this.children.add(child);
      if(this.gender.equals(Gender.MALE))
        {
           child.setFather(this);
           child.setMother(this.spouse);
        }else {
          child.setMother(this);
          child.setFather(this.spouse);
      }
       this.spouse.getChildren().add(child);
    }
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }


}
