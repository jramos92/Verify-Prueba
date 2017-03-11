package cn.sharesdk.framework.a;

import android.text.TextUtils;
import cn.sharesdk.framework.ShareSDK;
import com.mob.tools.network.HTTPPart;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.network.NetworkHelper.NetworkTimeOut;
import com.mob.tools.network.RawNetworkCallback;
import java.util.ArrayList;

public class a
  extends NetworkHelper
{
  private static a a = null;
  
  public static a a()
  {
    if (a == null) {
      a = new a();
    }
    return a;
  }
  
  private void a(String paramString, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramInt <= 0)) {
      return;
    }
    ShareSDK.logApiEvent(paramString, paramInt);
  }
  
  public String a(String paramString1, ArrayList<KVPair<String>> paramArrayList, KVPair<String> paramKVPair, String paramString2, int paramInt)
  {
    return a(paramString1, paramArrayList, paramKVPair, null, paramString2, paramInt);
  }
  
  public String a(String paramString1, ArrayList<KVPair<String>> paramArrayList1, KVPair<String> paramKVPair, ArrayList<KVPair<String>> paramArrayList2, NetworkHelper.NetworkTimeOut paramNetworkTimeOut, String paramString2, int paramInt)
  {
    a(paramString2, paramInt);
    return super.httpPost(paramString1, paramArrayList1, paramKVPair, paramArrayList2, paramNetworkTimeOut);
  }
  
  public String a(String paramString1, ArrayList<KVPair<String>> paramArrayList1, KVPair<String> paramKVPair, ArrayList<KVPair<String>> paramArrayList2, String paramString2, int paramInt)
  {
    return a(paramString1, paramArrayList1, paramKVPair, paramArrayList2, null, paramString2, paramInt);
  }
  
  public String a(String paramString1, ArrayList<KVPair<String>> paramArrayList, String paramString2, int paramInt)
  {
    return a(paramString1, paramArrayList, null, null, paramString2, paramInt);
  }
  
  public String a(String paramString1, ArrayList<KVPair<String>> paramArrayList1, ArrayList<KVPair<String>> paramArrayList2, NetworkHelper.NetworkTimeOut paramNetworkTimeOut, String paramString2, int paramInt)
  {
    a(paramString2, paramInt);
    return super.httpGet(paramString1, paramArrayList1, paramArrayList2, paramNetworkTimeOut);
  }
  
  public void a(String paramString1, ArrayList<KVPair<String>> paramArrayList, HTTPPart paramHTTPPart, RawNetworkCallback paramRawNetworkCallback, String paramString2, int paramInt)
  {
    a(paramString2, paramInt);
    super.rawPost(paramString1, paramArrayList, paramHTTPPart, paramRawNetworkCallback, null);
  }
  
  public String b(String paramString1, ArrayList<KVPair<String>> paramArrayList1, KVPair<String> paramKVPair, ArrayList<KVPair<String>> paramArrayList2, NetworkHelper.NetworkTimeOut paramNetworkTimeOut, String paramString2, int paramInt)
  {
    a(paramString2, paramInt);
    return super.httpPut(paramString1, paramArrayList1, paramKVPair, paramArrayList2, paramNetworkTimeOut);
  }
  
  public String b(String paramString1, ArrayList<KVPair<String>> paramArrayList, String paramString2, int paramInt)
  {
    return a(paramString1, paramArrayList, null, paramString2, paramInt);
  }
  
  public String b(String paramString1, ArrayList<KVPair<String>> paramArrayList1, ArrayList<KVPair<String>> paramArrayList2, NetworkHelper.NetworkTimeOut paramNetworkTimeOut, String paramString2, int paramInt)
  {
    a(paramString2, paramInt);
    return super.jsonPost(paramString1, paramArrayList1, paramArrayList2, paramNetworkTimeOut);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\framework\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */