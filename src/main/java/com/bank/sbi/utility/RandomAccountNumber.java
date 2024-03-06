package com.bank.sbi.utility;

public class RandomAccountNumber {
    public RandomAccountNumber() {}
    public static long generate() {
        long randoomNumber = (long) (Math.random() * 10_00_00_000);
        long result = 1_00_00_00_000l + randoomNumber;//insted of coma we use underscore.
        return result;
    }
}
