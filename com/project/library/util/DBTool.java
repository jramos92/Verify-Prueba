package com.project.library.util;

import android.content.Context;
import com.project.library.database.DaoMaster;
import com.project.library.database.DaoMaster.DevOpenHelper;
import com.project.library.database.DaoMaster.OpenHelper;
import com.project.library.database.DaoSession;

public class DBTool
{
  private static DBTool instance;
  private DaoMaster daoMaster;
  private DaoSession daoSession;
  private Context mCtx;
  
  public static DBTool getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DBTool();
      }
      DBTool localDBTool = instance;
      return localDBTool;
    }
    finally {}
  }
  
  public DaoMaster getDaoMaster()
  {
    if (this.daoMaster == null)
    {
      if (this.mCtx == null) {
        DebugLog.e("DBTool must init in application");
      }
      this.daoMaster = new DaoMaster(new DaoMaster.DevOpenHelper(this.mCtx, "db_veryfit2.db", null).getWritableDatabase());
    }
    return this.daoMaster;
  }
  
  public DaoSession getDaoSession()
  {
    if (this.daoSession == null)
    {
      if (this.daoMaster == null) {
        this.daoMaster = getDaoMaster();
      }
      this.daoSession = this.daoMaster.newSession();
    }
    return this.daoSession;
  }
  
  public void init(Context paramContext)
  {
    this.mCtx = paramContext;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\util\DBTool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */