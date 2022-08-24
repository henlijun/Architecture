package com.hefu.module_mvp.presenter_1;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

public class Presenter1_Model implements Presenter1_IModel{
    private Presenter1_Presenter presenter;

    @Override
    public void setPresenter(Presenter1_Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public String getLength(String text){
        if(!TextUtils.isEmpty(text)){
            return "" + text.length();
        }
        return "0";
    }

    @Override
    public void requestData(){
        new Thread(()->{
          new Handler(Looper.getMainLooper()).post(()->
                  presenter.onUIStart());

          new Handler(Looper.getMainLooper()).postDelayed(()->
                  presenter.onUIFinish(), 3000);
        }).start();
    }

    @Override
    public void clearModel() {
        presenter.onUIClear();
    }
}
