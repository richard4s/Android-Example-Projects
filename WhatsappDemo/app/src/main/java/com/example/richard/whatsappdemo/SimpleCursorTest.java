package com.example.richard.whatsappdemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class SimpleCursorTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_cursor_test);

        SQLiteDatabase sdb;
        String tableName = "whatsappDemo";

        sdb = this.openOrCreateDatabase("WhatsappClass", MODE_PRIVATE, null);

        sdb.execSQL("CREATE TABLE IF NOT EXISTS " + tableName
                    + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, surname VARCHAR(50), othername VARCHAR(50));");

        sdb.execSQL("INSERT INTO " + tableName + " (surname, othername)" + "VALUES('Olu', 'Oluwatobi');");

        Cursor c = sdb.rawQuery("SELECT _id, surname, othername FROM " + tableName, null);
        String from[] = {"surname", "othername"};
        int to[] = {R.id.ct1, R.id.ct2};
        SimpleCursorAdapter sc = new SimpleCursorAdapter(this, R.layout.scursor, c, from, to);

        ListView lview = (ListView) findViewById(R.id.sclistview);
        lview.setAdapter(sc);
    }
}
