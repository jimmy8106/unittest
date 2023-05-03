package org.cyber.reunion.unittest.service;

import org.cyber.reunion.unittest.model.AppUser;
import org.cyber.reunion.unittest.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  
  @Autowired
  AppUserRepository userRepository;
  
  public AppUser search(String username) {
    AppUser appUser = userRepository.findByUsername(username);
    return appUser;
  }
}
