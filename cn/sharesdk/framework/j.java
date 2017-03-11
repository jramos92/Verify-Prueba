package cn.sharesdk.framework;

import java.util.Comparator;

class j
  implements Comparator<Platform>
{
  j(i parami) {}
  
  public int a(Platform paramPlatform1, Platform paramPlatform2)
  {
    if (paramPlatform1.getSortId() != paramPlatform2.getSortId()) {
      return paramPlatform1.getSortId() - paramPlatform2.getSortId();
    }
    return paramPlatform1.getPlatformId() - paramPlatform2.getPlatformId();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\framework\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */