package com.aegarland.sample.vending.payment.service;

import com.aegarland.sample.vending.payment.domain.Coin;
import com.aegarland.sample.vending.payment.domain.InputObject;

import java.util.Optional;

/**
 * Created by aeg on 3/2/2016.
 */
public interface InputObjectClassifier {
    public Optional<Coin> classify(InputObject input);
}
