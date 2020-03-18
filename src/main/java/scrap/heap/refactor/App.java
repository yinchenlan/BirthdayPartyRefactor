package scrap.heap.refactor;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.log4j.Log4j2;
import scrap.heap.refactor.model.BalloonPurchase;
import scrap.heap.refactor.model.CakePurchase;
import scrap.heap.refactor.model.PurchaseOrder;
import scrap.heap.refactor.service.BalloonOrderService;
import scrap.heap.refactor.service.CakeOrderService;

/**
 * 
 * Spring boot application which reads in serialized JSON of {@link PurchaseOrder}.  
 * Validation is performed on the JSON.
 * 
 * @author Chuck Lan
 *
 */
@SpringBootApplication
@Log4j2
public class App implements CommandLineRunner {
	
	@Autowired
	private BalloonOrderService balloonOrderService;
	
	@Autowired
	private CakeOrderService cakeOrderService;
	
	public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

	public int purchase(InputStream in) throws Exception {
		int count = 0;
		ObjectMapper objectMapper = new ObjectMapper();
		PurchaseOrder po = objectMapper.readValue(in, PurchaseOrder.class);
		for (BalloonPurchase bp : po.getBalloons()) {
			balloonOrderService.order(bp);
			count++;
		}
		for (CakePurchase cp : po.getCakes()) {
			cakeOrderService.order(cp);
			count++;
		}
		return count;
	}

	@Override
	public void run(String... args) {
		if (args.length != 1) {
			System.out.println("Please specify path to JSON file.");
			return;
		}
		String pathName = args[0];
		File file = new File(pathName);
		
		try(FileInputStream fin = new FileInputStream(file)){
			purchase(fin);
		} catch (Exception e) {
			System.out.println("Error encountered while processing purchase order : " + e.getMessage());
			log.error("Exception encountered {}", e);
		}
	}

   
}
