package com.google.android.gms.location.places.internal;

import android.text.SpannableString;
import android.text.style.CharacterStyle;
import java.util.Iterator;
import java.util.List;

public class zzc
{
  public static CharSequence zza(String paramString, List<AutocompletePredictionEntity.SubstringEntity> paramList, CharacterStyle paramCharacterStyle)
  {
    if (paramCharacterStyle == null) {
      return paramString;
    }
    paramString = new SpannableString(paramString);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      AutocompletePredictionEntity.SubstringEntity localSubstringEntity = (AutocompletePredictionEntity.SubstringEntity)paramList.next();
      CharacterStyle localCharacterStyle = CharacterStyle.wrap(paramCharacterStyle);
      int i = localSubstringEntity.getOffset();
      int j = localSubstringEntity.getOffset();
      paramString.setSpan(localCharacterStyle, i, localSubstringEntity.getLength() + j, 0);
    }
    return paramString;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\location\places\internal\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */