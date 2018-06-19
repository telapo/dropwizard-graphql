/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.helloworld.db;

import com.example.helloworld.api.Grammar;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author davide
 */
public class GrammarDao {

    private final List<Grammar> listOfGrammars;

    public GrammarDao() {
        this.listOfGrammars = new ArrayList<>();
        listOfGrammars.add(new Grammar("first", "default grammar!"));
    }

    public List<Grammar> getGrammars() {
        return listOfGrammars;
    }

    public Grammar addGrammar(String name, String description) {
        Grammar grammar = new Grammar(name, description);
        listOfGrammars.add(grammar);
        return grammar;
    }

}
