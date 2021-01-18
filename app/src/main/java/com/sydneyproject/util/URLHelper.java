package com.sydneyproject.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URLHelper
{



//    http://178.128.116.149/billpay/api/signup
    //verification_code,device_id,device_token,device_type
    //RESEDN:-email(email or mobile_number)


    public static final String BASE_URL="http://178.128.116.149/billpay/api/";

    public static final String LOGIN = BASE_URL +"login";
    public static final String REGISTER = BASE_URL +"signup";
    public static final String VERIFY_OTP = BASE_URL +"verifyotp";
    public static final String REDEND_OTP = BASE_URL +"resendotp";
    public static final String SUBSCRIPTION_PLANS = BASE_URL +"plans";



    public static String getFormatedTime(String dateStr, String strReadFormat, String strWriteFormat)
    {
        try
        {
            String formattedDate = dateStr;

            DateFormat readFormat = new SimpleDateFormat(strReadFormat);
            readFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            DateFormat writeFormat = new SimpleDateFormat(strWriteFormat);
            writeFormat.setTimeZone(TimeZone.getDefault());
            Date date = null;
            try
            {
                date = readFormat.parse(dateStr);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
            if (date != null)
            {
                formattedDate = writeFormat.format(date);
            }

            return formattedDate;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return dateStr;
        }
    }

    public static String getFormatedDate(String dateStr, String strReadFormat, String strWriteFormat)
    {
        String formattedDate = dateStr;
        DateFormat readFormat = new SimpleDateFormat(strReadFormat);
        DateFormat writeFormat = new SimpleDateFormat(strWriteFormat);
        Date date = null;
        try
        {
            date = readFormat.parse(dateStr);
        }
        catch (ParseException e)
        {
            e.printStackTrace();

        }

        if (date != null)
        {
            formattedDate = writeFormat.format(date);
        }

        return formattedDate;
    }

}
