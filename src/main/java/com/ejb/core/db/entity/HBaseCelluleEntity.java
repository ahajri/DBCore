package com.ejb.core.db.entity;

import java.io.Serializable;

/**
 * Entity of HBase Cell
 * 
 * @author ahajri
 *
 */
public class HBaseCelluleEntity implements Serializable{

	/**
	 * Serialization UID
	 */
	private static final long serialVersionUID = -5340680697436104914L;

	/** String value of cell */
	private String value;

	/** Timestamp of string . */
	private long timestamp;

	/**
	 * Default Constructor
	 */
	public HBaseCelluleEntity() {
	}

	/**
	 * Constructor with all fields
	 * 
	 * @param value
	 * @param timestamp
	 */
	public HBaseCelluleEntity(String value, long timestamp) {
		this.value = value;
		this.timestamp = timestamp;
	}

	/**
	 * Constructor with value
	 * 
	 * @param value
	 */
	public HBaseCelluleEntity(String value) {
		this.value = value;
	}

	/** @return le {@link #value} à renvoyer. */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            le {@link #value} à définir.
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/** @return le {@link #timestamp} à renvoyer. */
	public long getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp
	 *            le {@link #timestamp} à définir.
	 */
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (timestamp ^ (timestamp >>> 32));
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HBaseCelluleEntity other = (HBaseCelluleEntity) obj;
		if (timestamp != other.timestamp)
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HBaseCelluleEntity [value=" + value + ", timestamp=" + timestamp + "]";
	}
}
