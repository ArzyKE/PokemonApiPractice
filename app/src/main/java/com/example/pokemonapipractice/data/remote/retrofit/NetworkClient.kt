package com.example.pokemonapipractice.data.remote.retrofit

import com.example.pokemonapipractice.data.remote.apiservices.PokemonApiService
import javax.inject.Inject

class NetworkClient @Inject constructor(
    retrofitClient: RetrofitClient,
    okHttp: OkHttp
) {

    private val provideRetrofit = retrofitClient.provideRetrofit(okHttp.provideOkHttpClient())

    fun providePokemonApiService() = provideRetrofit.create(PokemonApiService::class.java)
}