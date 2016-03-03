package com.aegarland.sample.vending.fulfillment.service;

import com.aegarland.sample.vending.fulfillment.domain.VendingMachineSlot;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by aeg on 3/2/2016.
 */
@RepositoryRestResource(collectionResourceRel = "slot", exported = true)
public interface VendingMachineSlotRepository
        extends org.springframework.data.repository.Repository<VendingMachineSlot,Integer> {

    List<VendingMachineSlot> findAll();
    VendingMachineSlot save(VendingMachineSlot s);
    VendingMachineSlot findBySlotlabel(String slotlabel);
    VendingMachineSlot findOne(Integer id);
}
