package com.jabong.promotion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Promotions {

	private List<Promotion> promotionsList;
	private int promotionsLogCount = 2;
	private int promotionsSuccessCount = 1;

	public void createPromotion(String id) {
		if (null == promotionsList)
			promotionsList = new ArrayList<Promotion>();
		promotionsList.add(new Promotion(id));
	}

	public void logPromotion(String id, int status) {
		promotionsLogCount++;
		System.out.println("Total promotions: " + promotionsLogCount);
		if (status == 1)
			promotionsSuccessCount++;
		System.out.println("Total success: " + promotionsSuccessCount);
		findPromotion(id).log(status, promotionsLogCount, promotionsSuccessCount);
	}

	private Promotion findPromotion(String id) {
		Promotion promotion = null;
		Iterator<Promotion> promotionsIter = promotionsList.iterator();
		while (promotionsIter.hasNext()) {
			Promotion checkPromotion = promotionsIter.next();
			if (checkPromotion.getId().equals(id))
				promotion = checkPromotion;
		}
		return promotion;
	}

	public static void main(String[] args) {
		Promotions promotions = new Promotions();
		promotions.createPromotion("Extra_25");
		promotions.createPromotion("Extra_22");

		promotions.logPromotion("Extra_25", 0);
		promotions.logPromotion("Extra_22", 0);
		promotions.logPromotion("Extra_25", 1);
		promotions.logPromotion("Extra_22", 0);
		promotions.logPromotion("Extra_22", 1);
	}
}
