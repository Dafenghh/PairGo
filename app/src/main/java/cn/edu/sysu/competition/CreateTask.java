package cn.edu.sysu.competition;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;

public class CreateTask extends AppCompatActivity {
    private DatePicker datePicker;
    private Calendar calendar_1, calendar_2;
    private TextView startDateView, endDateView;
    private EditText taskNameInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);
        taskNameInput = (EditText) findViewById(R.id.input_task_name);
        startDateView = (TextView) findViewById(R.id.text_view_start_date);
        endDateView = (TextView) findViewById(R.id.text_view_end_date);
        calendar_1 = Calendar.getInstance();
        calendar_2 = Calendar.getInstance();
        showDate(startDateView, calendar_1.get(Calendar.YEAR),
                calendar_1.get(Calendar.MONTH),calendar_1.get(Calendar.DAY_OF_MONTH));
        showDate(endDateView, calendar_2.get(Calendar.YEAR),
                calendar_2.get(Calendar.MONTH),calendar_2.get(Calendar.DAY_OF_MONTH));

    }

    @SuppressWarnings("deprecation")
    public void setStartDate(View view) {
        showDialog(999);
    }

    public void setEndDate(View view) {
        showDialog(998);
    }

    public void createTaskCancel(View view) {
        finish();
    }
    public void createTaskSubmit(View view) {
        String checkResult = checkTaskInfo();
        if (checkResult == "valid") {
            List<Task> taskList = TaskListFragment.getTaskList();
            taskList.add(new Task(2,R.drawable.example1, R.drawable.example2, true
                    , taskNameInput.getText().toString(),  0,calendar_1.getTime(), calendar_2.getTime()));

            /*
                public Task(int taskID, int icon1, int icon2, boolean isStart,
                String content1, String content2,
                int done1, int done2,
                Date startDate, Date endDate)


             */
            Toast.makeText(getApplicationContext(), "新建任务成功！",
                    Toast.LENGTH_SHORT)
                    .show();
            finish();
        }
        else {
            Toast.makeText(getApplicationContext(), checkResult,
                    Toast.LENGTH_SHORT)
                    .show();
        }

    }

    private String checkTaskInfo() {
        if (taskNameInput.getText().toString().isEmpty()) return "任务名为空！";
        Calendar calendar_3 = Calendar.getInstance(); // current time
        if (calendar_1.before(calendar_3) && (calendar_3.getTimeInMillis()-calendar_1.getTimeInMillis()) > 1000 * 3600 * 24) return "开始日期早于今天";
        if (calendar_2.before(calendar_1)) return "结束日期早于开始日期";
        return "valid";
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    startDateListener, calendar_1.get(Calendar.YEAR),
                    calendar_1.get(Calendar.MONTH),calendar_1.get(Calendar.DAY_OF_MONTH));
        }
        else if (id == 998) {
            return new DatePickerDialog(this,
                    endDateListener, calendar_2.get(Calendar.YEAR),
                    calendar_2.get(Calendar.MONTH),calendar_2.get(Calendar.DAY_OF_MONTH));
        }
        return null;
    }


    private DatePickerDialog.OnDateSetListener startDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(startDateView, arg1, arg2, arg3);
                    calendar_1.set(arg1, arg2, arg3);
                }
            };
    private DatePickerDialog.OnDateSetListener endDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(endDateView, arg1, arg2, arg3);
                    calendar_2.set(arg1, arg2, arg3);
                }
            };

    private void showDate(TextView dateView, int year, int month, int day) {
        dateView.setText(new StringBuilder().append(year).append("/")
                .append(month+1).append("/").append(day));
    }
}
