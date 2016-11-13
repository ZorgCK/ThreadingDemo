
package com.company.threadingdemo.dal;

import com.xdev.dal.JPADAO;
import com.company.threadingdemo.entities.OrderdetailId;
import com.company.threadingdemo.entities.Orderdetail;

/**
 * Home object for domain model class Orderdetail.
 * 
 * @see Orderdetail
 */
public class OrderdetailDAO extends JPADAO<Orderdetail, OrderdetailId> {
	public OrderdetailDAO() {
		super(Orderdetail.class);
	}
}