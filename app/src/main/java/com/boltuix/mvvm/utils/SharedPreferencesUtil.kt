package com.boltuix.mvvm.utils

import android.content.SharedPreferences
import javax.inject.Inject

class SpUtil @Inject constructor(private val sharedPref: SharedPreferences) {
    //********************************************************************************************** save all
    //To Store String data
    fun save(KEY_NAME: String, text: String) {

        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putString(KEY_NAME, text)
        editor.apply()
    }
    //..............................................................................................
    //To Store Int data
    fun save(KEY_NAME: String, value: Int) {

        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putInt(KEY_NAME, value)
        editor.apply()
    }

    //..............................................................................................
    //To Store Floating data
    fun save(KEY_NAME: String, value: Float) {

        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putFloat(KEY_NAME, value)
        editor.apply()
    }
    //..............................................................................................
    //To Store Boolean data
    fun save(KEY_NAME: String, status: Boolean) {

        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putBoolean(KEY_NAME, status)
        editor.apply()
    }
    //..............................................................................................
    //To Retrieve Int
    fun getValueInt(KEY_NAME: String): Int {
        return sharedPref.getInt(KEY_NAME, 0)
    }
    //..............................................................................................
    // To Retrieve Boolean
    fun getValueBoolean(KEY_NAME: String, defaultValue: Boolean): Boolean {
        return sharedPref.getBoolean(KEY_NAME, defaultValue)
    }
    //..............................................................................................
    //To Retrieve String
    fun getValueString(KEY_NAME: String): String? {

        return sharedPref.getString(KEY_NAME, "")
    }

    fun getValueFloat(KEY_NAME: String): Float {
        return sharedPref.getFloat(KEY_NAME, 0.0f)
    }
    //********************************************************************************************** delete all
    // To clear all data
    fun clearSharedPreference() {

        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.clear()
        editor.apply()
    }
    //********************************************************************************************** delete selected
    // To remove a specific data
    fun removeValue(KEY_NAME: String) {

        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.remove(KEY_NAME)
        editor.apply()
    }
}