package com.retail.dao;

import com.retail.dto.RetailManagerDTO;

public interface RetailManagerDAOInt {
	public long add(RetailManagerDTO dto) throws Exception;

	public RetailManagerDTO findByLatLong(Double latitude, Double longitude) throws Exception;
}
