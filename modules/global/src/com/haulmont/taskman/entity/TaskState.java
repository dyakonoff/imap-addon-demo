package com.haulmont.taskman.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum TaskState implements EnumClass<String> {

    OPEN("open"),
    IN_PROGRESS("in progress"),
    ASSIGNED("assigned"),
    REPLIED("replied"),
    CLOSED("closed");

    private String id;

    TaskState(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static TaskState fromId(String id) {
        for (TaskState at : TaskState.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}