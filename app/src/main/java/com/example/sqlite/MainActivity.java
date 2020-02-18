package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDB db = new MyDB(this);
        db.createRecords("1","meme");
        Spinner desplegable = (Spinner) this.findViewById(R.id.spinnerCategories);
        Cursor cur = db.selectRecords();
        String[] from = new String[]{"name"};
        int[] to = new int[]{android.R.id.text1};
        SimpleCursorAdapter mAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_spinner_item, cur, from, to,0);
        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        desplegable.setAdapter(mAdapter);
    }
}
