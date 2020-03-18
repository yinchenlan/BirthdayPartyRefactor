package scrap.heap.refactor.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import scrap.heap.refactor.model.BalloonPurchase;

@Service
@Log4j2
public class BalloonOrderService {
	public void order(BalloonPurchase purchase) throws BalloonPurchaseValidationException {
		Set<ConstraintViolation<BalloonPurchase>> violations = validate(purchase);
		if (violations.size() > 0) {
			throw new BalloonPurchaseValidationException(violations);
		}
		//for the purposes of this exercise, pretend this method works and adds balloons to the order
        System.out.println("Balloons ordered; " + purchase.getConfig().getColor() + 
        		", " + purchase.getConfig().getMaterial()  + ", " + purchase.getQuantity());
	}
	
	private Set<ConstraintViolation<BalloonPurchase>> validate(BalloonPurchase purchase) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<BalloonPurchase>> violations = validator.validate(purchase);
		for (ConstraintViolation<BalloonPurchase> violation : violations) {
		    log.error("property \"{}\" : {}", violation.getPropertyPath(), violation.getMessage());
		}
		return violations;
	}
}
