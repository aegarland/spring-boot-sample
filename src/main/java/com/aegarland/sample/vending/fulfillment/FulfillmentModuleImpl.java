package com.aegarland.sample.vending.fulfillment;

import com.aegarland.sample.vending.event.VendingMachineEvent;
import com.aegarland.sample.vending.fulfillment.domain.Product;
import com.aegarland.sample.vending.fulfillment.domain.VendingMachineSlot;
import com.aegarland.sample.vending.fulfillment.service.ProductRepository;
import com.aegarland.sample.vending.fulfillment.service.VendingMachineSlotRepository;
import com.aegarland.sample.vending.service.FulfillmentModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by aeg on 3/2/2016.
 */
@Component
public class FulfillmentModuleImpl implements FulfillmentModule {

    @Autowired
    VendingMachineSlotRepository slotDao;

    @Autowired
    ProductRepository productDao;

    @Override
    public Optional<Product> getProduct(String slotlabel) {
        VendingMachineSlot s = slotDao.findBySlotlabel(slotlabel);
        return Optional.ofNullable(s==null?null:s.getProduct());
    }

    @Override
    public boolean sell(String slotlabel) {
        VendingMachineSlot s = slotDao.findBySlotlabel(slotlabel);
        if ( s==null || s.getUnits()==0 ) {
            return false;
        }
        s.setUnits(s.getUnits()-1);
        slotDao.save(s);
        return true;
    }

    @Override
    public void onApplicationEvent(VendingMachineEvent vendingMachineEvent) {

    }
}
