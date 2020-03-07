package com.example.mahe.fitness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Pattern;

public class third extends AppCompatActivity {
    EditText wt,ht;
    int height,weight;
    String fs1,ss2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ht=(EditText)findViewById(R.id.editText);
        wt=(EditText)findViewById(R.id.editText4);
        Bundle b=getIntent().getExtras();
        if(b!=null)
        {
            fs1=b.getString("firstse1");
            ss2=b.getString("secondse1");
        }
    }
    public void page3(View view)
    {
        Intent intent=new Intent(third.this,second.class);
        startActivity(intent);
    }
    public void page5(View view)
    {   if (!isValidHeight()| !isValidWeight()) {
        return;
    }
    else {
        height=Integer.parseInt(ht.getText().toString().trim());
        weight=Integer.parseInt(wt.getText().toString().trim());
        Intent intent = new Intent(third.this, signup.class);
        intent.putExtra("height",height);
        intent.putExtra("weight",weight);
        intent.putExtra("firsts",fs1);
        intent.putExtra("seconds",ss2);
        startActivity(intent);
    }
    }
    private boolean isValidHeight() {
        String phone=ht.getText().toString().trim();
        if(Pattern.matches("[a-zA-Z]+", phone)) {
            ht.setError("Please enter valid height");
            return false;
        }
        else if (phone.isEmpty()) {
            ht.setError("Field can't be empty");
            return false;
        }
        else
        {return true;}
    }
    private boolean isValidWeight() {
        String phone=wt.getText().toString().trim();
        if(Pattern.matches("[a-zA-Z]+", phone)) {
            wt.setError("Please enter valid height");
            return false;
        }
        else if (phone.isEmpty()) {
            wt.setError("Field can't be empty");
            return false;
        }
        else
        {return false;}
    }
}
