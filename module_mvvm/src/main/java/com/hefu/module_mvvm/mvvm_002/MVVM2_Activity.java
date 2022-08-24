package com.hefu.module_mvvm.mvvm_002;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.hefu.module_mvvm.R;
import com.hefu.module_mvvm.databinding.ActivityMvvm2Binding;

/**
 * todo
 *      Binding
 *      Dependency
 *      Property
 *      Routed Events
 *      Command
 *      DataTemplate
 *      ControlTemplate
 * Activity - view
 * ViewModel - viewModel
 * Model - model
 * ViewModel 持有model， 接口交互
 *
 */
public class MVVM2_Activity extends AppCompatActivity {

    private MVVM2_ViewModel viewModel;
    private ActivityMvvm2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm_2);
        viewModel = new ViewModelProvider(this).get(MVVM2_ViewModel.class);

        binding.setData(viewModel);
        binding.setLifecycleOwner(this);

        binding.button2.setOnClickListener(v-> viewModel.clear());
        binding.button.setOnClickListener(v -> viewModel.requestUser());
        viewModel.state.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                if(integer.intValue() == MVVM2_ViewModel.STATE_START){
                    Toast.makeText(MVVM2_Activity.this, "requestStart",Toast.LENGTH_SHORT).show();
                }else  if(integer.intValue() == MVVM2_ViewModel.STATE_FINISH){
                    Toast.makeText(MVVM2_Activity.this, "requestFinish",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}