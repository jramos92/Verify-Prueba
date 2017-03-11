package com.veryfit.multi.util;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog.Calls;
import android.provider.ContactsContract.PhoneLookup;
import android.text.TextUtils;

public class SMSPhoneUtil
{
  public static String getContactNameFromPhoneBook(Context paramContext, String paramString)
  {
    String str = "";
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(paramString));
    paramString = paramContext.getContentResolver().query(paramString, new String[] { "display_name", "number" }, null, null, null);
    paramContext = str;
    if (paramString.moveToFirst())
    {
      paramContext = paramString.getString(paramString.getColumnIndex("display_name"));
      paramString.close();
    }
    return paramContext;
  }
  
  public static int getMissCallCount(Context paramContext)
  {
    int i = 0;
    paramContext = paramContext.getContentResolver().query(CallLog.Calls.CONTENT_URI, new String[] { "type" }, " type=? and new=?", new String[] { "3", "1" }, "date desc");
    if (paramContext != null)
    {
      i = paramContext.getCount();
      paramContext.close();
    }
    return i;
  }
  
  public static int getMissSmsCount(Context paramContext)
  {
    int i = 0;
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://sms"), null, "type = 1 and read = 0", null, null);
    if (paramContext != null)
    {
      i = paramContext.getCount();
      paramContext.close();
    }
    return i;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\util\SMSPhoneUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */