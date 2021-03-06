package server.rmi;



import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {
	public static void main(String args[])
	{
		ServerInterface d = null;
		try {
			//c = new ChineseChessArithmeticRMIImpl();
			d = (ServerInterface) Naming.lookup("rmi://127.0.0.1/ChessGame");
			System.out.println("check A : " + d.check("123", "201401"));
			System.out.println("check B : " + d.check("456", "201402"));
//			System.out.println("random connect A (rom num) : " + c.connect("123"));
//			System.out.println("random connect B (rom num) : " + c.connect("456"));
			int roomNum = d.connect("123", "456");
			System.out.println("connect A & B (rom num): " + roomNum);
//			System.out.println("A move chess : " + d.moveChess(roomNum, "123", 0, 0, 3, 3));
			System.out.println("A update : ");
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 8; j++) {
					System.out.print(d.updateChessBoardInfo(roomNum, "123")[i][j] + " ");
				}
				System.out.println();
			}
			
		
		}catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
