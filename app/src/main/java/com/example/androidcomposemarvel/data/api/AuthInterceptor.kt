package com.example.androidcomposemarvel.data.api

import okhttp3.Interceptor
import okhttp3.Response
import java.security.MessageDigest

class AuthInterceptor(
    private val publicKey: String,
    private val privateKey: String
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val ts = System.currentTimeMillis().toString()
        val hash = MessageDigest.getInstance("MD5")
            .digest("$ts$privateKey$publicKey".toByteArray())
            .joinToString("") { "%02x".format(it) }

        val original = chain.request().url
        val url = original.newBuilder()
            .addQueryParameter("ts", ts)
            .addQueryParameter("apikey", publicKey)
            .addQueryParameter("hash", hash)
            .build()

        val request = chain.request().newBuilder().url(url).build()
        return chain.proceed(request)
    }
}

