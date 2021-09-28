package com.acc.amar.mais.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acc.amar.mais.models.Login;
import com.acc.amar.mais.models.Usuario;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {

	Optional<Login> findByEmail(String login);
	boolean existsByEmail(String login);
}
