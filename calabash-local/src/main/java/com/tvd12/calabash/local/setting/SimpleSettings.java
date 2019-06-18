package com.tvd12.calabash.local.setting;

import java.util.HashMap;
import java.util.Map;

public class SimpleSettings implements Settings {

	protected Map<String, EntityMapSetting> mapSettings = new HashMap<>();
	
	public void addMapSetting(EntityMapSetting setting) {
		mapSettings.put(setting.getMapName(), setting);
	}
	
	@Override
	public EntityMapSetting getMapSetting(String mapName) {
		EntityMapSetting mapSetting = mapSettings.get(mapName);
		if(mapSetting == null) {
			mapSetting = newDefaultMapSetting(mapName);
		}
		return mapSetting;
	}
	
	protected EntityMapSetting newDefaultMapSetting(String mapName) {
		synchronized (mapSettings) {
			EntityMapSetting mapSetting = mapSettings.get(mapName);
			if (mapSetting == null) {
				mapSetting = new SimpleEntityMapSetting();
				mapSettings.put(mapName, mapSetting);
			}
			return mapSetting;
		}
	}
}