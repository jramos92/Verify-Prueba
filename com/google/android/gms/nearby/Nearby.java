package com.google.android.gms.nearby;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.internal.zzpm;
import com.google.android.gms.internal.zzpu;
import com.google.android.gms.nearby.bootstrap.zza;
import com.google.android.gms.nearby.connection.Connections;
import com.google.android.gms.nearby.messages.Messages;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.internal.zzk;
import com.google.android.gms.nearby.messages.internal.zzl;
import com.google.android.gms.nearby.messages.zzc;
import com.google.android.gms.nearby.sharing.internal.zzh;
import com.google.android.gms.nearby.sharing.internal.zzi;
import com.google.android.gms.nearby.sharing.zzd;
import com.google.android.gms.nearby.sharing.zze;

public final class Nearby
{
  public static final Api<Api.ApiOptions.NoOptions> CONNECTIONS_API = new Api("Nearby.CONNECTIONS_API", zzpu.zzRl, zzpu.zzRk);
  public static final Connections Connections = new zzpu();
  public static final Api<MessagesOptions> MESSAGES_API = new Api("Nearby.MESSAGES_API", zzk.zzRl, zzk.zzRk);
  public static final Messages Messages = new zzk();
  public static final zzc zzaPj = new zzl();
  public static final Api<Api.ApiOptions.NoOptions> zzaPk = new Api("Nearby.SHARING_API", zzh.zzRl, zzh.zzRk);
  public static final zzd zzaPl = new zzh();
  public static final zze zzaPm = new zzi();
  public static final Api<Api.ApiOptions.NoOptions> zzaPn = new Api("Nearby.BOOTSTRAP_API", zzpm.zzRl, zzpm.zzRk);
  public static final zza zzaPo = new zzpm();
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\Nearby.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */