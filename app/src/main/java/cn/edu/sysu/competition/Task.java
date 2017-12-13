package cn.edu.sysu.competition;

import java.util.Date;

/**
 * Created by Emilia on 2017/11/27.
 */

public class Task {
    private int taskID;
    private int icon1;
    private int icon2;
    private boolean isStart;
    private String content;
    private int done;
    private int goal;
    private Date startDate;
    private Date endDate;

    public Task(int taskID, int icon1, int icon2, boolean isStart,
                String content, int done, int goal) {
        this.taskID = taskID;
        this.icon1 = icon1;
        this.icon2 = icon2;
        this.isStart = isStart;
        this.content = content;
        this.done = done;
        this.goal = goal;
    }

    public Task(int taskID, int icon1, int icon2, boolean isStart,
                String content, int done, Date startDate, Date endDate) {
        this.taskID = taskID;
        this.icon1 = icon1;
        this.icon2 = icon2;
        this.isStart = isStart;
        this.content = content;
        this.done = done;
        this.startDate = startDate;
        this.endDate = endDate;
        int diff = (int)(startDate.getTime() - endDate.getTime());//这样得到的差值是微秒级别
        this.goal = 1 + diff / (1000 * 60 * 60 * 24);
    }

    public int getTaskID() {
        return taskID;
    }

    public int getIcon1() {
        return icon1;
    }

    public int getIcon2() {
        return icon2;
    }

    public boolean getStatu() {
        return isStart;
    }

    public String getContent() {
        return content;
    }

    public int getDone() {
        return done;
    }

    public int getGoal() {
        return goal;
    }
}
