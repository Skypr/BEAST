/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pse.beast.codearea.ErrorHandling;

import java.util.ArrayList;

/**
 * This class contains a list of all error finders sorted by dependency.
 * This means that once the first error finder finds and error, letting
 * the latteer ones search is unecessary
 * @author Holger-Desktop
 */
public class ErrorFinderList {
    private ArrayList<ErrorFinder> errorFinderList = new ArrayList<>();
    
    /**
     * starts asking all error finders to look for errors in the code. Once the
     * first error finder finds errors, it stops the search and returns
     * these errors
     * @return the list of errors found be the errorfinders
     */
    public ArrayList<CodeError>  getErrors() {
        ArrayList<CodeError> created = new ArrayList<>();
        for(int i = 0; i < errorFinderList.size() && created.size() == 0; ++i) {
            created.addAll(errorFinderList.get(i).getErrors());
        }
        return created;
    }
    
    public void add(ErrorFinder errorFinder) {
        errorFinderList.add(errorFinder);
    }
}
