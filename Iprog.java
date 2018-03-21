import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Iprog extends Remote
{
	public double deposite(double balance) throws RemoteException;
	public double withdrawl(double balance) throws RemoteException;
	public double balanceCheck() throws RemoteException;
}