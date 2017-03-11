package cn.sharesdk.framework.statistics;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.statistics.a.e;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.network.NetworkHelper.NetworkTimeOut;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.R;
import java.util.ArrayList;
import java.util.HashMap;

public class c
{
  private Context a;
  private cn.sharesdk.framework.statistics.a.c b;
  private DeviceHelper c;
  private NetworkHelper d;
  private Hashon e;
  private String f;
  private String g;
  private boolean h;
  
  public c(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
    this.b = cn.sharesdk.framework.statistics.a.c.a(this.a);
    this.c = DeviceHelper.getInstance(this.a);
    this.d = new NetworkHelper();
    this.e = new Hashon();
    e();
  }
  
  private String c(String paramString1, String paramString2)
  {
    boolean bool1 = this.b.b();
    boolean bool2 = this.b.c();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Data.urlEncode(this.c.getPackageName(), "utf-8")).append("|");
    localStringBuilder.append(Data.urlEncode(this.c.getAppVersionName(), "utf-8")).append("|");
    localStringBuilder.append(Data.urlEncode(String.valueOf(60000 + ShareSDK.getSDKVersionCode()), "utf-8")).append("|");
    localStringBuilder.append(Data.urlEncode(String.valueOf(this.c.getPlatformCode()), "utf-8")).append("|");
    localStringBuilder.append(Data.urlEncode(this.c.getDetailNetworkTypeForStatic(), "utf-8")).append("|");
    if (bool1)
    {
      localStringBuilder.append(Data.urlEncode(String.valueOf(this.c.getOSVersionInt()), "utf-8")).append("|");
      localStringBuilder.append(Data.urlEncode(this.c.getScreenSize(), "utf-8")).append("|");
      localStringBuilder.append(Data.urlEncode(this.c.getManufacturer(), "utf-8")).append("|");
      localStringBuilder.append(Data.urlEncode(this.c.getModel(), "utf-8")).append("|");
      localStringBuilder.append(Data.urlEncode(this.c.getCarrier(), "utf-8")).append("|");
      if (!bool2) {
        break label349;
      }
      localStringBuilder.append(paramString2);
    }
    for (;;)
    {
      paramString2 = localStringBuilder.toString();
      cn.sharesdk.framework.utils.d.a().i("shorLinkMsg ===>>>>", new Object[] { paramString2 });
      return Base64.encodeToString(Data.AES128Encode(Data.rawMD5(String.format("%s:%s", new Object[] { this.c.getDeviceKey(), paramString1 })), paramString2), 2);
      localStringBuilder.append("|||||");
      break;
      label349:
      localStringBuilder.append(paramString2.split("\\|")[0]);
      localStringBuilder.append("|||||");
    }
  }
  
  private String c(String paramString, HashMap<String, Object> paramHashMap)
  {
    paramHashMap.put("type", "DEVICE");
    paramHashMap.put("key", this.c.getDeviceKey());
    paramHashMap.put("carrier", this.c.getCarrier());
    paramHashMap.put("appkey", paramString);
    paramHashMap.put("apppkg", this.c.getPackageName());
    paramHashMap.put("appver", String.valueOf(this.c.getAppVersion()));
    paramHashMap.put("sdkver", Integer.valueOf(60000 + ShareSDK.getSDKVersionCode()));
    paramHashMap.put("networktype", this.c.getDetailNetworkTypeForStatic());
    return this.e.fromHashMap(paramHashMap);
  }
  
  private void e()
  {
    String str1 = this.c.getPackageName() + "/" + this.c.getAppVersionName();
    String str2 = "ShareSDK/" + ShareSDK.getSDKVersionName();
    String str3 = "Android/" + this.c.getOSVersionInt();
    this.f = (str1 + " " + str2 + " " + str3);
    this.g = "http://api.share.mob.com:80";
    this.h = true;
  }
  
  private String f()
  {
    return this.g + "/conn";
  }
  
  private String g()
  {
    return this.g + "/date";
  }
  
  private String h()
  {
    return this.g + "/conf4";
  }
  
  private String i()
  {
    return this.g + "/data2";
  }
  
  private String j()
  {
    return "http://up.sharesdk.cn/upload/image";
  }
  
  private String k()
  {
    return this.g + "/log4";
  }
  
  private String l()
  {
    return "http://l.mob.com/url/ShareSdkMapping.do";
  }
  
  private String m()
  {
    return this.g + "/snsconf";
  }
  
  public long a()
  {
    if (!this.b.i()) {
      return 0L;
    }
    Object localObject = "{}";
    try
    {
      String str = this.d.httpGet(g(), null, null, null);
      localObject = str;
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        cn.sharesdk.framework.utils.d.a().w(localThrowable2);
      }
    }
    localObject = this.e.fromJson((String)localObject);
    if (((HashMap)localObject).containsKey("timestamp")) {
      try
      {
        long l = R.parseLong(String.valueOf(((HashMap)localObject).get("timestamp")));
        l = System.currentTimeMillis() - l;
        this.b.a("service_time", Long.valueOf(l));
        return l;
      }
      catch (Throwable localThrowable1)
      {
        cn.sharesdk.framework.utils.d.a().w(localThrowable1);
        return this.b.a();
      }
    }
    return this.b.a();
  }
  
  public HashMap<String, Object> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new KVPair("appkey", paramString));
    paramString = new ArrayList();
    paramString.add(new KVPair("User-Agent", this.f));
    NetworkHelper.NetworkTimeOut localNetworkTimeOut = new NetworkHelper.NetworkTimeOut();
    localNetworkTimeOut.readTimout = 30000;
    localNetworkTimeOut.connectionTimeout = 30000;
    paramString = this.d.httpPost(f(), localArrayList, null, paramString, localNetworkTimeOut);
    cn.sharesdk.framework.utils.d.a().i(" isConnectToServer response == %s", new Object[] { paramString });
    return this.e.fromJson(paramString);
  }
  
  public HashMap<String, Object> a(String paramString1, String paramString2, ArrayList<String> paramArrayList, int paramInt, String paramString3)
  {
    if (!this.h) {}
    do
    {
      do
      {
        return null;
        paramString1 = new ArrayList();
        paramString1.add(new KVPair("key", paramString2));
        int i = 0;
        while (i < paramArrayList.size())
        {
          paramString1.add(new KVPair("urls", ((String)paramArrayList.get(i)).toString()));
          i += 1;
        }
        paramString1.add(new KVPair("deviceid", this.c.getDeviceKey()));
        paramString1.add(new KVPair("snsplat", String.valueOf(paramInt)));
        paramString2 = c(paramString2, paramString3);
      } while (TextUtils.isEmpty(paramString2));
      paramString1.add(new KVPair("m", paramString2));
      paramString2 = new ArrayList();
      paramString2.add(new KVPair("User-Agent", this.f));
      paramArrayList = new NetworkHelper.NetworkTimeOut();
      paramArrayList.readTimout = 5000;
      paramArrayList.connectionTimeout = 5000;
      paramString1 = this.d.httpPost(l(), paramString1, null, paramString2, paramArrayList);
      cn.sharesdk.framework.utils.d.a().i("> SERVER_SHORT_LINK_URL  resp: %s", new Object[] { paramString1 });
      if (TextUtils.isEmpty(paramString1))
      {
        this.h = false;
        return null;
      }
      paramString1 = this.e.fromJson(paramString1);
    } while (((Integer)paramString1.get("status")).intValue() != 200);
    return paramString1;
  }
  
  public void a(cn.sharesdk.framework.statistics.b.c paramc)
  {
    e.a(this.a, paramc.toString(), paramc.e);
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString1 = new ArrayList();
    paramString1.add(new KVPair("m", paramString2));
    paramString2 = new ArrayList();
    paramString2.add(new KVPair("User-Agent", this.f));
    NetworkHelper.NetworkTimeOut localNetworkTimeOut = new NetworkHelper.NetworkTimeOut();
    localNetworkTimeOut.readTimout = 10000;
    localNetworkTimeOut.connectionTimeout = 10000;
    paramString1 = this.d.httpPost(i(), paramString1, null, paramString2, localNetworkTimeOut);
    cn.sharesdk.framework.utils.d.a().i("> uploadEXTDeviceData  resp: %s", new Object[] { paramString1 });
  }
  
  public void a(String paramString, ArrayList<HashMap<String, String>> paramArrayList)
  {
    Object localObject = new HashMap();
    ((HashMap)localObject).put("type", paramString);
    ((HashMap)localObject).put("plat", Integer.valueOf(this.c.getPlatformCode()));
    ((HashMap)localObject).put("device", this.c.getDeviceKey());
    ((HashMap)localObject).put("list", paramArrayList);
    paramArrayList = new Hashon().fromHashMap((HashMap)localObject);
    paramString = new ArrayList();
    paramString.add(new KVPair("m", Data.Base64AES(paramArrayList, "sdk.sharesdk.sdk")));
    paramArrayList = new ArrayList();
    paramArrayList.add(new KVPair("User-Agent", this.f));
    localObject = new NetworkHelper.NetworkTimeOut();
    ((NetworkHelper.NetworkTimeOut)localObject).readTimout = 30000;
    ((NetworkHelper.NetworkTimeOut)localObject).connectionTimeout = 30000;
    paramString = this.d.httpPost(i(), paramString, null, paramArrayList, (NetworkHelper.NetworkTimeOut)localObject);
    cn.sharesdk.framework.utils.d.a().i("> uploadApps list resp: %s", new Object[] { paramString });
  }
  
  public void a(String paramString, HashMap<String, Object> paramHashMap)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new KVPair("m", Data.Base64AES(c(paramString, paramHashMap), "sdk.sharesdk.sdk")));
    paramString = new ArrayList();
    paramString.add(new KVPair("User-Agent", this.f));
    paramHashMap = new NetworkHelper.NetworkTimeOut();
    paramHashMap.readTimout = 30000;
    paramHashMap.connectionTimeout = 30000;
    paramString = this.d.httpPost(i(), localArrayList, null, paramString, paramHashMap);
    cn.sharesdk.framework.utils.d.a().i("> uploadDeviceData  resp: %s", new Object[] { paramString });
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if ("none".equals(this.c.getDetailNetworkTypeForStatic())) {
      throw new IllegalStateException("network is disconnected!");
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new KVPair("m", paramString));
    if (paramBoolean) {}
    for (paramString = "1";; paramString = "0")
    {
      localArrayList.add(new KVPair("t", paramString));
      paramString = new ArrayList();
      paramString.add(new KVPair("User-Agent", this.f));
      NetworkHelper.NetworkTimeOut localNetworkTimeOut = new NetworkHelper.NetworkTimeOut();
      localNetworkTimeOut.readTimout = 30000;
      localNetworkTimeOut.connectionTimeout = 30000;
      this.d.httpPost(k(), localArrayList, null, paramString, localNetworkTimeOut);
      return;
    }
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    e.a(this.a, paramArrayList);
  }
  
  public HashMap<String, Object> b()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("mac", this.c.getMacAddress());
    localHashMap.put("udid", this.c.getDeviceId());
    localHashMap.put("model", this.c.getModel());
    localHashMap.put("factory", this.c.getManufacturer());
    localHashMap.put("plat", Integer.valueOf(this.c.getPlatformCode()));
    localHashMap.put("sysver", String.valueOf(this.c.getOSVersionInt()));
    localHashMap.put("breaked", Boolean.valueOf(false));
    localHashMap.put("screensize", this.c.getScreenSize());
    localHashMap.put("androidid", this.c.getAndroidID());
    String str = this.c.getAdvertisingID();
    if (!TextUtils.isEmpty(str)) {
      localHashMap.put("adsid", str);
    }
    return localHashMap;
  }
  
  public HashMap<String, Object> b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new KVPair("appkey", paramString));
    localArrayList.add(new KVPair("device", this.c.getDeviceKey()));
    localArrayList.add(new KVPair("plat", String.valueOf(this.c.getPlatformCode())));
    localArrayList.add(new KVPair("apppkg", this.c.getPackageName()));
    localArrayList.add(new KVPair("appver", String.valueOf(this.c.getAppVersion())));
    localArrayList.add(new KVPair("sdkver", String.valueOf(60000 + ShareSDK.getSDKVersionCode())));
    localArrayList.add(new KVPair("networktype", this.c.getDetailNetworkTypeForStatic()));
    paramString = new ArrayList();
    paramString.add(new KVPair("User-Agent", this.f));
    NetworkHelper.NetworkTimeOut localNetworkTimeOut = new NetworkHelper.NetworkTimeOut();
    localNetworkTimeOut.readTimout = 10000;
    localNetworkTimeOut.connectionTimeout = 10000;
    paramString = this.d.httpPost(h(), localArrayList, null, paramString, localNetworkTimeOut);
    cn.sharesdk.framework.utils.d.a().i(" get server config response == %s", new Object[] { paramString });
    return this.e.fromJson(paramString);
  }
  
  public HashMap<String, Object> b(String paramString1, String paramString2)
  {
    paramString2 = Base64.decode(paramString2, 2);
    String str = this.c.getDeviceKey();
    paramString1 = new String(Data.AES128Decode(Data.rawMD5(paramString1 + ":" + str), paramString2), "UTF-8").trim();
    return this.e.fromJson(paramString1);
  }
  
  public void b(String paramString, HashMap<String, Object> paramHashMap)
  {
    paramHashMap = this.e.fromHashMap(paramHashMap);
    this.b.b(paramString, paramHashMap);
  }
  
  public String c()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", "DEVEXT");
    localHashMap.put("plat", Integer.valueOf(this.c.getPlatformCode()));
    localHashMap.put("device", this.c.getDeviceKey());
    localHashMap.put("phonename", this.c.getBluetoothName());
    localHashMap.put("signmd5", this.c.getSignMD5());
    if (this.c.getDetailNetworkTypeForStatic().equals("wifi"))
    {
      localHashMap.put("ssid", this.c.getSSID());
      localHashMap.put("bssid", this.c.getBssid());
    }
    return this.e.fromHashMap(localHashMap);
  }
  
  public void c(String paramString)
  {
    this.g = paramString;
  }
  
  public ArrayList<cn.sharesdk.framework.statistics.a.d> d()
  {
    ArrayList localArrayList2 = e.a(this.a);
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null) {
      localArrayList1 = new ArrayList();
    }
    return localArrayList1;
  }
  
  public HashMap<String, Object> d(String paramString)
  {
    paramString = new KVPair("file", paramString);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new KVPair("User-Agent", this.f));
    paramString = this.d.httpPost(j(), null, paramString, localArrayList, null);
    cn.sharesdk.framework.utils.d.a().i("upload file response == %s", new Object[] { paramString });
    return this.e.fromJson(paramString);
  }
  
  public HashMap<String, Object> e(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new KVPair("appkey", paramString));
    localArrayList.add(new KVPair("device", this.c.getDeviceKey()));
    paramString = new ArrayList();
    paramString.add(new KVPair("User-Agent", this.f));
    NetworkHelper.NetworkTimeOut localNetworkTimeOut = new NetworkHelper.NetworkTimeOut();
    localNetworkTimeOut.readTimout = 10000;
    localNetworkTimeOut.connectionTimeout = 10000;
    paramString = this.d.httpPost(m(), localArrayList, null, paramString, localNetworkTimeOut);
    return this.e.fromJson(paramString);
  }
  
  public HashMap<String, Object> f(String paramString)
  {
    paramString = this.b.h(paramString);
    return this.e.fromJson(paramString);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\framework\statistics\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */