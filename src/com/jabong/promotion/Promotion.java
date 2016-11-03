package com.jabong.promotion;

public class Promotion {

	private double successPrior = 0.75d;
	private String id;
	private int countSuccess;
	private int countFailure;
	private int countTotal;
	private double promotionPrior = 0.5d;
	private double likelihood;
	private double posterior;

	public Promotion(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCountSuccess() {
		return countSuccess;
	}

	public void setCountSuccess(int countSuccess) {
		this.countSuccess = countSuccess;
	}

	public int getCountFailure() {
		return countFailure;
	}

	public void setCountFailure(int countFailure) {
		this.countFailure = countFailure;
	}

	public int getCountTotal() {
		return countTotal;
	}

	public void setCountTotal(int countTotal) {
		this.countTotal = countTotal;
	}

	public void log(int status, int promotionsLogCount, int promotionsSuccessCount) {
		// double successPrior = promotionsSuccessCount * 1.0d /
		// promotionsLogCount;
		System.out.println("Success prior: " + successPrior);
		countTotal++;
		// promotionPrior = countTotal * 1.0d / promotionsLogCount;
		System.out.println("Promotion prior for " + id + " : " + promotionPrior);
		if (status == 0)
			countFailure++;
		else if (status == 1)
			countSuccess++;
		likelihood = (countSuccess * 1.0d / promotionsSuccessCount) / promotionPrior;
		System.out.println("Promotion likelikehood for " + id + " : " + likelihood);
		posterior = successPrior * likelihood;
		System.out.println("Promotion posterior for " + id + " : " + posterior);
	}

	public double getLikelihood() {
		return likelihood;
	}

	public double getPosterior() {
		return posterior;
	}

}
