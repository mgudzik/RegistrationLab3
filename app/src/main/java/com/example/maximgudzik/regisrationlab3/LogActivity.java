package com.example.maximgudzik.regisrationlab3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogActivity extends AppCompatActivity{

    private EditText loginText;
    private EditText passwordText;
    private Button goButton;
    private Button backButton;

    private SharedPreferences logNameInfo;
    private SharedPreferences logPasswordInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        viewDraw();
        setupListeners();
        logPasswordInfo = getSharedPreferences(getString(R.string.logPasswordInfo), MODE_PRIVATE);
        logNameInfo = getSharedPreferences(getString(R.string.logNameInfo), MODE_PRIVATE);
    }
    private void viewDraw(){
        loginText = (EditText)findViewById(R.id.loginText);
        passwordText = (EditText)findViewById(R.id.passwordText);
        goButton = (Button)findViewById(R.id.goButton);
        backButton = (Button)findViewById(R.id.backButton);
    }

    private void setupListeners(){
        goButton.setOnClickListener(goButtonListener);
        backButton.setOnClickListener(backButtonListener);
    }
    View.OnClickListener goButtonListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            String writtenLogin = loginText.getText().toString();
            String writtenPassword = passwordText.getText().toString();

            if (validLoginPassword(writtenLogin, writtenPassword)){
                String password = logPasswordInfo.getString(writtenPassword,"");
                String name = logNameInfo.getString(writtenLogin, "");

                blankFields();
                Intent intent = new Intent(LogActivity.this, HomeActivity.class);
                intent.putExtra(getResources().getString(R.string.name), name);
                startActivity(intent);
            }
        }
    };
    View.OnClickListener backButtonListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
             finish();
        }
    };

    private boolean validLoginPassword(String login, String password){
        if(!logPasswordInfo.contains(login)){
            Toast.makeText(LogActivity.this, "Login not found", Toast.LENGTH_LONG).show();
            blankFields();
            return false;
        }
        if(!(logPasswordInfo.getString(login,"").equals(password))){
            Toast.makeText(LogActivity.this,"Incorrect password",Toast.LENGTH_LONG).show();
            blankFields();
            return false;
        }
        return true;
    }
    private void blankFields(){
        loginText.setText("");
        passwordText.setText("");
    }
}
