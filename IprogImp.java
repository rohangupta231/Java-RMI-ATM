import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
class IprogImp extends UnicastRemoteObject implements Iprog
{
	public double balance;
	public IprogImp() throws RemoteException
	{
		this.balance=500;
	}
	public IprogImp(double balance) throws RemoteException
	{
		this.balance=balance;
	}
	public double deposite(double balance) throws RemoteException
	{
		this.balance=this.balance+balance;
		return (this.balance);
	}
	public double withdrawl(double balance) throws RemoteException
	{
		if(this.balance>=balance)
		{
			this.balance=this.balance-balance;
			return(this.balance);
		}
		return (-1);
	}
	public double balanceCheck() throws RemoteException
	{
		return this.balance;
	}
}