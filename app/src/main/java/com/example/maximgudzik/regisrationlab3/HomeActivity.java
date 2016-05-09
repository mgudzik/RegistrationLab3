package com.example.maximgudzik.regisrationlab3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private TextView hiText;
    private Button logOutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        hiText = (TextView)findViewById(R.id.hiText);
        logOutButton = (Button)findViewById(R.id.logOutButton);

        String name = getIntent().getStringExtra(getResources().getString(R.string.name));
        hiText.setText("Hi, "+ name);

        logOutButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
