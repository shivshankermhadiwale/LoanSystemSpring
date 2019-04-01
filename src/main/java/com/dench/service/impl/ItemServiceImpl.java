package com.dench.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.dench.entity.Item;
import com.dench.entity.ItemAudit;
import com.dench.exception.RecordNotFound;
import com.dench.service.DaoServicess;
import com.dench.service.ItemService;

@Service
public class ItemServiceImpl extends DaoServicess implements ItemService {

	@Override
	public Item addNewItem(Item item) {
		ItemAudit itemAudit = new ItemAudit();
		itemAudit.setAction("Created");
		itemAudit.setLastUpdatedDatetime(LocalDateTime.now());
		itemAudit.setLastUpdatedUserDesignation("NA");
		itemAudit.setLastUpdatedUserId("1");
		itemAudit.setLastUpdatedUserName("NA");
		itemAudit.setLoggedInUserId("1");
		itemAudit.setUserDesignation("NA");
		itemAudit.setUserName("NA");
		itemAudit.setItem(item);
		itemAudit.setCreatedOnDateTime(LocalDateTime.now());
		item.setItemAudit(itemAudit);
		return this.getDaoManager().getItemDao().addNewItem(item);
	}

	@Override
	public Item findItemById(Long itemId) {
		Optional<Item> item = this.getDaoManager().getItemDao().findItemById(itemId);
		if (!item.isPresent())
			throw new RecordNotFound("Item Not Found");
		return item.get();
	}

}
