package com.squareup.okhttp;

import okio.Buffer;

public final class FormEncodingBuilder
{
  private static final MediaType CONTENT_TYPE = MediaType.parse("application/x-www-form-urlencoded");
  private final Buffer content = new Buffer();
  
  public FormEncodingBuilder add(String paramString1, String paramString2)
  {
    if (this.content.size() > 0L) {
      this.content.writeByte(38);
    }
    HttpUrl.canonicalize(this.content, paramString1, 0, paramString1.length(), " \"'<>#&=", false, true);
    this.content.writeByte(61);
    HttpUrl.canonicalize(this.content, paramString2, 0, paramString2.length(), " \"'<>#&=", false, true);
    return this;
  }
  
  public FormEncodingBuilder addEncoded(String paramString1, String paramString2)
  {
    if (this.content.size() > 0L) {
      this.content.writeByte(38);
    }
    HttpUrl.canonicalize(this.content, paramString1, 0, paramString1.length(), " \"'<>#&=", true, true);
    this.content.writeByte(61);
    HttpUrl.canonicalize(this.content, paramString2, 0, paramString2.length(), " \"'<>#&=", true, true);
    return this;
  }
  
  public RequestBody build()
  {
    if (this.content.size() == 0L) {
      throw new IllegalStateException("Form encoded body must have at least one part.");
    }
    return RequestBody.create(CONTENT_TYPE, this.content.snapshot());
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\squareup\okhttp\FormEncodingBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */