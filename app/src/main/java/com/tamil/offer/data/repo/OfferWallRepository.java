package com.tamil.offer.data.repo;

import com.tamil.offer.data.network.ApiService;
import com.tamil.offer.data.repo.response.OfferWallResponse;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.inject.Inject;

import io.reactivex.Observable;

public class OfferWallRepository {

    private final ApiService apiService;

    @Inject
    public OfferWallRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public Observable<OfferWallResponse> getOfferWallData(Map<String, String> request, String apiKey) {
        SortedSet<String> keys = new TreeSet<>(request.keySet());
        StringBuilder sortedKeyValuePair = new StringBuilder();
        for (String key : keys) {
            String value = request.get(key);
            if (sortedKeyValuePair.length() != 0) {
                sortedKeyValuePair.append("&");
            }
            sortedKeyValuePair.append(key);
            sortedKeyValuePair.append("=");
            sortedKeyValuePair.append(value);
        }
        sortedKeyValuePair.append("&");
        sortedKeyValuePair.append(apiKey);
        String hashValue = "";
        try {
            hashValue = getSHA1(sortedKeyValuePair.toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return this.apiService.getOfferWall(
                request.get("appid"), request.get("locale"), request.get("ip"),
                request.get("offer_types"), request.get("timestamp"), request.get("uid"), hashValue);
    }

    private static String convertToHex(byte[] data) {
        StringBuilder buf = new StringBuilder();
        for (byte b : data) {
            int halfbyte = (b >>> 4) & 0x0F;
            int two_halfs = 0;
            do {
                buf.append(halfbyte <= 9 ? (char) ('0' + halfbyte) : (char) ('a' + halfbyte - 10));
                halfbyte = b & 0x0F;
            } while (two_halfs++ < 1);
        }
        return buf.toString();
    }

    public static String getSHA1(String text) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] textBytes = text.getBytes(StandardCharsets.ISO_8859_1);
        md.update(textBytes, 0, textBytes.length);
        byte[] sha1hash = md.digest();
        return convertToHex(sha1hash);
    }
}
