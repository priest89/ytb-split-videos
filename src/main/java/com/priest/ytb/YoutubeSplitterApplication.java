package com.priest.ytb;

import java.io.File;
import java.io.InputStream;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.priest.ytb.config.YoutubeProperties;

import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.probe.FFmpegFormat;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;

@SpringBootApplication
@EnableConfigurationProperties
public class YoutubeSplitterApplication extends SpringBootServletInitializer {

	private static Logger LOGGER = LoggerFactory.getLogger(YoutubeSplitterApplication.class);

	@Autowired
	private YoutubeProperties youtubeProperties;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(YoutubeSplitterApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(YoutubeSplitterApplication.class, args);
	}
}
