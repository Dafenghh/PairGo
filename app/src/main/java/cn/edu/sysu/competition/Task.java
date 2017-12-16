package cn.edu.sysu.competition;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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
    private Date startDate1;
    private Date startDate2;
    private Date endDate;
    private int todayStatus1; // 0:  未完成     1:待验证    2:已完成    3：不通过
    private int todayStatus2;

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
        startDate1 = null;
        startDate2 = null;
        todayStatus1 = 0;
        todayStatus2 = 0;
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
        this.startDate1 = startDate;
        this.endDate = endDate;
        int diff = (int)(endDate.getTime() - startDate.getTime());//这样得到的差值是微秒级别
        this.goal1 = 1 + diff / (1000 * 60 * 60 * 24);
        todayStatus1 = 0;
        todayStatus2 = 0;
    }

    public Task(int taskID, int icon1, int icon2, boolean isStart,
                String content1, int done1, Date startDate, Date endDate) {
        this.taskID = taskID;
        this.icon1 = icon1;
        this.icon2 = icon2;
        this.isStart = isStart;
        this.content1 = content1;
        this.done1 = done1;
        this.startDate1 = startDate;
        this.endDate = endDate;
        int diff = (int) (endDate.getTime() - startDate.getTime());//这样得到的差值是微秒级别
        this.goal1 = 1 + diff / (1000 * 60 * 60 * 24);
        todayStatus1 = 0;
        todayStatus2 = 0;

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

    public boolean getStatus() {
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

    public Date getStartDate(int which){
        switch (which) {
            case 1:
                return startDate1;
            case 2:
                return startDate2;
            default:
                return startDate1;
        }
    }
    public String getStartDateToString(int which){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        Date date = getStartDate(which);
        if (date == null) return "2017-12-1";
        return sdf.format(date);
    }
    public int getTodayStatus(int which){
        switch (which) {
            case 1:
                return todayStatus1;
            case 2:
                return todayStatus2;
            default:
                return todayStatus1;
        }
    }
    public void setTodayStatus(int newTodayStatus,int which){
        switch (which) {
            case 1:
                todayStatus1 = newTodayStatus;
                break;
            case 2:
                todayStatus2 = newTodayStatus;
                break;
            default:
                todayStatus1 = newTodayStatus;
        }
    }
}

