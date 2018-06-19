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
import java.util.Map;

/**
 *
 * @author davide
 */
public class GrammarCreator implements DataFetcher<Grammar> {

    private final GrammarDao grammarDao;

    public GrammarCreator() {
        this.grammarDao = HelloWorldApplication.grammarDao;
    }

    @Override
    public Grammar get(DataFetchingEnvironment dfe) {
        //
        // The graphql specification dictates that input object arguments MUST
        // be maps.  You can convert them to POJOs inside the data fetcher if that
        // suits your code better
        //
        // See http://facebook.github.io/graphql/October2016/#sec-Input-Objects
        //
        String name = dfe.getArgument("name");
        String description = dfe.getArgument("description");

        //
        // in this case we have type safe Java objects to call our backing code with
        //
        // make a call to your store to mutate your database
        Grammar updatedGrammar = grammarDao.addGrammar(name, description);

        // this returns a new view of the data
        return updatedGrammar;
    }
}
