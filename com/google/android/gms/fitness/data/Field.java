package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class Field
  implements SafeParcelable
{
  public static final Parcelable.Creator<Field> CREATOR = new zzi();
  public static final Field FIELD_ACCURACY;
  public static final Field FIELD_ACTIVITY = zzcQ("activity");
  public static final Field FIELD_ALTITUDE;
  public static final Field FIELD_AVERAGE;
  public static final Field FIELD_BPM;
  public static final Field FIELD_CALORIES;
  public static final Field FIELD_CIRCUMFERENCE;
  public static final Field FIELD_CONFIDENCE = zzcR("confidence");
  public static final Field FIELD_DISTANCE;
  public static final Field FIELD_DURATION;
  public static final Field FIELD_EXERCISE;
  public static final Field FIELD_FOOD_ITEM;
  public static final Field FIELD_HEIGHT;
  public static final Field FIELD_HIGH_LATITUDE;
  public static final Field FIELD_HIGH_LONGITUDE;
  public static final Field FIELD_LATITUDE;
  public static final Field FIELD_LONGITUDE;
  public static final Field FIELD_LOW_LATITUDE;
  public static final Field FIELD_LOW_LONGITUDE;
  public static final Field FIELD_MAX;
  public static final Field FIELD_MEAL_TYPE;
  public static final Field FIELD_MIN;
  public static final Field FIELD_NUM_SEGMENTS;
  public static final Field FIELD_NUTRIENTS;
  public static final Field FIELD_PERCENTAGE;
  public static final Field FIELD_REPETITIONS;
  public static final Field FIELD_RESISTANCE;
  public static final Field FIELD_RESISTANCE_TYPE;
  public static final Field FIELD_REVOLUTIONS;
  public static final Field FIELD_RPM;
  public static final Field FIELD_SPEED;
  public static final Field FIELD_STEPS;
  public static final Field FIELD_WATTS;
  public static final Field FIELD_WEIGHT;
  public static final int FORMAT_FLOAT = 2;
  public static final int FORMAT_INT32 = 1;
  public static final int FORMAT_MAP = 4;
  public static final int FORMAT_STRING = 3;
  public static final int MEAL_TYPE_BREAKFAST = 1;
  public static final int MEAL_TYPE_DINNER = 3;
  public static final int MEAL_TYPE_LUNCH = 2;
  public static final int MEAL_TYPE_SNACK = 4;
  public static final int MEAL_TYPE_UNKNOWN = 0;
  public static final String NUTRIENT_CALCIUM = "calcium";
  public static final String NUTRIENT_CALORIES = "calories";
  public static final String NUTRIENT_CHOLESTEROL = "cholesterol";
  public static final String NUTRIENT_DIETARY_FIBER = "dietary_fiber";
  public static final String NUTRIENT_IRON = "iron";
  public static final String NUTRIENT_MONOUNSATURATED_FAT = "fat.monounsaturated";
  public static final String NUTRIENT_POLYUNSATURATED_FAT = "fat.polyunsaturated";
  public static final String NUTRIENT_POTASSIUM = "potassium";
  public static final String NUTRIENT_PROTEIN = "protein";
  public static final String NUTRIENT_SATURATED_FAT = "fat.saturated";
  public static final String NUTRIENT_SODIUM = "sodium";
  public static final String NUTRIENT_SUGAR = "sugar";
  public static final String NUTRIENT_TOTAL_CARBS = "carbs.total";
  public static final String NUTRIENT_TOTAL_FAT = "fat.total";
  public static final String NUTRIENT_TRANS_FAT = "fat.trans";
  public static final String NUTRIENT_UNSATURATED_FAT = "fat.unsaturated";
  public static final String NUTRIENT_VITAMIN_A = "vitamin_a";
  public static final String NUTRIENT_VITAMIN_C = "vitamin_c";
  public static final int RESISTANCE_TYPE_BARBELL = 1;
  public static final int RESISTANCE_TYPE_BODY = 6;
  public static final int RESISTANCE_TYPE_CABLE = 2;
  public static final int RESISTANCE_TYPE_DUMBBELL = 3;
  public static final int RESISTANCE_TYPE_KETTLEBELL = 4;
  public static final int RESISTANCE_TYPE_MACHINE = 5;
  public static final int RESISTANCE_TYPE_UNKNOWN = 0;
  public static final Field zzaqB = zzcT("activity_confidence");
  public static final Field zzaqC;
  public static final Field zzaqD;
  public static final Field zzaqE;
  public static final Field zzaqF;
  public static final Field zzaqG;
  public static final Field zzaqH;
  public static final Field zzaqI;
  public static final Field zzaqJ;
  public static final Field zzaqK;
  public static final Field zzaqL;
  public static final Field zzaqM;
  public static final Field zzaqN;
  private final String mName;
  private final int mVersionCode;
  private final int zzaqO;
  
  static
  {
    FIELD_STEPS = zzcQ("steps");
    FIELD_DURATION = zzcQ("duration");
    zzaqC = zzcT("activity_duration");
    zzaqD = zzcT("activity_duration.ascending");
    zzaqE = zzcT("activity_duration.descending");
    FIELD_BPM = zzcR("bpm");
    FIELD_LATITUDE = zzcR("latitude");
    FIELD_LONGITUDE = zzcR("longitude");
    FIELD_ACCURACY = zzcR("accuracy");
    FIELD_ALTITUDE = zzcR("altitude");
    FIELD_DISTANCE = zzcR("distance");
    FIELD_HEIGHT = zzcR("height");
    FIELD_WEIGHT = zzcR("weight");
    FIELD_CIRCUMFERENCE = zzcR("circumference");
    FIELD_PERCENTAGE = zzcR("percentage");
    FIELD_SPEED = zzcR("speed");
    FIELD_RPM = zzcR("rpm");
    FIELD_REVOLUTIONS = zzcQ("revolutions");
    FIELD_CALORIES = zzcR("calories");
    FIELD_WATTS = zzcR("watts");
    FIELD_MEAL_TYPE = zzcQ("meal_type");
    FIELD_FOOD_ITEM = zzcS("food_item");
    FIELD_NUTRIENTS = zzcT("nutrients");
    zzaqF = zzcR("elevation.change");
    zzaqG = zzcT("elevation.gain");
    zzaqH = zzcT("elevation.loss");
    zzaqI = zzcR("floors");
    zzaqJ = zzcT("floor.gain");
    zzaqK = zzcT("floor.loss");
    FIELD_EXERCISE = zzcS("exercise");
    FIELD_REPETITIONS = zzcQ("repetitions");
    FIELD_RESISTANCE = zzcR("resistance");
    FIELD_RESISTANCE_TYPE = zzcQ("resistance_type");
    FIELD_NUM_SEGMENTS = zzcQ("num_segments");
    FIELD_AVERAGE = zzcR("average");
    FIELD_MAX = zzcR("max");
    FIELD_MIN = zzcR("min");
    FIELD_LOW_LATITUDE = zzcR("low_latitude");
    FIELD_LOW_LONGITUDE = zzcR("low_longitude");
    FIELD_HIGH_LATITUDE = zzcR("high_latitude");
    FIELD_HIGH_LONGITUDE = zzcR("high_longitude");
    zzaqL = zzcR("x");
    zzaqM = zzcR("y");
    zzaqN = zzcR("z");
  }
  
  Field(int paramInt1, String paramString, int paramInt2)
  {
    this.mVersionCode = paramInt1;
    this.mName = ((String)zzx.zzw(paramString));
    this.zzaqO = paramInt2;
  }
  
  private Field(String paramString, int paramInt)
  {
    this(1, paramString, paramInt);
  }
  
  private boolean zza(Field paramField)
  {
    return (this.mName.equals(paramField.mName)) && (this.zzaqO == paramField.zzaqO);
  }
  
  private static Field zzcQ(String paramString)
  {
    return new Field(paramString, 1);
  }
  
  private static Field zzcR(String paramString)
  {
    return new Field(paramString, 2);
  }
  
  private static Field zzcS(String paramString)
  {
    return new Field(paramString, 3);
  }
  
  private static Field zzcT(String paramString)
  {
    return new Field(paramString, 4);
  }
  
  public static Field zzo(String paramString, int paramInt)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return new Field(paramString, paramInt);
        if (paramString.equals("accuracy"))
        {
          i = 0;
          continue;
          if (paramString.equals("activity"))
          {
            i = 1;
            continue;
            if (paramString.equals("activity_duration"))
            {
              i = 2;
              continue;
              if (paramString.equals("activity_duration.ascending"))
              {
                i = 3;
                continue;
                if (paramString.equals("activity_duration.descending"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("altitude"))
                  {
                    i = 5;
                    continue;
                    if (paramString.equals("average"))
                    {
                      i = 6;
                      continue;
                      if (paramString.equals("bpm"))
                      {
                        i = 7;
                        continue;
                        if (paramString.equals("calories"))
                        {
                          i = 8;
                          continue;
                          if (paramString.equals("circumference"))
                          {
                            i = 9;
                            continue;
                            if (paramString.equals("confidence"))
                            {
                              i = 10;
                              continue;
                              if (paramString.equals("distance"))
                              {
                                i = 11;
                                continue;
                                if (paramString.equals("duration"))
                                {
                                  i = 12;
                                  continue;
                                  if (paramString.equals("elevation.change"))
                                  {
                                    i = 13;
                                    continue;
                                    if (paramString.equals("elevation.gain"))
                                    {
                                      i = 14;
                                      continue;
                                      if (paramString.equals("elevation.loss"))
                                      {
                                        i = 15;
                                        continue;
                                        if (paramString.equals("exercise"))
                                        {
                                          i = 16;
                                          continue;
                                          if (paramString.equals("floor.gain"))
                                          {
                                            i = 17;
                                            continue;
                                            if (paramString.equals("floor.loss"))
                                            {
                                              i = 18;
                                              continue;
                                              if (paramString.equals("floors"))
                                              {
                                                i = 19;
                                                continue;
                                                if (paramString.equals("food_item"))
                                                {
                                                  i = 20;
                                                  continue;
                                                  if (paramString.equals("height"))
                                                  {
                                                    i = 21;
                                                    continue;
                                                    if (paramString.equals("high_latitude"))
                                                    {
                                                      i = 22;
                                                      continue;
                                                      if (paramString.equals("high_longitude"))
                                                      {
                                                        i = 23;
                                                        continue;
                                                        if (paramString.equals("latitude"))
                                                        {
                                                          i = 24;
                                                          continue;
                                                          if (paramString.equals("longitude"))
                                                          {
                                                            i = 25;
                                                            continue;
                                                            if (paramString.equals("low_latitude"))
                                                            {
                                                              i = 26;
                                                              continue;
                                                              if (paramString.equals("low_longitude"))
                                                              {
                                                                i = 27;
                                                                continue;
                                                                if (paramString.equals("max"))
                                                                {
                                                                  i = 28;
                                                                  continue;
                                                                  if (paramString.equals("meal_type"))
                                                                  {
                                                                    i = 29;
                                                                    continue;
                                                                    if (paramString.equals("min"))
                                                                    {
                                                                      i = 30;
                                                                      continue;
                                                                      if (paramString.equals("num_segments"))
                                                                      {
                                                                        i = 31;
                                                                        continue;
                                                                        if (paramString.equals("nutrients"))
                                                                        {
                                                                          i = 32;
                                                                          continue;
                                                                          if (paramString.equals("percentage"))
                                                                          {
                                                                            i = 33;
                                                                            continue;
                                                                            if (paramString.equals("repetitions"))
                                                                            {
                                                                              i = 34;
                                                                              continue;
                                                                              if (paramString.equals("resistance"))
                                                                              {
                                                                                i = 35;
                                                                                continue;
                                                                                if (paramString.equals("resistance_type"))
                                                                                {
                                                                                  i = 36;
                                                                                  continue;
                                                                                  if (paramString.equals("revolutions"))
                                                                                  {
                                                                                    i = 37;
                                                                                    continue;
                                                                                    if (paramString.equals("rpm"))
                                                                                    {
                                                                                      i = 38;
                                                                                      continue;
                                                                                      if (paramString.equals("speed"))
                                                                                      {
                                                                                        i = 39;
                                                                                        continue;
                                                                                        if (paramString.equals("steps"))
                                                                                        {
                                                                                          i = 40;
                                                                                          continue;
                                                                                          if (paramString.equals("watts"))
                                                                                          {
                                                                                            i = 41;
                                                                                            continue;
                                                                                            if (paramString.equals("weight"))
                                                                                            {
                                                                                              i = 42;
                                                                                              continue;
                                                                                              if (paramString.equals("x"))
                                                                                              {
                                                                                                i = 43;
                                                                                                continue;
                                                                                                if (paramString.equals("y"))
                                                                                                {
                                                                                                  i = 44;
                                                                                                  continue;
                                                                                                  if (paramString.equals("z")) {
                                                                                                    i = 45;
                                                                                                  }
                                                                                                }
                                                                                              }
                                                                                            }
                                                                                          }
                                                                                        }
                                                                                      }
                                                                                    }
                                                                                  }
                                                                                }
                                                                              }
                                                                            }
                                                                          }
                                                                        }
                                                                      }
                                                                    }
                                                                  }
                                                                }
                                                              }
                                                            }
                                                          }
                                                        }
                                                      }
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    return FIELD_ACCURACY;
    return FIELD_ACTIVITY;
    return zzaqC;
    return zzaqD;
    return zzaqE;
    return FIELD_ALTITUDE;
    return FIELD_AVERAGE;
    return FIELD_BPM;
    return FIELD_CALORIES;
    return FIELD_CIRCUMFERENCE;
    return FIELD_CONFIDENCE;
    return FIELD_DISTANCE;
    return FIELD_DURATION;
    return zzaqF;
    return zzaqG;
    return zzaqH;
    return FIELD_EXERCISE;
    return zzaqJ;
    return zzaqK;
    return zzaqI;
    return FIELD_FOOD_ITEM;
    return FIELD_HEIGHT;
    return FIELD_HIGH_LATITUDE;
    return FIELD_HIGH_LONGITUDE;
    return FIELD_LATITUDE;
    return FIELD_LONGITUDE;
    return FIELD_LOW_LATITUDE;
    return FIELD_LOW_LONGITUDE;
    return FIELD_MAX;
    return FIELD_MEAL_TYPE;
    return FIELD_MIN;
    return FIELD_NUM_SEGMENTS;
    return FIELD_NUTRIENTS;
    return FIELD_PERCENTAGE;
    return FIELD_REPETITIONS;
    return FIELD_RESISTANCE;
    return FIELD_RESISTANCE_TYPE;
    return FIELD_REVOLUTIONS;
    return FIELD_RPM;
    return FIELD_SPEED;
    return FIELD_STEPS;
    return FIELD_WATTS;
    return FIELD_WEIGHT;
    return zzaqL;
    return zzaqM;
    return zzaqN;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof Field)) && (zza((Field)paramObject)));
  }
  
  public int getFormat()
  {
    return this.zzaqO;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return this.mName.hashCode();
  }
  
  public String toString()
  {
    String str2 = this.mName;
    if (this.zzaqO == 1) {}
    for (String str1 = "i";; str1 = "f") {
      return String.format("%s(%s)", new Object[] { str2, str1 });
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\data\Field.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */