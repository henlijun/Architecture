package com.hefu.module_mvvm.mvvm_004;

import android.os.Handler;
import android.os.Looper;

import androidx.annotation.MainThread;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MVMM4_ViewModel extends ViewModel {

    private MutableLiveData<List<StringBean>> recycleData = new MutableLiveData<>();
    public List<StringBean> recycleData2;

    private MVVM4_Model model;

    public MVMM4_ViewModel(){
        model = new MVVM4_Model(new Request4_Listener() {
            @Override
            public void itemAdded(StringBean item) {
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(()-> addItem(item));
            }

            @Override
            public void init(List<StringBean> list) {
                setRecycleData(list);
            }
        });
        getInitData();
    }

    @MainThread
    public void setRecycleData(List<StringBean> list) {
        this.recycleData.setValue(list);
        recycleData2.addAll(list);
    }
    @MainThread
    public void addItem(StringBean item){
        if(recycleData.getValue() == null)
            recycleData.setValue(new ArrayList<>());
        recycleData.getValue().add(item);

        if(recycleData2 == null)
            recycleData2 = new ArrayList<>();
        recycleData2.add(item);
    }

    public void addItem(){
        model.createItem();
    }

    public void getInitData(){
        recycleData.setValue(null);
        model.getInitData();
    }

    public void deleteItem(int id){
        recycleData.getValue().remove(id);
    }

    public void update(int position, StringBean item){
        recycleData.getValue().set(position, item);
    }


    public MutableLiveData<List<StringBean>> getRecycleData() {
        return recycleData;
    }
}
