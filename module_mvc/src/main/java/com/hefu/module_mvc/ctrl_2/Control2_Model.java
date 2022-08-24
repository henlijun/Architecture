package com.hefu.module_mvc.ctrl_2;

import android.widget.TextView;

import java.util.Arrays;

//Model 持有 View

/**
 * （计算机中数值一律用补码存储）-> 直接读值即补码
 * 补码： 正数（其本身），负数（反码+1）
 * 反码： 正数（其本身），负数（原码符号位，其余位取反）
 * 原码： 符号位 + 绝对值
 *
 * 正数：原码、反码、补码相同
 */
public class Control2_Model implements IModel{

    private TextView[] textViews;

    @Override
    public void setView(TextView[] textViews) {
        this.textViews = textViews;
    }

    @Override
    public void translate(int data) {
        //补码，（计算机中数值一律用补码存储）
        byte[] result = new byte[32];
        for (int j =0, i = 31; i>= 0; i--) {
            result[j++] = (byte) ((data >> i) & 0x01);
        }
        textViews[2].setText(Arrays.toString(result));

        //补码转原码：符号位不变，其他取反;最后+1;
        if(data < 0){
            for (int i=1; i<32; i++){
                result[i] = (result[i] == 1? (byte)0:(byte)1);
            }
        }
        textViews[0].setText(Arrays.toString(result));

        //补码转补码，补码-1
        if(data < 0){
            for (int i=1; i<32; i++){

            }
        }
        textViews[1].setText(Arrays.toString(result));
    }

    @Override
    public void clear() {
        if(textViews != null){
            for (TextView v : textViews){
                v.setText(null);
            }
        }
    }
}


interface IModel{
    void setView(TextView[] textViews);
    void translate(int data);
    void clear();
}
