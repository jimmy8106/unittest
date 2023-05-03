package org.cyber.reunion.unittest.service;

import java.util.List;

import org.cyber.reunion.unittest.common.RegexUtils;
import org.cyber.reunion.unittest.model.AppUser;
import org.cyber.reunion.unittest.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class UserCompnent {

  @Autowired
  AppUserRepository userRepository;
  
  public Integer countInvalidEmail() {
    List<AppUser> users =  userRepository.findAll();
    if(CollectionUtils.isEmpty(users)) {
      return 0;
    }
    int count = 0;
    for (AppUser appUser : users) {
      if(!RegexUtils.patternMatches(appUser.getEmail(), RegexUtils.emailRegexPattern)) {
        count++;
      }
    }
    
    return count;
  }
  
}
