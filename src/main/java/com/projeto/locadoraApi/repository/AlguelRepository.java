package com.projeto.locadoraApi.repository;

import com.projeto.locadoraApi.model.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlguelRepository extends JpaRepository<Aluguel,Long> {
}
