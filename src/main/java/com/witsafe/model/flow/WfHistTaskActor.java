package com.witsafe.model.flow;

public class WfHistTaskActor {
    private String taskId;

    private String actorId;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    public String getActorId() {
        return actorId;
    }

    public void setActorId(String actorId) {
        this.actorId = actorId == null ? null : actorId.trim();
    }
}