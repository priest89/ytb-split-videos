package com.priest.ytb.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priest.ytb.config.YoutubeProperties;
import com.priest.ytb.dto.request.CuttingRequest;
import com.priest.ytb.utils.Constants;
import com.priest.ytb.utils.TimeUtils;

import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.probe.FFmpegFormat;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;

@Service
public class CuttingService {

	private static Logger LOGGER = LoggerFactory.getLogger(CuttingService.class);

	@Autowired
	private YoutubeProperties youtubeProperties;

	public String cutVideo(CuttingRequest cuttingRequest) {
		try {
			File videosPath = new File(cuttingRequest.getVideoPath());
			if (videosPath.isDirectory()) {
				List<File> videosFile = Arrays.asList(videosPath.listFiles());
				
				for (File file : videosFile) {
					cutVideo(cuttingRequest, file);
				}
			} else if (videosPath.isFile()){
				cutVideo(cuttingRequest, videosPath);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return Constants.FAIL;
		}
		return Constants.SUCCESS;
	}

	public void cutVideo(CuttingRequest cuttingRequest, File file) throws IOException, InterruptedException {
		String videoPath = file.getAbsolutePath();
		FFprobe ffprobe = new FFprobe(youtubeProperties.getFfprobeFileLocation());
		FFmpegProbeResult probeResult = ffprobe.probe(videoPath);
		FFmpegFormat format = probeResult.getFormat();
		double startTime = 0;
		double endTime = 0;
		for (int i = 1; i <= cuttingRequest.getNumPart(); i++) {
			// prepare ffmpeg command line
			endTime = ((format.duration / cuttingRequest.getNumPart())) * i + 1;
			String cuttedVideoPath = StringUtils.replace(videoPath, ".mp4", " - new - " + i + " .mp4");

			String commandLineStr = youtubeProperties.getFfmpegFileLocation() + " -i \"" + videoPath + "\" -ss "  + TimeUtils.getTimeString(startTime) + " -to " + TimeUtils.getTimeString(endTime) + " -async 1 -c copy \"" + cuttedVideoPath + "\"";
			LOGGER.info(commandLineStr);
			
			// run ffmpeg
			Runtime commandPrompt = Runtime.getRuntime();
			Process powershell = commandPrompt.exec(commandLineStr);
			InputStream in = powershell.getErrorStream();
			int c;
			while ((c = in.read()) != -1) {
			}
			in.close();
			powershell.waitFor();
			startTime = endTime - 1;
		}
	}
}
