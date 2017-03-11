package com.nineoldandroids.animation;

public class ArgbEvaluator
  implements TypeEvaluator
{
  public Object evaluate(float paramFloat, Object paramObject1, Object paramObject2)
  {
    int m = ((Integer)paramObject1).intValue();
    int i = m >> 24;
    int j = m >> 16 & 0xFF;
    int k = m >> 8 & 0xFF;
    m &= 0xFF;
    int n = ((Integer)paramObject2).intValue();
    return Integer.valueOf((int)(((n >> 24) - i) * paramFloat) + i << 24 | (int)(((n >> 16 & 0xFF) - j) * paramFloat) + j << 16 | (int)(((n >> 8 & 0xFF) - k) * paramFloat) + k << 8 | (int)(((n & 0xFF) - m) * paramFloat) + m);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\nineoldandroids\animation\ArgbEvaluator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */