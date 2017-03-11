package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;

public final class zzc
  extends com.google.android.gms.common.data.zzc
  implements Moment
{
  private MomentEntity zzaTQ;
  
  public zzc(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  private MomentEntity zzBN()
  {
    try
    {
      if (this.zzaTQ == null)
      {
        byte[] arrayOfByte = getByteArray("momentImpl");
        Parcel localParcel = Parcel.obtain();
        localParcel.unmarshall(arrayOfByte, 0, arrayOfByte.length);
        localParcel.setDataPosition(0);
        this.zzaTQ = MomentEntity.CREATOR.zzgn(localParcel);
        localParcel.recycle();
      }
      return this.zzaTQ;
    }
    finally {}
  }
  
  public String getId()
  {
    return zzBN().getId();
  }
  
  public ItemScope getResult()
  {
    return zzBN().getResult();
  }
  
  public String getStartDate()
  {
    return zzBN().getStartDate();
  }
  
  public ItemScope getTarget()
  {
    return zzBN().getTarget();
  }
  
  public String getType()
  {
    return zzBN().getType();
  }
  
  public boolean hasId()
  {
    return zzBN().hasId();
  }
  
  public boolean hasResult()
  {
    return zzBN().hasResult();
  }
  
  public boolean hasStartDate()
  {
    return zzBN().hasStartDate();
  }
  
  public boolean hasTarget()
  {
    return zzBN().hasTarget();
  }
  
  public boolean hasType()
  {
    return zzBN().hasType();
  }
  
  public MomentEntity zzBM()
  {
    return zzBN();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\plus\internal\model\moments\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */