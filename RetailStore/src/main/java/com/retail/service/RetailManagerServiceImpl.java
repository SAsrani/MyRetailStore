package com.retail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.retail.dao.RetailManagerDAOInt;
import com.retail.dto.RetailManagerDTO;

@Service("retailManagerService")
public class RetailManagerServiceImpl implements RetailManagerServiceInt {

	@Autowired
	private RetailManagerDAOInt dao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(RetailManagerDTO dto) throws Exception {
		return dao.add(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public RetailManagerDTO findByLatLong(Double latitude, Double longitude) throws Exception {
		return dao.findByLatLong(latitude, longitude);
	}
}