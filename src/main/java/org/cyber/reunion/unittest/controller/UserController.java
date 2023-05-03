package org.cyber.reunion.unittest.controller;

import java.util.HashMap;
import java.util.Map;

import org.cyber.reunion.unittest.dto.UserDataDTO;
import org.cyber.reunion.unittest.service.UserCompnent;
import org.cyber.reunion.unittest.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;
  @Autowired
  private UserCompnent component;
  @Autowired
  private ModelMapper modelMapper;

  @GetMapping(value = "/queryUser/{username}")
  public UserDataDTO queryUser(@PathVariable String username) {
    return modelMapper.map(userService.search(username), UserDataDTO.class);
  }

  @GetMapping(value = "/countValidEmails")
  public ResponseEntity<?> queryUser() {
    int count = component.countInvalidEmail();
    Map<String, Integer> payload = new HashMap<>();
    payload.put("Invalid Emails", count);
    return ResponseEntity.ok(payload);
  }
}
