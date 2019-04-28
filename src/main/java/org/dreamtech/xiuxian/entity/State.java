package org.dreamtech.xiuxian.entity;

/**
 * 境界信息
 * 
 * @author Xu Yiqing
 *
 */
public class State {

	private String stateId;
	private String stateName;
	private Integer stateExp;
	private Integer successRate;
	private String stateDesc;

	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public Integer getStateExp() {
		return stateExp;
	}

	public void setStateExp(Integer stateExp) {
		this.stateExp = stateExp;
	}

	public Integer getSuccessRate() {
		return successRate;
	}

	public void setSuccessRate(Integer successRate) {
		this.successRate = successRate;
	}

	public String getStateDesc() {
		return stateDesc;
	}

	public void setStateDesc(String stateDesc) {
		this.stateDesc = stateDesc;
	}

	@Override
	public String toString() {
		return "State [stateId=" + stateId + ", stateName=" + stateName + ", stateExp=" + stateExp + ", successRate="
				+ successRate + ", stateDesc=" + stateDesc + "]";
	}

}
