package com.tamil.offer.ui.offerwall;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.tamil.offer.base.BaseViewModel;
import com.tamil.offer.data.repo.OfferWallRepository;
import com.tamil.offer.data.repo.response.OfferWallResponse;
import com.tamil.offer.util.FormSettings;

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
    private final FormSettings formSettings;

    @Inject
    public OfferWallViewModel(OfferWallRepository repository, FormSettings formSettings) {
        this.offerWallRepository = repository;
        this.formSettings = formSettings;
    }

    public void getOfferWallData() {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        Map<String, String> requestData = new HashMap<>();
        requestData.put("appid", this.formSettings.getApplicationID());
        requestData.put("uid", this.formSettings.getUserID());
        requestData.put("locale", "DE");
        requestData.put("ip", "109.235.143.113");
        requestData.put("offer_types", "112");
        requestData.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000L));
        compositeDisposable.add(this.offerWallRepository.getOfferWallData(requestData, this.formSettings.getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(_offerWallResponse::postValue, t -> Log.d("Error", t.getMessage())));
    }
}
