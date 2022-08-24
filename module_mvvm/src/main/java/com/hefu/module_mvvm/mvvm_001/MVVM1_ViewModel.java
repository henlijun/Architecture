package com.hefu.module_mvvm.mvvm_001;

import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hefu.module_mvvm.bean.User;

/**
 * ViewModel 处理和view相关的数据，
 *
 * ViewModel - model 相互持有
 */
public class MVVM1_ViewModel extends ViewModel {

    public final static int STATE_START = 1;
    public final static int STATE_FINISH = 3;

    private MVVM1_Model model;

    private MutableLiveData<User> user = new MutableLiveData<>();
    public ObservableField<String> editText = new ObservableField<>();
    public MutableLiveData<String> text = new MutableLiveData<>();

    protected MutableLiveData<Integer> state = new MutableLiveData<>();


    public MVVM1_ViewModel(){}


    public MutableLiveData<User> getUser() {
        return user;
    }

    public void setUser(MutableLiveData<User> user) {
        this.user = user;
    }

    public void setUser(User user) {
        this.user.setValue(user);
    }

    public void clear(){
        text.setValue(null);
        editText.set(null);
        user.setValue(null);
    }

    public void setModel(MVVM1_Model model) {
        this.model = model;
    }
}
