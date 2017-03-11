package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;

public class SessionDataSet
  implements SafeParcelable
{
  public static final Parcelable.Creator<SessionDataSet> CREATOR = new zzq();
  final int mVersionCode;
  private final Session zzapP;
  private final DataSet zzarb;
  
  SessionDataSet(int paramInt, Session paramSession, DataSet paramDataSet)
  {
    this.mVersionCode = paramInt;
    this.zzapP = paramSession;
    this.zzarb = paramDataSet;
  }
  
  private boolean zza(SessionDataSet paramSessionDataSet)
  {
    return (zzw.equal(this.zzapP, paramSessionDataSet.zzapP)) && (zzw.equal(this.zzarb, paramSessionDataSet.zzarb));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof SessionDataSet)) && (zza((SessionDataSet)paramObject)));
  }
  
  public Session getSession()
  {
    return this.zzapP;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzapP, this.zzarb });
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("session", this.zzapP).zzg("dataSet", this.zzarb).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzq.zza(this, paramParcel, paramInt);
  }
  
  public DataSet zzsA()
  {
    return this.zzarb;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\data\SessionDataSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */