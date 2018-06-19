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

/**
 *
 * @author davide
 */
public class GrammarGetByName implements DataFetcher<Grammar> {

    private final GrammarDao grammarDao;

    public GrammarGetByName() {
        this.grammarDao = HelloWorldApplication.grammarDao;
    }

    @Override
    public Grammar get(DataFetchingEnvironment environment) {
        String name = environment.getArgument("name");
        for (Grammar g : grammarDao.getGrammars()) {
            if (g.getName().equalsIgnoreCase(name)) {
                return g;
            }
        }
        return null;
    }
}
