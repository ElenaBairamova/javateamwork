package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {


    @Test
    public void shouldAddOne() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(1);

        Assertions.assertEquals(2_001, account.getBalance());
    }

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                1_000,
                1_000,
                10_000,
                5
        );

        account.add(10_000);

        Assertions.assertEquals(1_000, account.getBalance());
    }

    @Test
    public void shouldAddZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(0);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldAddNegative() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(-1);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldAddMaxBalancePlusOne() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(8_001);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void negativeMinBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    2_000,
                    -1_000,
                    10_000,
                    5
            );

        });
    }

    @Test
    public void negativeMaxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    2_000,
                    1_000,
                    -10_000,
                    5
            );

        });
    }

    @Test
    public void negativeMaxBalanceLimitValue() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    2_000,
                    1_000,
                    -1,
                    5
            );

        });
    }

    @Test
    public void balanceNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    -2_000,
                    1_000,
                    10_000,
                    5
            );
        });
    }

    @Test
    public void balanceNegativeLimitValue() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    -2,
                    1_000,
                    10_000,
                    5
            );
        });
    }

    @Test
    public void initialBalanceLessThanMinimum() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    1_000,
                    2_000,
                    10_000,
                    5
            );

        });
    }

    @Test
    public void maxBalanceLessThanMinBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    1_000,
                    20_000,
                    10_000,
                    5
            );

        });

    }

    @Test
    public void checkingTheBalanceForEqualityToTheMinBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    10_000,
                    1_000,
                    5_000,
                    5
            );

        });
    }

    @Test
    public void negativeInitialBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    -10_000,
                    1_000,
                    5_000,
                    5
            );

        });
    }


    @Test
    public void balanceMinBalance() {
        SavingAccount account = new SavingAccount(
                1_000,
                1_000,
                10_000,
                5);
        boolean result = account.pay(2_000);

        Assertions.assertEquals(1_000, account.getBalance());
        Assertions.assertEquals(false, result);
    }

    @Test
    public void payNegative() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5);

        account.pay(-1);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void balanceEqualMinBalancePlusOne() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5);

        boolean result = account.pay(1_001);

        account.pay(1_001);

        Assertions.assertEquals(2_000, account.getBalance());
        Assertions.assertEquals(false, result);
    }

    @Test
    public void payMoreBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                500,
                10_000,
                5);

        boolean result = account.pay(2_500);

        account.pay(2_500);

        Assertions.assertEquals(2000, account.getBalance());
        Assertions.assertEquals(false, result);
    }

    @Test
    public void balanceEqualMinBalance() {
        SavingAccount account = new SavingAccount(
                20_000,
                500,
                20_000,
                5);

        boolean result = account.pay(20_000);

        account.pay(10_000);

        Assertions.assertEquals(10_000, account.getBalance());
        Assertions.assertEquals(false, result);
    }

    @Test
    public void checkingTheCalculationOfMinBalanceWhenBuying() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5);
        boolean result = account.pay(1_000);

        Assertions.assertEquals(1_000, account.getBalance());
        Assertions.assertEquals(true, result);
    }


    @Test
    public void checkingTheCalculationOfInterestOnTheBalanceOfTheAccount() {
        SavingAccount account = new SavingAccount(
                1_000,
                1_000,
                10_000,
                5);

        Assertions.assertEquals(50, account.yearChange());
    }

    @Test
    public void checkingTheCalculationZeroOfInterestOnTheBalanceOfTheAccount() {
        SavingAccount account = new SavingAccount(
                1_000,
                1_000,
                10_000,
                0);

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void checkingTheCalculationOfInterestOnTheBalanceOfTheAccountZero() {
        SavingAccount account = new SavingAccount(
                0,
                0,
                10_000,
                5);

        Assertions.assertEquals(0, account.yearChange());
    }
}



