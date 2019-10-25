package model;

import model.Member;
import utils.DukeException;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;

//@@author chenyuheng
public class Task {
    private String name;
    private String description;
    private boolean isDone;
    private ArrayList<Member> memberList;
    private Date time;

    public Task(String name){
        this.name = name.trim();
        this.memberList = new ArrayList<>();
    }

    public void addMember(Member toAdd) {
        if (!memberList.contains(toAdd)) {
            memberList.add(toAdd);
        }
    }

    public void deleteMember(Member toDelete) {
        if (memberList.contains(toDelete)) {
            memberList.remove(toDelete);
        }
    }

    public ArrayList<Member> getMemberList() {
        return memberList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return isDone;
    }

    public void markAsDone() {
        isDone = true;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}