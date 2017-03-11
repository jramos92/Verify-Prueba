package com.google.android.gms.dynamic;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public final class zzb
  extends zzc.zza
{
  private Fragment zzapz;
  
  private zzb(Fragment paramFragment)
  {
    this.zzapz = paramFragment;
  }
  
  public static zzb zza(Fragment paramFragment)
  {
    if (paramFragment != null) {
      return new zzb(paramFragment);
    }
    return null;
  }
  
  public Bundle getArguments()
  {
    return this.zzapz.getArguments();
  }
  
  public int getId()
  {
    return this.zzapz.getId();
  }
  
  public boolean getRetainInstance()
  {
    return this.zzapz.getRetainInstance();
  }
  
  public String getTag()
  {
    return this.zzapz.getTag();
  }
  
  public int getTargetRequestCode()
  {
    return this.zzapz.getTargetRequestCode();
  }
  
  public boolean getUserVisibleHint()
  {
    return this.zzapz.getUserVisibleHint();
  }
  
  public zzd getView()
  {
    return zze.zzy(this.zzapz.getView());
  }
  
  public boolean isAdded()
  {
    return this.zzapz.isAdded();
  }
  
  public boolean isDetached()
  {
    return this.zzapz.isDetached();
  }
  
  public boolean isHidden()
  {
    return this.zzapz.isHidden();
  }
  
  public boolean isInLayout()
  {
    return this.zzapz.isInLayout();
  }
  
  public boolean isRemoving()
  {
    return this.zzapz.isRemoving();
  }
  
  public boolean isResumed()
  {
    return this.zzapz.isResumed();
  }
  
  public boolean isVisible()
  {
    return this.zzapz.isVisible();
  }
  
  public void setHasOptionsMenu(boolean paramBoolean)
  {
    this.zzapz.setHasOptionsMenu(paramBoolean);
  }
  
  public void setMenuVisibility(boolean paramBoolean)
  {
    this.zzapz.setMenuVisibility(paramBoolean);
  }
  
  public void setRetainInstance(boolean paramBoolean)
  {
    this.zzapz.setRetainInstance(paramBoolean);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    this.zzapz.setUserVisibleHint(paramBoolean);
  }
  
  public void startActivity(Intent paramIntent)
  {
    this.zzapz.startActivity(paramIntent);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    this.zzapz.startActivityForResult(paramIntent, paramInt);
  }
  
  public void zzn(zzd paramzzd)
  {
    paramzzd = (View)zze.zzp(paramzzd);
    this.zzapz.registerForContextMenu(paramzzd);
  }
  
  public void zzo(zzd paramzzd)
  {
    paramzzd = (View)zze.zzp(paramzzd);
    this.zzapz.unregisterForContextMenu(paramzzd);
  }
  
  public zzd zzsa()
  {
    return zze.zzy(this.zzapz.getActivity());
  }
  
  public zzc zzsb()
  {
    return zza(this.zzapz.getParentFragment());
  }
  
  public zzd zzsc()
  {
    return zze.zzy(this.zzapz.getResources());
  }
  
  public zzc zzsd()
  {
    return zza(this.zzapz.getTargetFragment());
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\dynamic\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */