package ru.geekbrains.DZ;

public class Main {

    static final int size = 10000000;
    static final int h = size / 2;

    public static void meth1(){
        float[] arr = new float[size];
        for (int n = 0; n < size; n++) {
            arr[n] = 1;
        }
        long a = System.currentTimeMillis();
        resA(arr, size);
        long b = System.currentTimeMillis();
        System.out.println(b-a);
    }


    public static void meth2(){
        float[] arr = new float[size];
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        for (int n = 0; n < size; n++) {
            arr[n] = 1;
        }
        long c = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        ResAThread r0 = new ResAThread(a1);
        r0.start();
        try {
            r0.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ResAThread r1 = new ResAThread(a2);
        r1.start();

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        long d = System.currentTimeMillis();
        System.out.println(d-c);
    }

    public static void resA(float[] a1, int h) {
        for (int k = 0; k < h; k++) {
            a1[k] = (float) (a1[k] * Math.sin(0.2f + k / 5) * Math.cos(0.2f + k / 5) * Math.cos(0.4f + k / 2));
        }
    }


    public static void main(String[] args) {
        System.out.print("первый метод: ");
        meth1();
        System.out.print("второй метод: ");
        meth2();

    }
}
