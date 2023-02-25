package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.LoginException;
import com.masai.model.Admin;
import com.masai.model.CurrentUserSession;
import com.masai.model.LoginDTO;
import com.masai.repository.AdminDao;
import com.masai.repository.SessionDao;

import net.bytebuddy.utility.RandomString;

@Service
public class AdminLoginServiceImpl implements AdminLoginService
{

	@Autowired
	private AdminDao aDao;
	@Autowired
	private SessionDao sDao;

	@Override
	public String LogIntoAccount(LoginDTO dto) throws LoginException
	{

		Admin existingAdmin = aDao.findBymobile(dto.getMobile());
		if (existingAdmin == null)
		{
			throw new LoginException("Mobile number not correct");
		}
		Optional<CurrentUserSession> ValidAdminSession = sDao.findById(existingAdmin.getAdminId());

		if (ValidAdminSession.isPresent())
		{
			throw new LoginException("User is already  loggedin");

		}

		if (existingAdmin.getAdminPassword().equals(dto.getPassword()))
		{

			String key = RandomString.make(6);

			CurrentUserSession currentUserSession = new CurrentUserSession(existingAdmin.getAdminId(), key,
					LocalDateTime.now(), "admin", 0);

			sDao.save(currentUserSession);
			return currentUserSession.toString();

		}
		else
		{
			throw new LoginException("password entered is not correct");
		}

	}

	@Override
	public String LogOutAccount(String key) throws LoginException
	{

		CurrentUserSession loggedInsession = sDao.findByuuid(key);
		if (loggedInsession == null)
		{
			throw new LoginException("user is not logged in");
		}
		else
		{
			sDao.delete(loggedInsession);
			return "Logged Out successfully";

		}

	}

}
