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
 * Created by 911 on 2017/12/3.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    private List<Task> mTaskList;

    static class ViewHolder extends  RecyclerView.ViewHolder {
        View taskView;
        TextView chatTitle;
        TextView lastMsg;
        CircleImageView icon;

        public ViewHolder(View view) {
            super(view);
            taskView = view;
            chatTitle = (TextView) view.findViewById(R.id.chat_name);
            lastMsg = (TextView) view.findViewById(R.id.last_msg);
            icon = (CircleImageView) view.findViewById(R.id.chat_icon);
        }
    }

    public ChatAdapter(List<Task> taskList) {
        mTaskList = taskList;
    }

    @Override
    public ChatAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chat_item, parent, false);
        final ChatAdapter.ViewHolder holder = new ChatAdapter.ViewHolder(view);

        // onClick event here

        return holder;
    }

    @Override
    public void onBindViewHolder(ChatAdapter.ViewHolder holder, int position) {
        Task task = mTaskList.get(position);
        holder.icon.setImageResource(task.getIcon2());
        holder.chatTitle.setText("对方用户名");
        holder.lastMsg.setText("最后信息");
    }

    @Override
    public int getItemCount() {
        return mTaskList.size();
    }
}
