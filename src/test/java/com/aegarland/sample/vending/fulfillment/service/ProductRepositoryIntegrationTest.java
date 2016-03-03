package com.aegarland.sample.vending.fulfillment.service;

import com.aegarland.sample.vending.VendingMachineRestApplication;
import com.aegarland.sample.vending.fulfillment.domain.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by aeg on 3/2/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = VendingMachineRestApplication.class)
@WebAppConfiguration
@Rollback
public class ProductRepositoryIntegrationTest {

    @Autowired
    ProductRepository repository;

    @Before
    public void setUp() throws Exception {
        Assert.assertNotNull(repository);
    }

    @Test
    public void testFindAll() throws Exception {
        List<Product> products = this.repository.findAll();
        assertThat(products.size(), is(greaterThan(0)));
    }

    @Test
    public void testFindOne() throws Exception {
        Product p = this.repository.findOne(1);
        assertNotNull(p);
    }
}