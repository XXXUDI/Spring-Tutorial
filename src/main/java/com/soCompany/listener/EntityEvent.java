package com.soCompany.listener;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

public class EntityEvent extends ApplicationEvent {
    @Getter
    AccessType accessType;
    public EntityEvent(Object source, AccessType accessType) {
        super(source);
        this.accessType = accessType;
    }
}
