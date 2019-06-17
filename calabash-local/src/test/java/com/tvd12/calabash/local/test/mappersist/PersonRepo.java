package com.tvd12.calabash.local.test.mappersist;

import com.tvd12.ezyfox.annotation.EzyAutoImpl;
import com.tvd12.ezyfox.mongodb.EzyMongoRepository;

@EzyAutoImpl
public interface PersonRepo extends EzyMongoRepository<Long, Person> {
}
