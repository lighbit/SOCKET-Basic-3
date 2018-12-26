package com.socket;

/**
 * TODO: SOCKET CLIENT TASK3 (SEND MANY CSV TO DATABASE)
 * @author zulkarnaen
 */

import java.awt.Frame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.Datakaryawan.DatakaryawanSimple;

@SuppressWarnings("unused")
public class Server3 {

	// TODO: Membuat variable
	private static ServerSocket serverSocket;
	private static Socket client;
	private static ObjectInputStream in;

	@SuppressWarnings({ "resource" })
	public static void main(String[] args) throws InterruptedException {

		// TODO: deklarasi address dan socket
		File myfile;
		File myfile1;
		File myfile2;
		File myfile3;

		Frame myFrame = new Frame();

		try {
			// TODO: Membuat socket baru dengan socket 5555
			serverSocket = new ServerSocket(5555);
			System.out.println("-------Menunggu Client...");

			// TODO: Socket client jika diterima
			client = serverSocket.accept();
			System.out.println("=============== WELCOME TO SERVER ===========\n");
			System.out.println("------------> Client Terhubung! <------------\n");

			// TODO: objectinputstream baru dengan client(socket) mengambil
			// inputstream
			in = new ObjectInputStream(client.getInputStream());

			// TODO: Mendapatkan semua Data
			myfile = (File) in.readObject();
			myfile1 = (File) in.readObject();
			myfile2 = (File) in.readObject();
			myfile3 = (File) in.readObject();

			System.out.println("=============== DIDAPAT DATA ================");
			System.out.println("Asal Path	: " + myfile.getAbsolutePath());
			System.out.println("Asal Path1	: " + myfile1.getAbsolutePath());
			System.out.println("Asal Path2	: " + myfile2.getAbsolutePath());
			System.out.println("Asal Path3	: " + myfile3.getAbsolutePath());
			System.out.println("---------------------------------------------");
			System.out.println("Nama File	: " + myfile.getName());
			System.out.println("Nama File1	: " + myfile1.getName());
			System.out.println("Nama File2	: " + myfile2.getName());
			System.out.println("Nama File3	: " + myfile3.getName());
			System.out.println("---------------------------------------------");
			System.out.println("length		: " + myfile.length() + " bytes");
			System.out.println("length1		: " + myfile1.length() + " bytes");
			System.out.println("length2		: " + myfile2.length() + " bytes");
			System.out.println("length3		: " + myfile3.length() + " bytes");
			System.out.println("---------------------------------------------");
			System.out.println("------- *your DB will appear in below ------\n");

			// TODO: Deklarasi Fileinput (inData) dan Fileouput(outData)
			FileInputStream inData = null;
			FileInputStream inData1 = null;
			FileInputStream inData2 = null;
			FileInputStream inData3 = null;

			FileOutputStream outData = null;
			FileOutputStream outData1 = null;
			FileOutputStream outData2 = null;
			FileOutputStream outData3 = null;

			// TODO: Memanggil Fileinput dan Fileouput
			inData = new FileInputStream(myfile);
			inData1 = new FileInputStream(myfile1);
			inData2 = new FileInputStream(myfile2);
			inData3 = new FileInputStream(myfile3);

			outData = new FileOutputStream("D://zTesting_Socket/zServer/" + myfile.getName());
			outData1 = new FileOutputStream("D:/zTesting_Socket/zServer/" + myfile1.getName());
			outData2 = new FileOutputStream("D:/zTesting_Socket/zServer/" + myfile2.getName());
			outData3 = new FileOutputStream("D:/zTesting_Socket/zServer/" + myfile3.getName());

			// TODO: Membuat looping pada data masuk dan data keluar untuk
			// membaca data nanti
			int c;
			while ((c = inData.read()) != -1) {
				outData.write(c);

			}
			while ((c = inData1.read()) != -1) {
				outData1.write(c);

			}
			while ((c = inData2.read()) != -1) {
				outData2.write(c);

			}
			while ((c = inData3.read()) != -1) {
				outData3.write(c);

			}

			// TODO: Deklarasi data di server dengan bufferedreader untuk
			// membaca datanya
			File file  = new File("D:/zTesting_Socket/zServer/" + myfile.getName());
			File file1 = new File("D:/zTesting_Socket/zServer/" + myfile1.getName());
			File file2 = new File("D:/zTesting_Socket/zServer/" + myfile2.getName());
			File file3 = new File("D:/zTesting_Socket/zServer/" + myfile3.getName());

			BufferedReader br = new BufferedReader(new FileReader(file));
			BufferedReader br1 = new BufferedReader(new FileReader(file1));
			BufferedReader br2 = new BufferedReader(new FileReader(file2));
			BufferedReader br3 = new BufferedReader(new FileReader(file3));

			// TODO: Membuat kondisi untuk memunculkan semua data pada csv
			// jika bufferedreader is ready maka data br akan di split dengan
			// nama line.
			System.out.println("=============== YOUR DATABASE ================");
			System.out.println("---------------- Multithread -----------------\n");
			while (br.ready()) {
				String line = br.readLine();
				String[] data = line.split(",");

				// TODO: Menentukan Array dari datakaryawansimple agar sesuai
				// dengan database
				DatakaryawanSimple datakaryawan = new DatakaryawanSimple(Integer.parseInt(data[0]), data[1], data[2],
						data[3]);

				// TODO: line (bufferedreader)
				System.out.println("--> " + line + " <--\n");

			}

			System.out.println("--------------- Multithread 1 --------------\n");
			while (br1.ready()) {
				String line1 = br1.readLine();
				String[] data = line1.split(",");

				// TODO: Menentukan Array dari datakaryawansimple agar sesuai
				// dengan database
				DatakaryawanSimple datakaryawan = new DatakaryawanSimple(Integer.parseInt(data[0]), data[1], data[2],
						data[3]);

				// TODO: line (bufferedreader)
				System.out.println("--> " + line1 + " <--\n");

			}

			System.out.println("--------------- Multithread 2 --------------\n");
			while (br2.ready()) {
				String line2 = br2.readLine();
				String[] data = line2.split(",");

				// TODO: Menentukan Array dari datakaryawansimple agar sesuai
				// dengan database
				DatakaryawanSimple datakaryawan = new DatakaryawanSimple(Integer.parseInt(data[0]), data[1], data[2],
						data[3]);

				// TODO: line (bufferedreader)
				System.out.println("--> " + line2 + " <--\n");

			}

			System.out.println("-------------- Multithread 3 ---------------\n");
			while (br3.ready()) {
				String line3 = br3.readLine();
				String[] data = line3.split(",");

				// TODO: Menentukan Array dari datakaryawansimple agar sesuai
				// dengan database
				DatakaryawanSimple datakaryawan = new DatakaryawanSimple(Integer.parseInt(data[0]), data[1], data[2],
						data[3]);

				// TODO: line (bufferedreader)
				System.out.println("--> " + line3 + " <--\n");

			}
			System.out.println("=============================================");
			System.out.println("-*if your DB not appear, cek your (BR)-\n");

			// TODO: Memberikan delay 9s (untuk redirect)
			Thread.sleep(9000);

			// TODO: putuskan semua koneksi
			outData.close();
			outData1.close();
			outData2.close();
			outData3.close();

			inData.close();
			inData1.close();
			inData2.close();
			inData3.close();

			in.close();
			client.close();
			System.out.println("----------> Client dihentikan <--------");

			serverSocket.close();
			System.out.println("----------> Server dihentikan <--------");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}
