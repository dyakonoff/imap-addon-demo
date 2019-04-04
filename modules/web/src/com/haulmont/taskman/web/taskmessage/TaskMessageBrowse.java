package com.haulmont.taskman.web.taskmessage;

import com.haulmont.cuba.gui.screen.*;
import com.haulmont.taskman.entity.TaskMessage;

@UiController("taskman_TaskMessage.browse")
@UiDescriptor("task-message-browse.xml")
@LookupComponent("taskMessagesTable")
@LoadDataBeforeShow
public class TaskMessageBrowse extends StandardLookup<TaskMessage> {
}