package edu.pse.beast.types.cbmctypes.inputplugins;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.pse.beast.datatypes.electiondescription.ElectionTypeContainer;
import edu.pse.beast.electionSimulator.Model.RowOfValues;
import edu.pse.beast.propertychecker.CBMCResultWrapperMultiArray;
import edu.pse.beast.propertychecker.CBMCResultWrapperSingleArray;
import edu.pse.beast.toolbox.CodeArrayListBeautifier;
import edu.pse.beast.types.cbmctypes.CBMCInputType;

public class WeightedApproval extends CBMCInputType {

	@Override
	public String getInputString() {
		return "[V][C]";
	}

	@Override
	public String getInputIDinFile() {
		return "WEIGHTED_APPROVAL";
	}

	@Override
	public String getMinimalValue(ElectionTypeContainer container) {
		return "" + container.getLowerBound();
	}

	@Override
	public String getMaximalValue(ElectionTypeContainer container) {
		return "" + container.getUpperBound();
	}

	@Override
	public boolean isVotingForOneCandidate() {
		return false;
	}

	@Override
	public List<String> addVerifyMethod(List<String> code, boolean multiOut) {
		code.add("void verify() {");
		code.add("int total_diff = 0;");

		code.add("int new_votes1[V][C];");

		code.add("for (int i = 0; i < V; i++) {"); // go over all voters
		code.add("for (int j = 0; i < C; i++) {"); // go over all candidates
		code.add("int changed = nondet_int();"); // determine, if we want to
													// changed votes for
													// this
													// voter - candidate
													// pair
		code.add("assume(0 <= changed);");
		code.add("assume(changed <= 1);");
		code.add("if(changed) {");
		code.add("total_diff++;"); // if we changed the vote, we keep track
									// of it
		code.add("new_votes1[i][j] = nondet_int();");
		code.add("assume(new_votes1[i][j] != ORIG_VOTES[i][j]);"); // set
																	// the
																	// vote
																	// to
		// (0-100), but
		// different
		// from
		// original
		code.add("assume(0 <= new_votes1[i][j]);");
		code.add("assume(new_votes1[i][j] <= 100);");
		code.add("} else {");
		code.add("new_votes1[i][j] = ORIG_VOTES[i][j];");
		code.add("}");
		code.add("}");
		code.add("}"); // end of the double for loop
		code.add("assume(total_diff <= MARGIN);"); // no more changes than
													// margin allows
		if (multiOut) {
			code.add("int *tmp_result = voting(new_votes1);");

			code.add("int new_result1[S];"); // create the array where the
												// new seats will get saved

			code.add("for (int i = 0; i < S; i++) {"); // iterate over the
														// seat array, and
														// fill it
			// we do this, so our cbmc parser can read out the value of the
			// array
			code.add("new_result1[i] = tmp_result[i];");
			code.add("}"); // close the for loop

			code.add("for (int i = 0; i < S; i++) {"); // iterate over all
														// candidates /
														// seats
			code.add("assert(new_result1[i] == ORIG_RESULT[i]);");
			code.add("}"); // end of the for loop
		} else {
			code.add("int new_result1 = voting(new_votes1);");
			code.add("assert(new_result1 == ORIG_RESULT);");
		}
		code.add("}"); // end of the function
		return code;
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
	public String vetValue(String newValue, ElectionTypeContainer container, RowOfValues rowOfValues) {
		int number;

		try {
			number = Integer.parseInt(newValue);
		} catch (NumberFormatException e) {
			return "0";
		}

		if (number < 0 || number > 100) {
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
		Long[] result = new Long[amountCandidates];
		Arrays.fill(result, 0l);

		for (int i = 0; i < amountVoters; i++) {
			String[] vote = votes[i];
			for (int j = 0; j < amountCandidates; j++) {
				result[j] += Long.parseLong(vote[j]);
			}
		}
		
		String[] toReturn = new String[amountCandidates];
		
		for (int i = 0; i < result.length; i++) {
			toReturn[i] = "" + result[i];
		}
		
		return toReturn;
	}

	@Override
	public String[] getVotePoints(String[] votes, int amountCandidates, int amountVoters) {
		return super.wrongInputTypeArray(amountCandidates, amountVoters);
	}

	@Override
	public CodeArrayListBeautifier addMarginMainCheck(CodeArrayListBeautifier code, int margin,
			List<String> origResult) {
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
		code.add("new_votes1[i][j] = nondet_int();");
		code.add("assume(new_votes1[i][j] != ORIG_VOTES[i][j]);"); // set
																	// the
																	// vote
																	// to
		// (0-100), but
		// different
		// from
		// original
		code.add("assume(0 <= new_votes1[i][j]);");
		code.add("assume(new_votes1[i][j] <= 100);");
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
		return code;
	}
	
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
		return "[][]";
	}

	@Override
	public int getDimension() {
		return 2;
	}

	@Override
	public CodeArrayListBeautifier addVotesArrayAndInit(CodeArrayListBeautifier code, int voteNumber) {
		return code;
	}

	@Override
	public CodeArrayListBeautifier getCodeForVoteSum(CodeArrayListBeautifier code, boolean unique) {
		code.add("unsigned int candSum = arr[i][candidate];");
		if (unique) {
			code.add("for(unsigned int j = 0; j < C; ++i) {");
			code.add("if(j != candidate && arr[i][j] >= candSum) candSum = 0;");
			code.add("}");
		}
		code.add("sum += candSum;");
		
		return code;
	}

	@Override
	public List<List<String>> getNewVotes(List<String> lastFailedRun) {
		return super.helper.readTwoDimVarLong("new_votes", lastFailedRun).get(0).getList();
	}
}
