package com.priest.ytb.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "priest.ytb")
public class YoutubeProperties {
	private String ffmpegFileLocation;
	private String ffprobeFileLocation;
	private String fileLocation;

	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public String getFfmpegFileLocation() {
		return ffmpegFileLocation;
	}

	public void setFfmpegFileLocation(String ffmpegFileLocation) {
		this.ffmpegFileLocation = ffmpegFileLocation;
	}

	public String getFfprobeFileLocation() {
		return ffprobeFileLocation;
	}

	public void setFfprobeFileLocation(String ffprobeFileLocation) {
		this.ffprobeFileLocation = ffprobeFileLocation;
	}

}
