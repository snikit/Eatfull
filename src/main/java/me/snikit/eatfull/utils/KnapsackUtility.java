package me.snikit.eatfull.utils;

import org.springframework.stereotype.Component;

@Component
// Common knapsack utlity
public class KnapsackUtility {

	//knapsack algo returns the maximum outcome that can be calculated from given
	// objects-value pairs under a given constraint
	//used generic terms so that if needed can be used elsewhere
	public int findMaxOutcomeForGivenConstraint(int constraint, int objects[], int values[], int count) {

		int outcomes[][] = new int[count + 1][constraint + 1];

		for (int i = 0; i <= count; i++) {
			for (int j = 0; j <= constraint; j++) {
				if (i == 0 || j == 0)
					outcomes[i][j] = 0;
				else if (objects[i - 1] <= j)
					outcomes[i][j] = Math.max(values[i - 1] + outcomes[i - 1][j - objects[i - 1]], outcomes[i - 1][j]);
				else
					outcomes[i][j] = outcomes[i - 1][j];
			}
		}

		return outcomes[count][constraint];
	}

}
