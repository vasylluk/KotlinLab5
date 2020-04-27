package com.example.locationservice

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class Client {
    fun getClient(): Service {
        val httpClient = OkHttpClient.Builder()
        //TODO:тут має бути адреса nodejs служби видачі локацій
        val builder = Retrofit.Builder()
                .baseUrl("https://wt-25e341bb2fca3ab10c862fb71cda965c-0.run.webtask.io/pusher-location-feeds/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())

        val retrofit = builder
                .client(httpClient.build())
                .build()

        return retrofit.create(Service::class.java)
    }
}