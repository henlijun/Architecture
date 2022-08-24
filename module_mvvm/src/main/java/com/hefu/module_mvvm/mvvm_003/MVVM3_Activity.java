package com.hefu.module_mvvm.mvvm_003;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.hefu.module_mvvm.R;
import com.hefu.module_mvvm.databinding.ActivityMvvm3Binding;

/**
 * ViewModel 持有model
 *
 * viewModel 使用
 *
 */
public class MVVM3_Activity extends AppCompatActivity {

    private MVVM3_ViewModel viewModel;
    private ActivityMvvm3Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm_3);
        viewModel = new ViewModelProvider(this).get(MVVM3_ViewModel.class);

        binding.setData(viewModel);
        binding.setLifecycleOwner(this);

        binding.button2.setOnClickListener(v-> viewModel.clear());
        binding.button.setOnClickListener(v -> viewModel.requestUser());
        viewModel.state.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                if(integer.intValue() == MVVM3_ViewModel.STATE_START){
                    Toast.makeText(MVVM3_Activity.this, "requestStart",Toast.LENGTH_SHORT).show();
                }else  if(integer.intValue() == MVVM3_ViewModel.STATE_FINISH){
                    Toast.makeText(MVVM3_Activity.this, "requestFinish",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}