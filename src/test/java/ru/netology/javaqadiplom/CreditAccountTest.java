package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {
    CreditAccount account = new CreditAccount(
            0,
            5_000,
            15
    );

    @Test
    public void shouldIllegalArgumentExceptionIfRateLessZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(1_000, 5_000, -10);
        });
    }

    @Test
    public void shouldIllegalArgumentExceptionIfCreditLimitLessZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(1_000, -5_000, 10);
        });
    }

    @Test
    public void shouldIllegalArgumentExceptionIfInitialBalanceLessZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(-1_000, 5_000, 10);
        });
    }

    @Test
    public void shouldInitialBalanceChangeIfAmountHighZero() {
        CreditAccount account = new CreditAccount(
                2_000,
                5_000,
                15
        );
        account.pay(1_000);

        Assertions.assertEquals(1_000, account.getBalance());
    }

    @Test
    public void shouldInitialBalanceNotChangeIfAmountZero() {
        CreditAccount account = new CreditAccount(
                2_000,
                5_000,
                15
        );
        account.pay(0);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldInitialBalanceNotChangeIfAmountLessZero() {
        CreditAccount account = new CreditAccount(
                2_000,
                5_000,
                11
        );
        account.pay(-100);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldInitialBalanceNotChangeIfBalanceHighCreditLimit() {
        CreditAccount account = new CreditAccount(
                2_000,
                5_000,
                15
        );
        account.pay(10_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldBeNegativeBalance() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.pay(2_000);

        Assertions.assertEquals(-1_000, account.getBalance());

    }

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldAddToNegativeBalance() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.add(-3_000);

        Assertions.assertEquals(1_000, account.getBalance());
    }

    @Test
    public void shouldAddToZeroBalance() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.add(0);

        Assertions.assertEquals(1_000, account.getBalance());
    }
    @Test
    public void shouldReturnZeroIfBalancePositive() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.pay(500);

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    
    public void shouldCalculateIfBalanceNegative() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.pay(2_000);

        Assertions.assertEquals(-150, account.yearChange());
    }

}

