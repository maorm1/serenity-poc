package com.maor.serenitypoc.repo;

import com.maor.serenitypoc.data.User;
import com.maor.serenitypoc.data.UserRight;
import com.maor.serenitypoc.data.UserRightsEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UsersRepository {

	private final JdbcTemplate jdbcTemplate;

	public List<User> getAllUsers() {
		return getUsers(null);
	}

	public User getUser(long userId) {
		List<User> users = getUsers(userId);
		if (CollectionUtils.isEmpty(users)) {
			return null;
		}
		return (users.get(0));
	}

	public List<User> getUsers(Long userId) {
		String query = "select * from USERS";
		if (userId != null) {
			query += " where ID = " + userId;
		}
		List<User> users = jdbcTemplate.query(query, USER_ROW_MAPPER);
		users.forEach(user -> user.setUserRights(getAllUserRightsForUserId(user.getId())));
		return users;
	}

	public List<UserRight> getAllUserRightsForUserId(long userId) {
		String query = "select * from USER_RIGHTS where USER_ID = " + userId;
		return jdbcTemplate.query(query, USER_RIGHTS_ROW_MAPPER);
	}

	private final UserRowMapper USER_ROW_MAPPER = new UserRowMapper();
	private final UserRightRowMapper USER_RIGHTS_ROW_MAPPER = new UserRightRowMapper();

	private static class UserRowMapper implements RowMapper<User> {
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			return User
					.builder()
					.id(rs.getLong("id"))
					.name(rs.getString("name"))
					.description(rs.getString("description"))
					.password(rs.getString("password"))
					.userRights(new ArrayList<>())
					.build();
		}
	}

	private static class UserRightRowMapper implements RowMapper<UserRight> {
		@Override
		public UserRight mapRow(ResultSet rs, int rowNum) throws SQLException {
			return UserRight
					.builder()
					.userRightsEnum(UserRightsEnum.fromId(rs.getInt("right_id")))
					.enabled(rs.getBoolean("enabled"))
					.build();
		}
	}
}
