package com.aegarland.sample.vending.payment.service;

import com.aegarland.sample.vending.domain.Currency;
import com.aegarland.sample.vending.payment.domain.Coin;
import com.aegarland.sample.vending.payment.domain.InputObject;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by aeg on 3/2/2016.
 */
public class InputObjectClassifierImplTest {

    private InputObjectClassifier classifier;

    @Before
    public void setUp () {
        Collection<Coin> coinCollection = new ArrayList<>(5);
        coinCollection.add(new Coin(3.0,1.1,1.2, Currency.USD, 1));
        coinCollection.add(new Coin(5.0,2.0,2.0, Currency.USD, 5));
        coinCollection.add(new Coin(2.0,1.0,1.0, Currency.USD, 10));
        coinCollection.add(new Coin(7.0,1.7,2.5, Currency.USD, 25));
        coinCollection.add(new Coin(10.0,1.8,5.0, Currency.USD, 50));
        classifier = new InputObjectClassifierImpl(coinCollection);
    }

    @Test
    public void testClassify() throws Exception {
        Optional<Coin> coin = classifier.classify(new InputObject(2.0,1.0,1.0));
        assertTrue(coin.isPresent());
        assertThat("a dime",coin.get(),is(equalTo(new Coin(0,0,0, Currency.USD, 10))));
    }
}