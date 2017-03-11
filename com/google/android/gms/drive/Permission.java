package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class Permission
  implements SafeParcelable
{
  public static final Parcelable.Creator<Permission> CREATOR = new zzi();
  final int mVersionCode;
  private String zzajj;
  private int zzajk;
  private String zzajl;
  private String zzajm;
  private int zzajn;
  private boolean zzajo;
  
  Permission(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, int paramInt3, boolean paramBoolean)
  {
    this.mVersionCode = paramInt1;
    this.zzajj = paramString1;
    this.zzajk = paramInt2;
    this.zzajl = paramString2;
    this.zzajm = paramString3;
    this.zzajn = paramInt3;
    this.zzajo = paramBoolean;
  }
  
  public static boolean zzcm(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean zzcn(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramObject == null) || (paramObject.getClass() != getClass())) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == this);
      paramObject = (Permission)paramObject;
      if ((!zzw.equal(this.zzajj, ((Permission)paramObject).zzajj)) || (this.zzajk != ((Permission)paramObject).zzajk) || (this.zzajn != ((Permission)paramObject).zzajn)) {
        break;
      }
      bool1 = bool2;
    } while (this.zzajo == ((Permission)paramObject).zzajo);
    return false;
  }
  
  public int getRole()
  {
    if (!zzcn(this.zzajn)) {
      return -1;
    }
    return this.zzajn;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzajj, Integer.valueOf(this.zzajk), Integer.valueOf(this.zzajn), Boolean.valueOf(this.zzajo) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
  
  public String zzqY()
  {
    if (!zzcm(this.zzajk)) {
      return null;
    }
    return this.zzajj;
  }
  
  public int zzqZ()
  {
    if (!zzcm(this.zzajk)) {
      return -1;
    }
    return this.zzajk;
  }
  
  public String zzra()
  {
    return this.zzajl;
  }
  
  public String zzrb()
  {
    return this.zzajm;
  }
  
  public boolean zzrc()
  {
    return this.zzajo;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\Permission.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */