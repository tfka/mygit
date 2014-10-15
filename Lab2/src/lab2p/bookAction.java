package lab2p;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import lab2p.sqlfind;
import lab2p.book;
import java.util.ArrayList;
import java.util.List;
public class bookAction extends ActionSupport
{
	private String name;
	public String aut;
	private sqlfind sf=new sqlfind();
	public String getName()
	{
		return this.name;
	}
	public void setName (String name)
	{
		this.name=name;
		aut=name;
	}
	public String execute() throws Exception
	{
		String id=sf.getauthorid(name);
		//System.out.print(id);
		ActionContext.getContext().put("booklist", sf.select(id));
		//ActionContext.getContext().put("booklist2", sf.select1(author));
		return SUCCESS;
	}
}
