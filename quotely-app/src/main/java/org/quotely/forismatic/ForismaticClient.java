package org.quotely.forismatic;

import java.io.IOException;

import org.quotely.model.ForismaticQuote;
import org.quotely.model.ForismaticRequest;
import org.quotely.model.Format;
import org.quotely.model.Method;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ForismaticClient {
    private static final String BASE_URL = "https://api.forismatic.com/";

    private final ForismaticApi forismaticApi;

    private final OkHttpClient okHttpClient;

    public ForismaticClient() {
        okHttpClient = new OkHttpClient.Builder()
            .build();

        forismaticApi = createForismaticApi(okHttpClient);
    }

    public ForismaticQuote getForismaticQuote(ForismaticRequest forismaticRequest) {
        try {
            return forismaticApi.call(Method.getQuote, Format.json, forismaticRequest.lang())
                    .execute()
                    .body();
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    public void close() {
        okHttpClient.connectionPool()
            .evictAll();
    }

    private ForismaticApi createForismaticApi(OkHttpClient okHttpClient) {
        Gson gson = new GsonBuilder()
            .create();

        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

        return retrofit.create(ForismaticApi.class);
    }
}
