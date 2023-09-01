package br.com.matrix.productapi.model;

import org.hibernate.annotations.ManyToAny;

import br.com.matrix.productapi.dto.ProductDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	
	private float preco;
	
	private String descricao;
	
	private String productIdentifier;
	
	@ManyToAny
	@JoinColumn(name = "category_id")
	private Category category;
	
	public static Product convert(ProductDTO productDTO) {
		Product product = new Product();
		product.setNome(productDTO.getNome());
		product.setPreco(productDTO.getPreco());
		product.setDescricao(productDTO.getDescricao());
		product.setProductIdentifier(product.getProductIdentifier());
		if (productDTO.getCategory()!= null) {
			product.setCategory(Category.convert(productDTO.getCategory()));
		}
		return product;
	}
}
