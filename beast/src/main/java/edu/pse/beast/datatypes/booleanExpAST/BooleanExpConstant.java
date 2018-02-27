package edu.pse.beast.datatypes.booleanExpAST;

import edu.pse.beast.toolbox.UnifiedNameContainer;

public class BooleanExpConstant {
    public static String getConstForVoterAmt() {
        return UnifiedNameContainer.getVoter();
    }
    
    public static String getConstForCandidateAmt() {
        return UnifiedNameContainer.getCandidate();
    }
    
    public static String getConstForSeatAmt() {
        return UnifiedNameContainer.getSeats();
    }
}
