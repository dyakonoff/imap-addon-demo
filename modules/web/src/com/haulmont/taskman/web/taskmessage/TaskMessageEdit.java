package com.haulmont.taskman.web.taskmessage;

import com.haulmont.cuba.gui.screen.EditedEntityContainer;
import com.haulmont.cuba.gui.screen.LoadDataBeforeShow;
import com.haulmont.cuba.gui.screen.StandardEditor;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import com.haulmont.taskman.entity.TaskMessage;

@UiController("taskman_TaskMessage.edit")
@UiDescriptor("task-message-edit.xml")
@EditedEntityContainer("taskMessageDc")
@LoadDataBeforeShow
public class TaskMessageEdit extends StandardEditor<TaskMessage> {
}