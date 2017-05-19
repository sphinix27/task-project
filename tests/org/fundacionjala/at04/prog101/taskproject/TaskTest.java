package org.fundacionjala.at04.prog101.taskproject;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by AbelBarrientos on 5/19/2017.
 */
public class TaskTest {

    @Test
    public void taskHasNameAndIntAttributes()
    {
        Task task = new Task("t1", 1);

        assertTrue(task instanceof Task);
    }

    @Test
    public void taskHasADependOnListTask()
    {
        Task task = new Task("t1", 1);



        assertEquals(0,task.getDependsOn().size());
    }

    @Test
    public void taskCanAddTasksOnListTask()
    {
        Task task = new Task("t1", 1);

        task.addTask(new Task("t2", 3));
        task.addTask(new Task("t3", 4));

        assertEquals(2,task.getDependsOn().size());
    }

    @Test
    public void taskCanBeCompletedAfterTime()
    {
        Task task = new Task("t1", 1);

        task.addTask(new Task("t2", 3));
        task.addTask(new Task("t3", 4));

        assertEquals(5, task.completedIn());
    }

    @Test
    public void taskCanBeCompletedAfterTimeExpected()
    {
        Task task = new Task("t1", 1);

        task.addTask(new Task("t2", 3));
        task.addTask(new Task("t3", 4));

        assertEquals(5, task.completedIn());
    }

}
