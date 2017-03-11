package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender.SendIntentException;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;

public final class Status
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<Status> CREATOR = new zzd();
  public static final Status zzabb = new Status(0);
  public static final Status zzabc = new Status(14);
  public static final Status zzabd = new Status(8);
  public static final Status zzabe = new Status(15);
  public static final Status zzabf = new Status(16);
  private final PendingIntent mPendingIntent;
  private final int mVersionCode;
  private final int zzYm;
  private final String zzZZ;
  
  public Status(int paramInt)
  {
    this(paramInt, null);
  }
  
  Status(int paramInt1, int paramInt2, String paramString, PendingIntent paramPendingIntent)
  {
    this.mVersionCode = paramInt1;
    this.zzYm = paramInt2;
    this.zzZZ = paramString;
    this.mPendingIntent = paramPendingIntent;
  }
  
  public Status(int paramInt, String paramString)
  {
    this(1, paramInt, paramString, null);
  }
  
  public Status(int paramInt, String paramString, PendingIntent paramPendingIntent)
  {
    this(1, paramInt, paramString, paramPendingIntent);
  }
  
  private String zznI()
  {
    if (this.zzZZ != null) {
      return this.zzZZ;
    }
    return CommonStatusCodes.getStatusCodeString(this.zzYm);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Status)) {}
    do
    {
      return false;
      paramObject = (Status)paramObject;
    } while ((this.mVersionCode != ((Status)paramObject).mVersionCode) || (this.zzYm != ((Status)paramObject).zzYm) || (!zzw.equal(this.zzZZ, ((Status)paramObject).zzZZ)) || (!zzw.equal(this.mPendingIntent, ((Status)paramObject).mPendingIntent)));
    return true;
  }
  
  public PendingIntent getResolution()
  {
    return this.mPendingIntent;
  }
  
  public Status getStatus()
  {
    return this;
  }
  
  public int getStatusCode()
  {
    return this.zzYm;
  }
  
  public String getStatusMessage()
  {
    return this.zzZZ;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public boolean hasResolution()
  {
    return this.mPendingIntent != null;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(this.mVersionCode), Integer.valueOf(this.zzYm), this.zzZZ, this.mPendingIntent });
  }
  
  public boolean isCanceled()
  {
    return this.zzYm == 16;
  }
  
  public boolean isInterrupted()
  {
    return this.zzYm == 14;
  }
  
  public boolean isSuccess()
  {
    return this.zzYm <= 0;
  }
  
  public void startResolutionForResult(Activity paramActivity, int paramInt)
    throws IntentSender.SendIntentException
  {
    if (!hasResolution()) {
      return;
    }
    paramActivity.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), paramInt, null, 0, 0, 0);
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("statusCode", zznI()).zzg("resolution", this.mPendingIntent).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
  
  PendingIntent zznH()
  {
    return this.mPendingIntent;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\common\api\Status.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */