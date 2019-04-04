package com.haulmont.taskman.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Listeners;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import com.haulmont.cuba.security.entity.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@NamePattern("[#%s] %s|number,subject")
@Table(name = "TASKMAN_TASK")
@Entity(name = "taskman_Task")
@Listeners({"taskman_TaskListener"})
public class Task extends StandardEntity {
    @NotNull
    @Column(name = "NUMBER_", nullable = false, unique = true)
    protected Long number;

    @Email(message = "Email address has invalid format: ${validatedValue}", regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$")
    @Column(name = "REPORTER_EMAIL")
    protected String reporterEmail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ASSIGNEE_ID")
    protected User assignee;

    @NotNull
    @Column(name = "STATE", nullable = false)
    protected String state = TaskState.OPEN.getId();

    @NotNull
    @Column(name = "SUBJECT", nullable = false)
    protected String subject;

    @Lob
    @Column(name = "CONTENT")
    protected String content;

    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "task")
    protected List<TaskMessage> messages;

    public List<TaskMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<TaskMessage> messages) {
        this.messages = messages;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public TaskState getState() {
        return state == null ? null : TaskState.fromId(state);
    }

    public void setState(TaskState state) {
        this.state = state == null ? null : state.getId();
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public String getReporterEmail() {
        return reporterEmail;
    }

    public void setReporterEmail(String reporterEmail) {
        this.reporterEmail = reporterEmail;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }
}