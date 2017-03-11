package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Arrays;

public class SharedContent
  implements SafeParcelable
{
  public static final Parcelable.Creator<SharedContent> CREATOR = new zzc();
  private final int versionCode;
  @Deprecated
  private String zzaRm;
  private ViewableItem[] zzaRn;
  private LocalContent[] zzaRo;
  
  private SharedContent()
  {
    this.versionCode = 2;
  }
  
  SharedContent(int paramInt, String paramString, ViewableItem[] paramArrayOfViewableItem, LocalContent[] paramArrayOfLocalContent)
  {
    this.versionCode = paramInt;
    this.zzaRm = paramString;
    this.zzaRn = paramArrayOfViewableItem;
    this.zzaRo = paramArrayOfLocalContent;
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
      if (!(paramObject instanceof SharedContent)) {
        return false;
      }
      paramObject = (SharedContent)paramObject;
    } while ((zzw.equal(this.zzaRn, ((SharedContent)paramObject).zzaRn)) && (zzw.equal(this.zzaRo, ((SharedContent)paramObject).zzaRo)) && (zzw.equal(this.zzaRm, ((SharedContent)paramObject).zzaRm)));
    return false;
  }
  
  public String getUri()
  {
    return this.zzaRm;
  }
  
  int getVersionCode()
  {
    return this.versionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzaRn, this.zzaRo, this.zzaRm });
  }
  
  public String toString()
  {
    return "SharedContent[viewableItems=" + Arrays.toString(this.zzaRn) + ", localContents=" + Arrays.toString(this.zzaRo) + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
  
  public ViewableItem[] zzBk()
  {
    return this.zzaRn;
  }
  
  public LocalContent[] zzBl()
  {
    return this.zzaRo;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\sharing\SharedContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */