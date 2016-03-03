package com.aegarland.sample.vending.fulfillment;

import com.aegarland.sample.vending.VendingMachineRestApplication;
import com.aegarland.sample.vending.fulfillment.domain.Product;
import com.aegarland.sample.vending.fulfillment.service.VendingMachineSlotRepository;
import com.aegarland.sample.vending.service.FulfillmentModule;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;

/**
 * Created by aeg on 3/2/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = VendingMachineRestApplication.class)
@WebAppConfiguration
@Rollback
public class FulfillmentModuleImplTest {

    @Autowired
    FulfillmentModule module;

    @Autowired
    VendingMachineSlotRepository repository;

    @Before
    public void setUp() throws Exception {
        assertNotNull(module);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetProduct() throws Exception {
        Optional<Product> product = module.getProduct("A1");
        assertNotNull(product);
    }

    @Test
    public void testSell() throws Exception {
        boolean sold = module.sell("A1");
        assertThat(sold,is(equalTo(true)));
        sold = module.sell("A1");
        assertThat(sold,is(equalTo(true)));
        sold = module.sell("A1");
        assertThat(sold,is(equalTo(true)));
        sold = module.sell("A1");
        assertThat(sold,is(equalTo(false)));
    }

    @Test
    public void testOnApplicationEvent() throws Exception {

    }
}