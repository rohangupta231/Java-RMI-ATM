import java.rmi.Naming;
import java.io.*;
class Client
{
	public static void main(String dt[])
	{
		InputStreamReader isr=null;
		BufferedReader br=null;
		try
		{
			Iprog ip=(Iprog)Naming.lookup("rmi://localhost:3000/myobj");
			isr=new InputStreamReader(System.in);
			br=new BufferedReader(isr);
			double balance;
			do
			{
				System.out.println("1 Deposite Cash");
				System.out.println("2 Withdraw Cash");
				System.out.println("3 Balance Enquiry");
				System.out.println("Please Select a Choice");
				String choice=br.readLine();
				switch(choice)
				{
					case "1":
					{
						System.out.println("Enter Amount");
						balance=Double.parseDouble(br.readLine());
						System.out.println("Balance Deposited,Your Current Balance is "+(ip.deposite(balance)));
						break;
					}
					case "2":
					{
						System.out.println("Enter Amount");
						balance=Double.parseDouble(br.readLine());
						if(ip.withdrawl(balance)==(-1))
						{
							System.out.println("Sorry Not enough amount of money");
						}	
						else
						{
							System.out.println("Collect Cash,Your Current Balance is "+(ip.withdrawl(balance)));
						}
						break;
					}
					case "3":
					{
						System.out.println(ip.balanceCheck());
						break;
					}
					case "4":
					{
						System.out.println("Thank You");
						System.exit(0);
					}
				}
			}while(true);
		}	
		catch(Exception e)
		{
			System.out.println(e);	
		}
		finally
		{
			try
			{
				br.close();
				isr.close();		
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
}