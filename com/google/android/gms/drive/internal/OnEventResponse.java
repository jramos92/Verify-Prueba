package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangesAvailableEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.ProgressEvent;
import com.google.android.gms.drive.events.QueryResultEventParcelable;

public class OnEventResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnEventResponse> CREATOR = new zzbb();
  final int mVersionCode;
  final int zzaho;
  final ChangeEvent zzame;
  final CompletionEvent zzamf;
  final QueryResultEventParcelable zzamg;
  final ChangesAvailableEvent zzamh;
  final ProgressEvent zzami;
  
  OnEventResponse(int paramInt1, int paramInt2, ChangeEvent paramChangeEvent, CompletionEvent paramCompletionEvent, QueryResultEventParcelable paramQueryResultEventParcelable, ChangesAvailableEvent paramChangesAvailableEvent, ProgressEvent paramProgressEvent)
  {
    this.mVersionCode = paramInt1;
    this.zzaho = paramInt2;
    this.zzame = paramChangeEvent;
    this.zzamf = paramCompletionEvent;
    this.zzamg = paramQueryResultEventParcelable;
    this.zzamh = paramChangesAvailableEvent;
    this.zzami = paramProgressEvent;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbb.zza(this, paramParcel, paramInt);
  }
  
  public DriveEvent zzrA()
  {
    switch (this.zzaho)
    {
    default: 
      throw new IllegalStateException("Unexpected event type " + this.zzaho);
    case 1: 
      return this.zzame;
    case 2: 
      return this.zzamf;
    case 3: 
      return this.zzamg;
    case 4: 
      return this.zzamh;
    }
    return this.zzami;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\OnEventResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */