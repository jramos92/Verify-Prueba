package com.google.android.gms.games.appcontent;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;
import java.util.ArrayList;

public final class AppContentSectionBuffer
  extends zzf<AppContentSection>
{
  private final ArrayList<DataHolder> zzauU;
  
  public void release()
  {
    super.release();
    int j = this.zzauU.size();
    int i = 1;
    while (i < j)
    {
      DataHolder localDataHolder = (DataHolder)this.zzauU.get(i);
      if (localDataHolder != null) {
        localDataHolder.close();
      }
      i += 1;
    }
  }
  
  protected AppContentSection zzm(int paramInt1, int paramInt2)
  {
    return new AppContentSectionRef(this.zzauU, paramInt1, paramInt2);
  }
  
  protected String zzoA()
  {
    return "card_id";
  }
  
  protected String zzoy()
  {
    return "section_id";
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\appcontent\AppContentSectionBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */