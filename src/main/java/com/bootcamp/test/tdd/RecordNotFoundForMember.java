package com.bootcamp.test.tdd;

public class RecordNotFoundForMember extends RuntimeException {
    RecordNotFoundForMember(){
        super("Record not found for the member");
    }
}
