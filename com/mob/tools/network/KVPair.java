package com.mob.tools.network;

public class KVPair<T>
{
  public final String name;
  public final T value;
  
  public KVPair(String paramString, T paramT)
  {
    this.name = paramString;
    this.value = paramT;
  }
  
  public String toString()
  {
    return this.name + " = " + this.value;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\tools\network\KVPair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */