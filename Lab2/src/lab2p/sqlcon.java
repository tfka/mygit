package lab2p;
import java.sql.*; 
public class sqlcon 
{
	public static String author;
	public static String title;
	public static String realauthor;
	public static String index;
    public static Connection ConnectMysql()
    {
    	Connection conn =null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_tfka","4jzlzmnloo","j10h3xy21xwj4xl00h42j2x4mi2hwm2jl5klw442");
        }catch(Exception ex){
            ex.printStackTrace();
        }
         return conn;
    }	
   
}
