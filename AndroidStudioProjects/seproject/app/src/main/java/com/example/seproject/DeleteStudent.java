package com.example.seproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DeleteStudent extends AppCompatActivity {

    EditText et1,et2;
    Button btn;

    DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_student);

        et1 = (EditText) findViewById(R.id.editText3);
        et2 = (EditText) findViewById(R.id.editText2);
        btn = (Button) findViewById(R.id.button);
        db = FirebaseDatabase.getInstance().getReference();

        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                deleteStudent();
            }
        });
    }

    private void deleteStudent()
    {
        String project = et1.getText().toString().trim();
        String name = et2.getText().toString().trim();

        if((TextUtils.isEmpty((name)) == false) && (TextUtils.isEmpty((project)) == false))
        {
            String id="";

            Student s;

            for(int i=0;i<Student.arr.size();i++)
            {
                s = Student.arr.get(i);

                if(s.name.equals(name) && (s.project.equals(project)))
                {
                    id = s.id;
                    Student.arr.remove(i);
                    break;
                }
            }

            if(id.length()!=0)
            {
                DatabaseReference dr = FirebaseDatabase.getInstance().getReference("student").child(id);
                dr.removeValue();

                Toast.makeText(this, "Student deleted", Toast.LENGTH_SHORT).show();
            }

            else
            {
                Toast.makeText(this, "Incorrect  student or project name", Toast.LENGTH_SHORT).show();
            }


        }

        else
        {
            Toast.makeText(this, "Enter project and student name properly", Toast.LENGTH_SHORT).show();
        }
    }
}
