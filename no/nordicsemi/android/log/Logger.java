package no.nordicsemi.android.log;

import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import java.util.ArrayList;
import java.util.List;

public class Logger
{
  public static final int MARK_CLEAR = 0;
  public static final int MARK_FLAG_BLUE = 5;
  public static final int MARK_FLAG_RED = 6;
  public static final int MARK_FLAG_YELLOW = 4;
  public static final int MARK_STAR_BLUE = 2;
  public static final int MARK_STAR_RED = 3;
  public static final int MARK_STAR_YELLOW = 1;
  private static final int SESSION_ID = 100;
  private static final int SESSION_ID_LOG = 101;
  private static final int SESSION_KEY_NUMBER = 102;
  private static final int SESSION_KEY_NUMBER_LOG = 103;
  private static final UriMatcher mUriMatcher = new UriMatcher(-1);
  
  static
  {
    UriMatcher localUriMatcher = mUriMatcher;
    localUriMatcher.addURI("no.nordicsemi.android.log", "session/#", 100);
    localUriMatcher.addURI("no.nordicsemi.android.log", "session/#/log", 101);
    localUriMatcher.addURI("no.nordicsemi.android.log", "session/key/*/#", 102);
    localUriMatcher.addURI("no.nordicsemi.android.log", "session/key/*/#/log", 103);
  }
  
  public static void d(LogSession paramLogSession, int paramInt, Object... paramVarArgs)
  {
    log(paramLogSession, 0, paramInt, paramVarArgs);
  }
  
  public static void d(LogSession paramLogSession, String paramString)
  {
    log(paramLogSession, 0, paramString);
  }
  
  public static void e(LogSession paramLogSession, int paramInt, Object... paramVarArgs)
  {
    log(paramLogSession, 20, paramInt, paramVarArgs);
  }
  
  public static void e(LogSession paramLogSession, String paramString)
  {
    log(paramLogSession, 20, paramString);
  }
  
  public static void i(LogSession paramLogSession, int paramInt, Object... paramVarArgs)
  {
    log(paramLogSession, 5, paramInt, paramVarArgs);
  }
  
  public static void i(LogSession paramLogSession, String paramString)
  {
    log(paramLogSession, 5, paramString);
  }
  
  public static void log(LogSession paramLogSession, int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    if (paramLogSession == null) {
      return;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("level", Integer.valueOf(paramInt1));
    localContentValues.put("data", paramLogSession.context.getString(paramInt2, paramVarArgs));
    try
    {
      paramLogSession.context.getContentResolver().insert(paramLogSession.getSessionEntriesUri(), localContentValues);
      return;
    }
    catch (Exception paramLogSession) {}
  }
  
  public static void log(LogSession paramLogSession, int paramInt, String paramString)
  {
    if (paramLogSession == null) {
      return;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("level", Integer.valueOf(paramInt));
    localContentValues.put("data", paramString);
    try
    {
      paramLogSession.context.getContentResolver().insert(paramLogSession.getSessionEntriesUri(), localContentValues);
      return;
    }
    catch (Exception paramLogSession) {}
  }
  
  public static LogSession newSession(Context paramContext, String paramString1, String paramString2)
  {
    return newSession(paramContext, null, paramString1, paramString2);
  }
  
  public static LogSession newSession(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList();
    ContentProviderOperation.Builder localBuilder = ContentProviderOperation.newInsert(LogContract.Application.CONTENT_URI);
    String str = paramContext.getApplicationInfo().loadLabel(paramContext.getPackageManager()).toString();
    if (paramString1 != null) {
      localBuilder.withValue("application", str + " " + paramString1);
    }
    for (;;)
    {
      localArrayList.add(localBuilder.build());
      paramString1 = ContentProviderOperation.newInsert(LogContract.Session.CONTENT_URI.buildUpon().appendEncodedPath("key").appendEncodedPath(paramString2).build());
      paramString1.withValueBackReference("application_id", 0);
      paramString1.withValue("name", paramString3);
      localArrayList.add(paramString1.build());
      try
      {
        paramContext = new LogSession(paramContext, paramContext.getContentResolver().applyBatch("no.nordicsemi.android.log", localArrayList)[1].uri);
        return paramContext;
      }
      catch (Exception paramContext) {}
      localBuilder.withValue("application", str);
    }
    return null;
  }
  
  public static LogSession openSession(Context paramContext, Uri paramUri)
  {
    if (paramUri == null) {
      return null;
    }
    switch (mUriMatcher.match(paramUri))
    {
    default: 
      return null;
    case 100: 
    case 102: 
      return new LogSession(paramContext, paramUri);
    }
    Uri.Builder localBuilder = LogContract.Session.CONTENT_URI.buildUpon();
    paramUri = paramUri.getPathSegments();
    int i = 1;
    for (;;)
    {
      if (i >= paramUri.size() - 1) {
        return new LogSession(paramContext, localBuilder.build());
      }
      localBuilder.appendEncodedPath((String)paramUri.get(i));
      i += 1;
    }
  }
  
  public static void setSessionDescription(LogSession paramLogSession, String paramString)
  {
    if (paramLogSession == null) {
      return;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("description", paramString);
    try
    {
      paramLogSession.context.getContentResolver().update(paramLogSession.getSessionUri(), localContentValues, null, null);
      return;
    }
    catch (Exception paramLogSession) {}
  }
  
  public static void setSessionMark(LogSession paramLogSession, int paramInt)
  {
    if (paramLogSession == null) {
      return;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("mark", Integer.valueOf(paramInt));
    try
    {
      paramLogSession.context.getContentResolver().update(paramLogSession.getSessionUri(), localContentValues, null, null);
      return;
    }
    catch (Exception paramLogSession) {}
  }
  
  public static void v(LogSession paramLogSession, int paramInt, Object... paramVarArgs)
  {
    log(paramLogSession, 1, paramInt, paramVarArgs);
  }
  
  public static void v(LogSession paramLogSession, String paramString)
  {
    log(paramLogSession, 1, paramString);
  }
  
  public static void w(LogSession paramLogSession, int paramInt, Object... paramVarArgs)
  {
    log(paramLogSession, 15, paramInt, paramVarArgs);
  }
  
  public static void w(LogSession paramLogSession, String paramString)
  {
    log(paramLogSession, 15, paramString);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\no\nordicsemi\android\log\Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */