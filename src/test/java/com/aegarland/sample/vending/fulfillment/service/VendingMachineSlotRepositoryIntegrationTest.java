package com.aegarland.sample.vending.fulfillment.service;

import com.aegarland.sample.vending.VendingMachineRestApplication;
import com.aegarland.sample.vending.fulfillment.domain.VendingMachineSlot;
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

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
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
public class VendingMachineSlotRepositoryIntegrationTest {

    @Autowired
    VendingMachineSlotRepository repository;

    @Before
    public void setUp() throws Exception {
        Assert.assertNotNull(repository);
    }

    @Test
    public void testFindAll() throws Exception {
        List<VendingMachineSlot> slots = this.repository.findAll();
        assertThat(slots.size(), is(greaterThan(0)));
    }

    @Test
    public void testSave() throws Exception {
        VendingMachineSlot s = this.repository.findBySlotlabel("A1");
        int n = s.getUnits();
        s.setUnits(n-1);
        VendingMachineSlot s2 = this.repository.save(s);
        assertNotNull(s2);
        assertThat("equal",s,is(not(equalTo(s2))));
        assertThat("right units",s2.getUnits(),is(equalTo(n-1)));
    }

    @Test
    public void testFindBySlotLabel() throws Exception {
        VendingMachineSlot s = this.repository.findBySlotlabel("A1");
        assertNotNull(s);
        assertNotNull(s.getProduct());
    }
}