package br.com.matrix.productapi.repositories.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.matrix.productapi.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(value = "select p from product p"
					+ " join category c p.category.id = c.id"
					+ " where c.id =: categoryId")
	public List<Product> getProductByCategory(@Param("categoryId") long categoryId);

	public Product findByProductIdenti(String productIdentifier);
}
