package com.example.mahe.fitness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class choose extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
    }
    public void lgn(View view)
    {
        Intent intent=new Intent(choose.this,RegisterActivity.class);
        startActivity(intent);
    }
    public void sup(View view)
    {
        Intent intent=new Intent(choose.this,first.class);
        startActivity(intent);
    }
}
