package com.uoons.users.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleAuthorityResponse {

	private String email;
	private List<String> roles;
	private Long userId;
}
