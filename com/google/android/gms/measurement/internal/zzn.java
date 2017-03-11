package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;

public class zzn
  extends zzy
{
  private static final X500Principal zzaMG = new X500Principal("CN=Android Debug,O=Android,C=US");
  private String zzOZ;
  private String zzPa;
  private String zzaLL;
  private String zzaLl;
  private String zzaMH;
  private long zzaMI;
  
  zzn(zzv paramzzv)
  {
    super(paramzzv);
  }
  
  static long zzo(byte[] paramArrayOfByte)
  {
    int j = 0;
    zzx.zzw(paramArrayOfByte);
    if (paramArrayOfByte.length > 0) {}
    long l;
    for (boolean bool = true;; bool = false)
    {
      zzx.zzZ(bool);
      l = 0L;
      int i = paramArrayOfByte.length - 1;
      while ((i >= 0) && (i >= paramArrayOfByte.length - 8))
      {
        l += ((paramArrayOfByte[i] & 0xFF) << j);
        j += 8;
        i -= 1;
      }
    }
    return l;
  }
  
  protected void zzhR()
  {
    str2 = "Unknown";
    String str1 = "Unknown";
    PackageManager localPackageManager = getContext().getPackageManager();
    String str3 = getContext().getPackageName();
    Object localObject1 = localPackageManager.getInstallerPackageName(str3);
    Object localObject3;
    if (localObject1 == null) {
      localObject3 = "manual_install";
    }
    for (;;)
    {
      localObject4 = str1;
      try
      {
        PackageInfo localPackageInfo = localPackageManager.getPackageInfo(getContext().getPackageName(), 0);
        localObject1 = str1;
        localObject4 = str2;
        if (localPackageInfo != null)
        {
          localObject4 = str1;
          CharSequence localCharSequence = localPackageManager.getApplicationLabel(localPackageInfo.applicationInfo);
          localObject1 = str1;
          localObject4 = str1;
          if (!TextUtils.isEmpty(localCharSequence))
          {
            localObject4 = str1;
            localObject1 = localCharSequence.toString();
          }
          localObject4 = localObject1;
          str1 = localPackageInfo.versionName;
          localObject4 = str1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException1)
      {
        for (;;)
        {
          zzyd().zzzK().zzj("Error retrieving package info: appName", localObject4);
          localObject2 = localObject4;
          localObject4 = str2;
        }
      }
      this.zzaLl = str3;
      this.zzaMH = ((String)localObject3);
      this.zzPa = ((String)localObject4);
      this.zzOZ = ((String)localObject1);
      l2 = 0L;
      try
      {
        localObject1 = MessageDigest.getInstance("MD5");
        l1 = l2;
        if (!zzzJ())
        {
          localObject3 = localPackageManager.getPackageInfo(getContext().getPackageName(), 64);
          l1 = l2;
          if (localObject1 != null)
          {
            l1 = l2;
            if (((PackageInfo)localObject3).signatures != null)
            {
              l1 = l2;
              if (((PackageInfo)localObject3).signatures.length > 0) {
                l1 = zzo(((MessageDigest)localObject1).digest(localObject3.signatures[0].toByteArray()));
              }
            }
          }
        }
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        for (;;)
        {
          Object localObject2;
          zzyd().zzzK().zzj("Could not get MD5 instance", localNoSuchAlgorithmException);
          l1 = l2;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException2)
      {
        for (;;)
        {
          zzyd().zzzK().zzj("Package name not found", localNameNotFoundException2);
          long l1 = l2;
        }
      }
      this.zzaMI = l1;
      return;
      localObject3 = localObject1;
      if ("com.android.vending".equals(localObject1)) {
        localObject3 = "";
      }
    }
  }
  
  AppMetadata zzzG()
  {
    return new AppMetadata(this.zzaLl, zzzH(), this.zzPa, this.zzaMH, zzzt().zzzb(), zzzI());
  }
  
  String zzzH()
  {
    zziE();
    if (zzzt().zzjA()) {
      return "";
    }
    Object localObject1;
    if (this.zzaLL == null)
    {
      localObject1 = zzl.zzaK(getContext());
      if ((localObject1 == null) || (!((Status)localObject1).isSuccess())) {}
    }
    else
    {
      for (;;)
      {
        try
        {
          if (!zzl.zzzE()) {
            continue;
          }
          localObject2 = zzl.zzzC();
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = "";
          }
          this.zzaLL = ((String)localObject1);
        }
        catch (IllegalStateException localIllegalStateException)
        {
          this.zzaLL = "";
          zzyd().zzzK().zzj("getGoogleAppId or isMeasurementEnabled failed with exception", localIllegalStateException);
          continue;
        }
        return this.zzaLL;
        this.zzaLL = "";
      }
    }
    this.zzaLL = "";
    Object localObject2 = zzyd().zzzK();
    if (localIllegalStateException == null) {}
    for (int i = 0;; i = localIllegalStateException.getStatusCode())
    {
      ((zzp.zza)localObject2).zzj("getGoogleAppId failed with status", Integer.valueOf(i));
      if ((localIllegalStateException == null) || (localIllegalStateException.getStatusMessage() == null)) {
        break;
      }
      zzyd().zzzP().zzec(localIllegalStateException.getStatusMessage());
      break;
    }
  }
  
  long zzzI()
  {
    zziE();
    return this.zzaMI;
  }
  
  boolean zzzJ()
  {
    try
    {
      Object localObject = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 64);
      if ((localObject != null) && (((PackageInfo)localObject).signatures != null) && (((PackageInfo)localObject).signatures.length > 0))
      {
        localObject = localObject.signatures[0];
        boolean bool = ((X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(((Signature)localObject).toByteArray()))).getSubjectX500Principal().equals(zzaMG);
        return bool;
      }
    }
    catch (CertificateException localCertificateException)
    {
      zzyd().zzzK().zzj("Error obtaining certificate", localCertificateException);
      return true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        zzyd().zzzK().zzj("Package name not found", localNameNotFoundException);
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\measurement\internal\zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */