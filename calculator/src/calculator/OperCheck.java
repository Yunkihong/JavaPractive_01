package calculator;

public abstract class OperCheck implements Calc{
	public String[] getOpers(String soosic) {
		String[] calcNums=null;
		return calcNums=soosic.split("//+|//-");
		}
}
