/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pse.beast.celectiondescriptioneditor;

import edu.pse.beast.celectiondescriptioneditor.CElectionCodeArea.CElectionCodeArea;
import edu.pse.beast.celectiondescriptioneditor.CElectionCodeArea.CElectionCodeAreaBuilder;
import edu.pse.beast.celectiondescriptioneditor.CElectionCodeArea.ErrorHandling.CErrorDisplayer;
import edu.pse.beast.celectiondescriptioneditor.GUI.CCodeEditorGUI;
import edu.pse.beast.celectiondescriptioneditor.UserActions.SaveBeforeChangeHandler;
import edu.pse.beast.datatypes.descofvoting.ElectionDescription;
import edu.pse.beast.datatypes.descofvoting.ElectionDescriptionChangeListener;
import edu.pse.beast.datatypes.descofvoting.ElectionTypeContainer;
import edu.pse.beast.highlevel.ElectionDescriptionSource;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.text.BadLocationException;


/**
 *  
 * @author Holger Klein
 */
public class CElectionDescriptionEditor implements ElectionDescriptionSource{
    private CElectionCodeArea codeArea;
    private ElectionDescription currentDescription;
    private CCodeEditorGUI gui;
    private CElectionCodeAreaBuilder builder;
    private ErrorWindow errorWindow;
    private SaveBeforeChangeHandler saveBeforeChangeHandler;
    private ArrayList<ElectionDescriptionChangeListener> descriptionChangeListeners = new ArrayList<>();

    public CElectionDescriptionEditor(
            CElectionCodeArea codeArea,
            CCodeEditorGUI gui,            
            CElectionCodeAreaBuilder builder) {
        this.codeArea = codeArea;
        this.gui = gui;
        this.builder = builder;
        this.errorWindow = errorWindow;
        this.saveBeforeChangeHandler = new SaveBeforeChangeHandler(codeArea.getPane());
    }

    @Override
    public ElectionDescription getElectionDescription() {
        updateCurrentDescription();
        return currentDescription;
    }

    private void updateCurrentDescription() {
        
    }

    public void changeElectionDescriptionInput(ElectionTypeContainer cont) {
        currentDescription.setInputType(cont);
        for(ElectionDescriptionChangeListener l : descriptionChangeListeners) 
            l.inputChanged(cont);
    }
    
    public void changeElectionDescriptionOutput(ElectionTypeContainer cont) {
        currentDescription.setOutputType(cont);
        for(ElectionDescriptionChangeListener l : descriptionChangeListeners) 
            l.outputChanged(cont);
    }
        
    @Override
    public boolean isCorrect() {
        return true;
    }

    @Override
    public void stopReacting() {
        
    }

    @Override
    public void resumeReacting() {
        
    }

    /**
     * Getter
     * @return the CElectionCodeArea
     */
    public CElectionCodeArea getCodeArea() {
        return codeArea;
    }

    public boolean letUserEditElectionDescription(ElectionDescription description) throws BadLocationException {
        gui.setNewCodeArea();
        codeArea = builder.createCElectionCodeArea(gui.getCodeArea(), 
                gui.getCodeAreaScrollPane(), 
                (CErrorDisplayer) codeArea.getErrorCtrl().getDisplayer());
        codeArea.letUserEditCode(description.getCode());
        codeArea.lockLine(description.getVotingDeclLine());     
        codeArea.lockLine(description.getCode().size() - 1);
        this.currentDescription = description;
        saveBeforeChangeHandler.addNewTextPane(codeArea.getPane());
        gui.setWindowTitle(description.getName());
        for(ElectionDescriptionChangeListener l : descriptionChangeListeners) {
            l.inputChanged(description.getInputType());
            l.outputChanged(description.getOutputType());
        }
        return true;
    }

    /**
     * Getter
     * @return the CCodeEditorGUI object of this class
     */
    public CCodeEditorGUI getGui() {
        return this.gui;
    }

    /**
     * Getter
     * @return the SaveBeforeChangeHandler object of this class
     */
    public SaveBeforeChangeHandler getSaveBeforeChangeHandler() {
        return this.saveBeforeChangeHandler;
    }
    
    public void addListener(ElectionDescriptionChangeListener l) {
        descriptionChangeListeners.add(l);
    }
    
    public void removeListener(ElectionDescriptionChangeListener l) {
        descriptionChangeListeners.remove(l);
    }
    
    public boolean getIsVisible() {
        return gui.isVisible();
    }
    
    public void setVisible(boolean vis) {
        gui.setVisible(vis);
    }
}
