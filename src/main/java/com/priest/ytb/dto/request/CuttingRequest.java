package com.priest.ytb.dto.request;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.priest.ytb.service.TimeRequest;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CuttingRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String videoPath;

	private Integer numPart;

	private List<TimeRequest> timeRequests;

	public List<TimeRequest> getTimeRequests() {
		return timeRequests;
	}

	public void setTimeRequests(List<TimeRequest> timeRequests) {
		this.timeRequests = timeRequests;
	}

	public Integer getNumPart() {
		return numPart;
	}

	public void setNumPart(Integer numPart) {
		this.numPart = numPart;
	}

	public String getVideoPath() {
		return videoPath;
	}

	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}

}
