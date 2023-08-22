package br.com.matrix.productapi.model;

import java.util.Locale.Category;

import org.hibernate.annotations.ManyToAny;

import br.com.matrix.productapi.dto.ProductDTO;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
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
		return product;
	}

}
