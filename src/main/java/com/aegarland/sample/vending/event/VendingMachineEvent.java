package com.aegarland.sample.vending.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by aeg on 3/2/2016.
 */
public class VendingMachineEvent<T> extends ApplicationEvent {
    private final T message;

    public VendingMachineEvent(Object source, T message) {
        super(source);
        this.message = message;
    }

    public T getMessage() {
        return message;
    }
}
