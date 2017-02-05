package edu.pse.beast.parametereditor.UserActions;

import edu.pse.beast.celectiondescriptioneditor.CElectionDescriptionEditor;
import edu.pse.beast.parametereditor.ParameterEditor;
import edu.pse.beast.propertylist.PropertyList;
import edu.pse.beast.saverloader.SaverLoaderInterface;
import edu.pse.beast.toolbox.UserAction;

/**
 * UserAction for saving a project at a certain path
 * @author Jonas
 */
public class SaveProjectAsUserAction extends UserAction {
    private final PropertyList propertyList;
    private final CElectionDescriptionEditor cElectionEditor;
    private final ParameterEditor paramEditor;
    private final SaverLoaderInterface saverLoaderIf;
    /**
     * Constructor
     * @param propertyList PropertyList
     * @param cElectionEditor CElectionDescriptionEditor
     * @param paramEditor ParameterEditor
     * @param saverLoaderIf SaverLoaderInterface
     */
    public SaveProjectAsUserAction(PropertyList propertyList, 
            CElectionDescriptionEditor cElectionEditor, ParameterEditor paramEditor, 
            SaverLoaderInterface saverLoaderIf) {
        super("save_as");
        this.propertyList = propertyList;
        this.cElectionEditor = cElectionEditor;
        this.paramEditor = paramEditor;
        this.saverLoaderIf = saverLoaderIf;
    }

    @Override
    public void perform() {
        //if (paramEditor.getReacts()) //TODO: implement
    }
}
