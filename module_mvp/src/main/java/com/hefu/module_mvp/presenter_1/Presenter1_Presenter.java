package com.hefu.module_mvp.presenter_1;

public class Presenter1_Presenter implements Presenter1_IPresenter{

    public Presenter1_Model model;
    public Presenter1_IView presenterView;

    @Override
    public void onCalculateClickEvent(String text) {
        String result = model.getLength(text);
        presenterView.uiUpdateLength(result);
    }

    @Override
    public void onUIStart() {
        presenterView.uiStart();
    }

    @Override
    public void onUIFinish() {
        presenterView.uiFinish();
    }

    @Override
    public void onUIClear() {
        presenterView.uiClear();
    }

    @Override
    public void clearData() {
        model.clearModel();
    }

    @Override
    public void requestData() {
        model.requestData();
    }

    @Override
    public void setModel(Presenter1_Model model) {
        this.model = model;
    }

    @Override
    public void setView(Presenter1_IView presenter1_iView) {
        this.presenterView = presenter1_iView;
    }
}
