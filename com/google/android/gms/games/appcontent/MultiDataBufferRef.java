package com.google.android.gms.games.appcontent;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import java.util.ArrayList;

public abstract class MultiDataBufferRef
  extends zzc
{
  protected final ArrayList<DataHolder> zzauU;
  
  protected MultiDataBufferRef(ArrayList<DataHolder> paramArrayList, int paramInt1, int paramInt2)
  {
    super((DataHolder)paramArrayList.get(paramInt1), paramInt2);
    this.zzauU = paramArrayList;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\appcontent\MultiDataBufferRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */