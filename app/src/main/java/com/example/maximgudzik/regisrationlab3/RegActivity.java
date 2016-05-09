package com.example.maximgudzik.regisrationlab3;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegActivity extends AppCompatActivity {

    private EditText newLoginText;
    private EditText newNameText;
    private EditText newPasswordText;

    private Button backButton;
    private Button completeButton;

    private SharedPreferences logPasswordInfo;
    private SharedPreferences logNameInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        viewDraw();
        setupListeners();

        logPasswordInfo = getSharedPreferences(getString(R.string.logPasswordInfo),MODE_PRIVATE);
        logNameInfo = getSharedPreferences(getString(R.string.logNameInfo),MODE_PRIVATE);
    }

    private void viewDraw(){
        newLoginText = (EditText)findViewById(R.id.newLoginText);
        newPasswordText = (EditText)findViewById(R.id.newPasswordText);
        newNameText = (EditText)findViewById(R.id.newNameText);
        backButton = (Button)findViewById(R.id.backButton);
        completeButton = (Button)findViewById(R.id.completeButton);
    }
    private void setupListeners(){
        backButton.setOnClickListener(backButtonListener);
        completeButton.setOnClickListener(completeButtonListener);
    }
    View.OnClickListener backButtonListener = new  View.OnClickListener(){
        @Override
        public void onClick(View v) {
            finish();
        }
    };
    View.OnClickListener completeButtonListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            String login = newLoginText.getText().toString();
            String name = newNameText.getText().toString();
            String password = newPasswordText.getText().toString();
            SharedPreferences.Editor editorPassword = logPasswordInfo.edit();
            SharedPreferences.Editor editorName = logNameInfo.edit();

            editorPassword.putString(login, password);
            editorName.putString(login, name);

            editorPassword.apply();
            editorName.apply();

            Toast.makeText(RegActivity.this, "Completed registration", Toast.LENGTH_LONG).show();
            finish();
        }
    };

}
