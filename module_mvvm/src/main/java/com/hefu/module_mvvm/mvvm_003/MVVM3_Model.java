package com.hefu.module_mvvm.mvvm_003;

import com.hefu.module_mvvm.bean.User;

/**
 *  Model 数据处理
 */
public class MVVM3_Model {

    public void requestUser(Request3_Listener listener){
        new Thread(()->{

            try {
                Thread.sleep(3000);
                listener.response(new User("lj", (int)(Math.random() * 100), true));
            }catch (InterruptedException e){

            }
        }).start();

    }


}
