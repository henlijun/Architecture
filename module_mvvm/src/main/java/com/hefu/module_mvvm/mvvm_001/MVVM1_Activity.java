package com.hefu.module_mvvm.mvvm_001;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

import com.hefu.module_mvvm.R;
import com.hefu.module_mvvm.databinding.ActivityMvvm1Binding;

/**
 * todo
 *      Binding
 *      Dependency
 *      Property
 *      Routed Events
 *      Command
 *      DataTemplate
 *      ControlTemplate
 *
 *  相互持有，不太合理
 */
public class MVVM1_Activity extends AppCompatActivity {

    private MVVM1_ViewModel viewModel;
    private ActivityMvvm1Binding binding;
    private MVVM1_Model model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm_1);
        viewModel = new ViewModelProvider(this).get(MVVM1_ViewModel.class);
        model = new MVVM1_Model();

        binding.setData(viewModel);
        binding.setLifecycleOwner(this);

        viewModel.setModel(model);
        model.setViewModel(viewModel);

        binding.button2.setOnClickListener(v-> viewModel.clear());
        binding.button.setOnClickListener(v -> model.requestUser());
        viewModel.state.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                if(integer.intValue() == MVVM1_ViewModel.STATE_START){
                    Toast.makeText(MVVM1_Activity.this, "requestStart",Toast.LENGTH_SHORT).show();
                }else  if(integer.intValue() == MVVM1_ViewModel.STATE_FINISH){
                    Toast.makeText(MVVM1_Activity.this, "requestFinish",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}