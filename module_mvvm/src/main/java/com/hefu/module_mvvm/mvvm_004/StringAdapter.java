package com.hefu.module_mvvm.mvvm_004;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.hefu.module_mvvm.R;
import com.hefu.module_mvvm.databinding.ItemStringBinding;

import java.util.List;

public class StringAdapter extends RecyclerView.Adapter<StringAdapter.ViewHolder> {

    private List<StringBean> data;
    private OnStringItemListener listener;
    public StringAdapter(List<StringBean> data, OnStringItemListener listener){
        this.data = data;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemStringBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_string, parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.setItem(data.get(position));
        holder.binding.textView3.setOnClickListener(v -> listener.onClick(position, data.get(position)));


        holder.binding.textView3.setOnClickListener(v -> listener.onClick(position, null ));

        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return data == null ? 0: data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ItemStringBinding binding;
        public ViewHolder(@NonNull ItemStringBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
    interface OnStringItemListener{
        void onClick(int position, StringBean value);
    }
}
