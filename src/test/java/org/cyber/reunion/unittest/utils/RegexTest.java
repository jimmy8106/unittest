package org.cyber.reunion.unittest.utils;

import org.cyber.reunion.unittest.common.RegexUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class RegexTest {
  @Autowired
  private RegexUtils utils;
  
  @Test
  public void validateValidEmail() {
    String email = "abc@gmail.com";
    Assert.isTrue(utils.patternMatches(email, utils.emailRegexPattern), "must be true");
  }
  
  @Test
  public void validateInvalidEmail() {
    String email = "@gmail.com";
    Assert.isTrue(false == utils.patternMatches(email, utils.emailRegexPattern), "must be false");
  }
}
