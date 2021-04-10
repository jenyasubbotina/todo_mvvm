package com.jenyasubbotina.todo;

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

    @Override
    public int getItemCount() {
        return todos.size();
    }

    public void setTodos(List<Task> todos) {
        this.todos = todos;
        notifyDataSetChanged();
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
