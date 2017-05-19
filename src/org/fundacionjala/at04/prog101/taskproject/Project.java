package org.fundacionjala.at04.prog101.taskproject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AbelBarrientos on 5/19/2017.
 */
public class Project {

    private List<Task> taskList;

    public Project()
    {
        taskList = new ArrayList<>();
    }

    public void add(Task task) {
        taskList.add(task);
    }

    public int size() {
        return taskList.size();
    }

    public int finish() {
        int maximun = taskList.get(0).completedIn();

        for(Task task: taskList)
        {
            if(maximun < task.completedIn())
                maximun = task.completedIn();
        }
        return maximun;
    }
}
