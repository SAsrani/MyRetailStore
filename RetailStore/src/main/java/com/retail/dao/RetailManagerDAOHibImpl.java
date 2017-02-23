package com.retail.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.retail.dto.RetailManagerDTO;

@Repository("retailManagerDAO")
public class RetailManagerDAOHibImpl implements RetailManagerDAOInt {

	@Autowired
	protected SessionFactory sessionFactory;

	public long add(RetailManagerDTO dto) throws Exception {
		return ((Long) sessionFactory.getCurrentSession().save(dto)).longValue();
	}

	public RetailManagerDTO findByLatLong(Double latitude, Double longitude) throws Exception {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(RetailManagerDTO.class);
		criteria.add(Restrictions.eq("latitude", latitude));
		criteria.add(Restrictions.eq("longitude", longitude));
		List<RetailManagerDTO> list = criteria.list();

		RetailManagerDTO dto = null;

		if (list != null && list.size() > 0) {
			dto = list.get(0);
		}

		return dto;
	}
}
