package de.greenrobot.dao.query;

import android.os.Process;
import android.util.SparseArray;
import de.greenrobot.dao.AbstractDao;
import java.lang.ref.WeakReference;

abstract class AbstractQueryData<T, Q extends AbstractQuery<T>>
{
  final AbstractDao<T, ?> dao;
  final String[] initialValues;
  final SparseArray<WeakReference<Q>> queriesForThreads;
  final String sql;
  
  AbstractQueryData(AbstractDao<T, ?> paramAbstractDao, String paramString, String[] paramArrayOfString)
  {
    this.dao = paramAbstractDao;
    this.sql = paramString;
    this.initialValues = paramArrayOfString;
    this.queriesForThreads = new SparseArray();
  }
  
  protected abstract Q createQuery();
  
  Q forCurrentThread()
  {
    int i = Process.myTid();
    for (;;)
    {
      synchronized (this.queriesForThreads)
      {
        Object localObject1 = (WeakReference)this.queriesForThreads.get(i);
        if (localObject1 != null)
        {
          localObject1 = (AbstractQuery)((WeakReference)localObject1).get();
          if (localObject1 == null)
          {
            gc();
            localObject1 = createQuery();
            this.queriesForThreads.put(i, new WeakReference(localObject1));
            return (Q)localObject1;
          }
          System.arraycopy(this.initialValues, 0, ((AbstractQuery)localObject1).parameters, 0, this.initialValues.length);
        }
      }
      Object localObject3 = null;
    }
  }
  
  Q forCurrentThread(Q paramQ)
  {
    if (Thread.currentThread() == paramQ.ownerThread)
    {
      System.arraycopy(this.initialValues, 0, paramQ.parameters, 0, this.initialValues.length);
      return paramQ;
    }
    return forCurrentThread();
  }
  
  void gc()
  {
    for (;;)
    {
      int i;
      synchronized (this.queriesForThreads)
      {
        i = this.queriesForThreads.size() - 1;
        if (i >= 0)
        {
          if (((WeakReference)this.queriesForThreads.valueAt(i)).get() == null) {
            this.queriesForThreads.remove(this.queriesForThreads.keyAt(i));
          }
        }
        else {
          return;
        }
      }
      i -= 1;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\de\greenrobot\dao\query\AbstractQueryData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */