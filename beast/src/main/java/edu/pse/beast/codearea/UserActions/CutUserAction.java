/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pse.beast.codearea.UserActions;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.text.BadLocationException;

import edu.pse.beast.codearea.CodeArea;
import edu.pse.beast.toolbox.UserAction;

/**
 * This useraction takes the selected text in a given codearea and copies it
 * to the clipboard and aks the codearea to replace the selection by the
 * empty string
 * @author Holger-Desktop
 */
public class CutUserAction extends UserAction  {
    private CodeArea codeArea;
    private Clipboard clipboard;

    public CutUserAction(CodeArea area) {
        super("cut");
        this.codeArea = area;
        this.clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    }

    @Override
    public void perform() {
        try {
            codeArea.getInsertToCode().getSaveBeforeRemove().save();
        } catch (BadLocationException ex) {
            Logger.getLogger(CutUserAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        StringSelection stringSelection = new StringSelection(codeArea.getPane().getSelectedText());
        clipboard.setContents(stringSelection, null);
        codeArea.insertString("");
    }
}
