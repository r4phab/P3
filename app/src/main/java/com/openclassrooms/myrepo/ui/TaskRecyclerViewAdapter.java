package com.openclassrooms.myrepo.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.openclassrooms.myrepo.R;
import com.openclassrooms.myrepo.model.Task;


public class TaskRecyclerViewAdapter extends ListAdapter<Task, TaskRecyclerViewAdapter.ViewHolder> {

    public TaskRecyclerViewAdapter() {
        super(new ItemCallback());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView factTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            factTextView = itemView.findViewById(R.id.task_description);
        }

        public void bind(Task task) {
            factTextView.setText(task.getDescription());
        }
    }

    private static class ItemCallback extends DiffUtil.ItemCallback<Task> {
        @Override
        public boolean areItemsTheSame(@NonNull Task oldItem, @NonNull Task newItem) {
            return oldItem.getDescription().equals(newItem.getDescription());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Task oldItem, @NonNull Task newItem) {
            return oldItem.equals(newItem);
        }
    }
}
