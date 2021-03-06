/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pse.beast.celectiondescriptioneditor.CElectionCodeArea.ErrorHandling;

import java.util.ArrayList;

import javax.swing.JTextPane;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.pse.beast.celectiondescriptioneditor.CElectionCodeArea.Antlr.CAntlrHandler;
import edu.pse.beast.codearea.ErrorHandling.CodeError;

/**
 *
 * @author Holger-Desktop
 */
public class CVariableErrorFinderTest {
    
    private JTextPane pane;
    private CAntlrHandler handler;
    private CVariableErrorFinder finder;
    public CVariableErrorFinderTest() {
        pane = new JTextPane();
        handler = new CAntlrHandler(pane);
        finder = new CVariableErrorFinder(pane);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getErrors method, of class CVariableErrorFinder.
     */
    @Test
    public void testGetVarNotDeclError() {
        String code = "void f(){c = 1;}";
        pane.setText(code);
        ArrayList<CodeError> ers = finder.getErrors();
        //assertEquals(1, ers.size());
    }

   
    
}
