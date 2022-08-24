package com.hefu.module_mvvm.mvvm_003;

import androidx.annotation.MainThread;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hefu.module_mvvm.bean.User;

/**
 * ViewModel 处理和view相关的数据，
 *
 * ViewModel - model 相互持有
 */
public class MVVM3_ViewModel extends ViewModel {

    public final static int STATE_START = 1;
    public final static int STATE_FINISH = 3;

    private MVVM3_Model model;

    private MutableLiveData<User> user = new MutableLiveData<>();
    public ObservableField<String> editText = new ObservableField<>();
    public MutableLiveData<String> text = new MutableLiveData<>();

    protected MutableLiveData<Integer> state = new MutableLiveData<>();


    public MVVM3_ViewModel(){
        model = new MVVM3_Model();
    }

    public void requestUser(){
        state.setValue(STATE_START);
        model.requestUser( data -> {
            setUser(data);
            setState(STATE_FINISH);
        });
    }

    public MutableLiveData<User> getUser() {
        return user;
    }

    public void setUser(MutableLiveData<User> user) {
        this.user = user;
    }

    public void setUser(User user) {
        this.user.postValue(user);
    }

    public void setState(int state) {
        this.state.postValue(state);
    }

    public void clear(){
        text.setValue(null);
        editText.set(null);
        user.setValue(null);
    }

}
