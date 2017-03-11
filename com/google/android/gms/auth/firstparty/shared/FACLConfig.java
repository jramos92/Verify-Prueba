package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class FACLConfig
  implements SafeParcelable
{
  public static final zza CREATOR = new zza();
  final int version;
  boolean zzTA;
  boolean zzTB;
  boolean zzTC;
  boolean zzTx;
  String zzTy;
  boolean zzTz;
  
  FACLConfig(int paramInt, boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    this.version = paramInt;
    this.zzTx = paramBoolean1;
    this.zzTy = paramString;
    this.zzTz = paramBoolean2;
    this.zzTA = paramBoolean3;
    this.zzTB = paramBoolean4;
    this.zzTC = paramBoolean5;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof FACLConfig))
    {
      paramObject = (FACLConfig)paramObject;
      bool1 = bool2;
      if (this.zzTx == ((FACLConfig)paramObject).zzTx)
      {
        bool1 = bool2;
        if (TextUtils.equals(this.zzTy, ((FACLConfig)paramObject).zzTy))
        {
          bool1 = bool2;
          if (this.zzTz == ((FACLConfig)paramObject).zzTz)
          {
            bool1 = bool2;
            if (this.zzTA == ((FACLConfig)paramObject).zzTA)
            {
              bool1 = bool2;
              if (this.zzTB == ((FACLConfig)paramObject).zzTB)
              {
                bool1 = bool2;
                if (this.zzTC == ((FACLConfig)paramObject).zzTC) {
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Boolean.valueOf(this.zzTx), this.zzTy, Boolean.valueOf(this.zzTz), Boolean.valueOf(this.zzTA), Boolean.valueOf(this.zzTB), Boolean.valueOf(this.zzTC) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\auth\firstparty\shared\FACLConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */