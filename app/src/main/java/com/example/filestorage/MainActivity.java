package com.example.filestorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText filename,content;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        filename = (EditText) findViewById(R.id.filename);
        content = (EditText) findViewById(R.id.content);
        save = (Button) findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fname = filename.getText().toString();
                String fcontent = content.getText().toString();
                FileOutputStream fos;

                try{
                    fos = openFileOutput(fname, Context.MODE_PRIVATE);
                    fos.write(fcontent.getBytes());
                    fos.close();
                    Toast.makeText(MainActivity.this,fname + " saved",Toast.LENGTH_SHORT).show();
                }catch(FileNotFoundException e){
                    e.printStackTrace();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        });
    }
}
