package scrap.heap.refactor.model;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import scrap.heap.refactor.model.CakeConfig.Color;
import scrap.heap.refactor.model.CakeConfig.Flavor;
import scrap.heap.refactor.model.CakeConfig.FrostingFlavor;
import scrap.heap.refactor.model.CakeConfig.Shape;
import scrap.heap.refactor.model.CakeConfig.Size;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public final class BalloonConfig {
	
	public static enum Color {red, blue, yellow};
	public static enum Material {mylar, latex};
	
	@NotNull
	private Color color;
	@NotNull
	private Material material;

}
