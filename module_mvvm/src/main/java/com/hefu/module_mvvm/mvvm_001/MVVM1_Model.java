package com.hefu.module_mvvm.mvvm_001;

import android.os.Handler;
import android.os.Looper;

import com.hefu.module_mvvm.bean.User;

/**
 *  Model 数据处理
 */
public class MVVM1_Model {
    private MVVM1_ViewModel viewModel;

    public void requestUser(){
        viewModel.state.setValue(MVVM1_ViewModel.STATE_START);

     /*   new Handler(Looper.getMainLooper()).postDelayed(()->{
            viewModel.setUser(new User("lj", (int)(Math.random() * 100), true));
            viewModel.state.setValue(MVVM1_ViewModel.STATE_FINISH);
        }, 2000);*/
        new Thread(()->{
                new Handler(Looper.getMainLooper()).postDelayed(()->{
                        viewModel.setUser(new User("lj", (int)(Math.random() * 100), true));
                        viewModel.state.setValue(MVVM1_ViewModel.STATE_FINISH);
                    }, 3000);
//            try {
//                Thread.sleep(2000);
//                viewModel.setUser(new User("lj", (int)(Math.random() * 100), true));
//                viewModel.state.setValue(MVVM1_ViewModel.STATE_FINISH);
//            }catch (InterruptedException e){
//
//            }
        }).start();
    }


    public void setViewModel(MVVM1_ViewModel viewModel) {
        this.viewModel = viewModel;
    }
}
