package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AddListenerRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<AddListenerRequest> CREATOR = new zzc();
  final int mVersionCode;
  public final IntentFilter[] zzbfA;
  public final String zzbfB;
  public final String zzbfC;
  public final zzaw zzbfz;
  
  AddListenerRequest(int paramInt, IBinder paramIBinder, IntentFilter[] paramArrayOfIntentFilter, String paramString1, String paramString2)
  {
    this.mVersionCode = paramInt;
    if (paramIBinder != null) {}
    for (this.zzbfz = zzaw.zza.zzef(paramIBinder);; this.zzbfz = null)
    {
      this.zzbfA = paramArrayOfIntentFilter;
      this.zzbfB = paramString1;
      this.zzbfC = paramString2;
      return;
    }
  }
  
  public AddListenerRequest(zzbp paramzzbp)
  {
    this.mVersionCode = 1;
    this.zzbfz = paramzzbp;
    this.zzbfA = paramzzbp.zzFe();
    this.zzbfB = paramzzbp.zzFf();
    this.zzbfC = paramzzbp.zzFg();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
  
  IBinder zzEO()
  {
    if (this.zzbfz == null) {
      return null;
    }
    return this.zzbfz.asBinder();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\internal\AddListenerRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */