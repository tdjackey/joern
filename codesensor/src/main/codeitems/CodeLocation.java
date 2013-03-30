package main.codeitems;
import org.antlr.v4.runtime.ParserRuleContext;

public class CodeLocation {

	final private int NOT_SET = -1;
	
	int startLine = NOT_SET;
	int startPos = NOT_SET;
	int startIndex = NOT_SET;
	int stopIndex = NOT_SET;
	
	public CodeLocation(){}
	
	public CodeLocation(ParserRuleContext ctx)
	{
		initializeFromContext(ctx);
	}

	private void initializeFromContext(ParserRuleContext ctx)
	{
		startLine = ctx.start.getLine();
		startPos = ctx.start.getCharPositionInLine();
		startIndex = ctx.start.getStartIndex();
		if(ctx.stop != null)
			stopIndex = ctx.stop.getStopIndex();
		else
			stopIndex = NOT_SET;
	}
	
	@Override
	public String toString()
	{
		return String.format( "%d:%d:%d:%d", startLine, startPos, startIndex, stopIndex); 
	}
	
}
