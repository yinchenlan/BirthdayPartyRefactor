package scrap.heap.refactor.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public final class PurchaseOrder {
	
	private List<CakePurchase> cakes;
	private List<BalloonPurchase> balloons;
}
