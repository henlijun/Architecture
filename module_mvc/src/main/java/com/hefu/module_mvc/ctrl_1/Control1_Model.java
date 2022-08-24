package com.hefu.module_mvc.ctrl_1;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/**
 * Model - 数据处理
 * http
 * sp
 * sqlite
 */
public class Control1_Model {
    ModelListener listener;

    public String convert(String text){
        try {
            int result = Integer.parseInt(text);
            return  Integer.toBinaryString(result);
        }catch (NumberFormatException e){

        }
        return null;
    }

    public void getData(){
         listener.mStart();
         new Thread(()-> {
             try {
                 Thread.sleep(1000);
                 new Handler(Looper.getMainLooper())
                         .postDelayed(()->{
                             listener.mSuccess();
                             listener.mFinish();
                         }, 1000);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }

         }).start();

    }


    public interface ModelListener{
        void mStart();
        void mFailed();
        void mSuccess();
        void mFinish();
    }

}
