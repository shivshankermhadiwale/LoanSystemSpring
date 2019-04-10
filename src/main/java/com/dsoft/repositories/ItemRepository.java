package com.dsoft.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dsoft.entity.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {

}
