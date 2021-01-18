package com.sydneyproject.util;

import android.content.Context;
import android.content.Intent;

import com.sydneyproject.R;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Alerts
{

    public static void callSweetAlertSuccessType(final Context context, final Class aClass,String msg,String buttonName)
    {
        new SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText(context.getResources().getString(R.string.app_name))
                .setContentText(msg)
                .setConfirmText(buttonName)
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        Intent intent=new Intent(context, aClass);
                        context.startActivity(intent);
                        sDialog.dismissWithAnimation();
                    }
                })

                .show();
    }
}
