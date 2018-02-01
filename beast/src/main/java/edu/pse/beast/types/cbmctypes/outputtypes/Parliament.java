package edu.pse.beast.types.cbmctypes.outputtypes;

import java.util.List;

import edu.pse.beast.propertychecker.CBMCResultWrapperLong;
import edu.pse.beast.propertychecker.CBMCResultWrapperSingleArray;
import edu.pse.beast.toolbox.CodeArrayListBeautifier;
import edu.pse.beast.types.cbmctypes.CBMCOutputType;

public class Parliament extends CBMCOutputType {

	@Override
	public String getOutputString() {
		return "struct result";
	}

	@Override
	public String getOutputIDinFile() {
		return "CAND_PER_SEAT";
	}

	@Override
	public boolean isOutputOneCandidate() {
		return false;
	}

	@Override
	public String[] extractResult(List<String> toExtract) {
		return super.helper.readOneDimVarLong("new_result", toExtract).get(0).getArray();
	}

	@Override
	public List<CBMCResultWrapperSingleArray> readSeatList(List<String> toExtract) {
		return super.helper.readOneDimVarLong("elect", toExtract);
	}

	@Override
	public List<CBMCResultWrapperLong> readElect(List<String> toExtract) {
		return null;
	}

	@Override
	public CodeArrayListBeautifier addMarginVerifyCheck(CodeArrayListBeautifier code) {
		code.add("void verify() {");
		// code.add("int new_votes1[V], diff[V], total_diff, pos_diff;");

		code.addTab();

		code.add("int total_diff = 0;");
		code.add("struct result tmp = voting(new_votes1);");

		code.add("int *tmp_result = tmp.arr;");

		code.add("int new_result1[S];"); // create the array where the
		// new seats will get saved

		code.add("for (int i = 0; i < S; i++) {"); // iterate over the
		code.addTab();
		// seat array, and
		// fill it
		// we do this, so our cbmc parser can read out the value of the
		// array
		code.add("new_result1[i] = tmp_result[i];");
		code.deleteTab();
		code.add("}"); // close the for loop

		code.add("for (int i = 0; i < S; i++) {"); // iterate over all
		code.addTab();
		// candidates /
		// seats
		code.add("assert(new_result1[i] == ORIG_RESULT[i]);");
		code.deleteTab();
		code.add("}"); // end of the for loop

		code.deleteTab();

		code.add("}"); // end of the function

		return code;
	}

	@Override
	public CodeArrayListBeautifier addVotesArrayAndInit(CodeArrayListBeautifier code, int voteNumber) {
		String temp = "struct result tmp" + voteNumber + " = voting(votes" + voteNumber + ");";
		code.add(temp);
		String tempElect = "unsigned int *tempElect" + voteNumber + " = tmp" + voteNumber + ".arr;";
		code.add(tempElect);
		String electX = "unsigned int elect" + voteNumber + "[S];";
		code.add(electX);
		String forLoop = "for (int electLoop = 0; electLoop < S; electLoop++) {";
		code.add(forLoop);
		code.addTab();
		code.add("elect" + voteNumber + "[electLoop] = tempElect" + voteNumber + "[electLoop];");
		code.deleteTab();
		code.add("}");

		return code;
	}

	@Override
	public String getCArrayType() {
		return "[][]";
	}

	@Override
	public CodeArrayListBeautifier addMarginMainTest(CodeArrayListBeautifier code, int voteNumber) {
		code.add("int main() {");
		code.addTab();

		String temp = "struct result tmp" + voteNumber + " = voting(ORIG_VOTES);";
		code.add(temp);
		String tempElect = "unsigned int *tempElect" + voteNumber + " = tmp" + voteNumber + ".arr;";
		code.add(tempElect);
		String electX = "unsigned int elect" + voteNumber + "[S];";
		code.add(electX);
		String forLoop = "for (int electLoop = 0; electLoop < S; electLoop++) {";
		code.add(forLoop);
		code.addTab();
		code.add("elect" + voteNumber + "[electLoop] = tempElect" + voteNumber + "[electLoop];");
		code.deleteTab();
		code.add("}");

		// add an assertion that always fails, so we can extract the trace
		code.add("assert(0);");

		code.deleteTab();

		code.add("}");

		return code;
	}

	@Override
	public List<String> getCodeToRunMargin(List<String> origResult, List<String> lastResult) {

		List<CBMCResultWrapperSingleArray> tmpResultOneDim = super.helper.readOneDimVarLong("elect",
				lastResult);

		origResult = tmpResultOneDim.get(0).getList();
		
		return origResult;
	}

	@Override
	public List<String> getNewResult(List<String> lastFailedRun) {
		List<CBMCResultWrapperSingleArray> tmpResultOneDim = super.helper.readOneDimVarLong("new_result", lastFailedRun);

		return tmpResultOneDim.get(0).getList();
	}
}
