/**
 * 
 */
package com.ejb.core.db.entity;

import java.io.Serializable;
import java.util.Map;

/**
 * HBase column family entity
 * 
 * @author ahajri
 */
public class HBaseColumnFamilyEntity implements Comparable<HBaseColumnFamilyEntity>, Cloneable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1160224080240150187L;

	/** Row Key. */
	private String rowKey;

	/** ID of Column Family. */
	private String identifiantColumnFamily;

	/**
	 * Map containing all cells of column Family Map key is column Identifier
	 * and {@link HBaseCelluleEntity} contains two attributes : Value as String
	 * and timestamp
	 */
	private Map<String, HBaseCelluleEntity> cells;

	/**
	 * Default Constructor
	 */
	public HBaseColumnFamilyEntity() {

	}

	/**
	 * Constructor with all fields
	 * 
	 * @param rowKey
	 * @param identifiantColumnFamily
	 * @param cells
	 */
	public HBaseColumnFamilyEntity(String rowKey, String identifiantColumnFamily,
			Map<String, HBaseCelluleEntity> cells) {
		this.rowKey = rowKey;
		this.identifiantColumnFamily = identifiantColumnFamily;
		this.cells = cells;
	}

	/** @return le {@link #rowKey}. */
	public String getRowKey() {
		return rowKey;
	}

	/**
	 * @param rowKey
	 *            {@link #rowKey} to define.
	 */
	public void setRowKey(String rowKey) {
		this.rowKey = rowKey;
	}

	/** @return {@link #identifiantColumnFamily}. */
	public String getIdentifiantColumnFamily() {
		return identifiantColumnFamily;
	}

	/**
	 * @param identifiantColumnFamily
	 *            {@link #identifiantColumnFamily} to define.
	 */
	public void setIdentifiantColumnFamily(String identifiantColumnFamily) {
		this.identifiantColumnFamily = identifiantColumnFamily;
	}

	/** @return {@link #cells} . */
	public Map<String, HBaseCelluleEntity> getCells() {
		return cells;
	}

	/**
	 * @param cells
	 *            {@link #cells} to define.
	 */
	public void setCells(Map<String, HBaseCelluleEntity> cells) {
		this.cells = cells;
	}

	/**
	 * Cette methode nous permet de trier une liste des Entités par la cleLigne
	 */
	@Override
	public int compareTo(HBaseColumnFamilyEntity o2) {
		return this.rowKey.compareTo(o2.getRowKey());
	}

	/**
	 * Cette methode nous permet de cloner cette class
	 */
	@Override
	public HBaseColumnFamilyEntity clone() {
		return new HBaseColumnFamilyEntity(this.rowKey, this.identifiantColumnFamily, this.cells);
	}

	/**
	 * Cette methode nous permet de recuperer la valeur d'une cellule HBase
	 * 
	 * @param nomCellule
	 *            : Le nom de la colonne
	 * @return La valeur de la colonne
	 */

	public String getCelluleValue(String nomCellule) {
		String valeur = null;
		if ((this.cells != null) && (this.cells.containsKey(nomCellule))) {
			valeur = this.cells.get(nomCellule).getValue();
		}
		return valeur;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cells == null) ? 0 : cells.hashCode());
		result = prime * result + ((rowKey == null) ? 0 : rowKey.hashCode());
		result = prime * result + ((identifiantColumnFamily == null) ? 0 : identifiantColumnFamily.hashCode());
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
		HBaseColumnFamilyEntity other = (HBaseColumnFamilyEntity) obj;
		if (cells == null) {
			if (other.cells != null)
				return false;
		} else if (!cells.equals(other.cells))
			return false;
		if (rowKey == null) {
			if (other.rowKey != null)
				return false;
		} else if (!rowKey.equals(other.rowKey))
			return false;
		if (identifiantColumnFamily == null) {
			if (other.identifiantColumnFamily != null)
				return false;
		} else if (!identifiantColumnFamily.equals(other.identifiantColumnFamily))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HBaseColumnFamilyEntity [cleLigne=" + rowKey + ", identifiantColumnFamily=" + identifiantColumnFamily
				+ ", cells=" + cells + "]";
	}

}
