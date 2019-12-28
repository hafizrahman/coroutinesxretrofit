package studio.oldblack.coroutinesxretrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import studio.oldblack.coroutinesxretrofit.models.Category

interface CategoryService {
    @GET("v2/categories/")
    suspend fun getCategories(): List<Category>

    companion object {
        fun create(): CategoryService {
            // Initialize Retrofit for API calls
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .baseUrl("http://freebbble.com/wp-json/wp/")
                .build()

            return retrofit.create(CategoryService::class.java)
        }
    }
}