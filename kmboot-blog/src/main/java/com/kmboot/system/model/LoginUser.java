package com.kmboot.system.model;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class LoginUser implements UserDetails {

	private static final long serialVersionUID = 1L;

// client info

	private String ip;

	private String location;

	private String browser;

	private String os;

	private Set<String> permissions;

	private String userName;

	private String password;

	private Long id;

	private String nickName;

	private String email;

	private String phone;

	private String sex;

	private String avatar;

	private String salt;

	private boolean status;

	public LoginUser() {
	}

	public LoginUser(String user, Set<String> permissions) {
		this.userName = user;
		this.permissions = permissions;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return status;
	}

	@Override
	public String getUsername() {
		return this.userName;
	}
}
