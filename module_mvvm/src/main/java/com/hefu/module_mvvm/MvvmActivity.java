package com.hefu.module_mvvm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hefu.module_mvvm.mvvm_001.MVVM1_Activity;
import com.hefu.module_mvvm.mvvm_002.MVVM2_Activity;
import com.hefu.module_mvvm.mvvm_003.MVVM3_Activity;
import com.hefu.module_mvvm.mvvm_004.MVVM4_Activity;

public class MvvmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvvm);
    }

    public void onClickEvent(View view){
        int rid = view.getId();
        if(rid == R.id.button3){
            startActivity(new Intent(this, MVVM1_Activity.class));
        }else if(rid == R.id.button4){
            startActivity(new Intent(this, MVVM2_Activity.class));
        }else if(rid == R.id.button5){
            startActivity(new Intent(this, MVVM3_Activity.class));
        }else if(rid == R.id.button6){
            startActivity(new Intent(this, MVVM4_Activity.class));
        }else if(rid == R.id.button7){

        }
    }
}