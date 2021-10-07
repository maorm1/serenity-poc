package com.maor.serenitypoc.data;

import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Configuration
public class DbConfig {

	@Bean(initMethod = "start", destroyMethod = "stop")
	public Server inMemoryH2Server() throws SQLException {
		return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9090");
	}
}
