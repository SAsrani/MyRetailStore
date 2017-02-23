package com.retail.ctl;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.retail.dto.RetailManagerDTO;
import com.retail.location.AddressConverter;
import com.retail.location.GoogleResponse;
import com.retail.location.Result;
import com.retail.service.RetailManagerServiceInt;

@RestController
@RequestMapping(value = "rest/RetailManager")
public class RetailManagerCtl {

	@Autowired
	private RetailManagerServiceInt service;

	@RequestMapping(value = { "/add" }, method = { RequestMethod.POST })
	public HashMap submitAdd(@RequestBody RetailManagerDTO dto, HttpSession session) throws Exception {
		HashMap<String, Object> response = new HashMap<String, Object>();
		String message = null;
		boolean flag = false;
		if (dto != null) {
			GoogleResponse res = new AddressConverter().convertToLatLong(dto.getAddress());
			if (res.getStatus().equals("OK")) {
				for (Result result : res.getResults()) {
					dto.setLatitude(Double.valueOf(result.getGeometry().getLocation().getLat()));
					dto.setLongitude(Double.valueOf(result.getGeometry().getLocation().getLng()));
				}
			}
			long pk = service.add(dto);
			message = "Data has been added successfully.";
		}
		response.put("message", message);
		response.put("success", flag);
		return response;
	}

	@RequestMapping(value = { "/get" }, method = { RequestMethod.GET, RequestMethod.POST })
	public HashMap get(@RequestBody RetailManagerDTO dto, HttpSession session) throws Exception {
		HashMap<String, Object> response = new HashMap<String, Object>();
		String message = null;
		boolean flag = false;
		RetailManagerDTO dbDTO = null;
		if (dto.getLatitude() != null && dto.getLatitude() > 0L && dto.getLongitude() != null
				&& dto.getLongitude() > 0L) {
			dbDTO = service.findByLatLong(dto.getLatitude(), dto.getLongitude());
			if (dbDTO != null) {
				flag = true;
				message = "Data has been fetched successfully.";
			} else {
				message = "Record not found.";
			}
		} else {
			message = "Data is not valid";
			flag = false;
		}
		response.put("dto", dbDTO);
		response.put("message", message);
		response.put("success", flag);
		return response;
	}

}
