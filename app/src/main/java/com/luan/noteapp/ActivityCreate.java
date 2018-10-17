package com.luan.noteapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.luan.noteapp.models.MyObjectBox;
import com.luan.noteapp.models.Note;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class ActivityCreate extends Activity{
    EditText edtTitle,edtContent;
    Button btnSave;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BoxStore boxStore = MainApplication.getApp().getmBoxStore();
        final Box<Note> noteBox = boxStore.boxFor(Note.class);

        setContentView(R.layout.activity_create);
        edtTitle=(EditText)findViewById(R.id.edtTitle);
        edtContent = (EditText)findViewById(R.id.edtDescription);
        btnSave=(Button)findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = edtTitle.getText().toString();
                String content = edtContent.getText().toString();
                if(title.equalsIgnoreCase("") || content.equalsIgnoreCase("")){
                    Toast.makeText(getApplicationContext(),"Vui long dien day du du lieu",Toast.LENGTH_SHORT).show();
                    return;
                }
                //lưu du lieu
                Note note = new Note();
                note.setTitle(title);
                note.setContent(content);
                noteBox.put(note);

                Toast.makeText(getApplicationContext(),"Note saved",Toast.LENGTH_SHORT).show();

                edtTitle.setText("");
                edtContent.setText("");

            }
        });

    }
}
