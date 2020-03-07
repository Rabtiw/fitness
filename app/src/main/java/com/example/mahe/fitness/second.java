package com.example.mahe.fitness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class second extends AppCompatActivity {
    String firstse;
    RadioGroup rg1;
    RadioButton rb1;
    String second;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        rg1=findViewById(R.id.radioGrouppp);
        Bundle b=getIntent().getExtras();
        if(b!=null)
        {
            firstse=b.getString("firstsel");
        }
    }
    public void page2(View view)
    {
        Intent intent=new Intent(second.this,first.class);
        startActivity(intent);
    }
    public void page3(View view)
    {
        Intent intent=new Intent(second.this,third.class);
        intent.putExtra("firstse1",firstse);
        intent.putExtra("secondse1",second);
        startActivity(intent);
    }
    public void val1(View view)
    {
        //int radioid1=rg1.getCheckedRadioButtonId();
        //rb1=findViewById(radioid1);
        //second=rb1.getText().toString();
        switch (rg1.getCheckedRadioButtonId()) {
            case R.id.radioButton4:
                rb1=findViewById(R.id.radioButton4);
                second=rb1.getText().toString();
                break;
            case R.id.radioButton5:
                rb1=findViewById(R.id.radioButton5);
                second=rb1.getText().toString();
                break;
            case R.id.radioButton6:
                rb1=findViewById(R.id.radioButton6);
                second=rb1.getText().toString();
                break;
            case R.id.radioButton7:
                rb1=findViewById(R.id.radioButton7);
                second=rb1.getText().toString();
                break;
        }
    }
}
