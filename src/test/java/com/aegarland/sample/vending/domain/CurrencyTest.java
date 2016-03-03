package com.aegarland.sample.vending.domain;

import org.junit.Test;

import static java.lang.Enum.valueOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * Created by aeg on 3/2/2016.
 */
public class CurrencyTest {

    @Test
    public void testValueOf() throws Exception {
        assertThat(Currency.USD,is(equalTo(valueOf(Currency.class,"USD"))));
    }
}