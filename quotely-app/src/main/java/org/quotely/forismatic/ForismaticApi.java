package org.quotely.forismatic;

import org.quotely.model.ForismaticQuote;
import org.quotely.model.Format;
import org.quotely.model.Lang;
import org.quotely.model.Method;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ForismaticApi {
    @GET("/api/1.0/")
    Call<ForismaticQuote> call(@Query("method") Method method, @Query("format") Format format, @Query("lang") Lang lang);
}
