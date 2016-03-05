package com.aegarland.sample.vending.domain;

import com.aegarland.sample.vending.event.VendingMachineEvent;
import com.aegarland.sample.vending.fulfillment.domain.Product;
import com.aegarland.sample.vending.payment.domain.InputObject;
import com.aegarland.sample.vending.service.DisplayModule;
import com.aegarland.sample.vending.service.FulfillmentModule;
import com.aegarland.sample.vending.service.PaymentModule;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * Created by aeg on 3/2/2016.
 */
@Resource
@RestController
public class VendingMachine {

    @Autowired
    PaymentModule payment;

    @Autowired
    FulfillmentModule fulfillment;

    @Autowired
    DisplayModule display;

    @RequestMapping(value = "/sell", method = RequestMethod.POST)
    @Transactional
    @ApiResponse(code = 200, message = "Check return code", response = Boolean.class)
    public @ResponseBody boolean sell(@ApiParam(name = "slotlabel", value = "slot label", required = true, allowableValues = "A1,A2") @RequestBody String slotlabel) {
        System.out.println(slotlabel);
        Optional<Product> product = fulfillment.getProduct(slotlabel);
        if (product.isPresent()) {
            if ( !fulfillment.sell(slotlabel) ) {
                display.update("Product not sellable");
                return false;
            }
            if ( payment.completeSale(product.get().getCurrency(), product.get().getPrice()) ) {
                display.update("Vending " + product.get().getDescription());
                return true;
            }
            display.update("Payment failed");
            throw new RuntimeException("Payment failed");
        } else {
            display.update("No product in slot");
            return false;
        }
    }

    @RequestMapping(value = "/input", method = RequestMethod.POST)
    @Transactional
    public void input(@ApiParam(name = "input", value = "input object", required = true) @RequestBody InputObject input) {
        payment.onApplicationEvent(new VendingMachineEvent<>(this,input));
        display.update("Balance ="+payment.getBalance());
    }

    @RequestMapping(value = "/balance", method = RequestMethod.GET)
    @ApiResponse(code = 200, message = "Ok", response = Integer.class)
    public @ResponseBody int balance() {
        return payment.getBalance();
    }
}
