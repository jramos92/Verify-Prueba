package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public class AccountChangeEvent
  implements SafeParcelable
{
  public static final Parcelable.Creator<AccountChangeEvent> CREATOR = new zza();
  final int mVersion;
  final long zzRr;
  final String zzRs;
  final int zzRt;
  final int zzRu;
  final String zzRv;
  
  AccountChangeEvent(int paramInt1, long paramLong, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    this.mVersion = paramInt1;
    this.zzRr = paramLong;
    this.zzRs = ((String)zzx.zzw(paramString1));
    this.zzRt = paramInt2;
    this.zzRu = paramInt3;
    this.zzRv = paramString2;
  }
  
  public AccountChangeEvent(long paramLong, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.mVersion = 1;
    this.zzRr = paramLong;
    this.zzRs = ((String)zzx.zzw(paramString1));
    this.zzRt = paramInt1;
    this.zzRu = paramInt2;
    this.zzRv = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof AccountChangeEvent)) {
        break;
      }
      paramObject = (AccountChangeEvent)paramObject;
    } while ((this.mVersion == ((AccountChangeEvent)paramObject).mVersion) && (this.zzRr == ((AccountChangeEvent)paramObject).zzRr) && (zzw.equal(this.zzRs, ((AccountChangeEvent)paramObject).zzRs)) && (this.zzRt == ((AccountChangeEvent)paramObject).zzRt) && (this.zzRu == ((AccountChangeEvent)paramObject).zzRu) && (zzw.equal(this.zzRv, ((AccountChangeEvent)paramObject).zzRv)));
    return false;
    return false;
  }
  
  public String getAccountName()
  {
    return this.zzRs;
  }
  
  public String getChangeData()
  {
    return this.zzRv;
  }
  
  public int getChangeType()
  {
    return this.zzRt;
  }
  
  public int getEventIndex()
  {
    return this.zzRu;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(this.mVersion), Long.valueOf(this.zzRr), this.zzRs, Integer.valueOf(this.zzRt), Integer.valueOf(this.zzRu), this.zzRv });
  }
  
  public String toString()
  {
    String str = "UNKNOWN";
    switch (this.zzRt)
    {
    }
    for (;;)
    {
      return "AccountChangeEvent {accountName = " + this.zzRs + ", changeType = " + str + ", changeData = " + this.zzRv + ", eventIndex = " + this.zzRu + "}";
      str = "ADDED";
      continue;
      str = "REMOVED";
      continue;
      str = "RENAMED_TO";
      continue;
      str = "RENAMED_FROM";
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\auth\AccountChangeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */