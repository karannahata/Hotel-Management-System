package Admin;

public class SwitchRes {

	static final float RATIOWIDTH = (float) 0.711458333;
	static final float RATIOHIEGHT = (float) 0.71111111111;
	
	public int getLowWidth(int res)
	{
		float ans=(float) 1.0;
		ans =  res * RATIOWIDTH;		
		return (int)ans;
	}
	
	public int getLowHieght(int res)
	{
		float ans = (float) 1.0;
		ans = res * RATIOHIEGHT;
		return (int)ans;
	}
	
}
