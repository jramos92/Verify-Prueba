package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.zzj;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class zzng
  extends zzj<DriveId>
{
  public static final zzng zzanH = new zzng();
  
  private zzng()
  {
    super("driveId", Arrays.asList(new String[] { "sqlId", "resourceId", "mimeType" }), Arrays.asList(new String[] { "dbInstanceId" }), 4100000);
  }
  
  protected boolean zzb(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    Iterator localIterator = zzrG().iterator();
    while (localIterator.hasNext()) {
      if (!paramDataHolder.zzce((String)localIterator.next())) {
        return false;
      }
    }
    return true;
  }
  
  protected DriveId zzm(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    long l1 = paramDataHolder.zzor().getLong("dbInstanceId");
    if ("application/vnd.google-apps.folder".equals(paramDataHolder.zzd(zznd.zzang.getName(), paramInt1, paramInt2))) {}
    for (int i = 1;; i = 0)
    {
      String str = paramDataHolder.zzd("resourceId", paramInt1, paramInt2);
      long l2 = paramDataHolder.zzb("sqlId", paramInt1, paramInt2);
      paramDataHolder = str;
      if ("generated-android-null".equals(str)) {
        paramDataHolder = null;
      }
      return new DriveId(paramDataHolder, Long.valueOf(l2).longValue(), l1, i);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzng.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */