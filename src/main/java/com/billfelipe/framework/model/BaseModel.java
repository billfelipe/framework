package com.billfelipe.framework.model;

import java.io.Serializable;

public abstract class BaseModel implements Serializable, Cloneable {

	private static final long serialVersionUID = -5612462303305608480L;

	public abstract Long getId();

	public abstract void setId(Long id);

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + (getId() == null ? 0 : getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		BaseModel other = (BaseModel) obj;
		if (getId() == null) {
			if (other.getId() != null) {
				return false;
			}
		} else if (!getId().equals(other.getId())) {
			return false;
		}
		return true;
	}
}