package com.hefu.module_mvp.presenter_1;

public interface Presenter1_IPresenter {
    void setModel(Presenter1_Model model);
    void setView(Presenter1_IView presenter1_iView);

    //view
    void onCalculateClickEvent(String text);
    void onUIStart();
    void onUIFinish();
    void onUIClear();

    //model
    void clearData();
    void requestData();
}
