package com.socket;

/**
 * TODO: SOCKET CLIENT TASK3 (SEND MANY CSV TO DATABASE)
 * @author zulkarnaen
 */

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class Client3 {

	private static SocketAddress address;
	private static Socket socket;
	private static ObjectOutputStream out;
	private static File myFile;
	private static File myFile1;
	private static File myFile2;
	private static File myFile3;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ip = "127.0.0.1";
		int port = 5555;

		address = new InetSocketAddress(ip, port);
		socket = new Socket();
		try {
			socket.connect(address);
			System.out.println("----------->Berhasil Terhubung ke Client!<-------------\n");
			System.out.println("================== WELCOME TO CLIENT ==================\n");
			out = new ObjectOutputStream(socket.getOutputStream());

			String msgFile 	= "D:/zTesting_Socket/zClient/Task2.csv";
			String msgFile1 = "D:/zTesting_Socket/zClient/Task2(1).csv";
			String msgFile2 = "D:/zTesting_Socket/zClient/Task2(2).csv";
			String msgFile3 = "D:/zTesting_Socket/zClient/Task2(3).csv";

			myFile = new File(msgFile);
			myFile1 = new File(msgFile1);
			myFile2 = new File(msgFile2);
			myFile3 = new File(msgFile3);

			System.out.println("=======================================================");
			System.out.println("--------->Asal Path		: " + myFile.getAbsolutePath());
			System.out.println("--------->Asal Path1  	: " + myFile1.getAbsolutePath());
			System.out.println("--------->Asal Path2  	: " + myFile2.getAbsolutePath());
			System.out.println("--------->Asal Path3 	: " + myFile3.getAbsolutePath());
			System.out.println("-------------------------------------------------------");
			System.out.println("--------->length	: " + myFile.length());
			System.out.println("--------->length1	: " + myFile1.length());
			System.out.println("--------->length2	: " + myFile2.length());
			System.out.println("--------->length3	: " + myFile3.length());
			System.out.println("-------------------------------------------------------\n");

			out.writeObject(myFile);
			out.writeObject(myFile1);
			out.writeObject(myFile2);
			out.writeObject(myFile3);

			// TODO: Multithread
			System.out.println("==================== INFO DATABASE ====================");
			System.out.println("================== INFO MULTI THREAD ==================");
			// TODO: Manipulasi untuk Insert ke DB
			SendCSVtoDatabase.readCsv();
			SendCSVtoDatabase.readCsvUsingLoad();
			System.out.println("--------------- Data Berhasil di Upload ---------------\n");
			System.out.println("=======================================================\n");

			// TODO: Multithread1
			System.out.println("================== INFO MULTI THREAD1 =================");
			// TODO: Manipulasi untuk Insert ke DB
			SendCSVtoDatabase.readCsv1();
			SendCSVtoDatabase.readCsvUsingLoad1();
			System.out.println("--------------- Data Berhasil di Upload ---------------\n");
			System.out.println("=======================================================\n");

			// TODO: Multithread2
			System.out.println("================== INFO MULTI THREAD2 =================");
			// TODO: Manipulasi untuk Insert ke DB
			SendCSVtoDatabase.readCsv2();
			SendCSVtoDatabase.readCsvUsingLoad2();
			System.out.println("--------------- Data Berhasil di Upload ---------------\n");
			System.out.println("=======================================================\n");

			// TODO: Multithread3
			System.out.println("================== INFO MULTI THREAD3 =================");
			// TODO: Manipulasi untuk Insert ke DB
			SendCSVtoDatabase.readCsv3();
			SendCSVtoDatabase.readCsvUsingLoad3();
			System.out.println("--------------- Data Berhasil di Upload ---------------\n");
			System.out.println("=======================================================\n");

			// TODO: CLOSE ALL CONNECTION
			out.close();
			socket.close();
			System.out.println("------------------->Socket ditutup <-------------------\n");
			System.out.println("*beberapa saat lagi console akan redirect ke server");
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}
