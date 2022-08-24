package com.hefu.module_mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hefu.module_mvp.presenter_1.Presenter1_Activity;

public class MvpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
    }


    public void onClickEvent(View view){
        int rid = view.getId();
        if(rid == R.id.button3){
            startActivity(new Intent(this, Presenter1_Activity.class));
        }else if(rid == R.id.button4){
//            startActivity(new Intent(this, Control2_Activity.class));
        }else if(rid == R.id.button5){

        }
    }
}