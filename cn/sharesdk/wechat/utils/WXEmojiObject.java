package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.utils.d;
import com.mob.tools.log.NLog;
import java.io.File;

public class WXEmojiObject
  implements WXMediaMessage.IMediaObject
{
  public byte[] emojiData;
  public String emojiPath;
  
  public WXEmojiObject() {}
  
  public WXEmojiObject(String paramString)
  {
    this.emojiPath = paramString;
  }
  
  public WXEmojiObject(byte[] paramArrayOfByte)
  {
    this.emojiData = paramArrayOfByte;
  }
  
  public boolean checkArgs()
  {
    if (((this.emojiData == null) || (this.emojiData.length == 0)) && (TextUtils.isEmpty(this.emojiPath)))
    {
      d.a().w("MicroMsg.SDK.WXEmojiObject", new Object[] { "checkArgs fail, both arguments is null" });
      return false;
    }
    if ((this.emojiData != null) && (this.emojiData.length > 10485760))
    {
      d.a().w("MicroMsg.SDK.WXEmojiObject", new Object[] { "checkArgs fail, emojiData is too large" });
      return false;
    }
    if (this.emojiPath != null)
    {
      File localFile = new File(this.emojiPath);
      if (!localFile.exists())
      {
        d.a().w("MicroMsg.SDK.WXEmojiObject", new Object[] { "checkArgs fail, emojiPath not found" });
        return false;
      }
      if (localFile.length() > 10485760L)
      {
        d.a().w("MicroMsg.SDK.WXEmojiObject", new Object[] { "checkArgs fail, emojiSize is too large" });
        return false;
      }
    }
    return true;
  }
  
  public void serialize(Bundle paramBundle)
  {
    paramBundle.putByteArray("_wxemojiobject_emojiData", this.emojiData);
    paramBundle.putString("_wxemojiobject_emojiPath", this.emojiPath);
  }
  
  public void setEmojiData(byte[] paramArrayOfByte)
  {
    this.emojiData = paramArrayOfByte;
  }
  
  public void setEmojiPath(String paramString)
  {
    this.emojiPath = paramString;
  }
  
  public int type()
  {
    return 8;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    this.emojiData = paramBundle.getByteArray("_wxemojiobject_emojiData");
    this.emojiPath = paramBundle.getString("_wxemojiobject_emojiPath");
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\wechat\utils\WXEmojiObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */