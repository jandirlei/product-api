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
	
	private long id;
	
	@NotBlank
	private String nome;
	
	@NotNull
	private float preco;
	
	@NotBlank
	private String descricao;
	
	@NotBlank
	private String productIdentifier;
	
	@NotNull
	private CategoryDTO category;
	
	public static ProductDTO convert(Product product) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setNome(product.getNome());
		productDTO.setPreco(product.getPreco());
		productDTO.setDescricao(product.getDescricao());
		productDTO.setProductIdentifier(product.getProductIdentifier());
		
		if (product.getCategory()!= null) {
			productDTO.setCategoryDTO(CategoryDTO.convert(product.getCategory()));
		}
		return productDTO;
	}
}
