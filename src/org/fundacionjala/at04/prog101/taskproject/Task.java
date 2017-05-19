package org.fundacionjala.at04.prog101.taskproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by AbelBarrientos on 5/19/2017.
 */
public class Task {

    private String name;
    private int time;
    private List<Task> taskList;


    public Task(String name, int time) {
        this.name = name;
        this.time = time;
        taskList = new ArrayList<>();
    }

    public List<Task> getDependsOn() {
        return taskList;
    }

    public void addTask(Task t2) {
        taskList.add(t2);
    }

    public int getTime() {
        return completedIn();
    }

    public int completedIn() {
        if(taskList.size() == 0)
        {
            return time;
        }
        int maximun = taskList.get(0).getTime();
        for(Task task: taskList)
        {
            if(maximun < task.getTime())
                maximun = task.getTime();
        }
        return maximun + time;
    }
}
