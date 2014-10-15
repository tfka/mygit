package lab2p;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import lab2p.author;
public class addauthorAction extends ActionSupport
{
	public author myauthor=new author();
	private sqlfind sf=new sqlfind();
	private String authorID;
	private String name;
	private String age;
	private String country;
	public String getName()
	{
		return this.name;
	}
	public void setName(String name)
	{
		this.name =name;
		myauthor.setName(name);
	}
	public String getAge()
	{
		return this.age;
	}
	public void setAge(String age)
	{
		this.age =age;
		myauthor.setAge(age);
		
	}
	public String getCountry()
	{
		return this.country;
	}
	public void setCountry(String country)
	{
		this.country=country;
		myauthor.setCountry(country);
	}
	public String execute() throws Exception
	{
		//System.out.print(myauthor.getAge());
		sf.InsertSql1(myauthor);
		return "SUCCESS";
	}
}
