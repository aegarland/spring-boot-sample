package com.aegarland.sample.vending.payment.domain;

import com.aegarland.sample.vending.domain.Currency;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

/**
 * Created by aeg on 3/2/2016.
 */
public class CoinTest {

    @Test
    public void testEquals() throws Exception {
        Coin c = new Coin(12.0,1.0,3.0, Currency.USD,5);
        Coin d = new Coin(11.0,1.1,3.1, Currency.USD,5);
        assertThat(c,is(equalTo(d)));
    }

    @Test
    public void testHashCode() throws Exception {
        Coin c = new Coin(12.0,1.0,3.0, Currency.USD,5);
        assertThat(c.hashCode(),is(not(equalTo( System.identityHashCode(c)))));
    }
}