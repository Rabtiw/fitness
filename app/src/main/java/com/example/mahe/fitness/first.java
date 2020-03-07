package com.example.mahe.fitness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class first extends AppCompatActivity {
    RadioGroup rg;
    RadioButton rb;
    String first;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        rg=findViewById(R.id.radioGroup);
    }
    public void page2(View view)
    {
        Intent intent=new Intent(first.this,second.class);
        intent.putExtra("firstsel",first);
        startActivity(intent);
    }
    public void val(View view)
    {
        switch (rg.getCheckedRadioButtonId()) {
            case R.id.lw:
                rb=findViewById(R.id.lw);
                first=rb.getText().toString();
                break;
            case R.id.mw:
                rb=findViewById(R.id.mw);
                first=rb.getText().toString();
                break;
            case R.id.gw:
                rb=findViewById(R.id.gw);
                first=rb.getText().toString();
                break;
        }
    }
}
