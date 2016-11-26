package a12mob.fiap.rapha.times_app.api;

import java.util.List;

import a12mob.fiap.rapha.times_app.model.Time;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by rapha on 25/11/2016.
 */

public interface TimesApi {
    // @path (/cars/type/{}) != @query (?q=)
    @GET("/v2/{tipo}")
    abstract Call<List<Time>> findBy(@Path("tipo") String tipo);
}
