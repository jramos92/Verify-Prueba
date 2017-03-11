package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;

public class zzh
  implements DialogInterface.OnClickListener
{
  private final Activity mActivity;
  private final Intent mIntent;
  private final int zzaaY;
  private final Fragment zzafl;
  
  public zzh(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    this.mActivity = paramActivity;
    this.zzafl = null;
    this.mIntent = paramIntent;
    this.zzaaY = paramInt;
  }
  
  public zzh(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    this.mActivity = null;
    this.zzafl = paramFragment;
    this.mIntent = paramIntent;
    this.zzaaY = paramInt;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if ((this.mIntent != null) && (this.zzafl != null)) {
        this.zzafl.startActivityForResult(this.mIntent, this.zzaaY);
      }
      for (;;)
      {
        paramDialogInterface.dismiss();
        return;
        if (this.mIntent != null) {
          this.mActivity.startActivityForResult(this.mIntent, this.zzaaY);
        }
      }
      return;
    }
    catch (ActivityNotFoundException paramDialogInterface)
    {
      Log.e("SettingsRedirect", "Can't redirect to app settings for Google Play services");
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\common\internal\zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */