/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pse.beast.celectiondescriptioneditor.UserActions;

import edu.pse.beast.celectiondescriptioneditor.CElectionDescriptionEditor;
import edu.pse.beast.toolbox.UserAction;

/**
 *
 * @author Holger-Desktop
 */
public class StaticErrorFindingUserAction extends UserAction {
    private final CElectionDescriptionEditor electionDescriptionEditor;

    public StaticErrorFindingUserAction(CElectionDescriptionEditor electionDescriptionEditor) {
        super("staticErrorFinding");
        this.electionDescriptionEditor = electionDescriptionEditor;
    }
    
    @Override
    public void perform() {
        electionDescriptionEditor.findErrorsAndDisplayThem();
    }
}
