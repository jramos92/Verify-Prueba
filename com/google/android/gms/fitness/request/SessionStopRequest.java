package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.internal.zzoi;
import com.google.android.gms.internal.zzoi.zza;

public class SessionStopRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<SessionStopRequest> CREATOR = new zzy();
  private final String mName;
  private final int mVersionCode;
  private final String zzaqY;
  private final zzoi zzasX;
  
  SessionStopRequest(int paramInt, String paramString1, String paramString2, IBinder paramIBinder)
  {
    this.mVersionCode = paramInt;
    this.mName = paramString1;
    this.zzaqY = paramString2;
    this.zzasX = zzoi.zza.zzbI(paramIBinder);
  }
  
  public SessionStopRequest(String paramString1, String paramString2, zzoi paramzzoi)
  {
    this.mVersionCode = 3;
    this.mName = paramString1;
    this.zzaqY = paramString2;
    this.zzasX = paramzzoi;
  }
  
  private boolean zzb(SessionStopRequest paramSessionStopRequest)
  {
    return (zzw.equal(this.mName, paramSessionStopRequest.mName)) && (zzw.equal(this.zzaqY, paramSessionStopRequest.zzaqY));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof SessionStopRequest)) && (zzb((SessionStopRequest)paramObject)));
  }
  
  public String getIdentifier()
  {
    return this.zzaqY;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.mName, this.zzaqY });
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("name", this.mName).zzg("identifier", this.zzaqY).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzy.zza(this, paramParcel, paramInt);
  }
  
  public IBinder zzsO()
  {
    if (this.zzasX == null) {
      return null;
    }
    return this.zzasX.asBinder();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\request\SessionStopRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */