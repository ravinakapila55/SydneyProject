package com.sydneyproject.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefUtil
{
    public static final String NAME = "name";
    public static final String PHONE_NUMBER = "phoneNumber";
    public static final String EMAIL = "email";
    public static final String USER_ID = "user_id";
    public static final String DEVICE_TOKEN = "deviceToken";



    /**
     * Name of the preference file
     */

    private static final String APP_PREFS = "application_preferences";
    private Context mContext;
    private static SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private static SharedPrefUtil instance;

    public SharedPrefUtil(Context mContext)
    {
        this.mContext = mContext;
        mSharedPreferences = mContext.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
    }

    public static void init(Context context)
    {
        if (instance == null)
        {
            instance=new SharedPrefUtil(context);
        }
    }

    public static SharedPrefUtil getInstance()
    {
        if (instance == null)
        {
            instance = new SharedPrefUtil(MyApplication.getInstance());
        }
        return instance;
    }


    public void saveString(String key, String value)
    {
        mEditor = mSharedPreferences.edit();
        mEditor.putString(key, value);
        mEditor.apply();
    }

    public void saveInt(String key, int value)
    {
        mEditor = mSharedPreferences.edit();
        mEditor.putInt(key, value);
        mEditor.apply();
    }


    public void saveBoolean(String key, boolean value)
    {
        mEditor = mSharedPreferences.edit();
        mEditor.putBoolean(key, value);
        mEditor.apply();
    }

    public String getString(String key)
    {
        //    mSharedPreferences = mContext.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
        return mSharedPreferences.getString(key, "");
    }

    public String getString(String key, String defaultValue)
    {
        //    mSharedPreferences = mContext.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
        return mSharedPreferences.getString(key, defaultValue);
    }


    public int getInt(String key)
    {
        // mSharedPreferences = mContext.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
        return mSharedPreferences.getInt(key, 0);
    }


    public int getInt(String key, int defaultValue)
    {
        //     mSharedPreferences = mContext.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
        return mSharedPreferences.getInt(key, defaultValue);
    }


    public boolean getBoolean(String key)
    {
        //     mSharedPreferences = mContext.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
        return mSharedPreferences.getBoolean(key, false);
    }


    public boolean getBoolean(String key, boolean defaultValue)
    {
        mSharedPreferences = mContext.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
        return mSharedPreferences.getBoolean(key, defaultValue);
    }

    /**
     * save the device token.
     *
     * @param token Vslue retrieved from the firebase.
     */
    public void saveDeviceToken(String token)
    {
        mEditor = mSharedPreferences.edit();
        mEditor.putString(DEVICE_TOKEN, token);
        mEditor.apply();
    }

    /**
     * get the current device token
     *
     * @return Returns the last update device token got from firebase.
     */
    public String getDeviceToken()
    {
        mSharedPreferences = mContext.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
        return mSharedPreferences.getString(DEVICE_TOKEN, "1234567890");
    }

    /**
     * save the userId of current user using the application
     *
     * @param userId this is the userId of the user
     */
    public void saveUserId(String userId)
    {
        mEditor = mSharedPreferences.edit();
        mEditor.putString(USER_ID, userId);
        mEditor.apply();
    }


    public String getUserId()
    {
        mSharedPreferences = mContext.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
        return mSharedPreferences.getString(USER_ID, "");
    }





    /**
     * set login state oin the device is there any user current login device
     */


    /**
     * @return is anyuser current login into the device accordingly true/false.
     */



    /**
     * save name of the user
     */
    public void saveName(String name)
    {
        mEditor = mSharedPreferences.edit();
        mEditor.putString(NAME, name);
        mEditor.apply();
    }

    /**
     * get name of the user
     */
    public String getName()
    {
        mSharedPreferences = mContext.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
        return mSharedPreferences.getString(NAME, "");
    }


    /**
     * save email of the user
     */
    public void saveEmail(String email)
    {
        mEditor = mSharedPreferences.edit();
        mEditor.putString(EMAIL, email);
        mEditor.apply();
    }

    /**
     * get email of the user
     */
    public String getEmail() {
        mSharedPreferences = mContext.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
        return mSharedPreferences.getString(EMAIL, "");
    }

    /**
     * save phoneNumber of the user
     */
    public void savePhoneNumber(String phoneNumber) {
        mEditor = mSharedPreferences.edit();
        mEditor.putString(PHONE_NUMBER, phoneNumber);
        mEditor.apply();
    }

    /**
     * get phoneNumber of the user
     */
    public String getPhoneNumber() {
        mSharedPreferences = mContext.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
        return mSharedPreferences.getString(PHONE_NUMBER, "");
    }

    /**
     * save image of the user
     */


    /**
     * get image of the user
     */




    /**
     * Clears the shared preference file
     */


    public void clear()
    {
        mSharedPreferences = mContext.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
        mSharedPreferences.edit().clear().apply();
    }

    public void onLogout()
    {
        mSharedPreferences = mContext.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
        mSharedPreferences.edit().clear().apply();
//        mEditor = mSharedPreferences.edit();
//        mEditor.clear();
////        mEditor.remove(USER_ID);
////        setLogin(false);
//        mEditor.apply();
    }
}
