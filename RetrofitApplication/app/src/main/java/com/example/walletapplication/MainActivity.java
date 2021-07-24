package com.example.walletapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// Models
import com.example.walletapplication.adapter.CurrencyListViewAdapter;
import com.example.walletapplication.model.Currencies;

public class MainActivity extends AppCompatActivity {

    TextView responseText;
    APIInterface apiInterface;
    List<Currencies> listCurrency;
    CurrencyListViewAdapter currencyListViewAdapter;
    ListView listViewCurrency;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        responseText = (TextView) findViewById(R.id.responseText);
        apiInterface = APIClient.getClient().create(APIInterface.class);

        Call<List<Currencies>> call = apiInterface.doGetCurrencies();
        call.enqueue(new Callback<List<Currencies>>() {
            @Override
            public void onResponse(Call<List<Currencies>> call, Response<List<Currencies>> response) {

                List<Currencies> resource = response.body();
                listCurrency = resource;
                Log.d("currency",resource.toString());

                listViewCurrency = (ListView) findViewById(R.id.list_currency);
                currencyListViewAdapter = new CurrencyListViewAdapter(listCurrency);
                listViewCurrency.setAdapter(currencyListViewAdapter);


                // Listener event
//                listViewCurrency.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                        Currencies currency = (Currencies) currencyListViewAdapter.getItem(i);
//                        responseText.setText(currency.toString());
//                        Toast.makeText(MainActivity.this, currency.sSymbol, Toast.LENGTH_LONG).show();
//                    }
//                });
//                String displayResponse = "";
//                for (Currencies datum : resource) {
//                    displayResponse += datum.sId + " " + datum.sName + " " + datum.sSymbol + "\n";
//                }
//
//                responseText.setText(displayResponse);

            }

            @Override
            public void onFailure(Call<List<Currencies>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                call.cancel();
            }
        });
    }
}