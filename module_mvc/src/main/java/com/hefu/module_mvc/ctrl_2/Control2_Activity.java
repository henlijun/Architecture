package com.hefu.module_mvc.ctrl_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.hefu.module_mvc.R;
//https://zhuanlan.zhihu.com/p/83635530

/**
 * View 持有 Controller，
 * Controller 持有 Model，
 * Model 持有 View
 */
public class Control2_Activity extends AppCompatActivity {
    private Control2_Model model;
    private Control2_Control control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control2);
        TextView[] textViews = new TextView[3];
        textViews[0] = findViewById(R.id.yuan_textView);
        textViews[1] = findViewById(R.id.fan_textView);
        textViews[2] = findViewById(R.id.bu_textView);

        model = new Control2_Model();
        model.setView(textViews);

        control = new Control2_Control();
        control.setModel(model);

        EditText editText = findViewById(R.id.editTextTextPersonName);
        findViewById(R.id.button)
                .setOnClickListener(v->
                        control.onConvertClick(editText.getText().toString()));

        findViewById(R.id.clear_button).setOnClickListener(v->
                control.onClearClick());
    }
}