package br.com.matrix.productapi.repositories.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.matrix.productapi.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
