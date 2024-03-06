package com.bank.sbi.utility;

//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RandomAccountNumberTest {

    @Test
    void generate() {
//        System.out.println(RandomAccountNumber.class);
        var result = RandomAccountNumber.generate();
        Assertions.assertTrue(result > 1_00_00_00_000);
    }
}