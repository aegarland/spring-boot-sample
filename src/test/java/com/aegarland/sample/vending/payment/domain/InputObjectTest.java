package com.aegarland.sample.vending.payment.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

/**
 * Created by aeg on 3/2/2016.
 */
public class InputObjectTest {

    @Test
    public void testEquals() throws Exception {
        InputObject c = new InputObject(12.0,1.0,3.0);
        InputObject d = new InputObject(11.0,1.1,3.1);
        assertThat(c,is(not(equalTo(d))));
    }

    @Test
    public void testHashCode() throws Exception {
        InputObject c = new InputObject(12.0,1.0,3.0);
        assertThat(c.hashCode(),is(not(equalTo( System.identityHashCode(c)))));
    }
}