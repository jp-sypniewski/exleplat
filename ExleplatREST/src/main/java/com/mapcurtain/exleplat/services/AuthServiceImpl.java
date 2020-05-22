package com.mapcurtain.exleplat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mapcurtain.exleplat.entities.User;
import com.mapcurtain.exleplat.repositories.ProfileRepository;
import com.mapcurtain.exleplat.repositories.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ProfileRepository profileRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public User register(User user) {
		String encodedPW = encoder.encode(user.getPassword());
		user.setPassword(encodedPW);
		profileRepo.saveAndFlush(user.getProfile());
		userRepo.saveAndFlush(user);
		return user;
	}

}
