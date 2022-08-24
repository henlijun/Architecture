package com.hefu.module_mvc.ctrl_2;
//Controller 持有 Model

import android.text.TextUtils;

import java.util.regex.Pattern;

/**
 * 分开处理Activity中非View的业务逻辑
 */
public class Control2_Control implements IControl {
    private Control2_Model model;
    @Override
    public void setModel(Control2_Model model) {
        this.model = model;
    }

    @Override
    public void onConvertClick(String text) {
      /*  if(TextUtils.isEmpty(text) || !isNumeric(text))
            return;*/
        try {
            int result = Integer.parseInt(text);
            model.translate(result);
        }catch (NumberFormatException e){
            model.clear();
        }
    }

    @Override
    public void onClearClick() {
        model.clear();
    }

    public boolean isNumeric(String text){
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(text).matches();
    }
}


interface IControl{
    void setModel(Control2_Model model);
    void onConvertClick(String text);
    void onClearClick();
}
