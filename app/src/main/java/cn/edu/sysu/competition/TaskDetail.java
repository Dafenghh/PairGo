package cn.edu.sysu.competition;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class TaskDetail extends AppCompatActivity {
    Button matcher_button,user_button;
    int matcher_task_id=0,user_task_id=1;
    Task matcher_task,user_task;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);
        //Intent intent=this.getIntent();

        List<Task> taskList = TaskListFragment.getTaskList();
        matcher_task = taskList.get(matcher_task_id);
        user_task = taskList.get(user_task_id);
        matcher_button = findViewById(R.id.check_matcher_button);
        user_button = findViewById(R.id.check_user_button);
        setTaskInfo();
        /*matcher_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (){

                }
            }
        });*/

    }
    private void setTaskInfo(){
        TextView matcher_task_task_name= findViewById(R.id.matcher_info).findViewById(R.id.detail_task_task_name);
        TextView matcher_task_start_time = findViewById(R.id.matcher_info).findViewById(R.id.detail_task_start_time);
        TextView matcher_task_goal_day =  findViewById(R.id.matcher_info).findViewById(R.id.detail_task_goal_day);
        TextView user_task_task_name= findViewById(R.id.user_info).findViewById(R.id.detail_task_task_name);
        TextView user_task_start_time =  findViewById(R.id.user_info).findViewById(R.id.detail_task_start_time);
        TextView user_task_goal_day =  findViewById(R.id.user_info).findViewById(R.id.detail_task_goal_day);

        matcher_task_task_name.setText(matcher_task.getContent());
        matcher_task_start_time.setText(matcher_task.getStartDateToString());
        matcher_task_goal_day.setText(Integer.toString(matcher_task.getGoal()));

        user_task_task_name.setText(user_task.getContent());
        user_task_start_time.setText(user_task.getStartDateToString());
        user_task_goal_day.setText(Integer.toString(user_task.getGoal()));

        TextView matcher_today_status = findViewById(R.id.matcher_today_status);
        switch (matcher_task.getTodayStatus()){
            case 0:
                matcher_today_status.setText("未完成");
                matcher_button.setText("温馨提醒");
                break;
            case 1:
                matcher_today_status.setText("待验收");
                matcher_button.setText("验收成果");
                break;
            case 2:
                matcher_today_status.setText("已完成");
                matcher_button.setText("为你点赞");
                break;
            case 3:
                matcher_today_status.setText("不通过");
                matcher_button.setText("温馨提醒");
                break;
        }

        TextView user_today_status = findViewById(R.id.user_today_status);
        switch (matcher_task.getTodayStatus()){
            case 0:
                user_today_status.setText("未完成");
                user_button.setText("提交成果");
                break;
            case 1:
                user_today_status.setText("待验收");
                user_button.setText("提醒验收");
                break;
            case 2:
                user_today_status.setText("已完成");
                user_button.setText("分享成果");
                break;
            case 3:
                user_today_status.setText("未通过");
                user_button.setText("重新提交");
        }
    }

}
