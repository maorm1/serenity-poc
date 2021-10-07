package com.maor.serenitypoc.data;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class User {

	private final long id;
	private String name;
	private String description;
	private String password;
	private List<UserRight> userRights;
}
