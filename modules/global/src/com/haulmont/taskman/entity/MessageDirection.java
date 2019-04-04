package com.haulmont.taskman.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum MessageDirection implements EnumClass<String> {

    INBOX("inbox"),
    OUTBOX("outbox");

    private String id;

    MessageDirection(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static MessageDirection fromId(String id) {
        for (MessageDirection at : MessageDirection.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}