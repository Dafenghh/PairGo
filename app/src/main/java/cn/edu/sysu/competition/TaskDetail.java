package cn.edu.sysu.competition;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class TaskDetail extends AppCompatActivity {
    Button matcher_button,user_button;
    Task user_task;
    CircleImageView matcher_icon,user_icon;
    TextView matcher_task_task_name,matcher_task_start_time,matcher_task_goal_day;
    TextView user_task_task_name,user_task_start_time,user_task_goal_day;
    TextView user_today_status,matcher_today_status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);
        Intent intent=this.getIntent();
        int user_task_id = intent.getIntExtra("position",0);
        List<Task> taskList = TaskListFragment.getTaskList();
        user_task = taskList.get(user_task_id);
        matcher_button = findViewById(R.id.check_matcher_button);
        user_button = findViewById(R.id.check_user_button);
        setTaskInfo();

        matcher_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (matcher_today_status.getText().toString().equals("未完成")) {
                    user_task.setTodayStatus(1,2);
                    new AlertDialog.Builder(TaskDetail.this).setTitle("温馨提示").setMessage("系统已向TA发送提醒信息")
                            .setPositiveButton("对话",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            
                        }
                    }).setNegativeButton("返回", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).create().show();
                }
                if (matcher_today_status.getText().toString().equals("待验收")) {
                    new AlertDialog.Builder(TaskDetail.this).setTitle("验收成果").setMessage("验证内容")
                            .setPositiveButton("认可",new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    user_task.setTodayStatus(2,2);
                                    setMatcherFinished();
                                }
                            }).setNegativeButton("驳回", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    user_task.setTodayStatus(0,2);
                                    setMatcherUnfinished();
                                }
                    }).create().show();
                }
                if (matcher_today_status.getText().toString().equals("已完成")) {
                    Toast.makeText(getApplicationContext(), "点赞成功，双方经验值+1", Toast.LENGTH_SHORT).show();
                }
            }
        });
        user_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user_today_status.getText().toString().equals("未完成")) {
                    new AlertDialog.Builder(TaskDetail.this).setTitle("我的成果").setMessage("输入验证信息（图片+文字）")
                            .setPositiveButton("提交", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    user_task.setTodayStatus(1,1);
                                    setUserWait();
                                }
                            }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                            }
                    }).create().show();
                }
                if (user_today_status.getText().toString().equals("待验收")){
                    Toast.makeText(getApplicationContext(), "已提醒对方验收您的成果", Toast.LENGTH_SHORT).show();
                    user_task.setTodayStatus(2,1);
                }
                if (user_today_status.getText().toString().equals("已完成")) {
                    new AlertDialog.Builder(TaskDetail.this).setTitle("分享今日成果").
                            setMessage(user_task.getContent(1)+"任务已进行坚持了"+Integer.toString(user_task.getGoal()))
                            .setPositiveButton("分享", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).create().show();
                }
                if (user_today_status.getText().toString().equals("未通过")){
                    new AlertDialog.Builder(TaskDetail.this).setTitle("我的成果").setMessage("输入验证信息（图片+文字）")
                            .setPositiveButton("提交", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    user_task.setTodayStatus(1,1);
                                    setUserWait();
                                }
                            }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).create().show();
                }
            }
        });
    }
    private void setTaskInfo(){
        matcher_icon = findViewById(R.id.matcher_icon);
        matcher_task_task_name= findViewById(R.id.matcher_info).findViewById(R.id.detail_task_task_name);
        matcher_task_start_time = findViewById(R.id.matcher_info).findViewById(R.id.detail_task_start_time);
        matcher_task_goal_day =  findViewById(R.id.matcher_info).findViewById(R.id.detail_task_goal_day);
        user_icon = findViewById(R.id.user_icon);
        user_task_task_name= findViewById(R.id.user_info).findViewById(R.id.detail_task_task_name);
        user_task_start_time =  findViewById(R.id.user_info).findViewById(R.id.detail_task_start_time);
        user_task_goal_day =  findViewById(R.id.user_info).findViewById(R.id.detail_task_goal_day);

        matcher_icon.setImageResource(user_task.getIcon2());
        matcher_task_task_name.setText(user_task.getContent(2));
        matcher_task_start_time.setText(user_task.getStartDateToString(2));
        matcher_task_goal_day.setText(Integer.toString(user_task.getGoal(2)));

        user_icon.setImageResource(user_task.getIcon1());
        user_task_task_name.setText(user_task.getContent(1));
        user_task_start_time.setText(user_task.getStartDateToString(1));
        user_task_goal_day.setText(Integer.toString(user_task.getGoal(1)));

        matcher_today_status = findViewById(R.id.matcher_today_status);
        switch (user_task.getTodayStatus(2)){
            case 0:
                setMatcherUnfinished();
                break;
            case 1:
                setMatcherWait();t
                break;
            case 2:
                setMatcherFinished();
        }

        user_today_status = findViewById(R.id.user_today_status);
        switch (user_task.getTodayStatus(1)){
            case 0:
                setUserUnfinished();
                break;
            case 1:
                setUserWait();
                break;
            case 2:
                setUserFinished();
                break;
            case 3:
                setUserUnpassed();
        }
    }
    private void setMatcherUnfinished(){
        matcher_today_status.setText("未完成");
        matcher_button.setText("温馨提醒");
    }
    private void setMatcherWait(){
        matcher_today_status.setText("待验收");
        matcher_button.setText("验收成果");
    }
    private void setMatcherFinished(){
        matcher_today_status.setText("已完成");
        matcher_button.setText(new String("为TA点赞"));
    }
    private void setUserUnfinished(){
        user_today_status.setText("未完成");
        user_button.setText("提交成果");
    }
    private void setUserWait(){
        user_today_status.setText("待验收");
        user_button.setText("提醒验收");
    }
    private void setUserFinished(){
        user_today_status.setText("已完成");
        user_button.setText("分享成果");
    }
    private void setUserUnpassed(){
        user_today_status.setText("未通过");
        user_button.setText("重新提交");
    }
}
