package lab2p;

public class book
{
	private String isbn;
	private String authorID;//����
	private String title;
	private String publish;//������
	private String date;//��������
	private String price;
	public String getIsbn()
	{
		return this.isbn;
	}
	public void setIsbn(String isbn)
	{
		this.isbn=isbn;
	}
	public String getAuthorID()
	{
		return this.authorID;
	}
	public void setAuthorID(String authorID)
	{
		this.authorID=authorID;
	}
	public String getTitle()
	{
		return this.title;
	}
	public void setTitle(String title)
	{
		this.title=title;
	}
	public String getPublish()
	{
		return this.publish;
	}
	public void setPublish(String publish)
	{
		this.publish=publish;
	}
	public String getDate()
	{
		return this.date;
	}
	public void setDate(String date)
	{
		this.date=date;
	}
	public String getPrice()
	{
		return this.price;
	}
	public void setPrice(String price)
	{
		this.price=price;
	}	
}
