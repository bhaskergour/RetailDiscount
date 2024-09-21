package com.retail.discount.utility;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.retail.discount.repository.ItemList;
import com.retail.discount.repository.UserList;

@Component
public class RunAfterStartup {

	@EventListener(ApplicationReadyEvent.class)
	public void runAfterStartup() {
		UserList.addUser();
		ItemList.addItem();
	}
}