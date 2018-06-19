/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.helloworld.api;

import com.example.helloworld.HelloWorldApplication;
import com.example.helloworld.db.GrammarDao;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

/**
 *
 * @author davide
 */
public class GrammarDataFetcher implements DataFetcher<List<Grammar>> {

    private final GrammarDao grammarDao;
    
    public GrammarDataFetcher() {
        this.grammarDao = HelloWorldApplication.grammarDao;
    }

    @Override
    public List<Grammar> get(DataFetchingEnvironment environment) {
        return grammarDao.getGrammars();
    }
}
