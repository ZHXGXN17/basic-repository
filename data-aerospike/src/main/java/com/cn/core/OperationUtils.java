package com.cn.core;

import com.aerospike.client.Bin;
import com.aerospike.client.Operation;

import java.util.function.Function;


/**
 * 工具类
 */
public class OperationUtils {

    public static Operation[] operations(Bin[] bins,
                                         Function<Bin, Operation> binToOperatin,
                                         Operation... additionalOperations){
        Operation[] operations = new Operation[bins.length + additionalOperations.length];
        int i = 0;
        for(Bin bin : bins){
            operations[i] = binToOperatin.apply(bin);
            i++;
        }
        for(Operation additionalOp : additionalOperations){
            operations[i] = additionalOp;
            i++;
        }
        return operations;
    }

}
