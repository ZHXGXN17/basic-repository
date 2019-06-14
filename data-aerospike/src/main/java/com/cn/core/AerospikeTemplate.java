package com.cn.core;

import com.aerospike.client.AerospikeClient;
import com.aerospike.helper.query.QueryEngine;
import com.cn.mapping.AerospikePersistentProperty;


@Slf4j
public class AerospikeTemplate implements AerospikeOperations {

    private final MappingContext<BasicAerospikePersistentEntity<?>, AerospikePersistentProperty> mappingContext;

    private AerospikeClient client;

    private final MappingAerospikeConverter converter;

    private String namespace;

    private QueryEngine queryEngine;

    private AerospikeExceptionTranslator exceptionTranslator;


}
