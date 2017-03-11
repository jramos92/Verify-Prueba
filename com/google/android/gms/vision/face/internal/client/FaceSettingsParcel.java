package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FaceSettingsParcel
  implements SafeParcelable
{
  public static final zzb CREATOR = new zzb();
  public int mode;
  public final int versionCode;
  public int zzbbX;
  public int zzbbY;
  public boolean zzbbZ;
  public boolean zzbca;
  
  public FaceSettingsParcel()
  {
    this.versionCode = 1;
  }
  
  public FaceSettingsParcel(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.versionCode = paramInt1;
    this.mode = paramInt2;
    this.zzbbX = paramInt3;
    this.zzbbY = paramInt4;
    this.zzbbZ = paramBoolean1;
    this.zzbca = paramBoolean2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\vision\face\internal\client\FaceSettingsParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */