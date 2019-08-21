package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddStudent extends AppCompatActivity {


    EditText et1,et2;
    Button btn;

    DatabaseReference db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);


        et1 = (EditText) findViewById(R.id.editText3);
        et2 = (EditText) findViewById(R.id.editText2);
        btn = (Button) findViewById(R.id.button);

        db = FirebaseDatabase.getInstance().getReference();

        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                addStudent();
            }
        });

    }
    private void addStudent()
    {
        String project = et1.getText().toString().trim();
        String name = et2.getText().toString().trim();

        if((TextUtils.isEmpty((name)) == false) && (TextUtils.isEmpty((project)) == false))
        {
            String id = db.push().getKey();

            Student1 s = new Student1(project,name);


            db.child("student").child(id).setValue(s);

            Toast.makeText(this, "Student added", Toast.LENGTH_SHORT).show();
        }
        
        else
        {
            Toast.makeText(this, "Enter project and student name properly", Toast.LENGTH_SHORT).show();
        }
    }
}


class Student
{
    public String project;
    public String name;


    public Student()
    {

    }

    public Student(String project, String name)
    {
        this.project = project;
        this.name = name;
    }
}