package com.jenyasubbotina.todo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.jenyasubbotina.todo.R;
import com.jenyasubbotina.todo.model.Task;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TodoViewHolder> {

    private List<Task> todos;
    private final Context context;

    public TaskAdapter(Context context, List<Task> todos) {
        this.context = context;
        this.todos = todos;
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View todoView = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item, parent, false);
        return new TodoViewHolder(todoView);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        Task todo = todos.get(position);
        holder.setData(todo);
        Toast.makeText(context, todo.getDescription(), Toast.LENGTH_SHORT).show();
    }

    public void setTodos(List<Task> todos) {
        this.todos = todos;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    static class TodoViewHolder extends RecyclerView.ViewHolder {

        TextView description;
        CheckBox checkbox;
        CardView type;

        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);
            description = itemView.findViewById(R.id.description);
            checkbox = itemView.findViewById(R.id.checkbox);
            type = itemView.findViewById(R.id.list_type);
        }

        public void setData(Task todo) {
            this.description.setText(todo.getDescription());
        }
    }
}
