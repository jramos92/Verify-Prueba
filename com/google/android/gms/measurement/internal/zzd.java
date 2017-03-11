package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzpk.zzd;
import com.google.android.gms.internal.zzrx;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

class zzd
  extends zzy
{
  private final zza zzaLU;
  private final zzac zzaLV = new zzac(zzit());
  
  zzd(zzv paramzzv)
  {
    super(paramzzv);
    paramzzv = zziZ();
    this.zzaLU = new zza(getContext(), paramzzv);
  }
  
  static int zza(Cursor paramCursor, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      return paramCursor.getType(paramInt);
    }
    CursorWindow localCursorWindow = ((SQLiteCursor)paramCursor).getWindow();
    int i = paramCursor.getPosition();
    if (localCursorWindow.isNull(i, paramInt)) {
      return 0;
    }
    if (localCursorWindow.isLong(i, paramInt)) {
      return 1;
    }
    if (localCursorWindow.isFloat(i, paramInt)) {
      return 2;
    }
    if (localCursorWindow.isString(i, paramInt)) {
      return 3;
    }
    if (localCursorWindow.isBlob(i, paramInt)) {
      return 4;
    }
    return -1;
  }
  
  private long zza(String paramString, String[] paramArrayOfString, long paramLong)
  {
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    Object localObject = null;
    String[] arrayOfString = null;
    try
    {
      paramArrayOfString = localSQLiteDatabase.rawQuery(paramString, paramArrayOfString);
      arrayOfString = paramArrayOfString;
      localObject = paramArrayOfString;
      long l;
      if (paramArrayOfString.moveToFirst())
      {
        arrayOfString = paramArrayOfString;
        localObject = paramArrayOfString;
        paramLong = paramArrayOfString.getLong(0);
        l = paramLong;
        if (paramArrayOfString != null)
        {
          paramArrayOfString.close();
          l = paramLong;
        }
      }
      do
      {
        return l;
        l = paramLong;
      } while (paramArrayOfString == null);
      paramArrayOfString.close();
      return paramLong;
    }
    catch (SQLiteException paramArrayOfString)
    {
      localObject = arrayOfString;
      zzyd().zzzK().zze("Database error", paramString, paramArrayOfString);
      localObject = arrayOfString;
      throw paramArrayOfString;
    }
    finally
    {
      if (localObject != null) {
        ((Cursor)localObject).close();
      }
    }
  }
  
  private String zziZ()
  {
    if (!zzzt().zzjA()) {
      return zzzt().zzka();
    }
    if (zzzt().zzjB()) {
      return zzzt().zzka();
    }
    zzyd().zzzM().zzec("Using secondary database");
    return zzzt().zzkb();
  }
  
  private void zzzv()
  {
    zzis();
    zziE();
    long l1 = zzzs().zzaNl.get();
    long l2 = zzit().elapsedRealtime();
    if (Math.abs(l2 - l1) > zzzt().zzzd())
    {
      zzzs().zzaNl.set(l2);
      zzzw();
    }
  }
  
  public void beginTransaction()
  {
    zziE();
    getWritableDatabase().beginTransaction();
  }
  
  public void endTransaction()
  {
    zziE();
    getWritableDatabase().endTransaction();
  }
  
  SQLiteDatabase getWritableDatabase()
  {
    zzis();
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.zzaLU.getWritableDatabase();
      return localSQLiteDatabase;
    }
    catch (SQLiteException localSQLiteException)
    {
      zzyd().zzzL().zzj("Error opening database", localSQLiteException);
      throw localSQLiteException;
    }
  }
  
  public void setTransactionSuccessful()
  {
    zziE();
    getWritableDatabase().setTransactionSuccessful();
  }
  
  /* Error */
  public zzh zzH(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_1
    //   4: invokestatic 225	com/google/android/gms/common/internal/zzx:zzcr	(Ljava/lang/String;)Ljava/lang/String;
    //   7: pop
    //   8: aload_2
    //   9: invokestatic 225	com/google/android/gms/common/internal/zzx:zzcr	(Ljava/lang/String;)Ljava/lang/String;
    //   12: pop
    //   13: aload_0
    //   14: invokevirtual 158	com/google/android/gms/measurement/internal/zzd:zzis	()V
    //   17: aload_0
    //   18: invokevirtual 161	com/google/android/gms/measurement/internal/zzd:zziE	()V
    //   21: aload_0
    //   22: invokevirtual 88	com/google/android/gms/measurement/internal/zzd:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   25: ldc -29
    //   27: iconst_3
    //   28: anewarray 229	java/lang/String
    //   31: dup
    //   32: iconst_0
    //   33: ldc -25
    //   35: aastore
    //   36: dup
    //   37: iconst_1
    //   38: ldc -23
    //   40: aastore
    //   41: dup
    //   42: iconst_2
    //   43: ldc -21
    //   45: aastore
    //   46: ldc -19
    //   48: iconst_2
    //   49: anewarray 229	java/lang/String
    //   52: dup
    //   53: iconst_0
    //   54: aload_1
    //   55: aastore
    //   56: dup
    //   57: iconst_1
    //   58: aload_2
    //   59: aastore
    //   60: aconst_null
    //   61: aconst_null
    //   62: aconst_null
    //   63: invokevirtual 241	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   66: astore 4
    //   68: aload 4
    //   70: invokeinterface 98 1 0
    //   75: istore_3
    //   76: iload_3
    //   77: ifne +19 -> 96
    //   80: aload 4
    //   82: ifnull +10 -> 92
    //   85: aload 4
    //   87: invokeinterface 106 1 0
    //   92: aconst_null
    //   93: astore_1
    //   94: aload_1
    //   95: areturn
    //   96: new 243	com/google/android/gms/measurement/internal/zzh
    //   99: dup
    //   100: aload_1
    //   101: aload_2
    //   102: aload 4
    //   104: iconst_0
    //   105: invokeinterface 102 2 0
    //   110: aload 4
    //   112: iconst_1
    //   113: invokeinterface 102 2 0
    //   118: aload 4
    //   120: iconst_2
    //   121: invokeinterface 102 2 0
    //   126: invokespecial 246	com/google/android/gms/measurement/internal/zzh:<init>	(Ljava/lang/String;Ljava/lang/String;JJJ)V
    //   129: astore 5
    //   131: aload 4
    //   133: invokeinterface 249 1 0
    //   138: ifeq +15 -> 153
    //   141: aload_0
    //   142: invokevirtual 110	com/google/android/gms/measurement/internal/zzd:zzyd	()Lcom/google/android/gms/measurement/internal/zzp;
    //   145: invokevirtual 116	com/google/android/gms/measurement/internal/zzp:zzzK	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   148: ldc -5
    //   150: invokevirtual 151	com/google/android/gms/measurement/internal/zzp$zza:zzec	(Ljava/lang/String;)V
    //   153: aload 5
    //   155: astore_1
    //   156: aload 4
    //   158: ifnull -64 -> 94
    //   161: aload 4
    //   163: invokeinterface 106 1 0
    //   168: aload 5
    //   170: areturn
    //   171: astore 5
    //   173: aconst_null
    //   174: astore 4
    //   176: aload_0
    //   177: invokevirtual 110	com/google/android/gms/measurement/internal/zzd:zzyd	()Lcom/google/android/gms/measurement/internal/zzp;
    //   180: invokevirtual 116	com/google/android/gms/measurement/internal/zzp:zzzK	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   183: ldc -3
    //   185: aload_1
    //   186: aload_2
    //   187: aload 5
    //   189: invokevirtual 257	com/google/android/gms/measurement/internal/zzp$zza:zzd	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   192: aload 4
    //   194: ifnull +10 -> 204
    //   197: aload 4
    //   199: invokeinterface 106 1 0
    //   204: aconst_null
    //   205: areturn
    //   206: astore_1
    //   207: aload 5
    //   209: astore_2
    //   210: aload_2
    //   211: ifnull +9 -> 220
    //   214: aload_2
    //   215: invokeinterface 106 1 0
    //   220: aload_1
    //   221: athrow
    //   222: astore_1
    //   223: aload 4
    //   225: astore_2
    //   226: goto -16 -> 210
    //   229: astore_1
    //   230: aload 4
    //   232: astore_2
    //   233: goto -23 -> 210
    //   236: astore 5
    //   238: goto -62 -> 176
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	this	zzd
    //   0	241	1	paramString1	String
    //   0	241	2	paramString2	String
    //   75	2	3	bool	boolean
    //   66	165	4	localCursor	Cursor
    //   1	168	5	localzzh	zzh
    //   171	37	5	localSQLiteException1	SQLiteException
    //   236	1	5	localSQLiteException2	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   21	68	171	android/database/sqlite/SQLiteException
    //   21	68	206	finally
    //   68	76	222	finally
    //   96	153	222	finally
    //   176	192	229	finally
    //   68	76	236	android/database/sqlite/SQLiteException
    //   96	153	236	android/database/sqlite/SQLiteException
  }
  
  public void zzI(String paramString1, String paramString2)
  {
    zzx.zzcr(paramString1);
    zzx.zzcr(paramString2);
    zzis();
    zziE();
    try
    {
      int i = getWritableDatabase().delete("user_attributes", "app_id=? and name=?", new String[] { paramString1, paramString2 });
      zzyd().zzzQ().zzj("Deleted user attribute rows:", Integer.valueOf(i));
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      zzyd().zzzK().zzd("Error deleting user attribute", paramString1, paramString2, localSQLiteException);
    }
  }
  
  public void zzN(long paramLong)
  {
    zzis();
    zziE();
    if (getWritableDatabase().delete("queue", "rowid=?", new String[] { String.valueOf(paramLong) }) != 1) {
      zzyd().zzzK().zzec("Deleted fewer rows from queue than expected");
    }
  }
  
  void zza(ContentValues paramContentValues, String paramString, Object paramObject)
  {
    zzx.zzcr(paramString);
    zzx.zzw(paramObject);
    if ((paramObject instanceof String))
    {
      paramContentValues.put(paramString, (String)paramObject);
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramContentValues.put(paramString, (Long)paramObject);
      return;
    }
    if ((paramObject instanceof Float))
    {
      paramContentValues.put(paramString, (Float)paramObject);
      return;
    }
    throw new IllegalArgumentException("Invalid value type");
  }
  
  public void zza(zzpk.zzd paramzzd)
  {
    zzis();
    zziE();
    zzx.zzw(paramzzd);
    zzx.zzcr(paramzzd.zzaOX);
    zzx.zzw(paramzzd.zzaOP);
    zzzv();
    long l = zzit().currentTimeMillis();
    if ((paramzzd.zzaOP.longValue() < l - zzzt().zzzc()) || (paramzzd.zzaOP.longValue() > zzzt().zzzc() + l)) {
      zzyd().zzzL().zze("Storing bundle outside of the max uploading time span. now, timestamp", Long.valueOf(l), paramzzd.zzaOP);
    }
    try
    {
      byte[] arrayOfByte = new byte[paramzzd.zzFR()];
      Object localObject = zzrx.zzC(arrayOfByte);
      paramzzd.zza((zzrx)localObject);
      ((zzrx)localObject).zzFE();
      arrayOfByte = zzzq().zzg(arrayOfByte);
      zzyd().zzzQ().zzj("Saving bundle, size", Integer.valueOf(arrayOfByte.length));
      localObject = new ContentValues();
      ((ContentValues)localObject).put("app_id", paramzzd.zzaOX);
      ((ContentValues)localObject).put("bundle_end_timestamp", paramzzd.zzaOP);
      ((ContentValues)localObject).put("data", arrayOfByte);
      return;
    }
    catch (IOException paramzzd)
    {
      try
      {
        if (getWritableDatabase().insert("queue", null, (ContentValues)localObject) == -1L) {
          zzyd().zzzK().zzec("Failed to insert bundle (got -1)");
        }
        return;
      }
      catch (SQLiteException paramzzd)
      {
        zzyd().zzzK().zzj("Error storing bundle", paramzzd);
      }
      paramzzd = paramzzd;
      zzyd().zzzK().zzj("Data loss. Failed to serialize bundle", paramzzd);
      return;
    }
  }
  
  public void zza(zza paramzza)
  {
    zzx.zzw(paramzza);
    zzis();
    zziE();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("app_id", paramzza.zzaLl);
    localContentValues.put("app_instance_id", paramzza.zzaLK);
    localContentValues.put("gmp_app_id", paramzza.zzaLL);
    localContentValues.put("resettable_device_id_hash", paramzza.zzaLM);
    localContentValues.put("last_bundle_index", Long.valueOf(paramzza.zzaLN));
    localContentValues.put("last_bundle_end_timestamp", Long.valueOf(paramzza.zzaLO));
    try
    {
      if (getWritableDatabase().insertWithOnConflict("apps", null, localContentValues, 5) == -1L) {
        zzyd().zzzK().zzec("Failed to insert/update app (got -1)");
      }
      return;
    }
    catch (SQLiteException paramzza)
    {
      zzyd().zzzK().zzj("Error storing app", paramzza);
    }
  }
  
  public void zza(zzae paramzzae)
  {
    zzx.zzw(paramzzae);
    zzis();
    zziE();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("app_id", paramzzae.zzaLl);
    localContentValues.put("name", paramzzae.mName);
    localContentValues.put("set_timestamp", Long.valueOf(paramzzae.zzaOy));
    zza(localContentValues, "value", paramzzae.zzJy);
    try
    {
      if (getWritableDatabase().insertWithOnConflict("user_attributes", null, localContentValues, 5) == -1L) {
        zzyd().zzzK().zzec("Failed to insert/update user attribute (got -1)");
      }
      return;
    }
    catch (SQLiteException paramzzae)
    {
      zzyd().zzzK().zzj("Error storing user attribute", paramzzae);
    }
  }
  
  public void zza(zzh paramzzh)
  {
    zzx.zzw(paramzzh);
    zzis();
    zziE();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("app_id", paramzzh.zzaLl);
    localContentValues.put("name", paramzzh.mName);
    localContentValues.put("lifetime_count", Long.valueOf(paramzzh.zzaMe));
    localContentValues.put("current_bundle_count", Long.valueOf(paramzzh.zzaMf));
    localContentValues.put("last_fire_timestamp", Long.valueOf(paramzzh.zzaMg));
    try
    {
      if (getWritableDatabase().insertWithOnConflict("events", null, localContentValues, 5) == -1L) {
        zzyd().zzzK().zzec("Failed to insert/update event aggregates (got -1)");
      }
      return;
    }
    catch (SQLiteException paramzzh)
    {
      zzyd().zzzK().zzj("Error storing event aggregates", paramzzh);
    }
  }
  
  Object zzb(Cursor paramCursor, int paramInt)
  {
    int i = zza(paramCursor, paramInt);
    switch (i)
    {
    default: 
      zzyd().zzzK().zzj("Loaded invalid unknown value type, ignoring it", Integer.valueOf(i));
      return null;
    case 0: 
      zzyd().zzzK().zzec("Loaded invalid null value from database");
      return null;
    case 1: 
      return Long.valueOf(paramCursor.getLong(paramInt));
    case 2: 
      return Float.valueOf(paramCursor.getFloat(paramInt));
    case 3: 
      return paramCursor.getString(paramInt);
    }
    zzyd().zzzK().zzec("Loaded invalid blob type value, ignoring it");
    return null;
  }
  
  /* Error */
  public java.util.List<zzae> zzdZ(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 225	com/google/android/gms/common/internal/zzx:zzcr	(Ljava/lang/String;)Ljava/lang/String;
    //   4: pop
    //   5: aload_0
    //   6: invokevirtual 158	com/google/android/gms/measurement/internal/zzd:zzis	()V
    //   9: aload_0
    //   10: invokevirtual 161	com/google/android/gms/measurement/internal/zzd:zziE	()V
    //   13: new 501	java/util/ArrayList
    //   16: dup
    //   17: invokespecial 502	java/util/ArrayList:<init>	()V
    //   20: astore 7
    //   22: aload_0
    //   23: invokevirtual 88	com/google/android/gms/measurement/internal/zzd:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   26: astore 6
    //   28: aload_0
    //   29: invokevirtual 131	com/google/android/gms/measurement/internal/zzd:zzzt	()Lcom/google/android/gms/measurement/internal/zzc;
    //   32: invokevirtual 505	com/google/android/gms/measurement/internal/zzc:zzyW	()I
    //   35: istore_2
    //   36: aload 6
    //   38: ldc_w 261
    //   41: iconst_3
    //   42: anewarray 229	java/lang/String
    //   45: dup
    //   46: iconst_0
    //   47: ldc_w 441
    //   50: aastore
    //   51: dup
    //   52: iconst_1
    //   53: ldc_w 446
    //   56: aastore
    //   57: dup
    //   58: iconst_2
    //   59: ldc_w 451
    //   62: aastore
    //   63: ldc_w 507
    //   66: iconst_1
    //   67: anewarray 229	java/lang/String
    //   70: dup
    //   71: iconst_0
    //   72: aload_1
    //   73: aastore
    //   74: aconst_null
    //   75: aconst_null
    //   76: ldc_w 509
    //   79: iload_2
    //   80: iconst_1
    //   81: iadd
    //   82: invokestatic 511	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   85: invokevirtual 514	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   88: astore 6
    //   90: aload 6
    //   92: invokeinterface 98 1 0
    //   97: istore_3
    //   98: iload_3
    //   99: ifne +18 -> 117
    //   102: aload 6
    //   104: ifnull +10 -> 114
    //   107: aload 6
    //   109: invokeinterface 106 1 0
    //   114: aload 7
    //   116: areturn
    //   117: aload 6
    //   119: iconst_0
    //   120: invokeinterface 495 2 0
    //   125: astore 8
    //   127: aload 6
    //   129: iconst_1
    //   130: invokeinterface 102 2 0
    //   135: lstore 4
    //   137: aload_0
    //   138: aload 6
    //   140: iconst_2
    //   141: invokevirtual 516	com/google/android/gms/measurement/internal/zzd:zzb	(Landroid/database/Cursor;I)Ljava/lang/Object;
    //   144: astore 9
    //   146: aload 9
    //   148: ifnonnull +86 -> 234
    //   151: aload_0
    //   152: invokevirtual 110	com/google/android/gms/measurement/internal/zzd:zzyd	()Lcom/google/android/gms/measurement/internal/zzp;
    //   155: invokevirtual 116	com/google/android/gms/measurement/internal/zzp:zzzK	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   158: ldc_w 518
    //   161: invokevirtual 151	com/google/android/gms/measurement/internal/zzp$zza:zzec	(Ljava/lang/String;)V
    //   164: aload 6
    //   166: invokeinterface 249 1 0
    //   171: ifne -54 -> 117
    //   174: aload 7
    //   176: invokeinterface 523 1 0
    //   181: aload_0
    //   182: invokevirtual 131	com/google/android/gms/measurement/internal/zzd:zzzt	()Lcom/google/android/gms/measurement/internal/zzc;
    //   185: invokevirtual 505	com/google/android/gms/measurement/internal/zzc:zzyW	()I
    //   188: if_icmple +31 -> 219
    //   191: aload_0
    //   192: invokevirtual 110	com/google/android/gms/measurement/internal/zzd:zzyd	()Lcom/google/android/gms/measurement/internal/zzp;
    //   195: invokevirtual 116	com/google/android/gms/measurement/internal/zzp:zzzK	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   198: ldc_w 525
    //   201: invokevirtual 151	com/google/android/gms/measurement/internal/zzp$zza:zzec	(Ljava/lang/String;)V
    //   204: aload 7
    //   206: aload_0
    //   207: invokevirtual 131	com/google/android/gms/measurement/internal/zzd:zzzt	()Lcom/google/android/gms/measurement/internal/zzc;
    //   210: invokevirtual 505	com/google/android/gms/measurement/internal/zzc:zzyW	()I
    //   213: invokeinterface 529 2 0
    //   218: pop
    //   219: aload 6
    //   221: ifnull +10 -> 231
    //   224: aload 6
    //   226: invokeinterface 106 1 0
    //   231: aload 7
    //   233: areturn
    //   234: aload 7
    //   236: new 438	com/google/android/gms/measurement/internal/zzae
    //   239: dup
    //   240: aload_1
    //   241: aload 8
    //   243: lload 4
    //   245: aload 9
    //   247: invokespecial 532	com/google/android/gms/measurement/internal/zzae:<init>	(Ljava/lang/String;Ljava/lang/String;JLjava/lang/Object;)V
    //   250: invokeinterface 536 2 0
    //   255: pop
    //   256: goto -92 -> 164
    //   259: astore 7
    //   261: aload_0
    //   262: invokevirtual 110	com/google/android/gms/measurement/internal/zzd:zzyd	()Lcom/google/android/gms/measurement/internal/zzp;
    //   265: invokevirtual 116	com/google/android/gms/measurement/internal/zzp:zzzK	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   268: ldc_w 538
    //   271: aload_1
    //   272: aload 7
    //   274: invokevirtual 124	com/google/android/gms/measurement/internal/zzp$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   277: aload 6
    //   279: ifnull +10 -> 289
    //   282: aload 6
    //   284: invokeinterface 106 1 0
    //   289: aconst_null
    //   290: areturn
    //   291: astore_1
    //   292: aconst_null
    //   293: astore 6
    //   295: aload 6
    //   297: ifnull +10 -> 307
    //   300: aload 6
    //   302: invokeinterface 106 1 0
    //   307: aload_1
    //   308: athrow
    //   309: astore_1
    //   310: goto -15 -> 295
    //   313: astore_1
    //   314: goto -19 -> 295
    //   317: astore 7
    //   319: aconst_null
    //   320: astore 6
    //   322: goto -61 -> 261
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	325	0	this	zzd
    //   0	325	1	paramString	String
    //   35	47	2	i	int
    //   97	2	3	bool	boolean
    //   135	109	4	l	long
    //   26	295	6	localObject1	Object
    //   20	215	7	localArrayList	java.util.ArrayList
    //   259	14	7	localSQLiteException1	SQLiteException
    //   317	1	7	localSQLiteException2	SQLiteException
    //   125	117	8	str	String
    //   144	102	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   90	98	259	android/database/sqlite/SQLiteException
    //   117	146	259	android/database/sqlite/SQLiteException
    //   151	164	259	android/database/sqlite/SQLiteException
    //   164	219	259	android/database/sqlite/SQLiteException
    //   234	256	259	android/database/sqlite/SQLiteException
    //   22	90	291	finally
    //   90	98	309	finally
    //   117	146	309	finally
    //   151	164	309	finally
    //   164	219	309	finally
    //   234	256	309	finally
    //   261	277	313	finally
    //   22	90	317	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public zza zzea(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_1
    //   4: invokestatic 225	com/google/android/gms/common/internal/zzx:zzcr	(Ljava/lang/String;)Ljava/lang/String;
    //   7: pop
    //   8: aload_0
    //   9: invokevirtual 158	com/google/android/gms/measurement/internal/zzd:zzis	()V
    //   12: aload_0
    //   13: invokevirtual 161	com/google/android/gms/measurement/internal/zzd:zziE	()V
    //   16: aload_0
    //   17: invokevirtual 88	com/google/android/gms/measurement/internal/zzd:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   20: ldc_w 427
    //   23: iconst_5
    //   24: anewarray 229	java/lang/String
    //   27: dup
    //   28: iconst_0
    //   29: ldc_w 401
    //   32: aastore
    //   33: dup
    //   34: iconst_1
    //   35: ldc_w 406
    //   38: aastore
    //   39: dup
    //   40: iconst_2
    //   41: ldc_w 411
    //   44: aastore
    //   45: dup
    //   46: iconst_3
    //   47: ldc_w 416
    //   50: aastore
    //   51: dup
    //   52: iconst_4
    //   53: ldc_w 422
    //   56: aastore
    //   57: ldc_w 507
    //   60: iconst_1
    //   61: anewarray 229	java/lang/String
    //   64: dup
    //   65: iconst_0
    //   66: aload_1
    //   67: aastore
    //   68: aconst_null
    //   69: aconst_null
    //   70: aconst_null
    //   71: invokevirtual 241	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   74: astore_3
    //   75: aload_3
    //   76: invokeinterface 98 1 0
    //   81: istore_2
    //   82: iload_2
    //   83: ifne +17 -> 100
    //   86: aload_3
    //   87: ifnull +9 -> 96
    //   90: aload_3
    //   91: invokeinterface 106 1 0
    //   96: aconst_null
    //   97: astore_1
    //   98: aload_1
    //   99: areturn
    //   100: new 396	com/google/android/gms/measurement/internal/zza
    //   103: dup
    //   104: aload_1
    //   105: aload_3
    //   106: iconst_0
    //   107: invokeinterface 495 2 0
    //   112: aload_3
    //   113: iconst_1
    //   114: invokeinterface 495 2 0
    //   119: aload_3
    //   120: iconst_2
    //   121: invokeinterface 495 2 0
    //   126: aload_3
    //   127: iconst_3
    //   128: invokeinterface 102 2 0
    //   133: aload_3
    //   134: iconst_4
    //   135: invokeinterface 102 2 0
    //   140: invokespecial 545	com/google/android/gms/measurement/internal/zza:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V
    //   143: astore 4
    //   145: aload_3
    //   146: invokeinterface 249 1 0
    //   151: ifeq +16 -> 167
    //   154: aload_0
    //   155: invokevirtual 110	com/google/android/gms/measurement/internal/zzd:zzyd	()Lcom/google/android/gms/measurement/internal/zzp;
    //   158: invokevirtual 116	com/google/android/gms/measurement/internal/zzp:zzzK	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   161: ldc_w 547
    //   164: invokevirtual 151	com/google/android/gms/measurement/internal/zzp$zza:zzec	(Ljava/lang/String;)V
    //   167: aload 4
    //   169: astore_1
    //   170: aload_3
    //   171: ifnull -73 -> 98
    //   174: aload_3
    //   175: invokeinterface 106 1 0
    //   180: aload 4
    //   182: areturn
    //   183: astore 4
    //   185: aconst_null
    //   186: astore_3
    //   187: aload_0
    //   188: invokevirtual 110	com/google/android/gms/measurement/internal/zzd:zzyd	()Lcom/google/android/gms/measurement/internal/zzp;
    //   191: invokevirtual 116	com/google/android/gms/measurement/internal/zzp:zzzK	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   194: ldc_w 549
    //   197: aload_1
    //   198: aload 4
    //   200: invokevirtual 124	com/google/android/gms/measurement/internal/zzp$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   203: aload_3
    //   204: ifnull +9 -> 213
    //   207: aload_3
    //   208: invokeinterface 106 1 0
    //   213: aconst_null
    //   214: areturn
    //   215: astore_1
    //   216: aload 4
    //   218: astore_3
    //   219: aload_3
    //   220: ifnull +9 -> 229
    //   223: aload_3
    //   224: invokeinterface 106 1 0
    //   229: aload_1
    //   230: athrow
    //   231: astore_1
    //   232: goto -13 -> 219
    //   235: astore_1
    //   236: goto -17 -> 219
    //   239: astore 4
    //   241: goto -54 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	this	zzd
    //   0	244	1	paramString	String
    //   81	2	2	bool	boolean
    //   74	150	3	localObject	Object
    //   1	180	4	localzza	zza
    //   183	34	4	localSQLiteException1	SQLiteException
    //   239	1	4	localSQLiteException2	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   16	75	183	android/database/sqlite/SQLiteException
    //   16	75	215	finally
    //   75	82	231	finally
    //   100	167	231	finally
    //   187	203	235	finally
    //   75	82	239	android/database/sqlite/SQLiteException
    //   100	167	239	android/database/sqlite/SQLiteException
  }
  
  protected void zzhR() {}
  
  /* Error */
  public java.util.List<android.util.Pair<zzpk.zzd, Long>> zzn(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: aload_0
    //   4: invokevirtual 158	com/google/android/gms/measurement/internal/zzd:zzis	()V
    //   7: aload_0
    //   8: invokevirtual 161	com/google/android/gms/measurement/internal/zzd:zziE	()V
    //   11: iload_2
    //   12: ifle +112 -> 124
    //   15: iconst_1
    //   16: istore 5
    //   18: iload 5
    //   20: invokestatic 556	com/google/android/gms/common/internal/zzx:zzaa	(Z)V
    //   23: iload_3
    //   24: ifle +106 -> 130
    //   27: iload 6
    //   29: istore 5
    //   31: iload 5
    //   33: invokestatic 556	com/google/android/gms/common/internal/zzx:zzaa	(Z)V
    //   36: aload_1
    //   37: invokestatic 225	com/google/android/gms/common/internal/zzx:zzcr	(Ljava/lang/String;)Ljava/lang/String;
    //   40: pop
    //   41: aload_0
    //   42: invokevirtual 88	com/google/android/gms/measurement/internal/zzd:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   45: ldc_w 281
    //   48: iconst_2
    //   49: anewarray 229	java/lang/String
    //   52: dup
    //   53: iconst_0
    //   54: ldc_w 509
    //   57: aastore
    //   58: dup
    //   59: iconst_1
    //   60: ldc_w 378
    //   63: aastore
    //   64: ldc_w 507
    //   67: iconst_1
    //   68: anewarray 229	java/lang/String
    //   71: dup
    //   72: iconst_0
    //   73: aload_1
    //   74: aastore
    //   75: aconst_null
    //   76: aconst_null
    //   77: ldc_w 509
    //   80: iload_2
    //   81: invokestatic 511	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   84: invokevirtual 514	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   87: astore 9
    //   89: aload 9
    //   91: invokeinterface 98 1 0
    //   96: ifne +40 -> 136
    //   99: invokestatic 562	java/util/Collections:emptyList	()Ljava/util/List;
    //   102: astore 10
    //   104: aload 10
    //   106: astore_1
    //   107: aload 9
    //   109: ifnull +13 -> 122
    //   112: aload 9
    //   114: invokeinterface 106 1 0
    //   119: aload 10
    //   121: astore_1
    //   122: aload_1
    //   123: areturn
    //   124: iconst_0
    //   125: istore 5
    //   127: goto -109 -> 18
    //   130: iconst_0
    //   131: istore 5
    //   133: goto -102 -> 31
    //   136: new 501	java/util/ArrayList
    //   139: dup
    //   140: invokespecial 502	java/util/ArrayList:<init>	()V
    //   143: astore 10
    //   145: iconst_0
    //   146: istore_2
    //   147: aload 9
    //   149: iconst_0
    //   150: invokeinterface 102 2 0
    //   155: lstore 7
    //   157: aload 9
    //   159: iconst_1
    //   160: invokeinterface 566 2 0
    //   165: astore 11
    //   167: aload_0
    //   168: invokevirtual 362	com/google/android/gms/measurement/internal/zzd:zzzq	()Lcom/google/android/gms/measurement/internal/zzag;
    //   171: aload 11
    //   173: invokevirtual 569	com/google/android/gms/measurement/internal/zzag:zzp	([B)[B
    //   176: astore 11
    //   178: aload 10
    //   180: invokeinterface 572 1 0
    //   185: ifne +70 -> 255
    //   188: aload 11
    //   190: arraylength
    //   191: istore 4
    //   193: iload 4
    //   195: iload_2
    //   196: iadd
    //   197: iload_3
    //   198: if_icmple +57 -> 255
    //   201: aload 10
    //   203: astore_1
    //   204: aload 9
    //   206: ifnull -84 -> 122
    //   209: aload 9
    //   211: invokeinterface 106 1 0
    //   216: aload 10
    //   218: areturn
    //   219: astore 11
    //   221: aload_0
    //   222: invokevirtual 110	com/google/android/gms/measurement/internal/zzd:zzyd	()Lcom/google/android/gms/measurement/internal/zzp;
    //   225: invokevirtual 116	com/google/android/gms/measurement/internal/zzp:zzzK	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   228: ldc_w 574
    //   231: aload_1
    //   232: aload 11
    //   234: invokevirtual 124	com/google/android/gms/measurement/internal/zzp$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   237: aload 9
    //   239: invokeinterface 249 1 0
    //   244: ifeq -43 -> 201
    //   247: iload_2
    //   248: iload_3
    //   249: if_icmpgt -48 -> 201
    //   252: goto -105 -> 147
    //   255: aload 11
    //   257: invokestatic 580	com/google/android/gms/internal/zzrw:zzB	([B)Lcom/google/android/gms/internal/zzrw;
    //   260: astore 12
    //   262: new 319	com/google/android/gms/internal/zzpk$zzd
    //   265: dup
    //   266: invokespecial 581	com/google/android/gms/internal/zzpk$zzd:<init>	()V
    //   269: astore 13
    //   271: aload 13
    //   273: aload 12
    //   275: invokevirtual 585	com/google/android/gms/internal/zzpk$zzd:zzx	(Lcom/google/android/gms/internal/zzrw;)Lcom/google/android/gms/internal/zzpk$zzd;
    //   278: pop
    //   279: aload 11
    //   281: arraylength
    //   282: iload_2
    //   283: iadd
    //   284: istore_2
    //   285: aload 10
    //   287: aload 13
    //   289: lload 7
    //   291: invokestatic 343	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   294: invokestatic 591	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   297: invokeinterface 536 2 0
    //   302: pop
    //   303: goto -66 -> 237
    //   306: astore 10
    //   308: aload_0
    //   309: invokevirtual 110	com/google/android/gms/measurement/internal/zzd:zzyd	()Lcom/google/android/gms/measurement/internal/zzp;
    //   312: invokevirtual 116	com/google/android/gms/measurement/internal/zzp:zzzK	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   315: ldc_w 593
    //   318: aload_1
    //   319: aload 10
    //   321: invokevirtual 124	com/google/android/gms/measurement/internal/zzp$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   324: invokestatic 562	java/util/Collections:emptyList	()Ljava/util/List;
    //   327: astore 10
    //   329: aload 10
    //   331: astore_1
    //   332: aload 9
    //   334: ifnull -212 -> 122
    //   337: aload 9
    //   339: invokeinterface 106 1 0
    //   344: aload 10
    //   346: areturn
    //   347: astore 11
    //   349: aload_0
    //   350: invokevirtual 110	com/google/android/gms/measurement/internal/zzd:zzyd	()Lcom/google/android/gms/measurement/internal/zzp;
    //   353: invokevirtual 116	com/google/android/gms/measurement/internal/zzp:zzzK	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   356: ldc_w 595
    //   359: aload_1
    //   360: aload 11
    //   362: invokevirtual 124	com/google/android/gms/measurement/internal/zzp$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   365: goto -128 -> 237
    //   368: astore_1
    //   369: aconst_null
    //   370: astore 9
    //   372: aload 9
    //   374: ifnull +10 -> 384
    //   377: aload 9
    //   379: invokeinterface 106 1 0
    //   384: aload_1
    //   385: athrow
    //   386: astore_1
    //   387: goto -15 -> 372
    //   390: astore_1
    //   391: goto -19 -> 372
    //   394: astore 10
    //   396: aconst_null
    //   397: astore 9
    //   399: goto -91 -> 308
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	402	0	this	zzd
    //   0	402	1	paramString	String
    //   0	402	2	paramInt1	int
    //   0	402	3	paramInt2	int
    //   191	6	4	i	int
    //   16	116	5	bool1	boolean
    //   1	27	6	bool2	boolean
    //   155	135	7	l	long
    //   87	311	9	localCursor	Cursor
    //   102	184	10	localObject	Object
    //   306	14	10	localSQLiteException1	SQLiteException
    //   327	18	10	localList	java.util.List
    //   394	1	10	localSQLiteException2	SQLiteException
    //   165	24	11	arrayOfByte	byte[]
    //   219	61	11	localIOException1	IOException
    //   347	14	11	localIOException2	IOException
    //   260	14	12	localzzrw	com.google.android.gms.internal.zzrw
    //   269	19	13	localzzd	zzpk.zzd
    // Exception table:
    //   from	to	target	type
    //   157	178	219	java/io/IOException
    //   89	104	306	android/database/sqlite/SQLiteException
    //   136	145	306	android/database/sqlite/SQLiteException
    //   147	157	306	android/database/sqlite/SQLiteException
    //   157	178	306	android/database/sqlite/SQLiteException
    //   178	193	306	android/database/sqlite/SQLiteException
    //   221	237	306	android/database/sqlite/SQLiteException
    //   237	247	306	android/database/sqlite/SQLiteException
    //   255	271	306	android/database/sqlite/SQLiteException
    //   271	279	306	android/database/sqlite/SQLiteException
    //   279	303	306	android/database/sqlite/SQLiteException
    //   349	365	306	android/database/sqlite/SQLiteException
    //   271	279	347	java/io/IOException
    //   41	89	368	finally
    //   89	104	386	finally
    //   136	145	386	finally
    //   147	157	386	finally
    //   157	178	386	finally
    //   178	193	386	finally
    //   221	237	386	finally
    //   237	247	386	finally
    //   255	271	386	finally
    //   271	279	386	finally
    //   279	303	386	finally
    //   349	365	386	finally
    //   308	329	390	finally
    //   41	89	394	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public String zzzu()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: invokevirtual 88	com/google/android/gms/measurement/internal/zzd:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   6: astore_1
    //   7: aload_1
    //   8: ldc_w 281
    //   11: iconst_1
    //   12: anewarray 229	java/lang/String
    //   15: dup
    //   16: iconst_0
    //   17: ldc_w 374
    //   20: aastore
    //   21: aconst_null
    //   22: aconst_null
    //   23: aconst_null
    //   24: aconst_null
    //   25: ldc_w 509
    //   28: ldc_w 599
    //   31: invokevirtual 514	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   34: astore_1
    //   35: aload_1
    //   36: astore_2
    //   37: aload_2
    //   38: astore_1
    //   39: aload_2
    //   40: invokeinterface 98 1 0
    //   45: ifeq +25 -> 70
    //   48: aload_2
    //   49: astore_1
    //   50: aload_2
    //   51: iconst_0
    //   52: invokeinterface 495 2 0
    //   57: astore_3
    //   58: aload_2
    //   59: ifnull +9 -> 68
    //   62: aload_2
    //   63: invokeinterface 106 1 0
    //   68: aload_3
    //   69: areturn
    //   70: aload_2
    //   71: ifnull +9 -> 80
    //   74: aload_2
    //   75: invokeinterface 106 1 0
    //   80: aconst_null
    //   81: areturn
    //   82: astore_3
    //   83: aconst_null
    //   84: astore_2
    //   85: aload_2
    //   86: astore_1
    //   87: aload_0
    //   88: invokevirtual 110	com/google/android/gms/measurement/internal/zzd:zzyd	()Lcom/google/android/gms/measurement/internal/zzp;
    //   91: invokevirtual 116	com/google/android/gms/measurement/internal/zzp:zzzK	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   94: ldc_w 601
    //   97: aload_3
    //   98: invokevirtual 214	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
    //   101: aload_2
    //   102: ifnull +9 -> 111
    //   105: aload_2
    //   106: invokeinterface 106 1 0
    //   111: aconst_null
    //   112: areturn
    //   113: astore_1
    //   114: aload_2
    //   115: ifnull +9 -> 124
    //   118: aload_2
    //   119: invokeinterface 106 1 0
    //   124: aload_1
    //   125: athrow
    //   126: astore_3
    //   127: aload_1
    //   128: astore_2
    //   129: aload_3
    //   130: astore_1
    //   131: goto -17 -> 114
    //   134: astore_3
    //   135: goto -50 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	zzd
    //   6	81	1	localObject1	Object
    //   113	15	1	localObject2	Object
    //   130	1	1	localObject3	Object
    //   1	128	2	localObject4	Object
    //   57	12	3	str	String
    //   82	16	3	localSQLiteException1	SQLiteException
    //   126	4	3	localObject5	Object
    //   134	1	3	localSQLiteException2	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   7	35	82	android/database/sqlite/SQLiteException
    //   7	35	113	finally
    //   39	48	126	finally
    //   50	58	126	finally
    //   87	101	126	finally
    //   39	48	134	android/database/sqlite/SQLiteException
    //   50	58	134	android/database/sqlite/SQLiteException
  }
  
  void zzzw()
  {
    zzis();
    zziE();
    int i = getWritableDatabase().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[] { String.valueOf(zzit().currentTimeMillis()), String.valueOf(zzzt().zzzc()) });
    if (i > 0) {
      zzyd().zzzQ().zzj("Deleted stale rows. rowsDeleted", Integer.valueOf(i));
    }
  }
  
  public long zzzx()
  {
    return zza("select max(bundle_end_timestamp) from queue", null, 0L);
  }
  
  private class zza
    extends SQLiteOpenHelper
  {
    zza(Context paramContext, String paramString)
    {
      super(paramString, null, 1);
    }
    
    private void zza(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2)
      throws SQLiteException
    {
      paramSQLiteDatabase = zzb(paramSQLiteDatabase, paramString1);
      paramString2 = paramString2.split(",");
      int j = paramString2.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString2[i];
        if (!paramSQLiteDatabase.remove(localObject)) {
          throw new SQLiteException("Database " + paramString1 + " is missing required column: " + (String)localObject);
        }
        i += 1;
      }
      if (!paramSQLiteDatabase.isEmpty()) {
        throw new SQLiteException("Database " + paramString1 + " table has extra columns");
      }
    }
    
    private void zza(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String paramString3)
      throws SQLiteException
    {
      if (!zza(paramSQLiteDatabase, paramString1)) {
        paramSQLiteDatabase.execSQL(paramString2);
      }
      try
      {
        zza(paramSQLiteDatabase, paramString1, paramString3);
        return;
      }
      catch (SQLiteException paramSQLiteDatabase)
      {
        zzd.this.zzyd().zzzK().zzj("Failed to verify columns on table that was just created", paramString1);
        throw paramSQLiteDatabase;
      }
    }
    
    /* Error */
    private boolean zza(SQLiteDatabase paramSQLiteDatabase, String paramString)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 4
      //   3: aload_1
      //   4: ldc 96
      //   6: iconst_1
      //   7: anewarray 28	java/lang/String
      //   10: dup
      //   11: iconst_0
      //   12: ldc 98
      //   14: aastore
      //   15: ldc 100
      //   17: iconst_1
      //   18: anewarray 28	java/lang/String
      //   21: dup
      //   22: iconst_0
      //   23: aload_2
      //   24: aastore
      //   25: aconst_null
      //   26: aconst_null
      //   27: aconst_null
      //   28: invokevirtual 104	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   31: astore_1
      //   32: aload_1
      //   33: astore 4
      //   35: aload 4
      //   37: astore_1
      //   38: aload 4
      //   40: invokeinterface 109 1 0
      //   45: istore_3
      //   46: aload 4
      //   48: ifnull +10 -> 58
      //   51: aload 4
      //   53: invokeinterface 112 1 0
      //   58: iload_3
      //   59: ireturn
      //   60: astore 5
      //   62: aconst_null
      //   63: astore 4
      //   65: aload 4
      //   67: astore_1
      //   68: aload_0
      //   69: getfield 13	com/google/android/gms/measurement/internal/zzd$zza:zzaLW	Lcom/google/android/gms/measurement/internal/zzd;
      //   72: invokevirtual 80	com/google/android/gms/measurement/internal/zzd:zzyd	()Lcom/google/android/gms/measurement/internal/zzp;
      //   75: invokevirtual 115	com/google/android/gms/measurement/internal/zzp:zzzL	()Lcom/google/android/gms/measurement/internal/zzp$zza;
      //   78: ldc 117
      //   80: aload_2
      //   81: aload 5
      //   83: invokevirtual 121	com/google/android/gms/measurement/internal/zzp$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
      //   86: aload 4
      //   88: ifnull +10 -> 98
      //   91: aload 4
      //   93: invokeinterface 112 1 0
      //   98: iconst_0
      //   99: ireturn
      //   100: astore_1
      //   101: aload 4
      //   103: astore_2
      //   104: aload_2
      //   105: ifnull +9 -> 114
      //   108: aload_2
      //   109: invokeinterface 112 1 0
      //   114: aload_1
      //   115: athrow
      //   116: astore 4
      //   118: aload_1
      //   119: astore_2
      //   120: aload 4
      //   122: astore_1
      //   123: goto -19 -> 104
      //   126: astore 5
      //   128: goto -63 -> 65
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	131	0	this	zza
      //   0	131	1	paramSQLiteDatabase	SQLiteDatabase
      //   0	131	2	paramString	String
      //   45	14	3	bool	boolean
      //   1	101	4	localSQLiteDatabase	SQLiteDatabase
      //   116	5	4	localObject	Object
      //   60	22	5	localSQLiteException1	SQLiteException
      //   126	1	5	localSQLiteException2	SQLiteException
      // Exception table:
      //   from	to	target	type
      //   3	32	60	android/database/sqlite/SQLiteException
      //   3	32	100	finally
      //   38	46	116	finally
      //   68	86	116	finally
      //   38	46	126	android/database/sqlite/SQLiteException
    }
    
    private Set<String> zzb(SQLiteDatabase paramSQLiteDatabase, String paramString)
    {
      HashSet localHashSet = new HashSet();
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM " + paramString + " LIMIT 0", null);
      try
      {
        paramString = paramSQLiteDatabase.getColumnNames();
        int i = 0;
        while (i < paramString.length)
        {
          localHashSet.add(paramString[i]);
          i += 1;
        }
        return localHashSet;
      }
      finally
      {
        paramSQLiteDatabase.close();
      }
    }
    
    public SQLiteDatabase getWritableDatabase()
    {
      if (!zzd.zza(zzd.this).zzv(zzd.this.zzzt().zzyX())) {
        throw new SQLiteException("Database open failed");
      }
      try
      {
        SQLiteDatabase localSQLiteDatabase = super.getWritableDatabase();
        return localSQLiteDatabase;
      }
      catch (SQLiteException localSQLiteException1)
      {
        zzd.zza(zzd.this).start();
        zzd.this.zzyd().zzzK().zzec("Opening the database failed, dropping and recreating it");
        Object localObject = zzd.zzb(zzd.this);
        zzd.this.getContext().getDatabasePath((String)localObject).delete();
        try
        {
          localObject = super.getWritableDatabase();
          zzd.zza(zzd.this).clear();
          return (SQLiteDatabase)localObject;
        }
        catch (SQLiteException localSQLiteException2)
        {
          zzd.this.zzyd().zzzK().zzj("Failed to open freshly created database", localSQLiteException2);
          throw localSQLiteException2;
        }
      }
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      if (Build.VERSION.SDK_INT >= 9)
      {
        paramSQLiteDatabase = new File(paramSQLiteDatabase.getPath());
        paramSQLiteDatabase.setReadable(false, false);
        paramSQLiteDatabase.setWritable(false, false);
        paramSQLiteDatabase.setReadable(true, true);
        paramSQLiteDatabase.setWritable(true, true);
      }
    }
    
    public void onOpen(SQLiteDatabase paramSQLiteDatabase)
    {
      Cursor localCursor;
      if (Build.VERSION.SDK_INT < 15) {
        localCursor = paramSQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
      }
      try
      {
        localCursor.moveToFirst();
        localCursor.close();
        zza(paramSQLiteDatabase, "events", "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp");
        zza(paramSQLiteDatabase, "user_attributes", "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,set_timestamp,value");
        zza(paramSQLiteDatabase, "apps", "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp");
        zza(paramSQLiteDatabase, "queue", "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data");
        return;
      }
      finally
      {
        localCursor.close();
      }
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\measurement\internal\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */