package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;
import java.util.List;

class AccessibilityNodeInfoCompatApi21
{
  static void addAction(Object paramObject, int paramInt, CharSequence paramCharSequence)
  {
    paramCharSequence = new AccessibilityNodeInfo.AccessibilityAction(paramInt, paramCharSequence);
    ((AccessibilityNodeInfo)paramObject).addAction(paramCharSequence);
  }
  
  static List<Object> getActionList(Object paramObject)
  {
    return (List)((AccessibilityNodeInfo)paramObject).getActionList();
  }
  
  public static Object obtainCollectionInfo(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    return AccessibilityNodeInfo.CollectionInfo.obtain(paramInt1, paramInt2, paramBoolean, paramInt3);
  }
  
  public static Object obtainCollectionItemInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    return AccessibilityNodeInfo.CollectionItemInfo.obtain(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2);
  }
  
  static class AccessibilityAction
  {
    static int getId(Object paramObject)
    {
      return ((AccessibilityNodeInfo.AccessibilityAction)paramObject).getId();
    }
    
    static CharSequence getLabel(Object paramObject)
    {
      return ((AccessibilityNodeInfo.AccessibilityAction)paramObject).getLabel();
    }
  }
  
  static class CollectionItemInfo
  {
    public static boolean isSelected(Object paramObject)
    {
      return ((AccessibilityNodeInfo.CollectionItemInfo)paramObject).isSelected();
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\android\support\v4\view\accessibility\AccessibilityNodeInfoCompatApi21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */