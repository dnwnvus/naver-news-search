package com.example.navernews.sharedPreference

import android.content.Context
import android.content.SharedPreferences

class PreferenceUtil(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("prefs", 0)

    fun getString(key: String, value: String): String {
        return prefs.getString(key, value).toString()
    }

    fun setString(key: String, value: String) {
        prefs.edit().putString(key, value).apply()
    }
}