package model;

import common.DukeException;
import core.Duke;

import java.util.ArrayList;
import java.util.Date;

/**
 * Exposes the api of Model, this falls in line with open close policy, allowing the different implementations of
 * model to be used, without having to change other major parts of the code
 */
public interface Model {
    //@@author JustinChia1997
    //==================Storage Interface======================

    void load();

    void save();

    //==================Task Interface======================
    ArrayList<Task> getTaskList();

    int getTaskListSize();

    String getTasks();

    String getTodoTasks();

    String getTaskNameById(int index);

    String getTaskNameByIdOnList(int indexOfTask);

    String getTaskIsDoneByIdOnList(int indexOfTask);

    String getTaskDescriptionByIdOnList(int indexOfTask);

    Date getTaskDateTimeByIdOnList(int indexOfTask);

    ArrayList<String> getMemberListOfTaskByIdOnList(int indexOfTask);

    ArrayList<String> getSkillListOfTaskByIdOnList(int indexOfTask);

    Date getTaskReminderByIdOnList(int indexOfTask);

    TasksManager getTasksManager();

    String getTasksByKeyword(String keyword);

    Task addTask(String name) throws DukeException;

    boolean hasTask(String name) throws DukeException;

    String tasksAllInorderTime();

    String tasksTodoInorderTime();

    String tasksAllInorderPicNum();

    String tasksTodoInorderPicNum();

    String updateTaskDes(int index, String des);

    void updateTaskTime(int index, String time) throws DukeException;

    boolean isInTaskList(int taskIndex);

    //TODO look into using exceptions instead?
    boolean addTaskReqSkill(String taskName, String skillName);


    //==================Member Interface======================
    ArrayList<Member> getMemberList();

    int getMemberListSize();

    String getMemberNameById(int index);

    MemberManager getMemberManager();

    void addMember(String name) throws DukeException;

    String updateMemberBio(String name, String bio);

    String updateMemberEmail(String name, String email) throws DukeException;

    String updateMemberPhone(String name, String phone) throws DukeException;

    boolean hasMember(String name) throws DukeException;

    boolean addMemberSkill(String memberName, String skillName);

    String membersInorderProgress();

    String membersInorderTodoNum();

    int getMemberIdByName(String name);

    String getMemberBioByName(String name);

    String getMemberEmailByName(String name);

    String getMemberPhoneByName(String name);

    ArrayList<String> getTaskListOfMemberByName(String name);

    ArrayList<String> getSkillListOfMemberByName(String name);

    //==================Task and Member Interface======================
    void link(int tasksIndexes, String memberNames);

    void unlink(int tasksIndexes, String memberNames) throws DukeException;

    String deleteTask(int index);

    void deleteMember(String memberName);

    String scheduleMemberAll(String memberName);

    String scheduleMemberTodo(String memberName);

    String check();
}
