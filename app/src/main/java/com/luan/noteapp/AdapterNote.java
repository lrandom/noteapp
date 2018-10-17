package com.luan.noteapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.luan.noteapp.models.Note;

import java.util.ArrayList;
import java.util.List;

public class AdapterNote extends ArrayAdapter<Note>{
    Context context;
    int resourcesId;
    ArrayList<Note> notes;

    public AdapterNote(@NonNull Context context, int resource, @NonNull ArrayList<Note> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resourcesId=resource;
        this.notes= objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if(v==null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = layoutInflater.inflate(resourcesId,null);
        }
        TextView tvTitle =(TextView) v.findViewById(R.id.tvTitle);
        TextView tvContent =(TextView) v.findViewById(R.id.tvContent);
        Note note = getItem(position);
        tvTitle.setText(note.getTitle());
        tvContent.setText(note.getContent());
        return v;
    }
}
