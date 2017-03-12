package edu.pse.beast.saverloader;

import edu.pse.beast.celectiondescriptioneditor.ElectionTemplates.ElectionTemplateHandler;
import edu.pse.beast.datatypes.electiondescription.ElectionDescription;
import edu.pse.beast.datatypes.electiondescription.ElectionTypeContainer;
import edu.pse.beast.datatypes.internal.InternalTypeRep;
import edu.pse.beast.saverloader.StaticSaverLoaders.SaverLoaderHelper;
import edu.pse.beast.saverloader.StaticSaverLoaders.StringSaverLoader;
import edu.pse.beast.stringresource.EnumToIdMapping;

import java.util.Arrays;
import java.util.Map;

/**
 * Implements SaverLoader methods for creating saveStrings from ElectionDescription objects and vice versa.
 * @author NikolaiLMS
 */
public class ElectionDescriptionSaverLoader implements SaverLoader {

    @Override
    public String createSaveString(Object obj) {
        SaverLoaderHelper h = new SaverLoaderHelper();
        String created = "";
        ElectionDescription electionDescription = (ElectionDescription) obj;
        created += h.getStringForAttr("name", electionDescription.getName());
        created += h.getStringForAttr("votingDeclLine", electionDescription.getVotingDeclLine());
        created += h.getStringForAttr("code", electionDescription.getCode());
        created += h.getStringForAttr("inputType", EnumToIdMapping.getIDInFile(electionDescription.getInputType().getId()) );
        created += h.getStringForAttr("outputType", EnumToIdMapping.getIDInFile(electionDescription.getOutputType().getId()));
        return created;
    }

    @Override
    public Object createFromSaveString(String s) throws ArrayIndexOutOfBoundsException {
        ElectionTemplateHandler electionTemplateHandler = new ElectionTemplateHandler();
        Map<String, String> m = new SaverLoaderHelper().parseSaveString(s);

        String name = m.get("name");
        ElectionTypeContainer inputType = electionTemplateHandler.getById(
                ElectionTypeContainer.ElectionTypeIds.valueOf(
                        EnumToIdMapping.getEnumStringFromIdInFile(
                                m.get("inputType"))
                        ));
        ElectionTypeContainer outputType = electionTemplateHandler.getById(
                ElectionTypeContainer.ElectionTypeIds.valueOf(EnumToIdMapping.getEnumStringFromIdInFile(
                        m.get("outputType"))
                ));
        int votingDecLine = Integer.valueOf(m.get("votingDeclLine"));
        String[] codeArray = m.get("code").split("\n");

        ElectionDescription electionDescription = new ElectionDescription(name, inputType, outputType, votingDecLine);
        electionDescription.setCode(Arrays.asList(codeArray));
        return electionDescription;
    }
}
