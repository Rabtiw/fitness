package com.example.mahe.fitness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class last extends AppCompatActivity {
    int calo;
    TextView t9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);
        Bundle b=getIntent().getExtras();
        if(b!=null)
        {
            calo=b.getInt("calories");
        }
        String c=Integer.toString(calo);
        t9=(TextView)findViewById(R.id.textView12);
        t9.setText(c);
    }
    public void logn(View view)
    {
        Intent intent=new Intent(last.this,RegisterActivity.class);
        startActivity(intent);
    }
}
