package com.cn.convert;

import com.aerospike.client.Bin;
import com.aerospike.client.Key;

import java.util.ArrayList;
import java.util.Collection;

public class AerospikeWriteData {

    private Key key;

    private Collection<Bin> bins;

    private  int expiration;

    public AerospikeWriteData(Key key, Collection<Bin> bins, int expiration) {
        this.key = key;
        this.bins = bins;
        this.expiration = expiration;
    }

    public static AerospikeWriteData forWrite(){
        return new AerospikeWriteData(null, new ArrayList<>(), 0);
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Collection<Bin> getBins() {
        return bins;
    }

    public void setBins(Collection<Bin> bins) {
        this.bins = bins;
    }

    public int getExpiration() {
        return expiration;
    }

    public void setExpiration(int expiration) {
        this.expiration = expiration;
    }
}
