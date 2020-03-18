package scrap.heap.refactor.model;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CakeConfig {
	public static enum Flavor {vanilla, chocolate};
	public static enum FrostingFlavor {vanilla, chocolate};
	public static enum Shape{square, circle};
	public static enum Size{small, medium, large};
	public static enum Color{brown, yellow};
	
	@NotNull
	private Flavor flavor;
	@NotNull
	private FrostingFlavor frostingFlavor;
	@NotNull
	private Shape shape;
	@NotNull
	private Size size;
	@NotNull
	private Color color;

}
