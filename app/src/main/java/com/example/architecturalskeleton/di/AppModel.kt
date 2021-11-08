package com.example.architecturalskeleton.di

import android.content.Context
import android.provider.SyncStateContract
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.architecturalskeleton.R
import com.example.architecturalskeleton.qualifiers.IOThread
import com.example.architecturalskeleton.qualifiers.MainThread
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModel {


    @Singleton
    @Provides
    fun provideApplicationContext(
        @ApplicationContext context: Context
    ) = context

    // TODO: 11/8/2021  For implementation MainDispatcher

    @MainThread
    @Singleton
    @Provides
    fun provideMainDispatcher(): CoroutineDispatcher = Dispatchers.Main


    // TODO: 11/8/2021  For implementation IODispatcher

    @IOThread
    @Singleton
    @Provides
    fun provideIODispatcher(): CoroutineDispatcher = Dispatchers.IO



    // TODO: 11/8/2021  For implementation Glide
    @Singleton
    @Provides
    fun provideGlideInstance(
        @ApplicationContext context: Context
    ) = Glide.with(context).setDefaultRequestOptions(
        RequestOptions()
            .placeholder(R.drawable.ic_image)
            .error(R.drawable.ic_error)
            .diskCacheStrategy(DiskCacheStrategy.DATA)

    )


    // TODO: 11/8/2021  For implementation AppDatabase

//    @Provides
//    @Singleton
//    fun provideAppDatabase(@ApplicationContext appContext: Context): JobDataBase {
//        return Room.databaseBuilder(
//            appContext,
//            JobDataBase::class.java,
//            "job_DB"
//        ).setJournalMode(RoomDatabase.JournalMode.TRUNCATE)
//            .build()
//    }

    // TODO: 11/8/2021  For implementation Moshi

    @Provides
    @Singleton
    fun providesMoshi(): Moshi = Moshi
        .Builder()
        .add(KotlinJsonAdapterFactory())
        .build()





    // TODO: 11/8/2021  For implementation OkHttpClient

    @Provides
    @Singleton
    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addInterceptor { chain ->
                val original: Request = chain.request()
                val builder: Request.Builder = chain.request().newBuilder()

                //    builder.addHeader(Constants.CONTENT_TYPE, Constants.APP_JSON)
                builder.method(original.method, original.body)
                chain.proceed(builder.build())
            }
            .addNetworkInterceptor(interceptor)
            .build()


    // TODO: 11/8/2021  For implementation Retrofit
//    @Provides
//    @Singleton
//    fun providesApiService(moshi: Moshi, okHttpClient: OkHttpClient): ApiJobService =
//
//        Retrofit.Builder()
//            .run {
//                baseUrl(Constants.BASE_URL)
//                client(okHttpClient)
//                addConverterFactory(GsonConverterFactory.create())
//                build()
//            }.create(ApiJobService::class.java)


}