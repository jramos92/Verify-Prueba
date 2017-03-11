package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.internal.zzoj;
import com.google.android.gms.internal.zzoj.zza;

public class SubscribeRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<SubscribeRequest> CREATOR = new zzac();
  private final int mVersionCode;
  private final zzoj zzasb;
  private Subscription zzata;
  private final boolean zzatb;
  
  SubscribeRequest(int paramInt, Subscription paramSubscription, boolean paramBoolean, IBinder paramIBinder)
  {
    this.mVersionCode = paramInt;
    this.zzata = paramSubscription;
    this.zzatb = paramBoolean;
    this.zzasb = zzoj.zza.zzbJ(paramIBinder);
  }
  
  public SubscribeRequest(Subscription paramSubscription, boolean paramBoolean, zzoj paramzzoj)
  {
    this.mVersionCode = 3;
    this.zzata = paramSubscription;
    this.zzatb = paramBoolean;
    this.zzasb = paramzzoj;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("subscription", this.zzata).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzac.zza(this, paramParcel, paramInt);
  }
  
  public IBinder zzsO()
  {
    if (this.zzasb == null) {
      return null;
    }
    return this.zzasb.asBinder();
  }
  
  public Subscription zztl()
  {
    return this.zzata;
  }
  
  public boolean zztm()
  {
    return this.zzatb;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\request\SubscribeRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */