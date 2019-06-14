package com.cn.core;

import com.aerospike.client.policy.WritePolicy;
import org.springframework.data.mapping.context.MappingContext;

import java.io.Serializable;

public interface AerospikeOperations {

    String getSetName(Class<?> entityClass);

    void insert(Object document);

    MappingContext<?, ?> getMappingContext();

    void save(Object document);

    void persist(Object document, WritePolicy writePolicy);

    void update(Object objectToUpdate);

    void delete(Class<?> type);

    boolean delete(Serializable id, Class<?> type);

    boolean delete(Object objectToDelete);

    boolean exists(Serializable id, Class<?> type);


}
