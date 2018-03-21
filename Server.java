import java.rmi.Naming;
class Server
{
	public static void main(String dt[])
	{
		try
		{
			Iprog ip=new IprogImp();
			Naming.rebind("rmi://localhost:3000/myobj",ip);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}