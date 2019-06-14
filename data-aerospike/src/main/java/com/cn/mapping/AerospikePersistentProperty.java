package com.cn.mapping;

import org.springframework.data.mapping.PersistentProperty;

public interface AerospikePersistentProperty extends PersistentProperty<AerospikePersistentProperty> {


    @Override
    boolean usePropertyAccess();

    boolean isExplicitIdProperty();

    boolean isExpirationProperty();

    boolean isExpirationSpecifiedAsUnixTime();

    String getFieldName();
}
