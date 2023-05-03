package org.cyber.reunion.unittest.utils;

import org.cyber.reunion.unittest.common.RegexUtils;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class RegexTest {
  
  @Test
  public void validateValidEmail() {
    String email = "abc@gmail.com";
    Assert.isTrue(RegexUtils.patternMatches(email, RegexUtils.emailRegexPattern), "must be true");
  }
  
  @Test
  public void validateInvalidEmail() {
    String email = "@gmail.com";
    Assert.isTrue(false == RegexUtils.patternMatches(email, RegexUtils.emailRegexPattern), "must be false");
  }
}
