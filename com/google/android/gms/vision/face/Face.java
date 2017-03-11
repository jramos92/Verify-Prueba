package com.google.android.gms.vision.face;

import android.graphics.PointF;
import java.util.Arrays;
import java.util.List;

public class Face
{
  public static final float UNCOMPUTED_PROBABILITY = -1.0F;
  private int mId;
  private float zzaJX;
  private float zzaJY;
  private PointF zzbbD;
  private float zzbbE;
  private float zzbbF;
  private List<Landmark> zzbbG;
  private float zzbbH;
  private float zzbbI;
  private float zzbbJ;
  
  public Face(int paramInt, PointF paramPointF, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Landmark[] paramArrayOfLandmark, float paramFloat5, float paramFloat6, float paramFloat7)
  {
    this.mId = paramInt;
    this.zzbbD = paramPointF;
    this.zzaJX = paramFloat1;
    this.zzaJY = paramFloat2;
    this.zzbbE = paramFloat3;
    this.zzbbF = paramFloat4;
    this.zzbbG = Arrays.asList(paramArrayOfLandmark);
    if ((paramFloat5 >= 0.0F) && (paramFloat5 <= 1.0F))
    {
      this.zzbbH = paramFloat5;
      if ((paramFloat6 < 0.0F) || (paramFloat6 > 1.0F)) {
        break label120;
      }
    }
    label120:
    for (this.zzbbI = paramFloat6;; this.zzbbI = -1.0F)
    {
      if ((this.zzbbJ < 0.0F) || (this.zzbbJ > 1.0F)) {
        break label129;
      }
      this.zzbbJ = paramFloat7;
      return;
      this.zzbbH = -1.0F;
      break;
    }
    label129:
    this.zzbbJ = -1.0F;
  }
  
  public float getEulerY()
  {
    return this.zzbbE;
  }
  
  public float getEulerZ()
  {
    return this.zzbbF;
  }
  
  public float getHeight()
  {
    return this.zzaJY;
  }
  
  public int getId()
  {
    return this.mId;
  }
  
  public float getIsLeftEyeOpenProbability()
  {
    return this.zzbbH;
  }
  
  public float getIsRightEyeOpenProbability()
  {
    return this.zzbbI;
  }
  
  public float getIsSmilingProbability()
  {
    return this.zzbbJ;
  }
  
  public List<Landmark> getLandmarks()
  {
    return this.zzbbG;
  }
  
  public PointF getPosition()
  {
    return new PointF(this.zzbbD.x - this.zzaJX / 2.0F, this.zzbbD.y - this.zzaJY / 2.0F);
  }
  
  public float getWidth()
  {
    return this.zzaJX;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\vision\face\Face.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */