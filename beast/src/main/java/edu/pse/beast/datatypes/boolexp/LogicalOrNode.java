package edu.pse.beast.datatypes.boolexp;

/**
 * 
 * @author Lukas
 *
 */
public class LogicalOrNode extends BinaryRelationshipNode {

    /**
     * 
     * @param lhsExpNode the lhs node
     * @param rhsExpNode the rhs node
     */
    public LogicalOrNode(BinaryRelationshipNode lhsExpNode, BinaryRelationshipNode rhsExpNode) {
        super(lhsExpNode, rhsExpNode);
    }

}
