package com.acc.amar.mais.repositories;

import com.acc.amar.mais.models.Doacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DoacaoRepository extends JpaRepository<Doacao, Integer> {

}
