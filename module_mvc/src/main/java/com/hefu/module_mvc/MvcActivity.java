package com.hefu.module_mvc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hefu.module_mvc.ctrl_1.Control1_Activity;
import com.hefu.module_mvc.ctrl_2.Control2_Activity;

public class MvcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
    }

    public void onClickEvent(View view){
        int rid = view.getId();
        if(rid == R.id.button3){
            startActivity(new Intent(this, Control1_Activity.class));
        }else if(rid == R.id.button4){
            startActivity(new Intent(this, Control2_Activity.class));
        }else if(rid == R.id.button5){

        }
    }
}