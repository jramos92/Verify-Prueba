package no.nordicsemi.android.log;

import android.net.Uri;
import android.net.Uri.Builder;
import android.provider.BaseColumns;

public class LogContract
{
  public static final String AUTHORITY = "no.nordicsemi.android.log";
  public static final Uri AUTHORITY_URI = Uri.parse("content://no.nordicsemi.android.log");
  
  public static final class Application
    implements BaseColumns, LogContract.ApplicationColumns
  {
    public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/no.nordicsemi.android.log.application";
    public static final String CONTENT_TYPE = "vnd.android.cursor.dir/no.nordicsemi.android.log.applications";
    public static final Uri CONTENT_URI = Uri.withAppendedPath(LogContract.AUTHORITY_URI, "application");
  }
  
  protected static abstract interface ApplicationColumns
  {
    public static final String APPLICATION = "application";
  }
  
  public static final class Log
    implements BaseColumns, LogContract.LogColumns
  {
    public static final String CONTENT_DIRECTORY = "log";
    public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/no.nordicsemi.android.log.entry";
    public static final String CONTENT_TYPE = "vnd.android.cursor.dir/no.nordicsemi.android.log.enties";
    
    public static Uri createUri(long paramLong)
    {
      return LogContract.Session.CONTENT_URI.buildUpon().appendEncodedPath(String.valueOf(paramLong)).appendEncodedPath("log").build();
    }
    
    public static Uri createUri(String paramString, int paramInt)
    {
      return LogContract.Session.CONTENT_URI.buildUpon().appendEncodedPath("key").appendEncodedPath(paramString).appendEncodedPath(String.valueOf(paramInt)).appendEncodedPath("log").build();
    }
    
    public final class Level
    {
      public static final int DEBUG = 0;
      public static final int ERROR = 20;
      public static final int INFO = 5;
      public static final int VERBOSE = 1;
      public static final int WARNING = 15;
      
      private Level() {}
    }
  }
  
  protected static abstract interface LogColumns
  {
    public static final String DATA = "data";
    public static final String LEVEL = "level";
    public static final String SESSION_ID = "session_id";
    public static final String TIME = "time";
  }
  
  public static final class Session
    implements BaseColumns, LogContract.SessionColumns
  {
    public static final String APPLICATION_CONTENT_DIRECTORY = "application";
    public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/no.nordicsemi.android.log.session";
    public static final String CONTENT_TYPE = "vnd.android.cursor.dir/no.nordicsemi.android.log.sessions";
    public static final Uri CONTENT_URI = Uri.withAppendedPath(LogContract.AUTHORITY_URI, "session");
    public static final String KEY_CONTENT_DIRECTORY = "key";
    
    public static Uri createSessionsUri(long paramLong)
    {
      return CONTENT_URI.buildUpon().appendEncodedPath("application").appendEncodedPath(String.valueOf(paramLong)).build();
    }
    
    public static Uri createUri(long paramLong)
    {
      return CONTENT_URI.buildUpon().appendEncodedPath(String.valueOf(paramLong)).build();
    }
    
    public static Uri createUri(String paramString, int paramInt)
    {
      return CONTENT_URI.buildUpon().appendEncodedPath("key").appendEncodedPath(paramString).appendEncodedPath(String.valueOf(paramInt)).build();
    }
    
    public static final class Content
    {
      public static final String CONTENT = "content";
    }
  }
  
  protected static abstract interface SessionColumns
  {
    public static final String APPLICATION_ID = "application_id";
    public static final String CREATED_AT = "created_at";
    public static final String DESCRIPTION = "description";
    public static final String KEY = "key";
    public static final String MARK = "mark";
    public static final String NAME = "name";
    public static final String NUMBER = "number";
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\no\nordicsemi\android\log\LogContract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */