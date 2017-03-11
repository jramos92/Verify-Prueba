package com.google.android.gms.plus.model.people;

import android.os.Bundle;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzd;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import com.google.android.gms.plus.internal.model.people.zzk;

public final class PersonBuffer
  extends AbstractDataBuffer<Person>
{
  private final zzd<PersonEntity> zzaUz;
  
  public PersonBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    if ((paramDataHolder.zzor() != null) && (paramDataHolder.zzor().getBoolean("com.google.android.gms.plus.IsSafeParcelable", false)))
    {
      this.zzaUz = new zzd(paramDataHolder, PersonEntity.CREATOR);
      return;
    }
    this.zzaUz = null;
  }
  
  public Person get(int paramInt)
  {
    if (this.zzaUz != null) {
      return (Person)this.zzaUz.zzbs(paramInt);
    }
    return new zzk(this.zzabq, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\plus\model\people\PersonBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */