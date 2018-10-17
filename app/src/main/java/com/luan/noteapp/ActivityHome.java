package com.luan.noteapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.luan.noteapp.models.MyObjectBox;
import com.luan.noteapp.models.Note;

import java.util.ArrayList;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class ActivityHome extends Activity{
    Button btnCreate;
    ArrayList<Note> notes;
    AdapterNote adapterNote;
    ListView lstView;
    Box<Note> noteBox;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BoxStore boxStore = MainApplication.getApp().getmBoxStore();
        noteBox = boxStore.boxFor(Note.class);
        setContentView(R.layout.activity_home);
        lstView=(ListView)findViewById(R.id.lstView);
        btnCreate=(Button)findViewById(R.id.btnCreateNote);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //chuyen man hinh
                Intent intent = new Intent(getApplicationContext(),ActivityCreate.class);
                startActivity(intent);
            }
        });
        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),ActivityDetail.class);
                Note note = notes.get(i);
                intent.putExtra("title",note.getTitle());
                intent.putExtra("content",note.getContent());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        notes = new ArrayList<Note>(noteBox.getAll());
        adapterNote = new AdapterNote(getApplicationContext(),R.layout.row_item_note,notes);
        lstView.setAdapter(adapterNote);
    }
}
