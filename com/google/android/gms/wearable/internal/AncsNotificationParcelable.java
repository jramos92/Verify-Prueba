package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.zzd;

public class AncsNotificationParcelable
  implements SafeParcelable, zzd
{
  public static final Parcelable.Creator<AncsNotificationParcelable> CREATOR = new zzh();
  private int mId;
  final int mVersionCode;
  private String zzTa;
  private final String zzVP;
  private final String zzaLl;
  private final String zzajf;
  private final String zzauO;
  private final String zzbfG;
  private byte zzbfH;
  private byte zzbfI;
  private byte zzbfJ;
  private byte zzbfK;
  
  AncsNotificationParcelable(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4)
  {
    this.mId = paramInt2;
    this.mVersionCode = paramInt1;
    this.zzaLl = paramString1;
    this.zzbfG = paramString2;
    this.zzVP = paramString3;
    this.zzajf = paramString4;
    this.zzauO = paramString5;
    this.zzTa = paramString6;
    this.zzbfH = paramByte1;
    this.zzbfI = paramByte2;
    this.zzbfJ = paramByte3;
    this.zzbfK = paramByte4;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (AncsNotificationParcelable)paramObject;
      if (this.zzbfK != ((AncsNotificationParcelable)paramObject).zzbfK) {
        return false;
      }
      if (this.zzbfJ != ((AncsNotificationParcelable)paramObject).zzbfJ) {
        return false;
      }
      if (this.zzbfI != ((AncsNotificationParcelable)paramObject).zzbfI) {
        return false;
      }
      if (this.zzbfH != ((AncsNotificationParcelable)paramObject).zzbfH) {
        return false;
      }
      if (this.mId != ((AncsNotificationParcelable)paramObject).mId) {
        return false;
      }
      if (this.mVersionCode != ((AncsNotificationParcelable)paramObject).mVersionCode) {
        return false;
      }
      if (!this.zzaLl.equals(((AncsNotificationParcelable)paramObject).zzaLl)) {
        return false;
      }
      if (this.zzbfG != null)
      {
        if (this.zzbfG.equals(((AncsNotificationParcelable)paramObject).zzbfG)) {}
      }
      else {
        while (((AncsNotificationParcelable)paramObject).zzbfG != null) {
          return false;
        }
      }
      if (!this.zzTa.equals(((AncsNotificationParcelable)paramObject).zzTa)) {
        return false;
      }
      if (!this.zzVP.equals(((AncsNotificationParcelable)paramObject).zzVP)) {
        return false;
      }
      if (!this.zzauO.equals(((AncsNotificationParcelable)paramObject).zzauO)) {
        return false;
      }
    } while (this.zzajf.equals(((AncsNotificationParcelable)paramObject).zzajf));
    return false;
  }
  
  public String getDisplayName()
  {
    if (this.zzTa == null) {
      return this.zzaLl;
    }
    return this.zzTa;
  }
  
  public int getId()
  {
    return this.mId;
  }
  
  public String getTitle()
  {
    return this.zzajf;
  }
  
  public int hashCode()
  {
    int j = this.mVersionCode;
    int k = this.mId;
    int m = this.zzaLl.hashCode();
    if (this.zzbfG != null) {}
    for (int i = this.zzbfG.hashCode();; i = 0) {
      return ((((((((i + ((j * 31 + k) * 31 + m) * 31) * 31 + this.zzVP.hashCode()) * 31 + this.zzajf.hashCode()) * 31 + this.zzauO.hashCode()) * 31 + this.zzTa.hashCode()) * 31 + this.zzbfH) * 31 + this.zzbfI) * 31 + this.zzbfJ) * 31 + this.zzbfK;
    }
  }
  
  public String toString()
  {
    return "AncsNotificationParcelable{mVersionCode=" + this.mVersionCode + ", mId=" + this.mId + ", mAppId='" + this.zzaLl + '\'' + ", mDateTime='" + this.zzbfG + '\'' + ", mNotificationText='" + this.zzVP + '\'' + ", mTitle='" + this.zzajf + '\'' + ", mSubtitle='" + this.zzauO + '\'' + ", mDisplayName='" + this.zzTa + '\'' + ", mEventId=" + this.zzbfH + ", mEventFlags=" + this.zzbfI + ", mCategoryId=" + this.zzbfJ + ", mCategoryCount=" + this.zzbfK + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
  
  public String zzER()
  {
    return this.zzbfG;
  }
  
  public String zzES()
  {
    return this.zzVP;
  }
  
  public byte zzET()
  {
    return this.zzbfH;
  }
  
  public byte zzEU()
  {
    return this.zzbfI;
  }
  
  public byte zzEV()
  {
    return this.zzbfJ;
  }
  
  public byte zzEW()
  {
    return this.zzbfK;
  }
  
  public String zzuM()
  {
    return this.zzaLl;
  }
  
  public String zzuc()
  {
    return this.zzauO;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\internal\AncsNotificationParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */