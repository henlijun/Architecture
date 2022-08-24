package com.hefu.module_mvvm.mvvm_004;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.hefu.module_mvvm.R;
import com.hefu.module_mvvm.databinding.ActivityMvvm4Binding;

import java.util.List;

/**
 * todo
 *      dataBinding
 *      BindingMethods 将自定义View的属性（xml）与方法相匹配同意
 *      BindAdapter
 *      BindingConversion
 *      https://blog.csdn.net/weixin_61845324/article/details/125742832
 */

@BindingMethods({
        @BindingMethod(type = TextView.class,attribute = "android:text", method = "setValue")
})
public class MVVM4_Activity extends AppCompatActivity {

    ActivityMvvm4Binding binding;
    private MVMM4_ViewModel viewModel;
    private int position;
    private StringBean value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm_4);
        viewModel = new ViewModelProvider(this).get(MVMM4_ViewModel.class);

        binding.setData(viewModel);
/*

        binding.recycleView.setLayoutManager(new LinearLayoutManager(this));
        StringAdapter adapter =  new StringAdapter(viewModel.getRecycleData().getValue(), (position, value) -> {
            if(value == null){
                viewModel.deleteItem(position);
            }else {
                this.position = position;
                this.value = value;
                binding.relativeLayout.setVisibility(View.VISIBLE);
                binding.editTextTextPersonName.setText(value.name);
                binding.editTextTextPersonName.setSelection(value.name.length());
            }

        });
        binding.recycleView.setAdapter(adapter);*/

        binding.button11.setOnClickListener(v-> binding.relativeLayout.setVisibility(View.GONE));
        binding.button12.setOnClickListener(v-> {viewModel.update(
                this.position, new StringBean(binding.editTextTextPersonName.getText().toString()));
                binding.relativeLayout.setVisibility(View.GONE);
        });


        binding.textView.setOnClickListener(v-> viewModel.addItem());

    }
}