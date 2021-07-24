# Retrofit
## Name: Wallet application
### Tech list:
- Call api: [Retrofit](https://square.github.io/retrofit/)
- Model MVVM: [Recycler view](https://developer.android.com/guide/topics/ui/layout/recyclerview)
- Display image: [x] [Picasso](https://square.github.io/picasso/) 

### Files were used in this folder
- adapter/CurrencyListViewAdapter
- model/Currencies
- APIClient
- APIInterface
- Constant
- MainActivity
- res/layout/activity_main
- res/layout/currency_view
- AndroidManifest
- build.gradle (app)

### Need to change
- Constant
```
  public static final String BASE_URL ="https://80de7f8b1f22.ngrok.io";
```

- AndroidManifest
```
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.walletapplication">
    <!-- Internet Permissions -->
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />

    <!-- Permission to write to external storage -->
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    ...
</manifest>
```

- build.gradle
```
dependencies {
    ...
    // Retrofit 2
    implementation 'com.google.code.gson:gson:2.8.7'
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'

    // define a BOM and its version
    implementation(platform("com.squareup.okhttp3:okhttp-bom:4.9.0"))

    // define any required OkHttp artifacts without version
    implementation("com.squareup.okhttp3:okhttp:4.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.0")

    implementation 'com.squareup.picasso:picasso:2.71828'
}
```


