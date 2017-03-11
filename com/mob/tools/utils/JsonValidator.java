package com.mob.tools.utils;

import java.io.PrintStream;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class JsonValidator
{
  private char c;
  private int col;
  private CharacterIterator it;
  
  private boolean aggregate(char paramChar1, char paramChar2, boolean paramBoolean)
  {
    if (this.c != paramChar1) {
      return false;
    }
    nextCharacter();
    skipWhiteSpace();
    if (this.c == paramChar2)
    {
      nextCharacter();
      return true;
    }
    do
    {
      nextCharacter();
      skipWhiteSpace();
      do
      {
        if (!value()) {
          break label163;
        }
        skipWhiteSpace();
        if (this.c != ',') {
          break;
        }
        nextCharacter();
        skipWhiteSpace();
      } while (!paramBoolean);
      paramChar1 = this.col;
      if (!string()) {
        return error("string", paramChar1);
      }
      skipWhiteSpace();
    } while (this.c == ':');
    return error("colon", this.col);
    if (this.c == paramChar2)
    {
      nextCharacter();
      return true;
    }
    return error("comma or " + paramChar2, this.col);
    label163:
    return error("value", this.col);
  }
  
  private boolean array()
  {
    return aggregate('[', ']', false);
  }
  
  private boolean error(String paramString, int paramInt)
  {
    System.out.printf("type: %s, col: %s%s", new Object[] { paramString, Integer.valueOf(paramInt), System.getProperty("line.separator") });
    return false;
  }
  
  private boolean escape()
  {
    int i = this.col - 1;
    if (" \\\"/bfnrtu".indexOf(this.c) < 0) {
      return error("escape sequence  \\\",\\\\,\\/,\\b,\\f,\\n,\\r,\\t  or  \\uxxxx ", i);
    }
    if ((this.c == 'u') && ((!ishex(nextCharacter())) || (!ishex(nextCharacter())) || (!ishex(nextCharacter())) || (!ishex(nextCharacter())))) {
      return error("unicode escape sequence  \\uxxxx ", i);
    }
    return true;
  }
  
  private boolean ishex(char paramChar)
  {
    return "0123456789abcdefABCDEF".indexOf(this.c) >= 0;
  }
  
  private boolean literal(String paramString)
  {
    StringCharacterIterator localStringCharacterIterator = new StringCharacterIterator(paramString);
    int i = localStringCharacterIterator.first();
    if (this.c != i)
    {
      bool2 = false;
      return bool2;
    }
    int j = this.col;
    boolean bool2 = true;
    for (i = localStringCharacterIterator.next();; i = localStringCharacterIterator.next())
    {
      boolean bool1 = bool2;
      if (i != 65535)
      {
        if (i != nextCharacter()) {
          bool1 = false;
        }
      }
      else
      {
        nextCharacter();
        bool2 = bool1;
        if (bool1) {
          break;
        }
        error("literal " + paramString, j);
        return bool1;
      }
    }
  }
  
  private char nextCharacter()
  {
    this.c = this.it.next();
    this.col += 1;
    return this.c;
  }
  
  private boolean number()
  {
    if ((!Character.isDigit(this.c)) && (this.c != '-')) {
      return false;
    }
    int i = this.col;
    if (this.c == '-') {
      nextCharacter();
    }
    if (this.c == '0') {
      nextCharacter();
    }
    while (this.c == '.')
    {
      nextCharacter();
      if (Character.isDigit(this.c))
      {
        while (Character.isDigit(this.c)) {
          nextCharacter();
        }
        if (Character.isDigit(this.c)) {
          while (Character.isDigit(this.c)) {
            nextCharacter();
          }
        } else {
          return error("number", i);
        }
      }
      else
      {
        return error("number", i);
      }
    }
    if ((this.c == 'e') || (this.c == 'E'))
    {
      nextCharacter();
      if ((this.c == '+') || (this.c == '-')) {
        nextCharacter();
      }
      if (Character.isDigit(this.c)) {
        while (Character.isDigit(this.c)) {
          nextCharacter();
        }
      }
      return error("number", i);
    }
    return true;
  }
  
  private boolean object()
  {
    return aggregate('{', '}', true);
  }
  
  private void skipWhiteSpace()
  {
    while (Character.isWhitespace(this.c)) {
      nextCharacter();
    }
  }
  
  private boolean string()
  {
    if (this.c != '"') {
      return false;
    }
    int j = this.col;
    int i = 0;
    nextCharacter();
    label23:
    if (this.c != 65535)
    {
      if ((i == 0) && (this.c == '\\')) {
        i = 1;
      }
      label71:
      do
      {
        for (;;)
        {
          nextCharacter();
          break label23;
          if (i == 0) {
            break label71;
          }
          if (!escape()) {
            break;
          }
          i = 0;
        }
      } while (this.c != '"');
      nextCharacter();
      return true;
    }
    return error("quoted string", j);
  }
  
  private boolean valid(String paramString)
  {
    if ("".equals(paramString)) {}
    do
    {
      return true;
      this.it = new StringCharacterIterator(paramString);
      this.c = this.it.first();
      this.col = 1;
      if (!value()) {
        return error("value", 1);
      }
      skipWhiteSpace();
    } while (this.c == 65535);
    return error("end", this.col);
  }
  
  private boolean value()
  {
    return (literal("true")) || (literal("false")) || (literal("null")) || (string()) || (number()) || (object()) || (array());
  }
  
  public boolean validate(String paramString)
  {
    return valid(paramString.trim());
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\tools\utils\JsonValidator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */