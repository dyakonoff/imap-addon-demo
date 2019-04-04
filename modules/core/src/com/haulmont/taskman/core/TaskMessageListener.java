package com.haulmont.taskman.core;

import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.listener.BeforeInsertEntityListener;
import com.haulmont.taskman.entity.MessageDirection;
import com.haulmont.taskman.entity.Task;
import com.haulmont.taskman.entity.TaskMessage;
import com.haulmont.taskman.entity.TaskState;
import org.springframework.stereotype.Component;

@Component(TaskMessageListener.NAME)
public class TaskMessageListener implements BeforeInsertEntityListener<TaskMessage> {
    public static final String NAME = "taskman_TaskMessageListener";


    @Override
    public void onBeforeInsert(TaskMessage message, EntityManager entityManager) {
        if (MessageDirection.OUTBOX == message.getDirection()) {
            Task task = entityManager.find(Task.class, message.getTask().getId(), "task-state-view");
            task.setState(TaskState.REPLIED);
            entityManager.persist(task);
        }
    }
}