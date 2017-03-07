// Generated from FormalPropertyDescription.g4 by ANTLR 4.5.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FormalPropertyDescriptionLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		Mult=10, Add=11, Vote=12, Elect=13, Votesum=14, ClosedBracket=15, OpenBracket=16, 
		Quantor=17, ComparisonSymbol=18, BinaryRelationSymbol=19, Integer=20, 
		Identifier=21, Whitespace=22, Newline=23, BlockComment=24, LineComment=25;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"Mult", "Add", "Vote", "Elect", "Votesum", "ClosedBracket", "OpenBracket", 
		"Quantor", "ComparisonSymbol", "BinaryRelationSymbol", "Integer", "Identifier", 
		"IdentifierNondigit", "Nondigit", "Digit", "UniversalCharacterName", "HexQuad", 
		"HexadecimalDigit", "Whitespace", "Newline", "BlockComment", "LineComment"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "':'", "'!'", "'VOTER_BY_POS'", "'CANDIDATE_BY_POS'", "'SEAT_BY_POS'", 
		"'V'", "'C'", "'S'", null, null, null, null, null, "')'", "'('"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "Mult", "Add", 
		"Vote", "Elect", "Votesum", "ClosedBracket", "OpenBracket", "Quantor", 
		"ComparisonSymbol", "BinaryRelationSymbol", "Integer", "Identifier", "Whitespace", 
		"Newline", "BlockComment", "LineComment"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public FormalPropertyDescriptionLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FormalPropertyDescription.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\33\u0173\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t"+
		"\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\5\22\u0109\n\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\5\23\u0114\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\5\24\u0121\n\24\3\25\6\25\u0124\n\25\r\25\16\25\u0125"+
		"\3\26\3\26\3\26\7\26\u012b\n\26\f\26\16\26\u012e\13\26\3\27\3\27\5\27"+
		"\u0132\n\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\5\32\u0142\n\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\35\6\35"+
		"\u014c\n\35\r\35\16\35\u014d\3\35\3\35\3\36\3\36\5\36\u0154\n\36\3\36"+
		"\5\36\u0157\n\36\3\36\3\36\3\37\3\37\3\37\3\37\7\37\u015f\n\37\f\37\16"+
		"\37\u0162\13\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \7 \u016d\n \f \16"+
		" \u0170\13 \3 \3 \3\u0160\2!\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\2/\2\61\2"+
		"\63\2\65\2\67\29\30;\31=\32?\33\3\2\n\4\2,,\61\61\4\2--//\4\2>>@@\5\2"+
		"C\\aac|\3\2\62;\5\2\62;CHch\4\2\13\13\"\"\4\2\f\f\17\17\u0182\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2"+
		"\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3"+
		"\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2"+
		"\2\2\2?\3\2\2\2\3A\3\2\2\2\5C\3\2\2\2\7E\3\2\2\2\tG\3\2\2\2\13T\3\2\2"+
		"\2\re\3\2\2\2\17q\3\2\2\2\21s\3\2\2\2\23u\3\2\2\2\25w\3\2\2\2\27y\3\2"+
		"\2\2\31{\3\2\2\2\33\u0083\3\2\2\2\35\u008b\3\2\2\2\37\u00a4\3\2\2\2!\u00a6"+
		"\3\2\2\2#\u0108\3\2\2\2%\u0113\3\2\2\2\'\u0120\3\2\2\2)\u0123\3\2\2\2"+
		"+\u0127\3\2\2\2-\u0131\3\2\2\2/\u0133\3\2\2\2\61\u0135\3\2\2\2\63\u0141"+
		"\3\2\2\2\65\u0143\3\2\2\2\67\u0148\3\2\2\29\u014b\3\2\2\2;\u0156\3\2\2"+
		"\2=\u015a\3\2\2\2?\u0168\3\2\2\2AB\7=\2\2B\4\3\2\2\2CD\7<\2\2D\6\3\2\2"+
		"\2EF\7#\2\2F\b\3\2\2\2GH\7X\2\2HI\7Q\2\2IJ\7V\2\2JK\7G\2\2KL\7T\2\2LM"+
		"\7a\2\2MN\7D\2\2NO\7[\2\2OP\7a\2\2PQ\7R\2\2QR\7Q\2\2RS\7U\2\2S\n\3\2\2"+
		"\2TU\7E\2\2UV\7C\2\2VW\7P\2\2WX\7F\2\2XY\7K\2\2YZ\7F\2\2Z[\7C\2\2[\\\7"+
		"V\2\2\\]\7G\2\2]^\7a\2\2^_\7D\2\2_`\7[\2\2`a\7a\2\2ab\7R\2\2bc\7Q\2\2"+
		"cd\7U\2\2d\f\3\2\2\2ef\7U\2\2fg\7G\2\2gh\7C\2\2hi\7V\2\2ij\7a\2\2jk\7"+
		"D\2\2kl\7[\2\2lm\7a\2\2mn\7R\2\2no\7Q\2\2op\7U\2\2p\16\3\2\2\2qr\7X\2"+
		"\2r\20\3\2\2\2st\7E\2\2t\22\3\2\2\2uv\7U\2\2v\24\3\2\2\2wx\t\2\2\2x\26"+
		"\3\2\2\2yz\t\3\2\2z\30\3\2\2\2{|\7X\2\2|}\7Q\2\2}~\7V\2\2~\177\7G\2\2"+
		"\177\u0080\7U\2\2\u0080\u0081\3\2\2\2\u0081\u0082\5)\25\2\u0082\32\3\2"+
		"\2\2\u0083\u0084\7G\2\2\u0084\u0085\7N\2\2\u0085\u0086\7G\2\2\u0086\u0087"+
		"\7E\2\2\u0087\u0088\7V\2\2\u0088\u0089\3\2\2\2\u0089\u008a\5)\25\2\u008a"+
		"\34\3\2\2\2\u008b\u008c\7X\2\2\u008c\u008d\7Q\2\2\u008d\u008e\7V\2\2\u008e"+
		"\u008f\7G\2\2\u008f\u0090\7a\2\2\u0090\u0091\7U\2\2\u0091\u0092\7W\2\2"+
		"\u0092\u0093\7O\2\2\u0093\u0094\7a\2\2\u0094\u0095\7H\2\2\u0095\u0096"+
		"\7Q\2\2\u0096\u0097\7T\2\2\u0097\u0098\7a\2\2\u0098\u0099\7E\2\2\u0099"+
		"\u009a\7C\2\2\u009a\u009b\7P\2\2\u009b\u009c\7F\2\2\u009c\u009d\7K\2\2"+
		"\u009d\u009e\7F\2\2\u009e\u009f\7C\2\2\u009f\u00a0\7V\2\2\u00a0\u00a1"+
		"\7G\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\5)\25\2\u00a3\36\3\2\2\2\u00a4"+
		"\u00a5\7+\2\2\u00a5 \3\2\2\2\u00a6\u00a7\7*\2\2\u00a7\"\3\2\2\2\u00a8"+
		"\u00a9\7H\2\2\u00a9\u00aa\7Q\2\2\u00aa\u00ab\7T\2\2\u00ab\u00ac\7a\2\2"+
		"\u00ac\u00ad\7C\2\2\u00ad\u00ae\7N\2\2\u00ae\u00af\7N\2\2\u00af\u00b0"+
		"\7a\2\2\u00b0\u00b1\7X\2\2\u00b1\u00b2\7Q\2\2\u00b2\u00b3\7V\2\2\u00b3"+
		"\u00b4\7G\2\2\u00b4\u00b5\7T\2\2\u00b5\u0109\7U\2\2\u00b6\u00b7\7H\2\2"+
		"\u00b7\u00b8\7Q\2\2\u00b8\u00b9\7T\2\2\u00b9\u00ba\7a\2\2\u00ba\u00bb"+
		"\7C\2\2\u00bb\u00bc\7N\2\2\u00bc\u00bd\7N\2\2\u00bd\u00be\7a\2\2\u00be"+
		"\u00bf\7E\2\2\u00bf\u00c0\7C\2\2\u00c0\u00c1\7P\2\2\u00c1\u00c2\7F\2\2"+
		"\u00c2\u00c3\7K\2\2\u00c3\u00c4\7F\2\2\u00c4\u00c5\7C\2\2\u00c5\u00c6"+
		"\7V\2\2\u00c6\u00c7\7G\2\2\u00c7\u0109\7U\2\2\u00c8\u00c9\7H\2\2\u00c9"+
		"\u00ca\7Q\2\2\u00ca\u00cb\7T\2\2\u00cb\u00cc\7a\2\2\u00cc\u00cd\7C\2\2"+
		"\u00cd\u00ce\7N\2\2\u00ce\u00cf\7N\2\2\u00cf\u00d0\7a\2\2\u00d0\u00d1"+
		"\7U\2\2\u00d1\u00d2\7G\2\2\u00d2\u00d3\7C\2\2\u00d3\u00d4\7V\2\2\u00d4"+
		"\u0109\7U\2\2\u00d5\u00d6\7G\2\2\u00d6\u00d7\7Z\2\2\u00d7\u00d8\7K\2\2"+
		"\u00d8\u00d9\7U\2\2\u00d9\u00da\7V\2\2\u00da\u00db\7U\2\2\u00db\u00dc"+
		"\7a\2\2\u00dc\u00dd\7Q\2\2\u00dd\u00de\7P\2\2\u00de\u00df\7G\2\2\u00df"+
		"\u00e0\7a\2\2\u00e0\u00e1\7X\2\2\u00e1\u00e2\7Q\2\2\u00e2\u00e3\7V\2\2"+
		"\u00e3\u00e4\7G\2\2\u00e4\u0109\7T\2\2\u00e5\u00e6\7G\2\2\u00e6\u00e7"+
		"\7Z\2\2\u00e7\u00e8\7K\2\2\u00e8\u00e9\7U\2\2\u00e9\u00ea\7V\2\2\u00ea"+
		"\u00eb\7U\2\2\u00eb\u00ec\7a\2\2\u00ec\u00ed\7Q\2\2\u00ed\u00ee\7P\2\2"+
		"\u00ee\u00ef\7G\2\2\u00ef\u00f0\7a\2\2\u00f0\u00f1\7E\2\2\u00f1\u00f2"+
		"\7C\2\2\u00f2\u00f3\7P\2\2\u00f3\u00f4\7F\2\2\u00f4\u00f5\7K\2\2\u00f5"+
		"\u00f6\7F\2\2\u00f6\u00f7\7C\2\2\u00f7\u00f8\7V\2\2\u00f8\u0109\7G\2\2"+
		"\u00f9\u00fa\7G\2\2\u00fa\u00fb\7Z\2\2\u00fb\u00fc\7K\2\2\u00fc\u00fd"+
		"\7U\2\2\u00fd\u00fe\7V\2\2\u00fe\u00ff\7U\2\2\u00ff\u0100\7a\2\2\u0100"+
		"\u0101\7Q\2\2\u0101\u0102\7P\2\2\u0102\u0103\7G\2\2\u0103\u0104\7a\2\2"+
		"\u0104\u0105\7U\2\2\u0105\u0106\7G\2\2\u0106\u0107\7C\2\2\u0107\u0109"+
		"\7V\2\2\u0108\u00a8\3\2\2\2\u0108\u00b6\3\2\2\2\u0108\u00c8\3\2\2\2\u0108"+
		"\u00d5\3\2\2\2\u0108\u00e5\3\2\2\2\u0108\u00f9\3\2\2\2\u0109$\3\2\2\2"+
		"\u010a\u010b\7?\2\2\u010b\u0114\7?\2\2\u010c\u010d\7#\2\2\u010d\u0114"+
		"\7?\2\2\u010e\u010f\7>\2\2\u010f\u0114\7?\2\2\u0110\u0111\7@\2\2\u0111"+
		"\u0114\7?\2\2\u0112\u0114\t\4\2\2\u0113\u010a\3\2\2\2\u0113\u010c\3\2"+
		"\2\2\u0113\u010e\3\2\2\2\u0113\u0110\3\2\2\2\u0113\u0112\3\2\2\2\u0114"+
		"&\3\2\2\2\u0115\u0116\7(\2\2\u0116\u0121\7(\2\2\u0117\u0118\7~\2\2\u0118"+
		"\u0121\7~\2\2\u0119\u011a\7?\2\2\u011a\u011b\7?\2\2\u011b\u0121\7@\2\2"+
		"\u011c\u011d\7>\2\2\u011d\u011e\7?\2\2\u011e\u011f\7?\2\2\u011f\u0121"+
		"\7@\2\2\u0120\u0115\3\2\2\2\u0120\u0117\3\2\2\2\u0120\u0119\3\2\2\2\u0120"+
		"\u011c\3\2\2\2\u0121(\3\2\2\2\u0122\u0124\5\61\31\2\u0123\u0122\3\2\2"+
		"\2\u0124\u0125\3\2\2\2\u0125\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126*"+
		"\3\2\2\2\u0127\u012c\5-\27\2\u0128\u012b\5-\27\2\u0129\u012b\5\61\31\2"+
		"\u012a\u0128\3\2\2\2\u012a\u0129\3\2\2\2\u012b\u012e\3\2\2\2\u012c\u012a"+
		"\3\2\2\2\u012c\u012d\3\2\2\2\u012d,\3\2\2\2\u012e\u012c\3\2\2\2\u012f"+
		"\u0132\5/\30\2\u0130\u0132\5\63\32\2\u0131\u012f\3\2\2\2\u0131\u0130\3"+
		"\2\2\2\u0132.\3\2\2\2\u0133\u0134\t\5\2\2\u0134\60\3\2\2\2\u0135\u0136"+
		"\t\6\2\2\u0136\62\3\2\2\2\u0137\u0138\7^\2\2\u0138\u0139\7w\2\2\u0139"+
		"\u013a\3\2\2\2\u013a\u0142\5\65\33\2\u013b\u013c\7^\2\2\u013c\u013d\7"+
		"W\2\2\u013d\u013e\3\2\2\2\u013e\u013f\5\65\33\2\u013f\u0140\5\65\33\2"+
		"\u0140\u0142\3\2\2\2\u0141\u0137\3\2\2\2\u0141\u013b\3\2\2\2\u0142\64"+
		"\3\2\2\2\u0143\u0144\5\67\34\2\u0144\u0145\5\67\34\2\u0145\u0146\5\67"+
		"\34\2\u0146\u0147\5\67\34\2\u0147\66\3\2\2\2\u0148\u0149\t\7\2\2\u0149"+
		"8\3\2\2\2\u014a\u014c\t\b\2\2\u014b\u014a\3\2\2\2\u014c\u014d\3\2\2\2"+
		"\u014d\u014b\3\2\2\2\u014d\u014e\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u0150"+
		"\b\35\2\2\u0150:\3\2\2\2\u0151\u0153\7\17\2\2\u0152\u0154\7\f\2\2\u0153"+
		"\u0152\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u0157\3\2\2\2\u0155\u0157\7\f"+
		"\2\2\u0156\u0151\3\2\2\2\u0156\u0155\3\2\2\2\u0157\u0158\3\2\2\2\u0158"+
		"\u0159\b\36\2\2\u0159<\3\2\2\2\u015a\u015b\7\61\2\2\u015b\u015c\7,\2\2"+
		"\u015c\u0160\3\2\2\2\u015d\u015f\13\2\2\2\u015e\u015d\3\2\2\2\u015f\u0162"+
		"\3\2\2\2\u0160\u0161\3\2\2\2\u0160\u015e\3\2\2\2\u0161\u0163\3\2\2\2\u0162"+
		"\u0160\3\2\2\2\u0163\u0164\7,\2\2\u0164\u0165\7\61\2\2\u0165\u0166\3\2"+
		"\2\2\u0166\u0167\b\37\2\2\u0167>\3\2\2\2\u0168\u0169\7\61\2\2\u0169\u016a"+
		"\7\61\2\2\u016a\u016e\3\2\2\2\u016b\u016d\n\t\2\2\u016c\u016b\3\2\2\2"+
		"\u016d\u0170\3\2\2\2\u016e\u016c\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u0171"+
		"\3\2\2\2\u0170\u016e\3\2\2\2\u0171\u0172\b \2\2\u0172@\3\2\2\2\20\2\u0108"+
		"\u0113\u0120\u0125\u012a\u012c\u0131\u0141\u014d\u0153\u0156\u0160\u016e"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}