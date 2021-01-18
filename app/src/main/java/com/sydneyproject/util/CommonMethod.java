package com.sydneyproject.util;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Toast;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.pedant.SweetAlert.SweetAlertDialog;


public class CommonMethod {

    private static ProgressDialog mProgress;





    public static boolean isValidMobile(String phone) {
        if (!Pattern.matches("[a-zA-Z]+", phone)) {
            return phone.length() > 6 && phone.length() <= 13;
        }
        return false;
    }

    public static void hideKeyboard(Context ctx) {
        InputMethodManager inputManager = (InputMethodManager) ctx
                .getSystemService(Context.INPUT_METHOD_SERVICE);

        // check if no view has focus:
        View v = ((Activity) ctx).getCurrentFocus();
        if (v == null)
            return;
        inputManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }
    public static boolean isValidName(String phone) {

        return phone.length() > 2 && phone.length() <= 20;

    }

    public static void showToast(Context mContext, String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

    public static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }


    public static boolean isValidPassword(final String password) {

        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static String getDeviceId(Context mContext) {

        String android_id = Settings.Secure.getString(mContext.getContentResolver(),
                Settings.Secure.ANDROID_ID);


        return android_id;

    }

    public static String getFormatedTime(String dateStr, String strReadFormat, String strWriteFormat) {


        try {

            String formattedDate = dateStr;

            DateFormat readFormat = new SimpleDateFormat(strReadFormat);
            readFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

            DateFormat writeFormat = new SimpleDateFormat(strWriteFormat);
            writeFormat.setTimeZone(TimeZone.getDefault());
            Date date = null;

            try {
                date = readFormat.parse(dateStr);
            } catch (ParseException e) {
            }

            if (date != null) {
                formattedDate = writeFormat.format(date);
            }

            return formattedDate;

        }
        catch (Exception ex){
            ex.printStackTrace();
            return dateStr;
        }
    }



    public static String getCompleteAddressString(Context mContext,double LATITUDE, double LONGITUDE) {
        String strAdd = "";
        Geocoder geocoder = new Geocoder(mContext, Locale.getDefault());
        try {
            List<Address> addresses = geocoder.getFromLocation(LATITUDE, LONGITUDE, 1);
            if (addresses != null) {
                Address returnedAddress = addresses.get(0);
                StringBuilder strReturnedAddress = new StringBuilder("");

                for (int i = 0; i <= returnedAddress.getMaxAddressLineIndex(); i++) {
                    strReturnedAddress.append(returnedAddress.getAddressLine(i)).append("\n");
                }
                strAdd = strReturnedAddress.toString();
                Log.w("Myaddress", strReturnedAddress.toString());
            } else {
                Log.w("Myaddress", "No Address returned!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.w("Myaddress", "Canont get Address!");
        }
        return strAdd;
    }





    public static boolean validatePhone(String phoneNo) {
        if (phoneNo.equalsIgnoreCase(""))
            return true;
        Pattern mPattern = Pattern.compile("^((\\+){0,1}91(\\s){0,1}(\\-){0,1}(\\s){0,1}){0,1}98(\\s){0,1}(\\-){0,1}(\\s){0,1}[1-9]{1}[0-9]{7}$");
        Matcher mMatcher = mPattern.matcher(phoneNo);
        if (phoneNo.equalsIgnoreCase("9876543210")) {
            return false;
        }

        Pattern p = Pattern.compile("(0/91)?[6-9][0-9]{9}");
        // Pattern class contains matcher() method
        // to find matching between given number
        // and regular expression
        Matcher marc = p.matcher(phoneNo);
        int MATCHING_VALUE = 0;
        String phoneNoV = "";
        for (int i = 0; i < phoneNo.length(); i++) {
            if (i < 5) {
                if (i == 0) {
                    phoneNoV = phoneNo.substring(0, 1);
                }
                if (phoneNoV.equals(phoneNo.substring(i, i + 1)) && MATCHING_VALUE == i) {
                    MATCHING_VALUE += 1;
                }
            }
        }

        if (MATCHING_VALUE == 5) {
            return false;
        }

        return p.matcher(phoneNo).matches();
    }




    // hide the common progress which is used in all application.
    public static void hideProgress() {
        try {
            if (mProgress != null) {
                mProgress.hide();
                mProgress.dismiss();
                mProgress = null;
            }
        } catch (Exception e) {

            mProgress = null;
        }
    }




}
