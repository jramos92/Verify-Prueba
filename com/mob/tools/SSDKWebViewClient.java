package com.mob.tools;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mob.tools.utils.DeviceHelper;

public class SSDKWebViewClient
  extends WebViewClient
{
  public static final int ERROR_AUTHENTICATION = -4;
  public static final int ERROR_BAD_URL = -12;
  public static final int ERROR_CONNECT = -6;
  public static final int ERROR_FAILED_SSL_HANDSHAKE = -11;
  public static final int ERROR_FILE = -13;
  public static final int ERROR_FILE_NOT_FOUND = -14;
  public static final int ERROR_HOST_LOOKUP = -2;
  public static final int ERROR_IO = -7;
  public static final int ERROR_PROXY_AUTHENTICATION = -5;
  public static final int ERROR_REDIRECT_LOOP = -9;
  public static final int ERROR_TIMEOUT = -8;
  public static final int ERROR_TOO_MANY_REQUESTS = -15;
  public static final int ERROR_UNKNOWN = -1;
  public static final int ERROR_UNSUPPORTED_AUTH_SCHEME = -3;
  public static final int ERROR_UNSUPPORTED_SCHEME = -10;
  
  public void doUpdateVisitedHistory(WebView paramWebView, String paramString, boolean paramBoolean) {}
  
  public void onFormResubmission(WebView paramWebView, Message paramMessage1, Message paramMessage2)
  {
    paramMessage1.sendToTarget();
  }
  
  public void onLoadResource(WebView paramWebView, String paramString) {}
  
  public void onPageFinished(WebView paramWebView, String paramString) {}
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap) {}
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) {}
  
  public void onReceivedHttpAuthRequest(WebView paramWebView, HttpAuthHandler paramHttpAuthHandler, String paramString1, String paramString2)
  {
    paramHttpAuthHandler.cancel();
  }
  
  public void onReceivedSslError(WebView paramWebView, final SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    if ((paramWebView.getContext() instanceof Activity))
    {
      Object localObject = (Activity)paramWebView.getContext();
      String[] arrayOfString;
      String str2;
      String str1;
      if ("zh".equals(DeviceHelper.getInstance((Context)localObject).getOSLanguage()))
      {
        arrayOfString = new String[5];
        arrayOfString[0] = String.valueOf(new char[] { 19981, 21463, 20449, 20219, 30340, -29759, 20070, 12290, 20320, -30335, 32487, 32493, 21527, -225 });
        arrayOfString[1] = String.valueOf(new char[] { -29759, 20070, 24050, -28729, 26399, 12290, 20320, -30335, 32487, 32493, 21527, -225 });
        arrayOfString[2] = String.valueOf(new char[] { -29759, 20070, 73, 68, 19981, 21305, -28339, 12290, 20320, -30335, 32487, 32493, 21527, -225 });
        arrayOfString[3] = String.valueOf(new char[] { -29759, 20070, 23578, 26410, 29983, 25928, 12290, 20320, -30335, 32487, 32493, 21527, -225 });
        arrayOfString[4] = String.valueOf(new char[] { -29759, 20070, -27367, -29713, 12290, 20320, -30335, 32487, 32493, 21527, -225 });
        str2 = String.valueOf(new char[] { -29759, 20070, -27367, -29713 });
        str1 = String.valueOf(new char[] { 32487, 32493 });
        paramWebView = String.valueOf(new char[] { 20572, 27490 });
        localObject = new AlertDialog.Builder((Context)localObject);
        ((AlertDialog.Builder)localObject).setTitle(str2);
        switch (paramSslError.getPrimaryError())
        {
        default: 
          ((AlertDialog.Builder)localObject).setMessage(arrayOfString[4]);
        }
      }
      for (;;)
      {
        ((AlertDialog.Builder)localObject).setCancelable(false);
        ((AlertDialog.Builder)localObject).setPositiveButton(str1, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            paramAnonymousDialogInterface.dismiss();
            paramSslErrorHandler.proceed();
          }
        });
        ((AlertDialog.Builder)localObject).setNegativeButton(paramWebView, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            paramAnonymousDialogInterface.dismiss();
            paramSslErrorHandler.cancel();
          }
        });
        ((AlertDialog.Builder)localObject).create().show();
        return;
        arrayOfString = new String[5];
        arrayOfString[0] = "Certificate is untrusted. Do you want to continue anyway?";
        arrayOfString[1] = "Certificate has expired. Do you want to continue anyway?";
        arrayOfString[2] = "Certificate ID is mismatched. Do you want to continue anyway?";
        arrayOfString[3] = "Certificate is not yet valid. Do you want to continue anyway?";
        arrayOfString[4] = "Certificate error. Do you want to continue anyway?";
        str2 = "SSL Certificate Error";
        str1 = "Yes";
        paramWebView = "No";
        break;
        ((AlertDialog.Builder)localObject).setMessage(arrayOfString[0]);
        continue;
        ((AlertDialog.Builder)localObject).setMessage(arrayOfString[1]);
        continue;
        ((AlertDialog.Builder)localObject).setMessage(arrayOfString[2]);
        continue;
        ((AlertDialog.Builder)localObject).setMessage(arrayOfString[3]);
      }
    }
    paramSslErrorHandler.cancel();
  }
  
  public void onScaleChanged(WebView paramWebView, float paramFloat1, float paramFloat2) {}
  
  public void onTooManyRedirects(WebView paramWebView, Message paramMessage1, Message paramMessage2)
  {
    paramMessage1.sendToTarget();
  }
  
  public void onUnhandledKeyEvent(WebView paramWebView, KeyEvent paramKeyEvent) {}
  
  public boolean shouldOverrideKeyEvent(WebView paramWebView, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return false;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\tools\SSDKWebViewClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */