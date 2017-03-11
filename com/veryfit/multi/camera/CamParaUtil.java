package com.veryfit.multi.camera;

import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class CamParaUtil
{
  private static CamParaUtil myCamPara = null;
  private CameraSizeComparator sizeComparator = new CameraSizeComparator();
  
  public static CamParaUtil getInstance()
  {
    if (myCamPara == null)
    {
      myCamPara = new CamParaUtil();
      return myCamPara;
    }
    return myCamPara;
  }
  
  public boolean equalRate(Camera.Size paramSize, float paramFloat)
  {
    return Math.abs(paramSize.width / paramSize.height - paramFloat) <= 0.03D;
  }
  
  public Camera.Size getPropPictureSize(List<Camera.Size> paramList, float paramFloat, int paramInt)
  {
    Collections.sort(paramList, this.sizeComparator);
    int i = 0;
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {}
      Camera.Size localSize;
      do
      {
        paramInt = i;
        if (i == paramList.size()) {
          paramInt = 0;
        }
        return (Camera.Size)paramList.get(paramInt);
        localSize = (Camera.Size)localIterator.next();
      } while ((localSize.width >= paramInt) && (equalRate(localSize, paramFloat)));
      i += 1;
    }
  }
  
  public Camera.Size getPropPreviewSize(List<Camera.Size> paramList, float paramFloat, int paramInt)
  {
    Collections.sort(paramList, this.sizeComparator);
    int i = 0;
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {}
      Camera.Size localSize;
      do
      {
        paramInt = i;
        if (i == paramList.size()) {
          paramInt = 0;
        }
        return (Camera.Size)paramList.get(paramInt);
        localSize = (Camera.Size)localIterator.next();
      } while ((localSize.width >= paramInt) && (equalRate(localSize, paramFloat)));
      i += 1;
    }
  }
  
  public void printSupportFocusMode(Camera.Parameters paramParameters)
  {
    paramParameters = paramParameters.getSupportedFocusModes().iterator();
    for (;;)
    {
      if (!paramParameters.hasNext()) {
        return;
      }
      String str = (String)paramParameters.next();
    }
  }
  
  public void printSupportPictureSize(Camera.Parameters paramParameters)
  {
    paramParameters = paramParameters.getSupportedPictureSizes();
    int i = 0;
    for (;;)
    {
      if (i >= paramParameters.size()) {
        return;
      }
      Camera.Size localSize = (Camera.Size)paramParameters.get(i);
      i += 1;
    }
  }
  
  public void printSupportPreviewSize(Camera.Parameters paramParameters)
  {
    paramParameters = paramParameters.getSupportedPreviewSizes();
    int i = 0;
    for (;;)
    {
      if (i >= paramParameters.size()) {
        return;
      }
      Camera.Size localSize = (Camera.Size)paramParameters.get(i);
      i += 1;
    }
  }
  
  public class CameraSizeComparator
    implements Comparator<Camera.Size>
  {
    public CameraSizeComparator() {}
    
    public int compare(Camera.Size paramSize1, Camera.Size paramSize2)
    {
      if (paramSize1.width == paramSize2.width) {
        return 0;
      }
      if (paramSize1.width > paramSize2.width) {
        return 1;
      }
      return -1;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\camera\CamParaUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */