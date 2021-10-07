package com.maor.serenitypoc.data;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public enum UserRightsEnum {
	ADMIN(1, "Admin"),
	USE_FEATURE(2, "Use feature");

	private final int id;
	private final String name;

	public static UserRightsEnum fromId(int id) {
		return mapById.get(id);
	}

	private static Map<Integer, UserRightsEnum> mapById = new HashMap<>();

	static {
		for (UserRightsEnum userRightsEnum : UserRightsEnum.values()) {
			mapById.put(userRightsEnum.id, userRightsEnum);
		}
	}

}
