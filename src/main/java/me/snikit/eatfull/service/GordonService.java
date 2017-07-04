package me.snikit.eatfull.service;

import java.io.InputStream;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.snikit.eatfull.domain.InputData;
import me.snikit.eatfull.exception.ReadDataException;
import me.snikit.eatfull.utils.KnapsackUtility;

@Service
public class GordonService {

	private static final Logger logger = LoggerFactory.getLogger(GordonService.class);

	@Autowired
	private KnapsackUtility knapsackUtility;

	/*
	 * reading data from file throws custom exception for any of the exceptions
	 * that might be thorwn by Scanner class since input mismatch etc all are
	 * runtime , so inorder to properly handle them , wrapping them all up in
	 * custom exception class child
	 */
	public InputData readDataFromStream(InputStream input) throws ReadDataException {

		int timeLimit = 0;
		int itemCount = 0;
		int menuItems[] = null;
		int itemSatisfactions[] = null;
		try (Scanner s = new Scanner(input)) {
			timeLimit = s.nextInt();
			itemCount = s.nextInt();
			menuItems = new int[itemCount];
			itemSatisfactions = new int[itemCount];
			for (Integer i = 0; i < itemCount; i++) {
				menuItems[i] = s.nextInt();
				itemSatisfactions[i] = s.nextInt();
			}
		} catch (Exception e) {
			throw new ReadDataException();
		}

		return new InputData(timeLimit, itemCount, menuItems, itemSatisfactions);
	}

	// didn't directly read and calculated the data so that we an easily add new
	// functionality if required on data without any mess
	public int getMaxSatisfaction(InputStream input) throws ReadDataException {
		InputData data = readDataFromStream(input);

		logger.error("Input data is : " + data);

		return knapsackUtility.findMaxOutcomeForGivenConstraint(data.getConstraint(), data.getObjects(),
				data.getValues(), data.getItemCount());

	}

}
