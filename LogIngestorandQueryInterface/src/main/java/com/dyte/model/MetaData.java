package com.dyte.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class MetaData {
	private String parentResourceId;

	public MetaData() {

	}

	public MetaData(String parentResourceId) {
		super();
		this.parentResourceId = parentResourceId;
	}

	public String getParentResourceId() {
		return parentResourceId;
	}

	public void setParentResourceId(String parentResourceId) {
		this.parentResourceId = parentResourceId;
	}

}
