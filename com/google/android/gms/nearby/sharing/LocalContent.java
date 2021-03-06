package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class LocalContent
  implements SafeParcelable
{
  public static final Parcelable.Creator<LocalContent> CREATOR = new zzb();
  private int type;
  private final int versionCode;
  private String zzaRl;
  
  private LocalContent()
  {
    this.versionCode = 1;
  }
  
  LocalContent(int paramInt1, int paramInt2, String paramString)
  {
    this.versionCode = paramInt1;
    this.type = paramInt2;
    this.zzaRl = paramString;
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
      if (!(paramObject instanceof LocalContent)) {
        return false;
      }
      paramObject = (LocalContent)paramObject;
    } while ((zzw.equal(Integer.valueOf(this.type), Integer.valueOf(((LocalContent)paramObject).type))) && (zzw.equal(this.zzaRl, ((LocalContent)paramObject).zzaRl)));
    return false;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  int getVersionCode()
  {
    return this.versionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(this.type), this.zzaRl });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("LocalContent[contentUri=").append(this.zzaRl).append(", type=");
    if (this.type == 1) {}
    for (String str = "PUBLIC_CONTENT";; str = "APP_CONTENT") {
      return str + "]";
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public String zzBj()
  {
    return this.zzaRl;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\sharing\LocalContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */