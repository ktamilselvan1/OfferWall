package com.tamil.offer.ui.offerwall;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.tamil.offer.base.BaseViewModel;
import com.tamil.offer.data.repo.OfferWallRepository;
import com.tamil.offer.data.repo.response.OfferWallResponse;

import java.security.cert.CertificateRevokedException;

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
        compositeDisposable.add(this.offerWallRepository.getOfferWallData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(_offerWallResponse::postValue, t -> Log.d("Error", t.getMessage())));
    }
}
