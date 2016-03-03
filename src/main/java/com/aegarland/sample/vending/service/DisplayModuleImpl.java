package com.aegarland.sample.vending.service;

import com.aegarland.sample.vending.event.VendingMachineEvent;
import org.springframework.stereotype.Component;

/**
 * Created by aeg on 3/2/2016.
 */
@Component
public class DisplayModuleImpl implements DisplayModule {
    @Override
    public void update(String message) {
        System.out.println(message);
    }

    @Override
    public void onApplicationEvent(VendingMachineEvent<String> stringVendingMachineEvent) {
       update(stringVendingMachineEvent.getMessage());
    }
}
