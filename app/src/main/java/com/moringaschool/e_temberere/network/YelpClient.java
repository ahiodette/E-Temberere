package com.moringaschool.e_temberere.network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.moringaschool.e_temberere.ui.Unchangeable.YELP_API_KEY;
import static com.moringaschool.e_temberere.ui.Unchangeable.YELP_BASE_URL;

public class YelpClient {
    private static Retrofit retrofit = null;

    public static YelpApi getClient() {

        if (retrofit == null) {
            OkHttpClient replyHttp = new OkHttpClient.Builder()
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request newRequest  = chain.request().newBuilder()
                                    .addHeader("Authorization", YELP_API_KEY)
                                    .build();
                            return chain.proceed(newRequest);
                        }
                    })
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(YELP_BASE_URL)
                    .client(replyHttp)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(YelpApi.class);
    }
}