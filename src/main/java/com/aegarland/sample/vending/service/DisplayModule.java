package com.aegarland.sample.vending.service;

import com.aegarland.sample.vending.event.VendingMachineEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by aeg on 3/2/2016.
 */
public interface DisplayModule extends ApplicationListener<VendingMachineEvent<String>> {
    void update(String message);
}
