package com.camila.ortiz.android2022.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.camila.ortiz.android2022.R;

import java.util.List;

public class StringAdapter extends RecyclerView.Adapter<StringAdapter.StringViewHolder> {

    List<String> contacts;
    public StringAdapter(List<String> contacts){
            this.contacts = contacts;
    }

    @NonNull
    @Override
    public StringViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_string,parent,false);
        StringViewHolder vh = new StringViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull StringViewHolder vh, int position) {
        String contactName = contacts.get(position);
        TextView tvContactName = vh.itemView.findViewById(R.id.tvContactName);
        tvContactName.setText(contactName);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    class StringViewHolder extends RecyclerView.ViewHolder{

        public StringViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
