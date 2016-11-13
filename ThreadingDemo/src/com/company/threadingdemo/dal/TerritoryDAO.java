
package com.company.threadingdemo.dal;

import com.xdev.dal.JPADAO;
import com.company.threadingdemo.entities.Territory;

/**
 * Home object for domain model class Territory.
 * 
 * @see Territory
 */
public class TerritoryDAO extends JPADAO<Territory, String> {
	public TerritoryDAO() {
		super(Territory.class);
	}
}