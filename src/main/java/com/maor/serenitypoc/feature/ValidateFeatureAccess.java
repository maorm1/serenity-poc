package com.maor.serenitypoc.feature;

import com.maor.serenitypoc.data.User;
import com.maor.serenitypoc.data.UserRight;
import com.maor.serenitypoc.data.UserRightsEnum;
import com.maor.serenitypoc.repo.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ValidateFeatureAccess {

	private final UsersRepository usersRepository;

	public void forUser(long userId) {
		System.out.println("\n\nVALIDATING FOR USER ID: " + userId);
		User user = usersRepository.getUser(userId);
		System.out.println("USER: " + user);
		if (accessIsAllowed(user)) {
			System.out.println("Access is allowed.");
		} else {
			System.out.println("Access is NOT allowed!");
			throw new RuntimeException("FEATURE NOT ACCESSIBLE!");
		}
	}

	private boolean accessIsAllowed(User user) {
		boolean result = false;
		if (user != null) {
			List<UserRight> userRights = user.getUserRights();
			for (UserRight userRight : userRights) {
				if ((userRight.getUserRightsEnum() == UserRightsEnum.USE_FEATURE)
						&& userRight.isEnabled()) {
					result = true;
					break;
				}
			}
		}
		return result;
	}
}
