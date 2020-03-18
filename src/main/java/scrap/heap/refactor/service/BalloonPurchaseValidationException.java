package scrap.heap.refactor.service;

import java.util.Set;

import javax.validation.ConstraintViolation;

import lombok.Getter;
import scrap.heap.refactor.model.BalloonPurchase;

public class BalloonPurchaseValidationException extends Exception {

	@Getter
	private final Set<ConstraintViolation<BalloonPurchase>> violations;
	
	public BalloonPurchaseValidationException(Set<ConstraintViolation<BalloonPurchase>> violations) {
		this.violations = violations;
	}

}
