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
    private String content1;
    private String content2;
    private int done1;
    private int done2;
    private int goal1;
    private int goal2;
    private Date startDate;
    private Date endDate;

    public Task(int taskID, int icon1, boolean isStart,
                String content1,
                int done1,
                int goal1) {
        this.taskID = taskID;
        this.icon1 = icon1;
        this.icon2 = R.drawable.defaulticon;
        this.isStart = isStart;
        this.content1 = content1;
        this.content2 = "Unset";
        this.done1 = done1;
        this.done2 = 0;
        this.goal1 = goal1;
        this.goal2 = 0;
    }

    public Task(int taskID, int icon1, int icon2, boolean isStart,
                String content1, String content2,
                int done1, int done2,
                int goal1, int goal2) {
        this.taskID = taskID;
        this.icon1 = icon1;
        this.icon2 = icon2;
        this.isStart = isStart;
        this.content1 = content1;
        this.content2 = content2;
        this.done1 = done1;
        this.done2 = done2;
        this.goal1 = goal1;
        this.goal2 = goal2;
    }

    public Task(int taskID, int icon1, int icon2, boolean isStart,
                String content1, String content2,
                int done1, int done2,
                Date startDate, Date endDate) {
        this.taskID = taskID;
        this.icon1 = icon1;
        this.icon2 = icon2;
        this.isStart = isStart;
        this.content1 = content1;
        this.content2 = content2;
        this.done1 = done1;
        this.done2 = done2;
        this.startDate = startDate;
        this.endDate = endDate;
        int diff = (int) (startDate.getTime() - endDate.getTime());//这样得到的差值是微秒级别
        this.goal1 = 1 + diff / (1000 * 60 * 60 * 24);
    }

    public Task(int taskID, int icon1, int icon2, boolean isStart,
                String content1, int done1, int goal1) {
        this.taskID = taskID;
        this.icon1 = icon1;
        this.icon2 = icon2;
        this.isStart = isStart;
        this.content1 = content1;
        this.done1 = done1;
        this.goal1 = goal1;
    }

    public Task(int taskID, int icon1, int icon2, boolean isStart,
                String content1, int done1, Date startDate, Date endDate) {
        this.taskID = taskID;
        this.icon1 = icon1;
        this.icon2 = icon2;
        this.isStart = isStart;
        this.content1 = content1;
        this.done1 = done1;
        this.startDate = startDate;
        this.endDate = endDate;
        int diff = (int) (startDate.getTime() - endDate.getTime());//这样得到的差值是微秒级别
        this.goal1 = 1 + diff / (1000 * 60 * 60 * 24);
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

    public String getContent(int which) {
        switch (which) {
            case 1:
                return content1;
            case 2:
                return content2;
            default:
                return content1;
        }
    }

    public int getDone(int which) {
        switch (which) {
            case 1:
                return done1;
            case 2:
                return done2;
            default:
                return done1;
        }
    }

    public int getGoal(int which) {
        switch (which) {
            case 1:
                return goal1;
            case 2:
                return goal2;
            default:
                return goal1;
        }
    }

    public String getContent() {
        return content1;
    }

    public int getDone() {
        return done1;
    }

    public int getGoal() {
        return goal1;
    }

}