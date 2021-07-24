package com.example.walletapplication.adapter;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.example.walletapplication.Constants;
import com.example.walletapplication.model.Currencies;
import com.example.walletapplication.R;
import com.squareup.picasso.Picasso;

public class CurrencyListViewAdapter extends BaseAdapter {
    final List<Currencies> listCurrency;

    public CurrencyListViewAdapter(List<Currencies> listCurrency) {
        this.listCurrency = listCurrency;
    }

    @Override
    public int getCount() {
        return listCurrency.size();
    }

    @Override
    public Object getItem(int position) {
        // Return item position in Adapter
        return listCurrency.get(position);
    }

    @Override
    public long getItemId(int position) {
        // Return an ID of item
        return listCurrency.get(position).sId;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View viewCurrency;
        if (view == null) {
            viewCurrency = View.inflate(viewGroup.getContext(), R.layout.currency_view, null);
        } else {
            viewCurrency = view;
        }

        // Binding data
        Currencies currency = (Currencies) getItem(position);

        String imageUri = Constants.BASE_URL + currency.sIconPath;
//        String imageUri = "https://i.imgur.com/tGbaZCY.jpg";
        ImageView imgView = (ImageView) viewCurrency.findViewById(R.id.currency_icon);
        Picasso.get().load(imageUri).resize(120,120).into(imgView);

        ((TextView) viewCurrency.findViewById(R.id.symbol)).setText(String.format(currency.sSymbol));
        ((TextView) viewCurrency.findViewById(R.id.name)).setText(String.format(currency.sName));
        ((TextView) viewCurrency.findViewById(R.id.currency_type)).setText(String.format(currency.sCurrencyType));

        // Handling button
        Button btnMore = (Button) viewCurrency.findViewById(R.id.btn_more);
        btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("adapter", (currency.sSymbol + currency.sName).toString());
                Toast.makeText(v.getContext(), (currency.sSymbol + currency.sName).toString(), Toast.LENGTH_SHORT).show();

            }

        });

        return viewCurrency;
    }
}
