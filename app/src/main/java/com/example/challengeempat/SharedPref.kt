package com.example.challengeempat

import android.content.Context
import androidx.core.content.edit

class SharedPref(context: Context) {

    private val sharedName = "SharedPreference"
    private var preference = context.getSharedPreferences(sharedName, Context.MODE_PRIVATE)

    var isLogin: Boolean
        set(value) {
            preference.edit{
                putBoolean("IS_LOGIN", value)
            }
        }
        get() = preference.getBoolean("IS_LOGIN", false)
}