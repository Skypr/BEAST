package edu.pse.beast.types.cbmctypes.inputplugins;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import edu.pse.beast.datatypes.electiondescription.ElectionTypeContainer;
import edu.pse.beast.electionSimulator.ElectionSimulation;
import edu.pse.beast.electionSimulator.Model.RowOfValues;
import edu.pse.beast.propertychecker.CBMCResultWrapperMultiArray;
import edu.pse.beast.propertychecker.CBMCResultWrapperSingleArray;
import edu.pse.beast.toolbox.CodeArrayListBeautifier;
import edu.pse.beast.types.InternalTypeContainer;
import edu.pse.beast.types.InternalTypeRep;
import edu.pse.beast.types.OutputType;
import edu.pse.beast.types.cbmctypes.CBMCInputType;

public class Approval extends CBMCInputType {

	@Override
	public String getInputString() {
		return "[V][C]";
	}

	@Override
	public String getInputIDinFile() {
		return "APPROVAL";
	}

	@Override
	public String getMinimalValue(ElectionTypeContainer container) {
		return "0";
	}

	@Override
	public String getMaximalValue(ElectionTypeContainer container) {
		return "2";
	}

	@Override
	public boolean isVotingForOneCandidate() {
		return false;
	}

	@Override
	public void addVerifyMethod(CodeArrayListBeautifier code, OutputType outType) {
		code.add("void verify() {");
		code.add("int total_diff = 0;");

		code.add("int new_votes1[V][C];");

		code.add("for (int i = 0; i < V; i++) {"); // go over all voters
		code.addTab();
		code.add("for (int j = 0; i < C; i++) {"); // go over all candidates
		code.addTab();
		code.add("int changed = nondet_int();"); // determine, if we want to
													// changed votes for
													// this
													// voter - candidate
													// pair
		code.add("assume(0 <= changed);");
		code.add("assume(changed <= 1);");
		code.add("if(changed) {");
		code.addTab();
		code.add("total_diff++;"); // if we changed the vote, we keep track
									// of it
		code.add("new_votes1[i][j] = !ORIG_VOTES[i][j];"); // flip the vote
															// (0 -> 1 |
		// 1 -> 0)
		code.deleteTab();
		code.add("} else {");
		code.addTab();
		code.add("new_votes1[i][j] = ORIG_VOTES[i][j];");
		code.deleteTab();
		code.add("}");
		code.deleteTab();
		code.add("}");
		code.deleteTab();
		code.add("}"); // end of the double for loop
		code.add("assume(total_diff <= MARGIN);"); // no more changes than
													// margin allows

		outType.addVerifyOutput(code);

		code.add("}"); // end of the function
	}

	@Override
	public boolean isTwoDim() {
		return true;
	}

	@Override
	public CBMCResultWrapperMultiArray extractVotesWrappedMulti(List<String> result, int numberCandidates) {
		return super.helper.readTwoDimVarLong("new_votes", result).get(0);
	}

	@Override
	public String vetValue(String newValue, ElectionTypeContainer container, RowOfValues row) {

		int number;

		try {
			number = Integer.parseInt(newValue);
		} catch (NumberFormatException e) {
			return "0";
		}

		if (number != 0 && number != 1) {
			newValue = "0";
		}
		return newValue;
	}

	@Override
	public List<CBMCResultWrapperMultiArray> readVoteList(List<String> toExtract) {
		return super.helper.readTwoDimVarLong("votes", toExtract);
	}

	@Override
	public List<CBMCResultWrapperSingleArray> readSingleVoteList(List<String> toExtract) {
		return null;
	}

	@Override
	public String[] getVotePoints(String[][] votes, int amountCandidates, int amountVoters) {
		String[] result = new String[amountCandidates];
		Arrays.fill(result, 0l);
		return result;
	}

	@Override
	public String[] getVotePoints(String[] votes, int amountCandidates, int amountVoters) {
		return super.wrongInputTypeArray(amountCandidates, amountVoters);
	}

	// @Override
	// public void addMarginMainCheck(CodeArrayListBeautifier code, int margin,
	// List<String> origResult) {
	// code.add("int new_votes1[V][C];");
	//
	// code.add("for (int i = 0; i < V; i++) {"); // go over all voters
	// code.addTab();
	// code.add("for (int j = 0; i < C; i++) {"); // go over all candidates
	// code.addTab();
	// code.add("int changed = nondet_int();"); // determine, if we want to
	// // changed votes for
	// // this
	// // voter - candidate
	// // pair
	// code.add("assume(0 <= changed);");
	// code.add("assume(changed <= 1);");
	// code.add("if(changed) {");
	// code.addTab();
	// code.add("total_diff++;"); // if we changed the vote, we keep track
	// // of it
	// code.add("new_votes1[i][j] = !ORIG_VOTES[i][j];"); // flip the vote
	// // (0 -> 1 |
	// // 1 -> 0)
	// code.deleteTab();
	// code.add("} else {");
	// code.addTab();
	// code.add("new_votes1[i][j] = ORIG_VOTES[i][j];");
	// code.deleteTab();
	// code.add("}");
	// code.deleteTab();
	// code.add("}");
	// code.deleteTab();
	// code.add("}"); // end of the double for loop
	// code.add("assume(total_diff <= MARGIN);"); // no more changes than
	// // margin allows
	// }

	@Override
	public List<String> getVotingResultCode(String[][] votingData) {

		List<String> toReturn = new ArrayList<String>();

		toReturn.add("int ORIG_VOTES[" + votingData.length + "][" + votingData[0].length + "] = {");

		for (int i = 0; i < votingData.length; i++) {
			String tmp = "";
			for (int j = 0; j < votingData[i].length; j++) {
				if (j < (votingData[i].length - 1)) {
					tmp = tmp + votingData[i][j] + ",";
				} else {
					tmp = tmp + votingData[i][j];
				}
			}

			tmp = "{" + tmp + "}";
			if (i < votingData.length - 1) {
				toReturn.add(tmp + ",");
			} else {
				toReturn.add(tmp); // the last entry doesn't need a
									// trailing comma
			}
		}

		toReturn.add("};"); // close the array declaration)

		return toReturn;
	}

	@Override
	public String getArrayType() {
		return "[V][C]";
	}

	@Override
	public int getDimension() {
		return 2;
	}

	@Override
	public void addExtraCodeAtEndOfCodeInit(CodeArrayListBeautifier code, int voteNumber) {

	}

	@Override
	public void addCodeForVoteSum(CodeArrayListBeautifier code, boolean unique) {
		code.add("unsigned int candSum = arr[i][candidate];");
		if (unique) {
			code.add("for(unsigned int j = 0; j < C; ++i) {");
			code.add("if(j != candidate && arr[i][j] >= candSum) candSum = 0;");
			code.add("}");
		}
		code.add("sum += candSum;");
	}

	@Override
	public List<List<String>> getNewVotes(List<String> lastFailedRun) {
		return super.helper.readTwoDimVarLong("new_votes", lastFailedRun).get(0).getList();
	}

	@Override
	public InternalTypeContainer getInternalTypeContainer() {
		return new InternalTypeContainer(new InternalTypeContainer(new InternalTypeContainer(InternalTypeRep.INTEGER),
				InternalTypeRep.CANDIDATE), InternalTypeRep.VOTER);
	}

	@Override
	public int vetAmountCandidates(int amountCandidates) {
		if (amountCandidates < 1) {
			return 1;
		} else {
			return amountCandidates;
		}
	}

	@Override
	public int vetAmountVoters(int amountVoters) {
		if (amountVoters < 1) {
			return 1;
		} else {
			return amountVoters;
		}
	}

	@Override
	public int vetAmountSeats(int amountSeats) {
		if (amountSeats < 1) {
			return 1;
		} else {
			return amountSeats;
		}
	}

	@Override
	public int getNumVotingPoints(String[][] votingData) {
		return ElectionSimulation.getNumVoters();
	}
}
