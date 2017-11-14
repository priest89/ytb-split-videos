package com.priest.ytb.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.priest.ytb.dto.request.CuttingRequest;
import com.priest.ytb.service.CuttingService;

@RestController
public class CuttingResource {
	@Autowired
	private CuttingService cuttingService;

	@RequestMapping(value = "/cutting/video", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createProducer(@RequestBody CuttingRequest cuttingRequest) {
		return cuttingService.cutVideo(cuttingRequest);
	}
}
