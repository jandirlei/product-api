package br.com.matrix.productapi.repositories.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.matrix.productapi.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
