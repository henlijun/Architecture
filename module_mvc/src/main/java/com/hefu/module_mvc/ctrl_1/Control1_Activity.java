package com.hefu.module_mvc.ctrl_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hefu.module_mvc.R;

public class Control1_Activity extends AppCompatActivity implements
    Control1_Model.ModelListener{

    public Control1_Model model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_001);

        model = new Control1_Model();
        model.listener = this;

        findViewById(R.id.button).setOnClickListener(v -> {
            String result = model.convert(
                    ((EditText)findViewById(R.id.editTextTextPersonName))
                            .getText().toString());

            ((TextView) findViewById(R.id.textView)).setText(result);
        });

        model.getData();
    }


    @Override
    public void mStart() {
        Toast.makeText(this, "mStart",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void mFailed() {
        Toast.makeText(this, "mFailed",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void mSuccess() {
        Toast.makeText(this, "mSuccess",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void mFinish() {
        Toast.makeText(this, "mFinish",Toast.LENGTH_SHORT).show();
    }
}