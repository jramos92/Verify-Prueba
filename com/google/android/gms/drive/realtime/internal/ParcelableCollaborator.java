package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableCollaborator
  implements SafeParcelable
{
  public static final Parcelable.Creator<ParcelableCollaborator> CREATOR = new zzq();
  final int mVersionCode;
  final String zzGY;
  final String zzHP;
  final String zzTa;
  final String zzaoA;
  final boolean zzaox;
  final boolean zzaoy;
  final String zzaoz;
  
  ParcelableCollaborator(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.mVersionCode = paramInt;
    this.zzaox = paramBoolean1;
    this.zzaoy = paramBoolean2;
    this.zzHP = paramString1;
    this.zzGY = paramString2;
    this.zzTa = paramString3;
    this.zzaoz = paramString4;
    this.zzaoA = paramString5;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof ParcelableCollaborator)) {
      return false;
    }
    paramObject = (ParcelableCollaborator)paramObject;
    return this.zzHP.equals(((ParcelableCollaborator)paramObject).zzHP);
  }
  
  public int hashCode()
  {
    return this.zzHP.hashCode();
  }
  
  public String toString()
  {
    return "Collaborator [isMe=" + this.zzaox + ", isAnonymous=" + this.zzaoy + ", sessionId=" + this.zzHP + ", userId=" + this.zzGY + ", displayName=" + this.zzTa + ", color=" + this.zzaoz + ", photoUrl=" + this.zzaoA + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzq.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\realtime\internal\ParcelableCollaborator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */