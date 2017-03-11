package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest.Gender;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Deprecated
public class MediationAdRequest
{
  private final Date zzaT;
  private final AdRequest.Gender zzaU;
  private final Set<String> zzaV;
  private final boolean zzaW;
  private final Location zzaX;
  
  public MediationAdRequest(Date paramDate, AdRequest.Gender paramGender, Set<String> paramSet, boolean paramBoolean, Location paramLocation)
  {
    this.zzaT = paramDate;
    this.zzaU = paramGender;
    this.zzaV = paramSet;
    this.zzaW = paramBoolean;
    this.zzaX = paramLocation;
  }
  
  public Integer getAgeInYears()
  {
    if (this.zzaT != null)
    {
      Calendar localCalendar1 = Calendar.getInstance();
      Calendar localCalendar2 = Calendar.getInstance();
      localCalendar1.setTime(this.zzaT);
      Integer localInteger2 = Integer.valueOf(localCalendar2.get(1) - localCalendar1.get(1));
      Integer localInteger1;
      if (localCalendar2.get(2) >= localCalendar1.get(2))
      {
        localInteger1 = localInteger2;
        if (localCalendar2.get(2) == localCalendar1.get(2))
        {
          localInteger1 = localInteger2;
          if (localCalendar2.get(5) >= localCalendar1.get(5)) {}
        }
      }
      else
      {
        localInteger1 = Integer.valueOf(localInteger2.intValue() - 1);
      }
      return localInteger1;
    }
    return null;
  }
  
  public Date getBirthday()
  {
    return this.zzaT;
  }
  
  public AdRequest.Gender getGender()
  {
    return this.zzaU;
  }
  
  public Set<String> getKeywords()
  {
    return this.zzaV;
  }
  
  public Location getLocation()
  {
    return this.zzaX;
  }
  
  public boolean isTesting()
  {
    return this.zzaW;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\ads\mediation\MediationAdRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */