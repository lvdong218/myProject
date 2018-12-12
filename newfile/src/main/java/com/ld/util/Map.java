package com.ld.util;

public interface Map extends java.util.Map<Object, Object>{
	@Override
	default Object put(Object key, Object value) {
		this.put(key, value);
		return this;
	}
}
