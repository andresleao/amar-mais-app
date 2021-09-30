package com.acc.amar.mais.repositories;

import com.acc.amar.mais.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
