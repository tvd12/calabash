package com.tvd12.calabash.local.persist;

import java.util.Map;
import java.util.function.Supplier;

import com.tvd12.calabash.persist.action.PersistActionBulkBuilder;
import com.tvd12.calabash.persist.action.PersistActionBulkFactory;
import com.tvd12.calabash.persist.action.PersistActionType;

public class PersistActionBulkFactoryImpl extends PersistActionBulkFactory {

	@Override
	protected void addDefaultBuilderSuppliers(Map<PersistActionType, Supplier<PersistActionBulkBuilder>> map) {
		map.put(PersistActionType.SAVE_ONE, PersistSaveActionBulk::builder);
		map.put(PersistActionType.SAVE_MANY, PersistSaveActionBulk::builder);
		map.put(PersistActionType.DELETE_ONE, PersistDeleteActionBulk::builder);
		map.put(PersistActionType.DELETE_MANY, PersistDeleteActionBulk::builder);
	}
	
}
