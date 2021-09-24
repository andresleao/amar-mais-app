package com.acc.amar.mais.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acc.amar.mais.models.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {

}
