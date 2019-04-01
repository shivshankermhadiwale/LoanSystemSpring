package com.dench.dao;

import java.util.Optional;

import com.dench.entity.Item;

public interface ItemDao {
	public Item addNewItem(Item item);
	public Optional<Item> findItemById(Long itemId);
}
