package br.com.matrix.productapi.dto;

import br.com.matrix.productapi.model.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {
	
	@NotBlank
	private String productIdentifier;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String descricao;
	
	@NotNull
	private float preco;
	
	@NotNull
	private CategoryDTO category;
	
	public static ProductDTO convert(Product product) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setNome(product.getNome());
		productDTO.setPreco(product.getPreco());
		productDTO.setProductIdentifier(product.getProductIdentifier());
		productDTO.setDescricao(product.getDescricao());
		
		if (product.getCategory()!= null) {
			productDTO.setCategory(CategoryDTO.convert(product.getCategory()));
		}
		return productDTO;
	}
}
