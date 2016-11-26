package a12mob.fiap.rapha.times_app.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import a12mob.fiap.rapha.times_app.DetailActivity;
import a12mob.fiap.rapha.times_app.R;
import a12mob.fiap.rapha.times_app.adapter.TimesListAdapter;
import a12mob.fiap.rapha.times_app.api.TimesApi;
import a12mob.fiap.rapha.times_app.contants.Constants;
import a12mob.fiap.rapha.times_app.listener.OnClickListener;
import a12mob.fiap.rapha.times_app.model.Time;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TimesFragment extends Fragment implements Callback<List<Time>>  {
    private String type;
    private TimesListAdapter adapter;
    protected RecyclerView rvTimes;

    public TimesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.type = getArguments().getString("type");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_times, container, false);
        rvTimes = (RecyclerView) v.findViewById(R.id.rvTimes);
        rvTimes.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvTimes.setHasFixedSize(true);

        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        loadTimes();
    }
    private void loadTimes() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.HeiderURL.getUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // prepara a chamada no Retrofit 2.0
        TimesApi timeAPI = retrofit.create(TimesApi.class);
        Call<List<Time>> call = timeAPI.findBy(type);

        // async call
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<Time>> call, Response<List<Time>> response) {
        adapter = new TimesListAdapter(getContext(), response.body(), onClickListener());
        rvTimes.setAdapter(adapter);
    }
    private OnClickListener onClickListener() {
        return new OnClickListener() {
            @Override
            public void onClick(View v, int pos) {
                // Pass data from here to next single screen
                Intent intent = new Intent(getContext(), DetailActivity.class);

                // Transform our object into Parcelable (Car class)
                intent.putExtra("time", adapter.getItem(pos));
                startActivity(intent);
            }
        };
    }
    @Override
    public void onFailure(Call<List<Time>> call, Throwable t) {
        Toast.makeText(getContext(),
                "Daahell yo, " + t.getMessage(),
                Toast.LENGTH_LONG).show();
    }
}
