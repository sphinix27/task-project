package org.fundacionjala.at04.prog101.taskproject;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by AbelBarrientos on 5/19/2017.
 */
public class ProjectTest {

    @Test
    public void aProjectHasManyTasks()
    {
        Project project = new Project();

        project.add(new Task("t1", 1));

        assertEquals(1, project.size());
    }

    @Test
    public void calculateTheTimeToCompleteTwoDifferentTasks()
    {
        Project project = new Project();

        project.add(new Task("t1", 1));
        project.add(new Task("t2", 3));

        assertEquals(3, project.finish());
    }

    @Test
    public void calculateTheTimeToCompleteThreeDifferentTasks()
    {
        Project project = new Project();

        project.add(new Task("t1", 1));
        project.add(new Task("t2", 3));
        project.add(new Task("t3", 4));

        assertEquals(4, project.finish());
    }

    @Test
    public void calculateTheTimeToCompleteThreeDifferentTasksOn()
    {
        Project project = new Project();

        project.add(new Task("t1", 5));
        project.add(new Task("t2", 3));
        project.add(new Task("t3", 4));

        assertEquals(5, project.finish());
    }

    @Test
    public void calculateTheTimeToCompleteWithTwoTasksWithDependOnTasks()
    {
        Project project = new Project();

        Task taskOne = new Task("t1", 1);

        taskOne.addTask(new Task("t2", 3));

        project.add(taskOne);

        assertEquals(4, project.finish());
    }


    @Test
    public void calculateTheTimeToCompleteWithTwoTasksWithDependOnTasksAndOneNot()
    {
        Project project = new Project();

        Task taskOne = new Task("t1", 2);
        Task taskTwo = new Task("t2", 4);
        Task taskThree = new Task("t3", 3);

        taskOne.addTask(taskTwo);
        taskOne.addTask(taskThree);

        project.add(taskOne);

        assertEquals(6, project.finish());
    }

    @Test
    public void calculateTheTimeToCompleteWithMoreNestedTasks()
    {
        Project project = new Project();

        Task taskOne = new Task("t1", 2);
        Task taskTwo = new Task("t2", 4);
        Task taskThree = new Task("t3", 3);
        Task taskFour = new Task("t4", 2);

        taskOne.addTask(taskTwo);
        taskOne.addTask(taskThree);

        taskThree.addTask(taskFour);

        assertEquals(5, taskThree.completedIn());

        project.add(taskOne);

        assertEquals(7, project.finish());
    }

    @Test
    public void calculateTheTimeToCompleteWithTheLastStep()
    {
        Project project = new Project();

        Task taskOne = new Task("t1", 1);
        Task taskTwo = new Task("t2", 5);
        Task taskThree = new Task("t3", 3);
        Task taskFour = new Task("t4", 2);
        Task taskFive = new Task("t5", 3);

        taskOne.addTask(taskTwo);

        taskTwo.addTask(taskThree);
        taskTwo.addTask(taskFour);

        taskThree.addTask(taskFive);

        taskFour.addTask(taskFive);

        project.add(taskOne);

        assertEquals(12, project.finish());
    }
}
