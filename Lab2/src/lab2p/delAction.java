package lab2p;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class delAction extends ActionSupport
{
	private sqlfind sf=new sqlfind();
	public String execute() throws Exception
	{
		String del="delete from Book where title="+"'"+lab2p.sqlcon.title+"'";
		
		sf.DeletSql(del);
		
		return SUCCESS;
	}
}
