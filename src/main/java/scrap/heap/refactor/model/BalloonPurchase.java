package scrap.heap.refactor.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public final class BalloonPurchase {
	@NotNull
	@Valid
	private BalloonConfig config;
	@Positive
	private int quantity;
}
