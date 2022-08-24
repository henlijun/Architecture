package com.hefu.module_mvvm.mvvm_004;

import android.accounts.AbstractAccountAuthenticator;
import android.content.pm.LabeledIntent;

import java.util.ArrayList;
import java.util.List;

public class MVVM4_Model {
    public Request4_Listener listener;
    public MVVM4_Model(Request4_Listener listener){
        this.listener = listener;
    }


    public void createItem(){
        listener.itemAdded(new StringBean(generator()));
/*        new Thread(()->{
            listener.itemAdded(new StringBean(generator()));
        }).start();*/

    }

    public void getInitData(){
//        new Thread(()->{
            List<StringBean> data = new ArrayList<>();
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            for (int i=0; i< 5; i++, data.add(new StringBean(generator())));
            listener.init(data);
//        }).start();
    }

    public String generator(){
        return "MVVM_" + (int)(Math.random() * 1000);
    }


}
