
package com.company.threadingdemo.dal;

import com.company.threadingdemo.entities.Customerdemographic;
import com.xdev.dal.JPADAO;

/**
 * Home object for domain model class Customerdemographic.
 * 
 * @see Customerdemographic
 */
public class CustomerdemographicDAO extends JPADAO<Customerdemographic, String> {
	public CustomerdemographicDAO() {
		super(Customerdemographic.class);
	}
}