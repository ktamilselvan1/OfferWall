package com.tamil.offer.data.repo;

import com.tamil.offer.BuildConfig;
import com.tamil.offer.data.network.ApiService;
import com.tamil.offer.data.repo.response.OfferWallResponse;

import junit.framework.TestCase;

import org.jetbrains.annotations.NotNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OfferWallRepositoryTest extends TestCase {

    private final MockWebServer server = new MockWebServer();
    private OfferWallRepository repository;
    private OfferWallResponse offerWallResponse;
    private final CountDownLatch latch = new CountDownLatch(1);

    @Before
    public void setUp() throws Exception {
        super.setUp();
        server.start();
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor())
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(BuildConfig.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService service = retrofit.create(ApiService.class);
        repository = new OfferWallRepository(service);
        server.setDispatcher(new Dispatcher() {
            @NotNull
            @Override
            public MockResponse dispatch(@NotNull RecordedRequest recordedRequest) throws InterruptedException {
                if (recordedRequest.getPath().contains("offer.json")) {
                    String response = readContentFromAsset("responses/offer_wall_response.json");
                    if (response == null)
                        return new MockResponse().setResponseCode(HttpURLConnection.HTTP_BAD_REQUEST);

                    return new MockResponse().setResponseCode(HttpURLConnection.HTTP_OK).setBody(response);
                } else {
                    return new MockResponse().setResponseCode(HttpURLConnection.HTTP_NOT_FOUND);
                }
            }
        });
    }

    @After
    public void tearDown() throws Exception {
        server.shutdown();
    }

    @Test
    public void testGetOfferWallData() {
        Map<String, String> requestData = new HashMap<>();
        requestData.put("appid", "2070");
        requestData.put("uid", "superman");
        requestData.put("locale", "DE");
        requestData.put("ip", "109.235.143.113");
        requestData.put("offer_types", "112");
        requestData.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000L));
        repository.getOfferWallData(requestData, "1c915e3b5d42d05136185030892fbb846c278927").enqueue(new Callback<OfferWallResponse>() {
            @Override
            public void onResponse(Call<OfferWallResponse> call, Response<OfferWallResponse> response) {
                offerWallResponse = response.body();
                latch.countDown();
            }

            @Override
            public void onFailure(Call<OfferWallResponse> call, Throwable t) {
                latch.countDown();
            }
        });
        try {
            latch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(offerWallResponse);

    }

    private String readContentFromAsset(String fileName) {
        String content = null;
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        try {
            content = new String(Files.readAllBytes(file.toPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}