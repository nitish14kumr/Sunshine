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

import static android.R.attr.dashGap;
import static android.R.attr.fragment;

public class DetailActivity extends AppCompatActivity {

    final static String TAG = "com.example.android";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
//
//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction().add(R.id.container,
//                    new PlaceHolderFragment()).commit();
//        }
        Bundle Data = getIntent().getExtras();
        String forecast = Data.getString("detail");
        PlaceHolderFragment placeHolderFragment = PlaceHolderFragment.newInstance(forecast);
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, placeHolderFragment).commit();
//
//        String forecastStr = Data.getString("detail");
//        Log.i(TAG,"forecast: "+forecastStr);
//        TextView detail = (TextView) findViewById(R.id.detailText);
//        detail.setText(forecastStr);

    }

    public static class PlaceHolderFragment extends Fragment {
        private static final String PARAM = "PARAM";

        public PlaceHolderFragment() {
        }

        public static PlaceHolderFragment newInstance(String forecast) {
            PlaceHolderFragment placeHolderFragment = new PlaceHolderFragment();
            Bundle bundle = new Bundle();
            bundle.putString(PARAM, forecast);
            placeHolderFragment.setArguments(bundle);
            return placeHolderFragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle save) {
//            Intent intent = getActivity().getIntent();
            View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
            TextView detailText = (TextView) rootView.findViewById(R.id.detailText);
            String forecastStr = "null";
//            if (intent != null && intent.hasExtra(Intent.EXTRA_TEXT)) {
//                String forecastStr = intent.getStringExtra(Intent.EXTRA_TEXT);
//                Log.i(TAG, "forecast: " + forecastStr);
//                TextView detailText = (TextView) rootView.findViewById(R.id.detailText);
//                detailText.setText(forecastStr);
//            }
            if (getArguments() != null) {
                forecastStr = getArguments().getString(PARAM); // getArguments used to get string back
                Log.e(TAG, "onCreateView: " + detailText.getText() + "  " + forecastStr);
            }
            detailText.setText(forecastStr);
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
