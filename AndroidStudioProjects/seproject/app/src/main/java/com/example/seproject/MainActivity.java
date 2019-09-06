package com.example.seproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btn1, btn2;
    //private EditText;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button)findViewById(R.id.button6);

        btn2 = (Button) findViewById(R.id.button7);

        btn1.setOnClickListener(new View.OnClickListener()
                                {
                                    @Override
                                    public void onClick (View view)
                                    {
                                        Intent intent = new Intent(MainActivity.this,AddStudent.class);
                                        startActivity(intent);
                                    }

                                }
        );

        btn2.setOnClickListener(new View.OnClickListener()

                                {
                                    @Override
                                    public void onClick (View view)
                                    {
                                        Intent intent = new Intent(MainActivity.this, DeleteStudent.class);
                                        startActivity(intent);
                                    }

                                }
        );

    }

}
