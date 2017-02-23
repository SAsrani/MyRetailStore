package com.retail.service;

import com.retail.dto.RetailManagerDTO;

public interface RetailManagerServiceInt {
	public long add(RetailManagerDTO dto) throws Exception;

	public RetailManagerDTO findByLatLong(Double latitude, Double longitude) throws Exception;
}