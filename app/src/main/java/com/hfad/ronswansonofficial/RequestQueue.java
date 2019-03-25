package com.hfad.ronswansonofficial;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

interface RequestQueue {

    @GET("api")
    Call<QuoteResponse> getAmountOfQuotes(@Body String recieveQuoteArray);
}
