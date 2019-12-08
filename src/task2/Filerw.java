package task2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Filerw {
    private String name = "";

    public void write(ArrayList<tour> b) throws Exception{
        System.out.println("Enter file name");
        Scanner in = new Scanner(System.in);
        name = in.next();

        DataOutputStream dataOut = new DataOutputStream(new FileOutputStream(name));

        for(tour t : b){
            dataOut.writeUTF(t.name);
            dataOut.writeUTF(t.country);
            dataOut.writeUTF(t.city);
            dataOut.writeUTF(t.hotel_name);
            dataOut.writeInt(t.stars);
            dataOut.writeInt(t.duration);
            dataOut.writeInt(t.amount);
            dataOut.writeDouble(t.cost);
            dataOut.writeUTF(t.company);
        }

        File f = new File(name);
        if (f.exists()){
            System.out.println("exists");
        }else{
            System.out.println("don't exist");
        }

        dataOut.close();
    }

    public ArrayList read(String company) throws Exception{
        DataInputStream dataIn = new DataInputStream(new FileInputStream(name));
        ArrayList<tour> b = new ArrayList<tour>();
        while (dataIn.available() > 0){

            String n = dataIn.readUTF();
            String c = dataIn.readUTF();
            String ci = dataIn.readUTF();
            String hn = dataIn.readUTF();
            int s = dataIn.readInt();
            int d = dataIn.readInt();
            int a = dataIn.readInt();
            Double cos = dataIn.readDouble();
            String com = dataIn.readUTF();
            if (com.equals(company)) {
                tour t = new tour(n, c, ci, hn, s, d, a, cos, com);

                b.add(t);
            }
        }
        dataIn.close();
        return b;
    }

    public void raf(ArrayList<tour> b, int num) throws Exception{
        name +="1.txt";
        DataOutputStream dataOut = new DataOutputStream(new FileOutputStream(name));

        for(tour t : b){
            byte[] bbb = t.toString().getBytes("UTF-8");
            dataOut.write(bbb);
            dataOut.write("\r\n".getBytes("UTF-8"));
        }
        dataOut.close();

        RandomAccessFile raf = new RandomAccessFile(name, "rw");
        raf.seek(0);
        String sss = "";
        for (int i = 0; i<=num; i++){
            sss = raf.readLine();
        }
        tour t = new tour(sss);
        t.add10();
        byte[] bbb = t.toString().getBytes("UTF-8");

        raf.seek(0);
        for (int i = 0; i<num; i++){
            raf.readLine();
        }
        raf.write(bbb);
        System.out.println(t.toString());
        raf.close();
    }
}
