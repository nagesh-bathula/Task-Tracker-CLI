package task.tracker.cli;

import java.io.Serializable;

public class Task implements Serializable
{
    private String description;
    private String status;

    public Task(String description)
    {
        this.description = description;
        this.status = "pending";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return description + "\n"+status ;
    }
}
