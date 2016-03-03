package com.aegarland.sample.vending.payment;

import com.aegarland.sample.vending.VendingMachineRestApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

/**
 * Created by aeg on 3/2/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = VendingMachineRestApplication.class)
@WebAppConfiguration
public class PaymentModuleImplTest {

    private final int initialBalance = 15;

    @Autowired
    PaymentModuleImpl module;

    @Before
    public void setUp() throws Exception {
        assertNotNull(module);
        module.balance = initialBalance;
    }

    @After
    public void tearDown() throws Exception {
        module.balance = 0;
    }

    @Test
    public void testOnApplicationEvent() throws Exception {

    }

    @Test
    public void testCompleteSale() throws Exception {
        assertFalse("insufficient balance",module.completeSale(module.getCurrency(),initialBalance+10));
        assertTrue("sale completed",module.completeSale(module.getCurrency(),initialBalance-5));
        assertThat("no balance left",module.getBalance(),is(equalTo(0)));
    }

    @Test
    public void testCancelSale() throws Exception {
        assertTrue("sale cancelled",module.cancelSale());
        assertThat("no balance left",module.getBalance(),is(equalTo(0)));
    }

    @Test
    public void testGetBalance() throws Exception {
        assertThat("initial balance matches",module.getBalance(),is(equalTo(initialBalance)));
    }
}