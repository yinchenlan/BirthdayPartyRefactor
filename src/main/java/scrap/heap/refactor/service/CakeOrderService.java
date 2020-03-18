package scrap.heap.refactor.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import scrap.heap.refactor.model.CakePurchase;

@Service
@Log4j2
public class CakeOrderService {
	public void order(CakePurchase purchase) throws CakePurchaseValidationException {
		Set<ConstraintViolation<CakePurchase>> violations = validate(purchase);
		if (violations.size() > 0) {
			throw new CakePurchaseValidationException(violations);
		}
		
		//for the purposes of this exercise, pretend that this method adds a cake to the order
        System.out.println("cake ordered; " + purchase.getConfig().getFlavor() + 
        		", " + purchase.getConfig().getFrostingFlavor()  + ", " + purchase.getConfig().getShape() + 
        		", " + purchase.getConfig().getSize() + ", " + purchase.getConfig().getColor());
	}

	private Set<ConstraintViolation<CakePurchase>> validate(CakePurchase purchase) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<CakePurchase>> violations = validator.validate(purchase);
		for (ConstraintViolation<CakePurchase> violation : violations) {
		    log.error("property \"{}\" : {}", violation.getPropertyPath(), violation.getMessage()); 
		}
		return violations;
	}
}
