package com.hefu.module_mvp.presenter_1;

public interface Presenter1_IModel {
    void setPresenter(Presenter1_Presenter presenter);
    String getLength(String text);
    void requestData();
    void clearModel();
}
