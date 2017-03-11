package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Contents
  implements SafeParcelable
{
  public static final Parcelable.Creator<Contents> CREATOR = new zzb();
  final int mVersionCode;
  final ParcelFileDescriptor zzadS;
  final DriveId zzaiA;
  final boolean zzaiB;
  final int zzaiy;
  final int zzaiz;
  final String zzrW;
  
  Contents(int paramInt1, ParcelFileDescriptor paramParcelFileDescriptor, int paramInt2, int paramInt3, DriveId paramDriveId, boolean paramBoolean, String paramString)
  {
    this.mVersionCode = paramInt1;
    this.zzadS = paramParcelFileDescriptor;
    this.zzaiy = paramInt2;
    this.zzaiz = paramInt3;
    this.zzaiA = paramDriveId;
    this.zzaiB = paramBoolean;
    this.zzrW = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public DriveId getDriveId()
  {
    return this.zzaiA;
  }
  
  public InputStream getInputStream()
  {
    return new FileInputStream(this.zzadS.getFileDescriptor());
  }
  
  public int getMode()
  {
    return this.zzaiz;
  }
  
  public OutputStream getOutputStream()
  {
    return new FileOutputStream(this.zzadS.getFileDescriptor());
  }
  
  public ParcelFileDescriptor getParcelFileDescriptor()
  {
    return this.zzadS;
  }
  
  public int getRequestId()
  {
    return this.zzaiy;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public boolean zzqM()
  {
    return this.zzaiB;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\Contents.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */