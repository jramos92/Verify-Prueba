package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.fitness.data.Session;
import java.util.Collections;
import java.util.List;

public class SessionStopResult
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<SessionStopResult> CREATOR = new zzk();
  private final int mVersionCode;
  private final Status zzSC;
  private final List<Session> zzase;
  
  SessionStopResult(int paramInt, Status paramStatus, List<Session> paramList)
  {
    this.mVersionCode = paramInt;
    this.zzSC = paramStatus;
    this.zzase = Collections.unmodifiableList(paramList);
  }
  
  public SessionStopResult(Status paramStatus, List<Session> paramList)
  {
    this.mVersionCode = 3;
    this.zzSC = paramStatus;
    this.zzase = Collections.unmodifiableList(paramList);
  }
  
  public static SessionStopResult zzU(Status paramStatus)
  {
    return new SessionStopResult(paramStatus, Collections.emptyList());
  }
  
  private boolean zzb(SessionStopResult paramSessionStopResult)
  {
    return (this.zzSC.equals(paramSessionStopResult.zzSC)) && (zzw.equal(this.zzase, paramSessionStopResult.zzase));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof SessionStopResult)) && (zzb((SessionStopResult)paramObject)));
  }
  
  public List<Session> getSessions()
  {
    return this.zzase;
  }
  
  public Status getStatus()
  {
    return this.zzSC;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzSC, this.zzase });
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("status", this.zzSC).zzg("sessions", this.zzase).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzk.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\result\SessionStopResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */