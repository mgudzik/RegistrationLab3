package com.example.maximgudzik.regisrationlab3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button loginButton;
    private Button registrationButton;
    private Button exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewDraw();
        setupListeners();
    }

    private void viewDraw(){
        loginButton = (Button)findViewById(R.id.loginButton);
        registrationButton = (Button)findViewById(R.id.registrationButton);
        exitButton = (Button)findViewById(R.id.exitButton);
    }
    private void setupListeners(){
        loginButton.setOnClickListener(this);
        registrationButton.setOnClickListener(this);
        exitButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case(R.id.loginButton):
                startActivity(new Intent(this, LogActivity.class));
                break;
            case(R.id.registrationButton):
                startActivity(new Intent(this, RegActivity.class));
                break;
            case(R.id.exitButton):
                finish();
                break;
        }
    }
}
