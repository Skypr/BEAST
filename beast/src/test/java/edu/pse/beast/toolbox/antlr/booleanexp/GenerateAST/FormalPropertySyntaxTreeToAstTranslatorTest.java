package edu.pse.beast.toolbox.antlr.booleanexp.GenerateAST;

import edu.pse.beast.booleanexpeditor.booleanExpCodeArea.BooleanExpANTLRHandler;
import edu.pse.beast.celectiondescriptioneditor.ElectionTemplates.ElectionTemplateHandler;
import edu.pse.beast.datatypes.booleanExpAST.BooleanExpListNode;
import edu.pse.beast.datatypes.booleanExpAST.BooleanValuedNodes.ComparisonNode;
import edu.pse.beast.datatypes.booleanExpAST.BooleanValuedNodes.IntegerComparisonNode;
import edu.pse.beast.datatypes.booleanExpAST.ComparisonSymbol;
import edu.pse.beast.datatypes.booleanExpAST.otherValuedNodes.AtPosExp;
import edu.pse.beast.datatypes.booleanExpAST.otherValuedNodes.integerValuedNodes.BinaryIntegerValuedNode;
import edu.pse.beast.datatypes.booleanExpAST.otherValuedNodes.integerValuedNodes.IntegerNode;
import edu.pse.beast.datatypes.internal.InternalTypeContainer;
import edu.pse.beast.datatypes.internal.InternalTypeRep;
import edu.pse.beast.datatypes.propertydescription.SymbolicVariable;
import edu.pse.beast.toolbox.Tuple;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by holger on 08.03.17.
 */
public class FormalPropertySyntaxTreeToAstTranslatorTest {
    private FormalPropertySyntaxTreeToAstTranslator translator = new FormalPropertySyntaxTreeToAstTranslator();
    private BooleanExpANTLRHandler handler;
    private JTextPane pane = new JTextPane();

    @Before
    public void setUp() {
        handler = new BooleanExpANTLRHandler(pane.getStyledDocument());
    }

    @Test
    public void parseSimpleAddition() {
        BooleanExpListNode created = translate("1 == 2 - 1;", Arrays.asList());
        BooleanExpListNode expected = new BooleanExpListNode();
        IntegerNode lhsIntNode = new IntegerNode(1);

        IntegerNode rhs2 = new IntegerNode(2);
        IntegerNode rhs1 = new IntegerNode(1);
        BinaryIntegerValuedNode minus = new BinaryIntegerValuedNode(rhs2, rhs1, "-");

        IntegerComparisonNode comparisonNode =
                new IntegerComparisonNode(lhsIntNode, minus, new ComparisonSymbol("=="));

        expected.addNode(comparisonNode, 0);
        AstTesterHelper.areTheSame(created, expected);
    }

    @Test
    public void parseVoterAtPos() {
        BooleanExpListNode listNode  = translate(
                "v == VOTER_AT_POS(1)",
                new SymbolicVariable("v", new InternalTypeContainer(InternalTypeRep.VOTER)));
        ComparisonNode firstChild = (ComparisonNode) listNode.getBooleanExpressions().get(0).get(0);
        AtPosExp voterbypos = (AtPosExp) firstChild.getRHSBooleanExpNode();
    }

    @Test
    public void parseComplicatedExpression() {
        setPaneTest("1 == V / 2 * (3 + VOTE_SUM_FOR_CANDIDATE1(c)) - C - S;");
        BooleanExpListNode listNode = translator.generateFromSyntaxTree(
                handler.getParseTree(),
                getStandardInput(),
                getStandardOutput(),
                getNewScope("c", InternalTypeRep.CANDIDATE)
        );
        ComparisonNode firstChild = (ComparisonNode) listNode.getBooleanExpressions().get(0).get(0);
    }

    private BooleanExpScope getNewScope(String id, InternalTypeRep internalType) {
        BooleanExpScope scope= new BooleanExpScope ();
        scope.addTypeForId(id, new InternalTypeContainer(internalType));
        return scope;
    }


    private static InternalTypeContainer getStandardInput() {
        return new ElectionTemplateHandler().getStandardInput().getType();
    }

    private static InternalTypeContainer getStandardOutput() {
        return new ElectionTemplateHandler().getStandardResult().getType();
    }

    private void setPaneTest(String s) {
        pane.setText(s);
    }

    public static BooleanExpListNode translate(String s, SymbolicVariable c) {
        JTextPane pane = new JTextPane();
        pane.setText(s);
        BooleanExpANTLRHandler booleanExpANTLRHandler = new BooleanExpANTLRHandler(pane.getStyledDocument());
        FormalPropertySyntaxTreeToAstTranslator translator = new FormalPropertySyntaxTreeToAstTranslator();
        BooleanExpScope scope;
        scope = new BooleanExpScope();
        scope.addTypeForId(c.getId(), c.getInternalTypeContainer());

        return translator.generateFromSyntaxTree(booleanExpANTLRHandler.getParseTree(),
                getStandardInput(),
                getStandardOutput(),
                scope);
    }

    public static BooleanExpListNode translate(String s, List<Tuple<String, InternalTypeRep>> nameAndTypes) {
        JTextPane pane = new JTextPane();
        pane.setText(s);
        BooleanExpANTLRHandler booleanExpANTLRHandler = new BooleanExpANTLRHandler(pane.getStyledDocument());
        FormalPropertySyntaxTreeToAstTranslator translator = new FormalPropertySyntaxTreeToAstTranslator();
        BooleanExpScope scope;
        scope = new BooleanExpScope();
        nameAndTypes.forEach(t -> scope.addTypeForId(t.x, new InternalTypeContainer(t.y)));
        return translator.generateFromSyntaxTree(booleanExpANTLRHandler.getParseTree(),
                getStandardInput(),
                getStandardOutput(),
                scope);
    }

    
}