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

//
        /**
         GET List Resources
         **/
//        Call<MultipleResource> call = apiInterface.doGetListResources();
//        call.enqueue(new Callback<MultipleResource>() {
//            @Override
//            public void onResponse(Call<MultipleResource> call, Response<MultipleResource> response) {
//
//
//                Log.d("TAG",response.code()+"");
//
//                String displayResponse = "";
//
//                MultipleResource resource = response.body();
//                Integer text = resource.page;
//                Integer total = resource.total;
//                Integer totalPages = resource.totalPages;
//                List<MultipleResource.Datum> datumList = resource.data;
//
////                displayResponse += text + " Page\n" + total + " Total\n" + totalPages + " Total Pages\n";
//
//                for (MultipleResource.Datum datum : datumList) {
//                    displayResponse += datum.id + " " + datum.name + " " + datum.pantoneValue + " " + datum.year + "\n";
//                }
//
//                responseText.setText(displayResponse);
//
//            }
//
//            @Override
//            public void onFailure(Call<MultipleResource> call, Throwable t) {
//                call.cancel();
//            }
//        });
//
//        /**
//         Create new user
//         **/
//        User user = new User("morpheus", "leader");
//        Call<User> call1 = apiInterface.createUser(user);
//        call1.enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                User user1 = response.body();
//
//                Toast.makeText(getApplicationContext(), user1.name + " " + user1.job + " " + user1.id + " " + user1.createdAt, Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//                call.cancel();
//            }
//        });
//
//        /**
//         GET List Users
//         **/
//        Call<UserList> call2 = apiInterface.doGetUserList("2");
//        call2.enqueue(new Callback<UserList>() {
//            @Override
//            public void onResponse(Call<UserList> call, Response<UserList> response) {
//
//                UserList userList = response.body();
//                Integer text = userList.page;
//                Integer total = userList.total;
//                Integer totalPages = userList.totalPages;
//                List<UserList.Datum> datumList = userList.data;
//                Toast.makeText(getApplicationContext(), text + " page\n" + total + " total\n" + totalPages + " totalPages\n", Toast.LENGTH_SHORT).show();
//
//                for (UserList.Datum datum : datumList) {
//                    Toast.makeText(getApplicationContext(), "id : " + datum.id + " name: " + datum.first_name + " " + datum.last_name + " avatar: " + datum.avatar, Toast.LENGTH_SHORT).show();
//                }
//
//
//            }
//
//            @Override
//            public void onFailure(Call<UserList> call, Throwable t) {
//                call.cancel();
//            }
//        });
//
//
//        /**
//         POST name and job Url encoded.
//         **/
//        Call<UserList> call3 = apiInterface.doCreateUserWithField("morpheus","leader");
//        call3.enqueue(new Callback<UserList>() {
//            @Override
//            public void onResponse(Call<UserList> call, Response<UserList> response) {
//                UserList userList = response.body();
//                Integer text = userList.page;
//                Integer total = userList.total;
//                Integer totalPages = userList.totalPages;
//                List<UserList.Datum> datumList = userList.data;
//                Toast.makeText(getApplicationContext(), text + " page\n" + total + " total\n" + totalPages + " totalPages\n", Toast.LENGTH_SHORT).show();
//
//                for (UserList.Datum datum : datumList) {
//                    Toast.makeText(getApplicationContext(), "id : " + datum.id + " name: " + datum.first_name + " " + datum.last_name + " avatar: " + datum.avatar, Toast.LENGTH_SHORT).show();
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<UserList> call, Throwable t) {
//                call.cancel();
//            }
//        });

    }
}


//
//import android.os.Bundle;
//import android.view.View;
//import android.view.Menu;
//
//import com.google.android.material.snackbar.Snackbar;
//import com.google.android.material.navigation.NavigationView;
//
//import androidx.navigation.NavController;
//import androidx.navigation.Navigation;
//import androidx.navigation.ui.AppBarConfiguration;
//import androidx.navigation.ui.NavigationUI;
//import androidx.drawerlayout.widget.DrawerLayout;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.walletapplication.databinding.ActivityMainBinding;
//
//
////import retrofit2.Call;
////import retrofit2.Callback;
////import retrofit2.Response;
//
//import android.widget.TextView;
//
////import com.example.walletapplication.model.User;
////import com.example.walletapplication.model.Currency;
//
//public class MainActivity extends AppCompatActivity {
//
//    private AppBarConfiguration mAppBarConfiguration;
//    private ActivityMainBinding binding;
//
//    TextView responseText;
//    APIInterface apiInterface;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        // TODO: response area
////        setContentView(R.layout.activity_main);
//        responseText = (TextView) findViewById(R.id.text_home);
////        apiInterface = APIClient.getClient().create(APIInterface.class);
//
//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        setSupportActionBar(binding.appBarMain.toolbar);
//        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//
//            }
//        });
//        DrawerLayout drawer = binding.drawerLayout;
//        NavigationView navigationView = binding.navView;
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        mAppBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
//                .setDrawerLayout(drawer)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
//        NavigationUI.setupWithNavController(navigationView, navController);
//    }
//
//    // TODO: GET Currencies
//    private void getCurrency() {
//        Call<Currency> call2 = apiInterface.doGetCurrencies();
//        call2.enqueue(new Callback<Currency>() {
//            @Override
//            public void onResponse(Call<Currency> call, Response<Currency> response) {
//
//                Currency currency = response.body();
//                List<Currency.Datum> datumList = currency.data;
//                String displayResponse = "";
//                for (Currency.Datum datum : datumList) {
//                    displayResponse += datum.sId + " " + datum.sName + " " + datum.sSymbol + "\n";
//                }
//
//                responseText.setText(displayResponse);
//
//            }
//
//            @Override
//            public void onFailure(Call<Currency> call, Throwable t) {
//
//            }
//        });
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
//                || super.onSupportNavigateUp();
//    }
//}