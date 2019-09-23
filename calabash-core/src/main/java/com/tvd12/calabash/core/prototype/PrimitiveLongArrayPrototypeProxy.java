package com.tvd12.calabash.core.prototype;

public final class PrimitiveLongArrayPrototypeProxy implements PrototypeProxy<long[]> {

	private static final PrimitiveLongArrayPrototypeProxy INSTANCE 
			= new PrimitiveLongArrayPrototypeProxy();
	
	private PrimitiveLongArrayPrototypeProxy() {}
	
	public static PrimitiveLongArrayPrototypeProxy getInstance() {
		return INSTANCE;
	}
	
	@Override
	public long[] clone(Prototypes prototypes, long[] origin) {
		long[] copy = new long[origin.length];
		for(int i = 0 ; i < copy.length ; ++i)
			copy[i] = origin[i];
		return copy;
	}
	
}
