package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {


    @Test
    public void shouldAddLessThanMaxBalance() {  //следует добавить меньше максимального баланса
        SavingAccount account = new SavingAccount(
                1_000,
                1_000,
                10_000,
                5
        );

        account.add(10_000);

        Assertions.assertEquals(1_000 + 10_000, account.getBalance());
    }

    @Test
    public void negativeMinBalance() {  // минимальный баланс не может быть отрицательным.
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
    public void negativeMaxBaiance() {  // максимальный баланс не может быть отрицательным.
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
    public void initialBalanceLessThanMinimum() {   // начальный баланс не может быть меньше минимального.
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
    public void maxBalanceLessThanMinBalance() { // минимальный баланс не может быть больше максимального.
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
    public void icheckingTheBalanceForEqualityToTheMinBalance() {   // начальный баланс не может быть больше максимального.
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
    public void negativeInitialBalance() {   // начальный баланс не может быть  отрицательным.
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
    public void balanceMinBalance() { //проверка минимального баланса
        SavingAccount account = new SavingAccount(1_000, 1_000, 10_000, 5);
        boolean result = account.pay(2_000);

        Assertions.assertEquals(2_000, account.getBalance());
        Assertions.assertEquals(false, result);
    }


    @Test
    public void checkingTheCalculationOfMinBalanceWhenBuying() {  //проверка расчета мин. остатка при покупке
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);
        boolean result = account.pay(1_000);

        Assertions.assertEquals(1_000, account.getBalance());
        Assertions.assertEquals(true, result);
    }


    @Test
    public void checkingTheCalculationOfInterestOnTheBalanceOfTheAccount() {  //проверка начисления процентов на остаток по счету
        SavingAccount account = new SavingAccount(1_000, 1_000, 10_000, 5);

        account.yearChange();
        Assertions.assertEquals(50, account.getBalance());
    }
}



