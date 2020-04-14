

import java.io.*;

    public class ubung1 {

        public static void main(String[] args) {
            final String filename = "testFile.txt";
            String sensorName = "MyGoodOldSensor";
            String abstand = "\n";
            String abstand2 = "/";

            long[] timeStamps = new long[3];
            timeStamps[0] = System.currentTimeMillis();
            timeStamps[1] = timeStamps[0] + 1;
            timeStamps[2] = timeStamps[1] + 1000;

            float[][] values = new float[3][];
            float[] valueSet = new float[1];
            values[0] = valueSet;
            valueSet[0] = (float) 1.5;


            valueSet = new float[3];
            values[1] = valueSet;
            valueSet[0] = (float) 0.7;
            valueSet[1] = (float) 1.2;
            valueSet[2] = (float) 2.1;


            valueSet = new float[2];
            values[2] = valueSet;
            valueSet[0] = (float) 0.7;
            valueSet[1] = (float) 1.2;


            OutputStream os;
            DataOutputStream dos = null;
            try {
                os = new FileOutputStream(filename);
                dos = new DataOutputStream(os);
            } catch (FileNotFoundException ex) {
                System.err.println("couldn’t open file - fatal");
                System.exit(0);
            }
            for (float[] value : values) {
                try {
                    dos.writeUTF(sensorName);
                    for (int j = 0; j < value.length; j++) {
                        dos.writeUTF(abstand2);
                        dos.writeLong(timeStamps[j]);
                        dos.writeUTF(abstand2);
                        dos.writeFloat(value[j]);
                    }
                    dos.writeUTF(abstand);

                } catch (IOException ex) {
                    System.err.println("couldn’t write data (fatal)");
                    System.exit(0);
                }
            }


            InputStream is;
            DataInputStream dis = null;
            try {
                is = new FileInputStream(filename);
                dis = new DataInputStream(is);
            } catch (FileNotFoundException ex) {
                System.err.println("couldn’t open file - fatal");
                System.exit(0);
            }
            System.out.println("Aufbau: Sensorname/Zeit/Wert/.../Zeit/Wert");
            for (float[] value : values) {
                try {
                    String a = dis.readUTF();
                    System.out.print(a);
                    for (int j = 0; j < value.length; j++) {
                        String b = dis.readUTF();
                        System.out.print(b);
                        long c = dis.readLong();
                        System.out.print(c);
                        String d = dis.readUTF();
                        System.out.print(d);
                        float e = dis.readFloat();
                        System.out.print(e);
                    }
                    String f = dis.readUTF();
                    System.out.print(f);

                } catch (IOException ex) {
                    System.err.println("couldn’t write data (fatal)");
                    System.exit(0);
                }
            }
        }
    }




