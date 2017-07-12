package com.asterik.utility.snapshot.variableTypes;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class CacheImpl {


    public static LoadingCache<String,String> loadingCache = CacheBuilder.newBuilder()
            .maximumSize(3).build(
                    new CacheLoader<String, String>() {
                        public String load(String str) throws Exception {
                            return str.toString().toUpperCase();
                        }
                    }
            );





}


