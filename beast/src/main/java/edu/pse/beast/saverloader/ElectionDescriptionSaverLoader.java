package edu.pse.beast.saverloader;

import edu.pse.beast.celectiondescriptioneditor.ElectionTemplates.ElectionTemplateHandler;
import edu.pse.beast.datatypes.electiondescription.ElectionDescription;
import edu.pse.beast.datatypes.electiondescription.ElectionTypeContainer;
import edu.pse.beast.saverloader.StaticSaverLoaders.StringSaverLoader;

import java.util.Arrays;

/**
 * Implements SaverLoader methods for creating saveStrings from ElectionDescription objects and vice versa.
 * @author NikolaiLMS
 */
public class ElectionDescriptionSaverLoader implements SaverLoader {

    @Override
    public String createSaveString(Object electionDescription) {
        String created = "";
        String name = "<electionName>\n" + ((ElectionDescription) electionDescription).getName()
                + "\n</electionName>\n";
        String votingDecLine = "<votingDecLine>\n" + ((ElectionDescription) electionDescription).getVotingDeclLine()
                + "\n</votingDecLine>\n";
        String code = "<code>\n";
        String codeString = "";
        for (String s : ((ElectionDescription) electionDescription).getCode()) {
            codeString += s + "\n";
        }
        code += StringSaverLoader.createSaveString(codeString) + "\n</code>\n";
        String inputType = "<inputType>\n"
                + ((ElectionDescription) electionDescription).getInputType().getId()
                + "\n</inputType>\n";
        String outputType = "<outputType>\n"
                + ((ElectionDescription) electionDescription).getOutputType().getId()
                + "\n</outputType>\n";
        created += name + votingDecLine + code + inputType + outputType;
        return created;
    }

    @Override
    public Object createFromSaveString(String s) throws ArrayIndexOutOfBoundsException {
        ElectionTemplateHandler electionTemplateHandler = new ElectionTemplateHandler();

        String split[] = s.split("\n</electionName>\n");
        String name = split[0].replace("<electionName>\n", "");
        split = split[1].split("\n</votingDecLine>\n");
        int votingDecLine = Integer.parseInt(split[0].replace("<votingDecLine>\n", ""));
        split = split[1].split("\n</code>\n");
        String code = split[0].replace("<code>\n", "");
        String [] codeArray = StringSaverLoader.createFromSaveString(code).split("\n");
        split = split[1].split("\n</inputType>\n");
        ElectionTypeContainer inputType = electionTemplateHandler.getById(
                ElectionTypeContainer.ElectionTypeIds.valueOf(split[0].replace("<inputType>\n", "")));
        split = split[1].split("\n</outputType>\n");
        ElectionTypeContainer outputType = electionTemplateHandler.getById(
                ElectionTypeContainer.ElectionTypeIds.valueOf(split[0].replace("<outputType>\n", "")));
        ElectionDescription electionDescription = new ElectionDescription(name, inputType, outputType, votingDecLine);
        electionDescription.setCode(Arrays.asList(codeArray));
        return electionDescription;
    }
}
