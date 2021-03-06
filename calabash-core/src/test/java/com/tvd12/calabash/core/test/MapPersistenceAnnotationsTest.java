package com.tvd12.calabash.core.test;

import org.testng.annotations.Test;

import com.tvd12.calabash.core.annotation.MapPersistence;
import com.tvd12.calabash.core.util.MapPersistenceAnnotations;

public class MapPersistenceAnnotationsTest {

	@Test
	public void test() {
		assert MapPersistenceAnnotations.getMapName(new A()).equals("a");
		assert MapPersistenceAnnotations.getMapName(new BZ()).equals("b");
	}

	@MapPersistence
	public static class A {
	}
	
	@MapPersistence("b")
	public static class BZ {
	}
	
}
