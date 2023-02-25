package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.LoginException;
import com.masai.model.CurrentUserSession;
import com.masai.model.LoginDTO;
import com.masai.model.User;
import com.masai.repository.SessionDao;
import com.masai.repository.UserDao;

import net.bytebuddy.utility.RandomString;

@Service
public class UserLoginServiceImpl implements UserLoginService
{

	@Autowired
	private UserDao uDao;
	@Autowired
	private SessionDao sDao;

	@Override
	public String LogIntoAccount(LoginDTO dto) throws LoginException
	{

		User existingUser = uDao.findBymobile(dto.getMobile());

		if (existingUser == null)
		{
			throw new LoginException("Mobile number not correct");
		}

		Optional<CurrentUserSession> ValidUserSession = sDao.findById(existingUser.getUserId());

		if (ValidUserSession.isPresent())
		{
			throw new LoginException("User is already  loggedin");

		}

		if (existingUser.getPassword().equals(dto.getPassword()))
		{

			String key = RandomString.make(6);

			CurrentUserSession currentUserSession = new CurrentUserSession(existingUser.getUserId(), key,
					LocalDateTime.now(), "User", existingUser.getCart().getCartId());

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
