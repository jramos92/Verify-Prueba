package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzjp;
import com.google.android.gms.internal.zzjr;
import com.google.android.gms.internal.zzjs;
import com.google.android.gms.internal.zzlb.zza;
import com.google.android.gms.internal.zzlb.zzb;
import java.util.List;

public class GetRecentContextCall
{
  public static class Request
    implements SafeParcelable
  {
    public static final zzf CREATOR = new zzf();
    final int mVersionCode;
    public final Account zzQq;
    public final boolean zzQr;
    public final boolean zzQs;
    public final boolean zzQt;
    public final String zzQu;
    
    public Request()
    {
      this(null, false, false, false, null);
    }
    
    Request(int paramInt, Account paramAccount, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
    {
      this.mVersionCode = paramInt;
      this.zzQq = paramAccount;
      this.zzQr = paramBoolean1;
      this.zzQs = paramBoolean2;
      this.zzQt = paramBoolean3;
      this.zzQu = paramString;
    }
    
    public Request(Account paramAccount, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
    {
      this(1, paramAccount, paramBoolean1, paramBoolean2, paramBoolean3, paramString);
    }
    
    public int describeContents()
    {
      zzf localzzf = CREATOR;
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzf localzzf = CREATOR;
      zzf.zza(this, paramParcel, paramInt);
    }
    
    public static final class zza
    {
      private Account zzQv;
      private boolean zzQw;
      private boolean zzQx;
      private boolean zzQy;
      private String zzQz;
      
      public zza zzL(boolean paramBoolean)
      {
        this.zzQx = paramBoolean;
        return this;
      }
      
      public zza zzby(String paramString)
      {
        this.zzQz = paramString;
        return this;
      }
      
      public GetRecentContextCall.Request zzlr()
      {
        return new GetRecentContextCall.Request(this.zzQv, this.zzQw, this.zzQx, this.zzQy, this.zzQz);
      }
    }
  }
  
  public static class Response
    implements Result, SafeParcelable
  {
    public static final zzg CREATOR = new zzg();
    final int mVersionCode;
    public Status zzQA;
    public List<UsageInfo> zzQB;
    public String[] zzQC;
    
    public Response()
    {
      this.mVersionCode = 1;
    }
    
    Response(int paramInt, Status paramStatus, List<UsageInfo> paramList, String[] paramArrayOfString)
    {
      this.mVersionCode = paramInt;
      this.zzQA = paramStatus;
      this.zzQB = paramList;
      this.zzQC = paramArrayOfString;
    }
    
    public int describeContents()
    {
      zzg localzzg = CREATOR;
      return 0;
    }
    
    public Status getStatus()
    {
      return this.zzQA;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzg localzzg = CREATOR;
      zzg.zza(this, paramParcel, paramInt);
    }
  }
  
  public static class zza
    extends zzlb.zza<GetRecentContextCall.Response, zzjs>
  {
    private final GetRecentContextCall.Request zzQo;
    
    public zza(GetRecentContextCall.Request paramRequest, GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
      this.zzQo = paramRequest;
    }
    
    protected GetRecentContextCall.Response zza(Status paramStatus)
    {
      GetRecentContextCall.Response localResponse = new GetRecentContextCall.Response();
      localResponse.zzQA = paramStatus;
      return localResponse;
    }
    
    protected void zza(zzjs paramzzjs)
      throws RemoteException
    {
      paramzzjs.zzlw().zza(this.zzQo, new zzjr(this)
      {
        public void zza(GetRecentContextCall.Response paramAnonymousResponse)
        {
          this.zzRb.zzp(paramAnonymousResponse);
        }
      });
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\appdatasearch\GetRecentContextCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */