package com.google.android.gms.plus.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.server.response.SafeParcelResponse;
import com.google.android.gms.internal.zzlb.zzb;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.model.moments.MomentEntity;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

public class zze
  extends zzj<zzd>
{
  private Person zzaSo;
  private final PlusSession zzaSp;
  
  public zze(Context paramContext, Looper paramLooper, zzf paramzzf, PlusSession paramPlusSession, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 2, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
    this.zzaSp = paramPlusSession;
  }
  
  public static boolean zzd(Set<Scope> paramSet)
  {
    if ((paramSet == null) || (paramSet.isEmpty())) {}
    while ((paramSet.size() == 1) && (paramSet.contains(new Scope("plus_one_placeholder_scope")))) {
      return false;
    }
    return true;
  }
  
  private Bundle zzlz()
  {
    Bundle localBundle = this.zzaSp.zzBJ();
    localBundle.putStringArray("request_visible_actions", this.zzaSp.zzBD());
    localBundle.putString("auth_package", this.zzaSp.zzBF());
    return localBundle;
  }
  
  public String getAccountName()
  {
    zzpb();
    try
    {
      String str = ((zzd)zzpc()).getAccountName();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public void zzBx()
  {
    zzpb();
    try
    {
      this.zzaSo = null;
      ((zzd)zzpc()).zzBx();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public Person zzBz()
  {
    zzpb();
    return this.zzaSo;
  }
  
  public zzq zza(zzlb.zzb<People.LoadPeopleResult> paramzzb, int paramInt, String paramString)
  {
    zzpb();
    paramzzb = new zze(paramzzb);
    try
    {
      paramString = ((zzd)zzpc()).zza(paramzzb, 1, paramInt, -1, paramString);
      return paramString;
    }
    catch (RemoteException paramString)
    {
      paramzzb.zza(DataHolder.zzbu(8), null);
    }
    return null;
  }
  
  protected void zza(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramBundle != null) && (paramBundle.containsKey("loaded_person"))) {
      this.zzaSo = PersonEntity.zzt(paramBundle.getByteArray("loaded_person"));
    }
    super.zza(paramInt1, paramIBinder, paramBundle, paramInt2);
  }
  
  public void zza(zzlb.zzb<Moments.LoadMomentsResult> paramzzb, int paramInt, String paramString1, Uri paramUri, String paramString2, String paramString3)
  {
    zzpb();
    if (paramzzb != null) {}
    for (paramzzb = new zzd(paramzzb);; paramzzb = null) {
      try
      {
        ((zzd)zzpc()).zza(paramzzb, paramInt, paramString1, paramUri, paramString2, paramString3);
        return;
      }
      catch (RemoteException paramString1)
      {
        paramzzb.zza(DataHolder.zzbu(8), null, null);
      }
    }
  }
  
  public void zza(zzlb.zzb<Status> paramzzb, Moment paramMoment)
  {
    zzpb();
    if (paramzzb != null) {}
    for (paramzzb = new zzc(paramzzb);; paramzzb = null) {
      try
      {
        paramMoment = SafeParcelResponse.zza((MomentEntity)paramMoment);
        ((zzd)zzpc()).zza(paramzzb, paramMoment);
        return;
      }
      catch (RemoteException paramMoment)
      {
        if (paramzzb != null) {
          break;
        }
        throw new IllegalStateException(paramMoment);
        paramzzb.zzaW(new Status(8, null, null));
      }
    }
  }
  
  public void zza(zzlb.zzb<People.LoadPeopleResult> paramzzb, Collection<String> paramCollection)
  {
    zzpb();
    paramzzb = new zze(paramzzb);
    try
    {
      ((zzd)zzpc()).zza(paramzzb, new ArrayList(paramCollection));
      return;
    }
    catch (RemoteException paramCollection)
    {
      paramzzb.zza(DataHolder.zzbu(8), null);
    }
  }
  
  public void zzd(zzlb.zzb<People.LoadPeopleResult> paramzzb, String[] paramArrayOfString)
  {
    zza(paramzzb, Arrays.asList(paramArrayOfString));
  }
  
  protected zzd zzdE(IBinder paramIBinder)
  {
    return zzd.zza.zzdD(paramIBinder);
  }
  
  public void zzeq(String paramString)
  {
    zzpb();
    try
    {
      ((zzd)zzpc()).zzeq(paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      throw new IllegalStateException(paramString);
    }
  }
  
  protected String zzfK()
  {
    return "com.google.android.gms.plus.service.START";
  }
  
  protected String zzfL()
  {
    return "com.google.android.gms.plus.internal.IPlusService";
  }
  
  public void zzj(zzlb.zzb<Moments.LoadMomentsResult> paramzzb)
  {
    zza(paramzzb, 20, null, null, null, "me");
  }
  
  public void zzk(zzlb.zzb<People.LoadPeopleResult> paramzzb)
  {
    zzpb();
    paramzzb = new zze(paramzzb);
    try
    {
      ((zzd)zzpc()).zza(paramzzb, 2, 1, -1, null);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      paramzzb.zza(DataHolder.zzbu(8), null);
    }
  }
  
  public void zzl(zzlb.zzb<Status> paramzzb)
  {
    zzpb();
    zzBx();
    paramzzb = new zzf(paramzzb);
    try
    {
      ((zzd)zzpc()).zzb(paramzzb);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      paramzzb.zzi(8, null);
    }
  }
  
  public boolean zzlN()
  {
    return zzd(zzpa().zzb(Plus.API));
  }
  
  protected Bundle zzly()
  {
    return zzlz();
  }
  
  protected Bundle zzpd()
  {
    return zzlz();
  }
  
  public zzq zzq(zzlb.zzb<People.LoadPeopleResult> paramzzb, String paramString)
  {
    return zza(paramzzb, 0, paramString);
  }
  
  static final class zza
    implements Moments.LoadMomentsResult
  {
    private final Status zzSC;
    private final String zzaSq;
    private final String zzaSr;
    private final MomentBuffer zzaSs;
    
    public zza(Status paramStatus, DataHolder paramDataHolder, String paramString1, String paramString2)
    {
      this.zzSC = paramStatus;
      this.zzaSq = paramString1;
      this.zzaSr = paramString2;
      if (paramDataHolder != null) {}
      for (paramStatus = new MomentBuffer(paramDataHolder);; paramStatus = null)
      {
        this.zzaSs = paramStatus;
        return;
      }
    }
    
    public MomentBuffer getMomentBuffer()
    {
      return this.zzaSs;
    }
    
    public String getNextPageToken()
    {
      return this.zzaSq;
    }
    
    public Status getStatus()
    {
      return this.zzSC;
    }
    
    public String getUpdated()
    {
      return this.zzaSr;
    }
    
    public void release()
    {
      if (this.zzaSs != null) {
        this.zzaSs.release();
      }
    }
  }
  
  static final class zzb
    implements People.LoadPeopleResult
  {
    private final Status zzSC;
    private final String zzaSq;
    private final PersonBuffer zzaSt;
    
    public zzb(Status paramStatus, DataHolder paramDataHolder, String paramString)
    {
      this.zzSC = paramStatus;
      this.zzaSq = paramString;
      if (paramDataHolder != null) {}
      for (paramStatus = new PersonBuffer(paramDataHolder);; paramStatus = null)
      {
        this.zzaSt = paramStatus;
        return;
      }
    }
    
    public String getNextPageToken()
    {
      return this.zzaSq;
    }
    
    public PersonBuffer getPersonBuffer()
    {
      return this.zzaSt;
    }
    
    public Status getStatus()
    {
      return this.zzSC;
    }
    
    public void release()
    {
      if (this.zzaSt != null) {
        this.zzaSt.release();
      }
    }
  }
  
  static final class zzc
    extends zza
  {
    private final zzlb.zzb<Status> zzaFC;
    
    public zzc(zzlb.zzb<Status> paramzzb)
    {
      this.zzaFC = paramzzb;
    }
    
    public void zzaW(Status paramStatus)
    {
      this.zzaFC.zzp(paramStatus);
    }
  }
  
  static final class zzd
    extends zza
  {
    private final zzlb.zzb<Moments.LoadMomentsResult> zzaFC;
    
    public zzd(zzlb.zzb<Moments.LoadMomentsResult> paramzzb)
    {
      this.zzaFC = paramzzb;
    }
    
    public void zza(DataHolder paramDataHolder, String paramString1, String paramString2)
    {
      if (paramDataHolder.zzor() != null) {}
      for (Object localObject = (PendingIntent)paramDataHolder.zzor().getParcelable("pendingIntent");; localObject = null)
      {
        Status localStatus = new Status(paramDataHolder.getStatusCode(), null, (PendingIntent)localObject);
        localObject = paramDataHolder;
        if (!localStatus.isSuccess())
        {
          localObject = paramDataHolder;
          if (paramDataHolder != null)
          {
            if (!paramDataHolder.isClosed()) {
              paramDataHolder.close();
            }
            localObject = null;
          }
        }
        this.zzaFC.zzp(new zze.zza(localStatus, (DataHolder)localObject, paramString1, paramString2));
        return;
      }
    }
  }
  
  static final class zze
    extends zza
  {
    private final zzlb.zzb<People.LoadPeopleResult> zzaFC;
    
    public zze(zzlb.zzb<People.LoadPeopleResult> paramzzb)
    {
      this.zzaFC = paramzzb;
    }
    
    public void zza(DataHolder paramDataHolder, String paramString)
    {
      if (paramDataHolder.zzor() != null) {}
      for (Object localObject = (PendingIntent)paramDataHolder.zzor().getParcelable("pendingIntent");; localObject = null)
      {
        Status localStatus = new Status(paramDataHolder.getStatusCode(), null, (PendingIntent)localObject);
        localObject = paramDataHolder;
        if (!localStatus.isSuccess())
        {
          localObject = paramDataHolder;
          if (paramDataHolder != null)
          {
            if (!paramDataHolder.isClosed()) {
              paramDataHolder.close();
            }
            localObject = null;
          }
        }
        this.zzaFC.zzp(new zze.zzb(localStatus, (DataHolder)localObject, paramString));
        return;
      }
    }
  }
  
  static final class zzf
    extends zza
  {
    private final zzlb.zzb<Status> zzaFC;
    
    public zzf(zzlb.zzb<Status> paramzzb)
    {
      this.zzaFC = paramzzb;
    }
    
    public void zzi(int paramInt, Bundle paramBundle)
    {
      if (paramBundle != null) {}
      for (paramBundle = (PendingIntent)paramBundle.getParcelable("pendingIntent");; paramBundle = null)
      {
        paramBundle = new Status(paramInt, null, paramBundle);
        this.zzaFC.zzp(paramBundle);
        return;
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\plus\internal\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */