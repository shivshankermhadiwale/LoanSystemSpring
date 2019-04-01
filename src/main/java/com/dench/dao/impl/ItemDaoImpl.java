package com.dench.dao.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dench.dao.ItemDao;
import com.dench.entity.Item;
import com.dench.repositories.ItemRepository;

@Repository
public class ItemDaoImpl implements ItemDao {
	@Autowired
	ItemRepository itemRepository;

	@Override
	public Item addNewItem(Item item) {
		return itemRepository.save(item);
	}

	public Optional<Item> findItemById(Long itemId) {
		return itemRepository.findById(itemId);
	}

}
