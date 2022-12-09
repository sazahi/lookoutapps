package id.kotlin.recyclerview.Api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface TodoApi {
    @GET("https://jlssvretpbzsnnbfpijd.supabase.co/rest/v1/item?select=*")
    suspend fun get(
        @Header("Authorization")
        token: String,
        @Header("apikey") apiKey: String
    ) : Response<List<TodoItem>>
}