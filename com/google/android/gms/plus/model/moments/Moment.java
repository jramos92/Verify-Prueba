package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.plus.internal.model.moments.ItemScopeEntity;
import com.google.android.gms.plus.internal.model.moments.MomentEntity;
import java.util.HashSet;
import java.util.Set;

public abstract interface Moment
  extends Freezable<Moment>
{
  public abstract String getId();
  
  public abstract ItemScope getResult();
  
  public abstract String getStartDate();
  
  public abstract ItemScope getTarget();
  
  public abstract String getType();
  
  public abstract boolean hasId();
  
  public abstract boolean hasResult();
  
  public abstract boolean hasStartDate();
  
  public abstract boolean hasTarget();
  
  public abstract boolean hasType();
  
  public static class Builder
  {
    private String zzGq;
    private final Set<Integer> zzaST = new HashSet();
    private String zzaTG;
    private ItemScopeEntity zzaTO;
    private ItemScopeEntity zzaTP;
    private String zzwN;
    
    public Moment build()
    {
      return new MomentEntity(this.zzaST, this.zzwN, this.zzaTO, this.zzaTG, this.zzaTP, this.zzGq);
    }
    
    public Builder setId(String paramString)
    {
      this.zzwN = paramString;
      this.zzaST.add(Integer.valueOf(2));
      return this;
    }
    
    public Builder setResult(ItemScope paramItemScope)
    {
      this.zzaTO = ((ItemScopeEntity)paramItemScope);
      this.zzaST.add(Integer.valueOf(4));
      return this;
    }
    
    public Builder setStartDate(String paramString)
    {
      this.zzaTG = paramString;
      this.zzaST.add(Integer.valueOf(5));
      return this;
    }
    
    public Builder setTarget(ItemScope paramItemScope)
    {
      this.zzaTP = ((ItemScopeEntity)paramItemScope);
      this.zzaST.add(Integer.valueOf(6));
      return this;
    }
    
    public Builder setType(String paramString)
    {
      this.zzGq = paramString;
      this.zzaST.add(Integer.valueOf(7));
      return this;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\plus\model\moments\Moment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */