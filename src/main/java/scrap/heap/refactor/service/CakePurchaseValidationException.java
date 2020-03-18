package scrap.heap.refactor.service;

import java.util.Set;

import javax.validation.ConstraintViolation;

import scrap.heap.refactor.model.CakePurchase;

public class CakePurchaseValidationException extends Exception {

	private final Set<ConstraintViolation<CakePurchase>> violations;

	public CakePurchaseValidationException(Set<ConstraintViolation<CakePurchase>> violations) {
		this.violations = violations;
	}

}
