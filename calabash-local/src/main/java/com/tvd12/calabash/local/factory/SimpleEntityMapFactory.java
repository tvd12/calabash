package com.tvd12.calabash.local.factory;

import com.tvd12.calabash.core.EntityMap;
import com.tvd12.calabash.core.EntityMapPersist;
import com.tvd12.calabash.local.builder.EntityMapBuilder;
import com.tvd12.calabash.local.executor.EntityMapPersistExecutor;
import com.tvd12.calabash.local.setting.Settings;
import com.tvd12.calabash.persist.factory.EntityMapPersistFactory;
import com.tvd12.calabash.persist.manager.MapPersistManager;
import com.tvd12.ezyfox.builder.EzyBuilder;
import com.tvd12.ezyfox.util.EzyLoggable;

@SuppressWarnings("rawtypes")
public class SimpleEntityMapFactory extends EzyLoggable implements EntityMapFactory {

	protected final Settings settings;
	protected final EntityMapPersistFactory entityMapPersistFactory;
	protected final MapPersistManager mapPersistManager;
	protected final EntityMapPersistExecutor mapPersistExecutor;
	
	protected SimpleEntityMapFactory(Builder builder) {
		this.settings = builder.settings;
		this.entityMapPersistFactory = builder.entityMapPersistFactory;
		this.mapPersistManager = builder.mapPersistManager;
		this.mapPersistExecutor = builder.mapPersistExecutor;
	}
	
	@Override
	public EntityMap newMap(String mapName) {
		EntityMap map = createMap(mapName);
		newMapPersist(mapName);
		return map;
	}
	
	protected EntityMap createMap(String mapName) {
		EntityMap map = new EntityMapBuilder()
				.mapPersistExecutor(mapPersistExecutor)
				.mapSetting(settings.getMapSetting(mapName))
				.build();
		return map;
	}
	
	protected void newMapPersist(String mapName) {
		EntityMapPersist<?, ?> mapPersist = entityMapPersistFactory.newMapPersist(mapName);
		mapPersistManager.addMapPersist(mapName, mapPersist);
	}
	
	public static Builder builder() {
		return new Builder();
	}
	
	public static class Builder implements EzyBuilder<EntityMapFactory> {
		
		protected Settings settings;
		protected EntityMapPersistFactory entityMapPersistFactory;
		protected MapPersistManager mapPersistManager;
		protected EntityMapPersistExecutor mapPersistExecutor;
		
		public Builder settings(Settings settings) {
			this.settings = settings;
			return this;
		}
		
		public Builder entityMapPersistFactory(EntityMapPersistFactory entityMapPersistFactory) {
			this.entityMapPersistFactory = entityMapPersistFactory;
			return this;
		}
		
		public Builder mapPersistManager(MapPersistManager mapPersistManager) {
			this.mapPersistManager = mapPersistManager;
			return this;
		}
		
		public Builder mapPersistExecutor(EntityMapPersistExecutor mapPersistExecutor) {
			this.mapPersistExecutor = mapPersistExecutor;
			return this;
		}
		
		@Override
		public EntityMapFactory build() {
			return new SimpleEntityMapFactory(this);
		}
	}
	
}
