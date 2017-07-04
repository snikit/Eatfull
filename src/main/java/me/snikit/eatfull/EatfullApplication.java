package me.snikit.eatfull;

import java.io.FileInputStream;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import me.snikit.eatfull.service.GordonService;

@SpringBootApplication
public class EatfullApplication {

	public static final String FILE_PATH_ARG_KEY = "FILE";
	private static final Logger logger = LoggerFactory.getLogger(EatfullApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EatfullApplication.class, args);
	}

	@Bean // runs as soon as the application is bootstrapped
	public CommandLineRunner commandLineRunner(GordonService service) {
		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {

				logger.info("App Start Up!");

				if (null == System.getProperty(EatfullApplication.FILE_PATH_ARG_KEY)) {
					logger.error(
							"Hi ! You need to pass file path by setting system property ( FILE=<value>) \n example gradlew -DFILE=D:/data.txt bootrun ");
					return;
				}

				logger.info("File path is : " + System.getProperty(EatfullApplication.FILE_PATH_ARG_KEY));
				try {
					logger.info(
							"\n\n\n-------------------------------------------------------\nMax Satisfaction for provided data is : "
									+ service.getMaxSatisfaction(new FileInputStream(
											System.getProperty(EatfullApplication.FILE_PATH_ARG_KEY)))
									+ "\n-------------------------------------------------------\n");
				} catch (Exception e) {
					logger.info(
							"There was some error in processing of the file. Please make sure the file path is correct and the file exists ! \nIf everything seems right forward these logs to the developer !");
					logger.error(e.getMessage());
					logger.error(Arrays.toString(e.getStackTrace()));
				}
			}

		};
	}

}
