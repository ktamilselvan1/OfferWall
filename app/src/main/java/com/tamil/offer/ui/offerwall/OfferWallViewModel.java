package com.tamil.offer.ui.offerwall;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.tamil.offer.base.BaseViewModel;
import com.tamil.offer.data.repo.OfferWallRepository;
import com.tamil.offer.data.repo.response.OfferWallResponse;

import java.security.cert.CertificateRevokedException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class OfferWallViewModel extends BaseViewModel {

    private final MutableLiveData<OfferWallResponse> _offerWallResponse
            = new MutableLiveData<>();

    public LiveData<OfferWallResponse> offerWallResponse = _offerWallResponse;

    private final OfferWallRepository offerWallRepository;

    @Inject
    public OfferWallViewModel(OfferWallRepository repository) {
        this.offerWallRepository = repository;
    }

    public void getOfferWallData() {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        Map<String, String> requestData = new HashMap<>();
        requestData.put("appid", "2070");
        requestData.put("device_id", "2070");
        requestData.put("locale", "DE");
        requestData.put("ip", "109.235.143.113");
        requestData.put("os_version", "2070");
        requestData.put("phone_version", "2070");
        requestData.put("uid", "superman");
        requestData.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000L));
        compositeDisposable.add(this.offerWallRepository.getOfferWallData(requestData, "1c915e3b5d42d05136185030892fbb846c278927")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(_offerWallResponse::postValue, t -> Log.d("Error", t.getMessage())));
    }
}
