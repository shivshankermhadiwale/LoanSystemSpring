package com.dench.service;


import com.dench.entity.Item;

public interface ItemService {
	public Item addNewItem(Item item);
	public Item findItemById(Long itemId);
}
