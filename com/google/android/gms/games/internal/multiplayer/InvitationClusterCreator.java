package com.google.android.gms.games.internal.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import java.util.ArrayList;

public class InvitationClusterCreator
  implements Parcelable.Creator<ZInvitationCluster>
{
  static void zza(ZInvitationCluster paramZInvitationCluster, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramZInvitationCluster.zzvq(), false);
    zzb.zzc(paramParcel, 1000, paramZInvitationCluster.getVersionCode());
    zzb.zzI(paramParcel, paramInt);
  }
  
  public ZInvitationCluster zzeb(Parcel paramParcel)
  {
    int j = zza.zzap(paramParcel);
    int i = 0;
    ArrayList localArrayList = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzao(paramParcel);
      switch (zza.zzbM(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        localArrayList = zza.zzc(paramParcel, k, InvitationEntity.CREATOR);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new ZInvitationCluster(i, localArrayList);
  }
  
  public ZInvitationCluster[] zzgf(int paramInt)
  {
    return new ZInvitationCluster[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\internal\multiplayer\InvitationClusterCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */