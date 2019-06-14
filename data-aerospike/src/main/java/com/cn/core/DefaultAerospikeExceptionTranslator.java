package com.cn.core;

import com.aerospike.client.AerospikeException;
import com.aerospike.client.ResultCode;
import org.springframework.dao.*;
import org.springframework.data.keyvalue.core.UncategorizedKeyValueException;

public class DefaultAerospikeExceptionTranslator implements AerospikeExceptionTranslator {

    public DataAccessException translateExceptionIfPossible(RuntimeException cause){

        if(cause instanceof AerospikeException){
            int resultCode = ((AerospikeException)cause).getResultCode();
            String msg = cause.getMessage();
            switch (resultCode){
                case ResultCode.KEY_EXISTS_ERROR:
                    return new DuplicateKeyException(msg, cause);
                case ResultCode.KEY_NOT_FOUND_ERROR:
                    return new DataRetrievalFailureException(msg, cause);
                case ResultCode.INDEX_NOTFOUND:
                case ResultCode.INDEX_ALREADY_EXISTS:
                    return new InvalidDataAccessResourceUsageException(msg, cause);
                case ResultCode.TIMEOUT:
                case ResultCode.QUERY_TIMEOUT:
                    return new QueryTimeoutException(msg, cause);
                case ResultCode.DEVICE_OVERLOAD:
                case ResultCode.NO_MORE_CONNECTIONS:
                case ResultCode.KEY_BUSY:
                    return new TransientDataAccessResourceException(msg, cause);
                default:
                    return new RecoverableDataAccessException(msg, cause);
            }
        }

        return new UncategorizedKeyValueException("Unexpected Aerospike Exception", cause);
    }

}
