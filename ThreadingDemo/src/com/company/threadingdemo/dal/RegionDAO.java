
package com.company.threadingdemo.dal;

import com.company.threadingdemo.entities.Region;
import com.xdev.dal.JPADAO;

/**
 * Home object for domain model class Region.
 * 
 * @see Region
 */
public class RegionDAO extends JPADAO<Region, Integer> {
	public RegionDAO() {
		super(Region.class);
	}
}