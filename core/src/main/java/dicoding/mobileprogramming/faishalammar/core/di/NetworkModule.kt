package dicoding.mobileprogramming.faishalammar.core.di

import dagger.Module
import dagger.Provides
import dicoding.mobileprogramming.faishalammar.core.data.source.remote.network.ApiService
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class NetworkModule {

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val mainDomain = "https://api.themoviedb.org/3/"
        val certificatePinner = CertificatePinner.Builder()
            .add(mainDomain, "sha256/0950fbaf3ba71f574ebe3e4d5549f9d6=")
            .build()
        return OkHttpClient.Builder()
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .certificatePinner(certificatePinner)
            .build()
    }

    @Provides
    fun provideApiService(client: OkHttpClient): ApiService {
        val mainDomain = "https://api.themoviedb.org/3/"
        val retrofit = Retrofit.Builder()
            .baseUrl(mainDomain)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()

        return retrofit.create(ApiService::class.java)
    }
}