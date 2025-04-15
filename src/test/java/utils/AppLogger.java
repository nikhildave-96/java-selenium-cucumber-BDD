package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class AppLogger {
	static Logger logger = Logger.getLogger(AppLogger.class.getName());
	static FileHandler fh;
	static String logFilePath;

	static {
		try {
			logFilePath = System.getProperty("user.dir") + "/applogs/app.log";
			if (!Files.exists(Paths.get(logFilePath))) {
				File f = new File(logFilePath);
				f.getParentFile().mkdir();
				f.createNewFile();
			}

			fh = new FileHandler(logFilePath, true);
			logger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Logger getLogger() {
		return logger;
	}
}
