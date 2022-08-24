package com.hefu.module_mvp.presenter_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hefu.module_mvp.R;

public class Presenter1_Activity extends AppCompatActivity
    implements Presenter1_IView{

    public Presenter1_Presenter presenter;
    public Presenter1_Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presenter_001);

        model = new Presenter1_Model();
        presenter = new Presenter1_Presenter();

        model.setPresenter(presenter);
        presenter.setModel(model);
        presenter.setView(this);

        EditText editText = findViewById(R.id.editTextTextPersonName);
        findViewById(R.id.button).setOnClickListener(v ->
                presenter.onCalculateClickEvent(editText.getText().toString()));

        findViewById(R.id.button2).setOnClickListener(v->
                presenter.clearData());

        findViewById(R.id.button11).setOnClickListener(v->
                presenter.requestData());

    }

    @Override
    public void uiStart() {
        Toast.makeText(this, "uiStart",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void uiFinish() {
        Toast.makeText(this, "uiFinish",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void uiClear() {
        ((TextView) findViewById(R.id.textView)).setText(null);
    }

    @Override
    public void uiUpdateLength(String length) {
        ((TextView) findViewById(R.id.textView)).setText(length);
    }
}