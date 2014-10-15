package lab2p;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import lab2p.sqlfind;
import lab2p.book;
import java.util.ArrayList;
import java.util.List;
public class bookiAction extends ActionSupport
{
	private String author;
	private String h;
	private int i;
	private List<book> list2;
	private sqlfind sf=new sqlfind();
	
	public String getH()
	{
		return this.h;
	}
	public void setH(String h)
	{
		this.h=h;
	}
	public String execute() throws Exception
	{
		//System.out.print(h);
		ActionContext.getContext().put("abooklist", sf.select1(lab2p.sqlcon.author,Integer.parseInt(h)));
		
		return SUCCESS;
	}
}