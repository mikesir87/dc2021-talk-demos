package io.mikesir87.dc2021demo.domain;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Item {

    @Id
    private String id;

    private String description;
    private boolean completed;
    private Date creationDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String toString() {
        return String.format("GroceryItem[id=%s, description=%s, completed=%b]", id, description, completed);
    }
}
