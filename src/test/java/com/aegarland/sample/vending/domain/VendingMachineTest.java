package com.aegarland.sample.vending.domain;

import com.aegarland.sample.vending.VendingMachineRestApplication;
import com.aegarland.sample.vending.payment.PaymentModuleImpl;
import com.aegarland.sample.vending.payment.domain.InputObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;

/**
 * Created by aeg on 3/3/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = VendingMachineRestApplication.class)
@WebAppConfiguration
@Rollback
public class VendingMachineTest {

    @Autowired
    VendingMachine machine;

    @Autowired
    PaymentModuleImpl payment;

    @Before
    public void setUp() throws Exception {
        assertNotNull(machine);
        assertNotNull(payment);
    }

    @After
    public void tearDown() throws Exception {
        payment.cancelSale();
    }

    @Test(expected = RuntimeException.class)
    public void testSell() throws Exception {
        machine.sell("A1");
    }

    @Test
    @Transactional
    public void testInput() throws Exception {
        InputObject io = new InputObject(10.0,1.8,5.0);
        machine.input(io);
        assertThat(payment.getBalance(),is(equalTo(50)));
        machine.input(io);
        assertThat(payment.getBalance(),is(equalTo(100)));
        boolean result = machine.sell("A1");
        assertThat(result,is(equalTo(true)));
        assertThat(payment.getBalance(),is(equalTo(0)));
    }
}