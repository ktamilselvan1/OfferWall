package com.tamil.offer.base;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BaseViewModel extends ViewModel {
    private final MutableLiveData<Boolean> _showLoading
            = new MutableLiveData<>();

    public LiveData<Boolean> showLoading = _showLoading;

    protected void showLoading() {
        _showLoading.postValue(true);
    }

    protected void hideLoading() {
        _showLoading.postValue(false);
    }
}
