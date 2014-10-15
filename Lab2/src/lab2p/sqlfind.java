package lab2p;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import lab2p.sqlcon;
import lab2p.book;
import java.util.logging.Level;
import java.util.logging.Logger;
public class sqlfind
{
	String sql="select*from Book";
	public List<book> select(String author)
	{
		lab2p.sqlcon.author=author;
		Connection conn=lab2p.sqlcon.ConnectMysql();
		ResultSet rs=null;
		List<book> data=new ArrayList<book>();
		try
		{
			Statement statement=conn.createStatement();
			rs=statement.executeQuery(sql);
			while(rs.next())
			{
				book mybook=new book();
				mybook.setIsbn(rs.getString("ISBN"));
				mybook.setAuthorID(rs.getString("AuthorID"));				
				mybook.setTitle(rs.getString("Title"));
				mybook.setPublish(rs.getString("Publish"));
				mybook.setDate(rs.getString("Date"));
				mybook.setPrice(rs.getString("Price"));
				
				if((rs.getString("AuthorID")).equals(author))
				{
					//System.out.print("1");
					data.add(mybook);
				}
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null)
			{
				try { 
						rs.close();
					
					} catch (SQLException e)
					{
						e.printStackTrace();
					}
			}
			if(conn!=null)
			{
				try{
					conn.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		//System.out.print("x");
		return data;
	}
	public List<book> select1(String author,int h)
	{
		int index=1;
		Connection conn=lab2p.sqlcon.ConnectMysql();
		ResultSet rs=null;
		List<book> data=new ArrayList<book>();
		try
		{
			Statement statement=conn.createStatement();
			rs=statement.executeQuery(sql);
			while(rs.next())
			{
				book mybook=new book();
				mybook.setIsbn(rs.getString("ISBN"));
				mybook.setAuthorID(rs.getString("AuthorID"));				
				mybook.setTitle(rs.getString("Title"));
				mybook.setPublish(rs.getString("Publish"));
				mybook.setDate(rs.getString("Date"));
				mybook.setPrice(rs.getString("Price"));
				
				if((rs.getString("AuthorID")).equals(author))
				{
					if(h==index)
					{
						lab2p.sqlcon.title=rs.getString("title");
						data.add(mybook);
					}
					index++;
				}
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null)
			{
				try { 
						rs.close();
					
					} catch (SQLException e)
					{
						e.printStackTrace();
					}
			}
			if(conn!=null)
			{
				try{
					conn.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		return data;
	}
	
	public boolean DeletSql(String delsql)
	{
		
		Connection conn=lab2p.sqlcon.ConnectMysql();
		ResultSet rs=null;	 
      try {
            PreparedStatement ps = conn.prepareStatement(delsql);
            int result=ps.executeUpdate(delsql);
            if(result>0)
                return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
         }
	public String getauthorid(String name)
	{
		//System.out.print(name);
		lab2p.sqlcon.realauthor=name;
		String data=null;
		String sql="select*from Author";
		Connection conn=lab2p.sqlcon.ConnectMysql();
		ResultSet rs=null;
		try
		{
			Statement statement=conn.createStatement();
			rs=statement.executeQuery(sql);
			while(rs.next())
			{
				
				
				if((rs.getString("Name")).equals(name))
				{
					
					data= rs.getString("AuthorID");
				}
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null)
			{
				try { 
						rs.close();
					
					} catch (SQLException e)
					{
						e.printStackTrace();
					}
			}
			if(conn!=null)
			{
				try{
					conn.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		return data;
	}
	public List<author> getauthorinf()
	{
		//String data=null;
		String sql="select*from Author";
		Connection conn=lab2p.sqlcon.ConnectMysql();
		ResultSet rs=null;
		List<author> data=new ArrayList();
		
		try
		{
			Statement statement=conn.createStatement();
			rs=statement.executeQuery(sql);
			while(rs.next())
			{
				author  myauthor=new author();
				myauthor.setName(rs.getString("Name"));
				myauthor.setAuthorID(rs.getString("AuthorID"));
				myauthor.setAge(rs.getString("Age"));
				myauthor.setCountry(rs.getString("Country"));
				//System.out.print("XXX"+lab2p.sqlcon.author);
				//System.out.print("\n");
				//System.out.print("YYY"+rs.getString("Name"));
				if((rs.getString("Name")).equals(lab2p.sqlcon.realauthor))
				{
					//System.out.print("1");
					data.add(myauthor);
				}
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null)
			{
				try { 
						rs.close();
					
					} catch (SQLException e)
					{
						e.printStackTrace();
					}
			}
			if(conn!=null)
			{
				try{
					conn.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		return data;
	}
	public boolean isauthor(String name)
	{
		String sql="select*from Author";
		Connection conn=lab2p.sqlcon.ConnectMysql();
		ResultSet rs=null;
		boolean x=false;
		int exist=1;
		try
		{
			Statement statement=conn.createStatement();
			rs=statement.executeQuery(sql);
			while(rs.next())
			{
				if((rs.getString("Name")).equals(name))
				{
					lab2p.sqlcon.index=rs.getString("AuthorID");
					x=true;
				}
				else exist++;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null)
			{
				try { 
						rs.close();
					
					} catch (SQLException e)
					{
						e.printStackTrace();
					}
			}
			if(conn!=null)
			{
				try{
					conn.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		if(x==false)
		{
			lab2p.sqlcon.index=Integer.toString(exist);
		}
		//System.out.print(exist);
		//System.out.print(lab2p.sqlcon.index);
		return x;
	}
	public boolean InsertSql(book mybook){
	String insql=null;
     try{

             insql="insert into Book(ISBN,Title,AuthorID,Publish,Date,Price) values(?,?,?,?,?,?)";
             Connection conn=lab2p.sqlcon.ConnectMysql();
            PreparedStatement ps=conn.prepareStatement(insql);
            
            ps.setString(1, mybook.getIsbn());
            ps.setString(2, mybook.getTitle());
            //System.out.print(lab2p.sqlcon.index);
            ps.setString(3, lab2p.sqlcon.index);
            ps.setString(4, mybook.getPublish());
            ps.setString(5, mybook.getDate());
            ps.setString(6, mybook.getPrice());
            int result=ps.executeUpdate();
            //ps.executeUpdate();无法判断是否已经插入
            if(result>0)
                return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
	public boolean InsertSql1(author myauthor){
		String insql=null;
	     try{

	             insql="insert into Author(AuthorID,Name,Age,Country) values(?,?,?,?)";
	             Connection conn=lab2p.sqlcon.ConnectMysql();
	            PreparedStatement ps=conn.prepareStatement(insql);
	            
	            ps.setString(1, lab2p.sqlcon.index);
	            ps.setString(2, myauthor.getName());
	           // System.out.print(lab2p.sqlcon.index);
	            ps.setString(3, myauthor.getAge());
	            ps.setString(4,myauthor.getCountry());
	            
	            int result=ps.executeUpdate();
	            //ps.executeUpdate();无法判断是否已经插入
	            if(result>0)
	                return true;
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	        return false;
	    }
}
