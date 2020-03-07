package com.example.mahe.fitness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class signup extends AppCompatActivity {
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$");
    EditText name,age,phno,location,email;
    DatabaseReference reff;
    Member member;
    String em;
    Long ph;
    String f1,s1;
    int h1,w1;
    int cal=9,ag;
    double calculate;
    String gen;
    RadioGroup rg2;
    RadioButton rb2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name=(EditText)findViewById(R.id.editText);
        age=(EditText)findViewById(R.id.editText6);
        //gender=(EditText)findViewById(R.id.editText5);
        email=(EditText)findViewById(R.id.editText4);
        phno=(EditText)findViewById(R.id.editText3);
        location=(EditText)findViewById(R.id.editText2);
        member=new Member();
        rg2=findViewById(R.id.editText5);
        //ag=Integer.parseInt(age.getText().toString().trim());
        reff= FirebaseDatabase.getInstance().getReference().child("Member");
        Bundle b=getIntent().getExtras();
        if(b!=null)
        {
            f1=b.getString("firsts");
            s1=b.getString("seconds");
            h1=b.getInt("height");
            w1=b.getInt("weight");
        }
        System.out.println(f1);
        System.out.println(s1);
    }
    private boolean validateEmail() {
        em = email.getText().toString().trim();

        if (em.isEmpty()) {
            email.setError("Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(em).matches()) {
            email.setError("Please enter a valid email address");
            return false;
        } else {
            email.setError(null);
            return true;
        }
    }
    private boolean isValidMobile() {
        String phone=phno.getText().toString().trim();
        ph=Long.parseLong(phno.getText().toString().trim());
        if(Pattern.matches("[a-zA-Z]+", phone)) {
            phno.setError("Please enter a valid Phone Number");
            return false;
        }
        else if(phone.length()!=10)
        {
            phno.setError("Please enter a valid Phone Number");
            return false;
        }
        else if (em.isEmpty()) {
            phno.setError("Field can't be empty");
            return false;
        }
        else{
        return true;}
    }
    public void onclick(View view)
    {
        String nam=name.getText().toString().trim();
        ag=Integer.parseInt(age.getText().toString().trim());
        //String gen=gender.getText().toString().trim();
        //String em=email.getText().toString().trim();
        //long ph=Long.parseLong(phno.getText().toString().trim());
        String loc=location.getText().toString().trim();
        if(gen.equalsIgnoreCase("male"))
        {
            calculate=66.0+(6.23*w1*2.205)+(12.7*(h1/2.54))-(6.8*ag);
        }
        else
        {
            calculate=655+(4.35*w1*2.205)+(4.7*(h1/2.54))-(4.7*ag);
        }
        if(f1.equalsIgnoreCase("Loose weight"))
        {
            if(s1.equalsIgnoreCase("Not very active"))
            {
                calculate=calculate-500;
                calculate*=1.2;
            }
            else if(s1.equalsIgnoreCase("Lightly Active"))
            {
                calculate=calculate-500;
                calculate*=1.375;
            }
            else if(s1.equalsIgnoreCase("Active"))
            {
                calculate=calculate-500;
                calculate*=1.55;
            }
            else if(s1.equalsIgnoreCase("Very active"))
            {
                calculate=calculate-500;
                calculate*=1.7;
            }

        }
        else if(f1.equalsIgnoreCase("Maintain weight"))
        {
            if(s1.equalsIgnoreCase("Not very active"))
            {
                calculate*=1.2;
            }
            else if(s1.equalsIgnoreCase("Lightly Active"))
            {
                calculate*=1.375;
            }
            else if(s1.equalsIgnoreCase("Active"))
            {
                calculate*=1.55;
            }
            else if(s1.equalsIgnoreCase("Very active"))
            {
                calculate*=1.7;
            }
        }
        else if(f1.equalsIgnoreCase("Gain weight"))
        {
            if(s1.equalsIgnoreCase("Not very active"))
            {
                calculate=calculate+500;
                calculate*=1.2;
            }
            else if(s1.equalsIgnoreCase("Lightly Active"))
            {
                calculate=calculate+500;
                calculate*=1.375;
            }
            else if(s1.equalsIgnoreCase("Active"))
            {
                calculate=calculate+500;
                calculate*=1.55;
            }
            else if(s1.equalsIgnoreCase("Very active"))
            {
                calculate=calculate+500;
                calculate*=1.7;
            }
        }
        cal=(int)Math.round(calculate);
        if (!validateEmail()| !isValidMobile()) {
            return;
        }
        else {
            member.setName(nam);
            member.setAge(ag);
            member.setGender(gen);
            member.setEmail(em);
            member.setPhno(ph);
            member.setLocation(loc);
            member.setCalories(cal);
            reff.push().setValue(member);
            Toast.makeText(signup.this, "SignUP Successfully", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(signup.this, last.class);
            intent.putExtra("calories",cal);
            startActivity(intent);
        }
    }
    public void val2(View view)
    {
        int radioid2=rg2.getCheckedRadioButtonId();
        rb2=findViewById(radioid2);
        gen=rb2.getText().toString();
    }
}
