package com.haulmont.taskman.core;

import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.app.UniqueNumbersAPI;
import com.haulmont.cuba.core.listener.BeforeInsertEntityListener;
import com.haulmont.taskman.entity.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component(TaskListener.NAME)
public class TaskListener implements BeforeInsertEntityListener<Task> {
    public static final String NAME = "taskman_TaskListener";

    @Inject
    private UniqueNumbersAPI uniqueNumbersAPI;

    private static final Logger log = LoggerFactory.getLogger(TaskListener.class);

    @Override
    public void onBeforeInsert(Task entity, EntityManager entityManager) {
        if (entity.getNumber() == null || entity.getNumber() == 0L) {
            entity.setNumber(uniqueNumbersAPI.getNextNumber(Task.class.getSimpleName()));
            entityManager.persist(entity);
        }
    }
}