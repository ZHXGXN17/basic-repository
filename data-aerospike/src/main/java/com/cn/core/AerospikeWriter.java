package com.cn.core;

import com.cn.convert.AerospikeWriteData;
import com.cn.mapping.AerospikePersistentProperty;
import org.springframework.data.convert.EntityWriter;
import org.springframework.data.util.TypeInformation;


public interface AerospikeWriter<T> extends EntityWriter<T, AerospikeWriteData> {

    Object convertToAerospikeType(Object object);

    Object convertToAerospikeType(Object object, TypeInformation<?> typeInformation);

    AerospikeWriteData toAerospikeData(Object object, AerospikePersistentProperty referingProperty);



}
