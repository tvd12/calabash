package com.tvd12.calabash.backend.persist;

import com.tvd12.calabash.backend.setting.Settings;

public class PersistActionQueueFactory {
	
	protected final Settings settings;
	
	public PersistActionQueueFactory(Settings settings) {
		this.settings = settings;
	}
	
	public PersistActionQueue newActionQueue(String mapName) {
		return new PersistActionQueue();
	}
	
}