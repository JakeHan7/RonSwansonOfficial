package com.hfad.ronswansonofficial;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetQuoteService {
    @GET("quotes/{count}")
    Call<String[]> getAmountOfQuotes(@Path("count") int amountOfQuotes);
}
