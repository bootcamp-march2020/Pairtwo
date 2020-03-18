package com.bootcamp.test.tdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FamilyTree {
    private List<Person> familyMembers;

    {
        familyMembers = new ArrayList();
        Person king  = createPerson("King shan", Gender.MALE);
        Person queen = createPerson("Queen Anga", Gender.FEMALE);
        Person chit = createPerson("chit",Gender.MALE);
        Person ish = createPerson("ish",Gender.MALE);
        Person vich = createPerson("vich",Gender.MALE);
        Person aras = createPerson("aras",Gender.MALE);
        Person satya = createPerson("satya",Gender.FEMALE);
        Person amba = createPerson("amba",Gender.FEMALE);
        Person lika = createPerson("lika",Gender.FEMALE);
        Person chitra = createPerson("chitra",Gender.FEMALE);
        Person vyan = createPerson("vyan",Gender.MALE);

        Person dritha = createPerson("dritha",Gender.FEMALE);
        Person tritha = createPerson("tritha",Gender.FEMALE);
        Person vritha = createPerson("vritha",Gender.MALE);

        Person jaya = createPerson("jaya",Gender.MALE);

        Person vila = createPerson("vila",Gender.FEMALE);
        Person chika = createPerson("chika",Gender.FEMALE);

        Person arit = createPerson("arit",Gender.MALE);
        Person jnki = createPerson("jnki",Gender.FEMALE);
        Person ahit = createPerson("ahit",Gender.MALE);

        Person satvy = createPerson("satvy",Gender.FEMALE);
        Person asva = createPerson("asav",Gender.MALE);
        Person krpi = createPerson("krpi",Gender.FEMALE);
        Person vyas = createPerson("vyas",Gender.MALE);
        Person atya = createPerson("atya",Gender.FEMALE);

        Person yodhan = createPerson("yodhan",Gender.MALE);
        Person laki = createPerson("laki",Gender.MALE);
        Person lavnya = createPerson("lavnya",Gender.FEMALE);
        Person vasa = createPerson("vasa",Gender.MALE);
        Person kriya = createPerson("kriya",Gender.MALE);
        Person krithi = createPerson("krithi",Gender.FEMALE);

        king.getMarriedTo(queen);
        king.giveBirthTo(chit);
        king.giveBirthTo(ish);
        king.giveBirthTo(vich);
        king.giveBirthTo(aras);
        king.giveBirthTo(satya);

        chit.getMarriedTo(amba);
        vich.getMarriedTo(lika);
        aras.getMarriedTo(chitra);
        satya.getMarriedTo(vyan);
        chit.giveBirthTo(dritha);
        chit.giveBirthTo(tritha);
        chit.giveBirthTo(vritha);
        dritha.getMarriedTo(jaya);
        vich.giveBirthTo(vila);
        vich.giveBirthTo(chika);

        aras.giveBirthTo(jnki);
        aras.giveBirthTo(ahit);
        jnki.getMarriedTo(arit);

        vyan.giveBirthTo(asva);
        vyan.giveBirthTo(vyas);
        vyan.giveBirthTo(atya);
        asva.getMarriedTo(satvy);
        vyas.getMarriedTo(krpi);

        jaya.giveBirthTo(yodhan);
        arit.giveBirthTo(laki);
        arit.giveBirthTo(lavnya);
        asva.giveBirthTo(vasa);
        vyas.giveBirthTo(kriya);
        vyas.giveBirthTo(krithi);

        familyMembers =  Arrays.asList(king,queen,chit,amba, ish, vich, lika, aras, chitra, satya, vyan, dritha,jaya, vritha, tritha, vila, chika, arit, jnki, ahit, satvy, asva,
                krpi,vyas, atya,yodhan, laki, lavnya, vasa,kriya,krithi);

    }

    public  Person findMember( String memberName){
        for (Person p : familyMembers){
            if(p.getName().equals(memberName)){
                return p;
            }
        }
        throw new InvalidPersonException();
    }


    private Person createPerson(String name, Gender gender){
        return new Person(name, gender);
    }
    public List<Person> getSiblings(String personName){
        Person person = findMember(personName);
        Person father = person.getFather();
        List<Person> children = father.getChildren();
        List<Person> result = new ArrayList<>();
        for(Person child: children){
            if(!child.getName().equals(person.getName())){
                result.add(child);
            }
        }
        return result;
    }

    public List<Person> getPaternalUncle(String personName){
        Person person = findMember(personName);
        Person father = person.getFather();
        Person grndFather = father.getFather();
       List<Person> uncles=  grndFather.getChildren();
        return uncles.stream()
                .filter(p -> !(p.getName().equals(father.getName())))
                .collect(Collectors.toList());
    }

    public List<Person> getSisterInLaw(String personName){
        Person person = findMember(personName);
        List<Person> siblings = getSiblings(personName);
        Predicate<Person> marriedMale =p -> p.getSpouse()!=null && p.getGender().equals(Gender.MALE);
        List<Person> firstSetSIL = siblings.stream().filter(marriedMale).map(p -> p.getSpouse()).collect(Collectors.toList());
        Person spouse = person.getSpouse();
        return  null;
    }
    public static void main(String[] args) {

    }
}
