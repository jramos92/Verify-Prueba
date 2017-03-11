package com.veryfit.multi.vo;

import com.project.library.device.cmd.settings.Userinfos;
import com.veryfit.multi.share.AppSharedPreferences;

public class UserInfo
  extends Userinfos
{
  public String name;
  
  public void init()
  {
    AppSharedPreferences localAppSharedPreferences = AppSharedPreferences.getInstance();
    this.name = localAppSharedPreferences.getUserName();
    if (localAppSharedPreferences.getUserSex()) {}
    for (int i = 0;; i = 1)
    {
      this.gender = i;
      this.year = localAppSharedPreferences.getUserBirthdayYear();
      this.month = localAppSharedPreferences.getUserBirthdayMonth();
      this.day = localAppSharedPreferences.getUserBirthdayDay();
      this.height = localAppSharedPreferences.getUserHeight();
      this.weight = localAppSharedPreferences.getUserWeight();
      return;
    }
  }
  
  public void save()
  {
    AppSharedPreferences localAppSharedPreferences = AppSharedPreferences.getInstance();
    localAppSharedPreferences.setUserName(this.name);
    if (this.gender == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localAppSharedPreferences.setUserSex(bool);
      localAppSharedPreferences.setUserBirthdayYear(this.year);
      localAppSharedPreferences.setUserBirthdayMonth(this.month);
      localAppSharedPreferences.setUserBirthdayDay(this.day);
      localAppSharedPreferences.setUserHeight(this.height);
      localAppSharedPreferences.setUserWeight(this.weight);
      return;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\vo\UserInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */