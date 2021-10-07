package com.maor.serenitypoc.data;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserRightsEnum {
	ADMIN(1, "Admin"),
	USE_FEATURE(2, "Use feature");

	private final int id;
	private final String name;

}
