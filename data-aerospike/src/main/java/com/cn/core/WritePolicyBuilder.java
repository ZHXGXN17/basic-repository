package com.cn.core;

import com.aerospike.client.policy.GenerationPolicy;
import com.aerospike.client.policy.RecordExistsAction;
import com.aerospike.client.policy.WritePolicy;
import org.springframework.util.Assert;

/**
 * 写策略
 */
public class WritePolicyBuilder {

    private WritePolicy writePolicy;

    private WritePolicyBuilder(WritePolicy writePolicy){
        this.writePolicy = writePolicy;
    }

    public static WritePolicyBuilder builder(WritePolicy policy){
        Assert.notNull(policy, "Policy must not be null!");
        return new WritePolicyBuilder(new WritePolicy(policy));
    }


    public WritePolicyBuilder expiration(int expiration){
        writePolicy.expiration = expiration;
        return this;
    }

    public WritePolicyBuilder sendKey(boolean sendKey){
        writePolicy.sendKey = sendKey;
        return this;
    }

    public WritePolicyBuilder recordExistsAction(RecordExistsAction recordExistsAction){
        writePolicy.recordExistsAction = recordExistsAction;
        return this;
    }

    public WritePolicyBuilder generationPolicy(GenerationPolicy generationPolicy){
        writePolicy.generationPolicy = generationPolicy;
        return this;
    }

    public WritePolicyBuilder generation(int generation){
        writePolicy.generation = generation;
        return this;
    }

    public WritePolicy build(){
        validate();
        return new WritePolicy(writePolicy);
    }

    private void validate(){
        Assert.notNull(writePolicy.commitLevel, "Field 'commitLevel' must not be null");
        Assert.notNull(writePolicy.recordExistsAction, "Field 'recordExistsAction' must not be null");
        Assert.notNull(writePolicy.generationPolicy, "Field 'generationPolicy' must not be null");
        Assert.state(!(writePolicy.generation > 0 && writePolicy.generationPolicy == GenerationPolicy.NONE),
                "Field 'generationPolicy' must not be 'NONE' when 'generation' is set");
    }


}
