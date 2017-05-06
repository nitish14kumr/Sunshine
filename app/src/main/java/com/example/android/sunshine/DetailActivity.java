package com.example.android.sunshine;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.zip.Inflater;

import static android.R.attr.fragment;

public class DetailActivity extends AppCompatActivity{

    final static String TAG = "com.example.android";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container,
                    new ForecastFragment()).commit();
        }

//        PlaceHolderFragment placeHolderFragment = new PlaceHolderFragment();
//        placeHolderFragment.onCreateView();

//        Bundle Data = getIntent().getExtras();
//
//        String forecastStr = Data.getString("detail");
//        Log.i(TAG,"forecast: "+forecastStr);
//        TextView detail = (TextView) findViewById(R.id.detailText);
//        detail.setText(forecastStr);

    }

    public static class PlaceHolderFragment extends Fragment{
        public PlaceHolderFragment(){
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle save){
            Intent intent = getActivity().getIntent();
            View rootView = inflater.inflate(R.layout.fragment_detail, container,false);
            if(intent != null && intent.hasExtra(Intent.EXTRA_TEXT)){
                String forecastStr = intent.getStringExtra(Intent.EXTRA_TEXT);
                Log.i(TAG,"forecast: "+forecastStr);
                TextView detailText = (TextView) rootView.findViewById(R.id.detailText);
                detailText.setText(forecastStr);
            }
            return rootView;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
