package com.tamil.offer.ui.offerwall;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.tamil.offer.base.BaseViewModel;
import com.tamil.offer.data.repo.OfferWallRepository;
import com.tamil.offer.data.repo.response.OfferWallResponse;
import com.tamil.offer.util.FormSettings;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        showLoading();
        Map<String, String> requestData = new HashMap<>();
        requestData.put("appid", this.formSettings.getApplicationID());
        requestData.put("uid", this.formSettings.getUserID());
        requestData.put("locale", "DE");
        requestData.put("ip", "109.235.143.113");
        requestData.put("offer_types", "112");
        requestData.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000L));
        this.offerWallRepository.getOfferWallData(requestData, this.formSettings.getToken())
                .enqueue(new Callback<OfferWallResponse>() {
                    @Override
                    public void onResponse(Call<OfferWallResponse> call, Response<OfferWallResponse> response) {
                        _offerWallResponse.postValue(response.body());
                        hideLoading();
                    }

                    @Override
                    public void onFailure(Call<OfferWallResponse> call, Throwable t) {
                        hideLoading();
                    }
                });
    }
}
