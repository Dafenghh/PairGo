package cn.edu.sysu.competition;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Emilia on 2017/11/27.
 */

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder>{

    private static final String TAG = "TaskAdapter";

    private List<Task> mTaskList;

    static class ViewHolder extends  RecyclerView.ViewHolder {
        View taskView;
        TextView taskTitle;
        TextView taskDone;
        TextView taskProcess;
        CircleImageView icon1;
        CircleImageView icon2;
        RelativeLayout icon_layout;
        LinearLayout task_layout;
        boolean isSelf;
        boolean isStart;
        int position;

        public ViewHolder(View view) {
            super(view);
            taskView = view;
            taskTitle = (TextView) view.findViewById(R.id.task_title);
            taskDone = (TextView) view.findViewById(R.id.task_done);
            taskProcess = (TextView) view.findViewById(R.id.task_process);
            icon1 = (CircleImageView) view.findViewById(R.id.profile_image1);
            icon2 = (CircleImageView) view.findViewById(R.id.profile_image2);
            icon_layout = (RelativeLayout) view.findViewById(R.id.icon_layout);
            task_layout = (LinearLayout) view.findViewById(R.id.task_layout);
            isSelf = true;
        }
    }

    public TaskAdapter(List<Task> taskList) {
        mTaskList = taskList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_item, parent, false);
        WindowManager windowManager = (WindowManager)parent.getContext().getSystemService(Context.WINDOW_SERVICE);
        int width = windowManager.getDefaultDisplay().getWidth();
        view.setLayoutParams(new RecyclerView.LayoutParams(width, 250));
        final ViewHolder holder = new ViewHolder(view);

        holder.icon_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.isStart) {
                    Drawable temp1 = holder.icon1.getDrawable().getConstantState().newDrawable(),
                            temp2 = holder.icon2.getDrawable().getConstantState().newDrawable();
                    holder.icon1.setImageDrawable(temp2);
                    holder.icon2.setImageDrawable(temp1);
                    int tempColor = holder.icon1.getBorderColor();
                    holder.icon1.setBorderColor(holder.icon2.getBorderColor());
                    holder.icon2.setBorderColor(tempColor);


                    Task task = mTaskList.get(holder.position);

                    if (holder.isSelf) {
                        holder.taskTitle.setText(task.getContent(2));
                        holder.taskDone.setText("已进行" + task.getDone(2) + "天");
                        holder.taskProcess.setText("完成度" + ((task.getDone(2) * 100) / task.getGoal(2)) + "%");
                    } else {
                        holder.taskTitle.setText(task.getContent(1));
                        holder.taskDone.setText("已进行" + task.getDone(1) + "天");
                        holder.taskProcess.setText("完成度" + ((task.getDone(1) * 100) / task.getGoal(1)) + "%");
                    }

                    holder.isSelf = !holder.isSelf;
                }
            }
        });

        holder.task_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Task task = mTaskList.get(position);
                Intent intent = new Intent(view.getContext(), TaskDetail.class);
                intent.putExtra("position", position);
                view.getContext().startActivity(intent);
            }
        });
        // onClick event here

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.position = position;
        Task task = mTaskList.get(position);
        holder.isStart = task.getStatus();
        holder.taskTitle.setText(task.getContent(1));
        holder.taskDone.setText("已进行" + task.getDone(1) + "天");
        holder.taskProcess.setText("完成度" + ((task.getDone(1) * 100) / task.getGoal(1)) + "%");
        holder.icon1.setImageResource(task.getIcon1());
        holder.icon2.setImageResource(task.getIcon2());
    }

    @Override
    public int getItemCount() {
        return mTaskList.size();
    }

}
