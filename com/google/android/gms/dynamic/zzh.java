package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

public final class zzh
  extends zzc.zza
{
  private Fragment zzafl;
  
  private zzh(Fragment paramFragment)
  {
    this.zzafl = paramFragment;
  }
  
  public static zzh zza(Fragment paramFragment)
  {
    if (paramFragment != null) {
      return new zzh(paramFragment);
    }
    return null;
  }
  
  public Bundle getArguments()
  {
    return this.zzafl.getArguments();
  }
  
  public int getId()
  {
    return this.zzafl.getId();
  }
  
  public boolean getRetainInstance()
  {
    return this.zzafl.getRetainInstance();
  }
  
  public String getTag()
  {
    return this.zzafl.getTag();
  }
  
  public int getTargetRequestCode()
  {
    return this.zzafl.getTargetRequestCode();
  }
  
  public boolean getUserVisibleHint()
  {
    return this.zzafl.getUserVisibleHint();
  }
  
  public zzd getView()
  {
    return zze.zzy(this.zzafl.getView());
  }
  
  public boolean isAdded()
  {
    return this.zzafl.isAdded();
  }
  
  public boolean isDetached()
  {
    return this.zzafl.isDetached();
  }
  
  public boolean isHidden()
  {
    return this.zzafl.isHidden();
  }
  
  public boolean isInLayout()
  {
    return this.zzafl.isInLayout();
  }
  
  public boolean isRemoving()
  {
    return this.zzafl.isRemoving();
  }
  
  public boolean isResumed()
  {
    return this.zzafl.isResumed();
  }
  
  public boolean isVisible()
  {
    return this.zzafl.isVisible();
  }
  
  public void setHasOptionsMenu(boolean paramBoolean)
  {
    this.zzafl.setHasOptionsMenu(paramBoolean);
  }
  
  public void setMenuVisibility(boolean paramBoolean)
  {
    this.zzafl.setMenuVisibility(paramBoolean);
  }
  
  public void setRetainInstance(boolean paramBoolean)
  {
    this.zzafl.setRetainInstance(paramBoolean);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    this.zzafl.setUserVisibleHint(paramBoolean);
  }
  
  public void startActivity(Intent paramIntent)
  {
    this.zzafl.startActivity(paramIntent);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    this.zzafl.startActivityForResult(paramIntent, paramInt);
  }
  
  public void zzn(zzd paramzzd)
  {
    paramzzd = (View)zze.zzp(paramzzd);
    this.zzafl.registerForContextMenu(paramzzd);
  }
  
  public void zzo(zzd paramzzd)
  {
    paramzzd = (View)zze.zzp(paramzzd);
    this.zzafl.unregisterForContextMenu(paramzzd);
  }
  
  public zzd zzsa()
  {
    return zze.zzy(this.zzafl.getActivity());
  }
  
  public zzc zzsb()
  {
    return zza(this.zzafl.getParentFragment());
  }
  
  public zzd zzsc()
  {
    return zze.zzy(this.zzafl.getResources());
  }
  
  public zzc zzsd()
  {
    return zza(this.zzafl.getTargetFragment());
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\dynamic\zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */