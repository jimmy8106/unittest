package org.cyber.reunion.unittest.common;

import java.util.regex.Pattern;

public final class RegexUtils {
  
  public static final String emailRegexPattern = "^(.+)@(\\S+)$";
  
  public static boolean patternMatches(String emailAddress, String regexPattern) {
    return Pattern.compile(regexPattern)
      .matcher(emailAddress)
      .matches();
}
}
