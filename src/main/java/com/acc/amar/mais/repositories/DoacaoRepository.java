package com.acc.amar.mais.repositories;

import com.acc.amar.mais.models.Doacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DoacaoRepository extends JpaRepository<Doacao, Integer> {

    @Query(value = "SELECT * FROM doacao d WHERE d.is_ativo = true", nativeQuery = true)
    List<Doacao> findAllByAtivo();

    @Transactional
    @Modifying
    @Query(value = " UPDATE doacao SET is_ativo = false, id_donatario = :donatario WHERE id = :id ", nativeQuery = true)
    void disableDoacao(@Param("id") Integer id, @Param("donatario") Integer donatario);
}
