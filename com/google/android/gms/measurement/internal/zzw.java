package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzx;

public class zzw
  extends zzm.zza
{
  private final zzv zzaKG;
  private final boolean zzaOf;
  
  public zzw(zzv paramzzv)
  {
    zzx.zzw(paramzzv);
    this.zzaKG = paramzzv;
    this.zzaOf = false;
  }
  
  public zzw(zzv paramzzv, boolean paramBoolean)
  {
    zzx.zzw(paramzzv);
    this.zzaKG = paramzzv;
    this.zzaOf = paramBoolean;
  }
  
  private void zzed(String paramString)
    throws SecurityException
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.zzaKG.zzyd().zzzK().zzec("Measurement Service called without app package");
      throw new SecurityException("Measurement Service called without app package");
    }
    try
    {
      zzee(paramString);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      this.zzaKG.zzyd().zzzK().zzj("Measurement Service called with invalid calling package", paramString);
      throw localSecurityException;
    }
  }
  
  private void zzee(String paramString)
    throws SecurityException
  {
    int i;
    if (this.zzaOf)
    {
      i = Process.myUid();
      if (!GooglePlayServicesUtil.zzb(this.zzaKG.getContext(), i, paramString)) {
        break label34;
      }
    }
    label34:
    while ((GooglePlayServicesUtil.zze(this.zzaKG.getContext(), i)) && (!this.zzaKG.zzAi()))
    {
      return;
      i = Binder.getCallingUid();
      break;
    }
    throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[] { paramString }));
  }
  
  public void zza(final AppMetadata paramAppMetadata)
  {
    zzx.zzw(paramAppMetadata);
    zzed(paramAppMetadata.packageName);
    this.zzaKG.zzzr().zzh(new Runnable()
    {
      public void run()
      {
        zzw.zza(zzw.this).zzb(paramAppMetadata);
      }
    });
  }
  
  public void zza(final EventParcel paramEventParcel, final AppMetadata paramAppMetadata)
  {
    zzx.zzw(paramEventParcel);
    zzx.zzw(paramAppMetadata);
    zzed(paramAppMetadata.packageName);
    this.zzaKG.zzzr().zzh(new Runnable()
    {
      public void run()
      {
        zzw.zza(zzw.this).zzb(paramEventParcel, paramAppMetadata);
      }
    });
  }
  
  public void zza(final UserAttributeParcel paramUserAttributeParcel, final AppMetadata paramAppMetadata)
  {
    zzx.zzw(paramUserAttributeParcel);
    zzx.zzw(paramAppMetadata);
    zzed(paramAppMetadata.packageName);
    if (paramUserAttributeParcel.getValue() == null)
    {
      this.zzaKG.zzzr().zzh(new Runnable()
      {
        public void run()
        {
          zzw.zza(zzw.this).zzc(paramUserAttributeParcel, paramAppMetadata);
        }
      });
      return;
    }
    this.zzaKG.zzzr().zzh(new Runnable()
    {
      public void run()
      {
        zzw.zza(zzw.this).zzb(paramUserAttributeParcel, paramAppMetadata);
      }
    });
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\measurement\internal\zzw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */