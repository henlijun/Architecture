package com.hefu.module_mvvm.mvvm_002;

import android.os.Handler;
import android.os.Looper;

import com.hefu.module_mvvm.bean.User;

/**
 *  Model 数据处理
 */
public class MVVM2_Model {

    public void requestUser(RequestListener listener){
        new Thread(()->{

            try {
                Thread.sleep(3000);
                listener.response(new User("lj", (int)(Math.random() * 100), true));
            }catch (InterruptedException e){

            }
        }).start();

    }


}
