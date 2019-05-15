package com.example.bloodbankapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class HealthFragment extends Fragment {

    private static final String API_KEY = "9b017b36c1b74854aeb704e2b893a1b9";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_health, container, false);

        final Api apiService = ApiClient.getClient().create(Api.class);

        //Call<ResponseModel> call = apiService.getLatestNews("ng",API_KEY);
        // Inflate the layout for this fragment
        return view;
    }

}
