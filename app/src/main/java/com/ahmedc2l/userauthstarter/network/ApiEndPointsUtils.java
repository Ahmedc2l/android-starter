package com.ahmedc2l.userauthstarter.network;


public class ApiEndPointsUtils {
    // TODO add your back end base url here
    private static final String BASE_URL = "";

    public static ApiEndPoints getAPIService() {
        return RetrofitClient.getClientInstance(BASE_URL).create(ApiEndPoints.class);
    }
}
