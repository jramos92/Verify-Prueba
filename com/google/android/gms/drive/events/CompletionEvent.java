package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.zzap;
import com.google.android.gms.drive.internal.zzap.zza;
import com.google.android.gms.drive.internal.zzz;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.zzmt;
import com.google.android.gms.internal.zznd;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class CompletionEvent
  implements SafeParcelable, ResourceEvent
{
  public static final Parcelable.Creator<CompletionEvent> CREATOR = new zze();
  public static final int STATUS_CANCELED = 3;
  public static final int STATUS_CONFLICT = 2;
  public static final int STATUS_FAILURE = 1;
  public static final int STATUS_SUCCESS = 0;
  final int mVersionCode;
  final String zzRs;
  final DriveId zzaiA;
  final ParcelFileDescriptor zzajC;
  final ParcelFileDescriptor zzajD;
  final MetadataBundle zzajE;
  final List<String> zzajF;
  final IBinder zzajG;
  private boolean zzajH = false;
  private boolean zzajI = false;
  private boolean zzajJ = false;
  final int zzys;
  
  CompletionEvent(int paramInt1, DriveId paramDriveId, String paramString, ParcelFileDescriptor paramParcelFileDescriptor1, ParcelFileDescriptor paramParcelFileDescriptor2, MetadataBundle paramMetadataBundle, List<String> paramList, int paramInt2, IBinder paramIBinder)
  {
    this.mVersionCode = paramInt1;
    this.zzaiA = paramDriveId;
    this.zzRs = paramString;
    this.zzajC = paramParcelFileDescriptor1;
    this.zzajD = paramParcelFileDescriptor2;
    this.zzajE = paramMetadataBundle;
    this.zzajF = paramList;
    this.zzys = paramInt2;
    this.zzajG = paramIBinder;
  }
  
  private void zzre()
  {
    if (this.zzajJ) {
      throw new IllegalStateException("Event has already been dismissed or snoozed.");
    }
  }
  
  private void zzt(boolean paramBoolean)
  {
    zzre();
    this.zzajJ = true;
    zzmt.zza(this.zzajC);
    zzmt.zza(this.zzajD);
    if ((this.zzajE != null) && (this.zzajE.zzc(zznd.zzano))) {
      ((BitmapTeleporter)this.zzajE.zza(zznd.zzano)).release();
    }
    if (this.zzajG == null)
    {
      StringBuilder localStringBuilder1 = new StringBuilder().append("No callback on ");
      if (paramBoolean) {}
      for (str = "snooze";; str = "dismiss")
      {
        zzz.zzz("CompletionEvent", str);
        return;
      }
    }
    StringBuilder localStringBuilder2;
    try
    {
      zzap.zza.zzaV(this.zzajG).zzt(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localStringBuilder2 = new StringBuilder().append("RemoteException on ");
      if (!paramBoolean) {}
    }
    for (String str = "snooze";; str = "dismiss")
    {
      zzz.zzz("CompletionEvent", str + ": " + localRemoteException);
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void dismiss()
  {
    zzt(false);
  }
  
  public String getAccountName()
  {
    zzre();
    return this.zzRs;
  }
  
  public InputStream getBaseContentsInputStream()
  {
    zzre();
    if (this.zzajC == null) {
      return null;
    }
    if (this.zzajH) {
      throw new IllegalStateException("getBaseInputStream() can only be called once per CompletionEvent instance.");
    }
    this.zzajH = true;
    return new FileInputStream(this.zzajC.getFileDescriptor());
  }
  
  public DriveId getDriveId()
  {
    zzre();
    return this.zzaiA;
  }
  
  public InputStream getModifiedContentsInputStream()
  {
    zzre();
    if (this.zzajD == null) {
      return null;
    }
    if (this.zzajI) {
      throw new IllegalStateException("getModifiedInputStream() can only be called once per CompletionEvent instance.");
    }
    this.zzajI = true;
    return new FileInputStream(this.zzajD.getFileDescriptor());
  }
  
  public MetadataChangeSet getModifiedMetadataChangeSet()
  {
    zzre();
    if (this.zzajE != null) {
      return new MetadataChangeSet(this.zzajE);
    }
    return null;
  }
  
  public int getStatus()
  {
    zzre();
    return this.zzys;
  }
  
  public List<String> getTrackingTags()
  {
    zzre();
    return new ArrayList(this.zzajF);
  }
  
  public int getType()
  {
    return 2;
  }
  
  public void snooze()
  {
    zzt(true);
  }
  
  public String toString()
  {
    if (this.zzajF == null) {}
    for (String str = "<null>";; str = "'" + TextUtils.join("','", this.zzajF) + "'") {
      return String.format(Locale.US, "CompletionEvent [id=%s, status=%s, trackingTag=%s]", new Object[] { this.zzaiA, Integer.valueOf(this.zzys), str });
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt | 0x1);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\events\CompletionEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */