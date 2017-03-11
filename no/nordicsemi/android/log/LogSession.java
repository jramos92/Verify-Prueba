package no.nordicsemi.android.log;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;

public class LogSession
{
  final Context context;
  final Uri sessionUri;
  
  LogSession(Context paramContext, Uri paramUri)
  {
    this.context = paramContext;
    this.sessionUri = paramUri;
  }
  
  public Uri getSessionContentUri()
  {
    return this.sessionUri.buildUpon().appendEncodedPath("log").appendEncodedPath("content").build();
  }
  
  public Uri getSessionEntriesUri()
  {
    return this.sessionUri.buildUpon().appendEncodedPath("log").build();
  }
  
  public Uri getSessionUri()
  {
    return this.sessionUri;
  }
  
  public Uri getSessionsUri()
  {
    try
    {
      Cursor localCursor = this.context.getContentResolver().query(this.sessionUri, new String[] { "application_id" }, null, null, null);
      try
      {
        if (localCursor.moveToNext())
        {
          Uri localUri = LogContract.Session.createSessionsUri(localCursor.getLong(0));
          return localUri;
        }
        return null;
      }
      finally
      {
        localCursor.close();
      }
      return null;
    }
    catch (Exception localException) {}
  }
  
  public String toString()
  {
    return this.sessionUri.toString();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\no\nordicsemi\android\log\LogSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */