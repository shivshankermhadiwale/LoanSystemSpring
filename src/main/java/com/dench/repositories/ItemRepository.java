package com.dench.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dench.entity.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {

}
