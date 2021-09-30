package com.acc.amar.mais.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acc.amar.mais.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Usuario findByCpf(String cpf);
	Usuario findByEmail(String email);
	
	//@Query("SELECT obj FROM Usuario obj WHERE obj.email =:email")
	//Usuario findByEMAIL(@Param("email") String email);
}
