package org.dreamtech.xiuxian.entity;

/**
 * 个人信息
 * 
 * @author Xu Yiqing
 *
 */
public class Person {

	private String userId;
	private Integer exp;
	private String stateId;
	private String username;
	private String password;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getExp() {
		return exp;
	}

	public void setExp(Integer exp) {
		this.exp = exp;
	}

	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Person [userId=" + userId + ", exp=" + exp + ", stateId=" + stateId + ", username=" + username
				+ ", password=" + password + "]";
	}

}
