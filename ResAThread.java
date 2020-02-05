package ru.geekbrains.DZ;

public class ResAThread extends Thread{
    private float [] arr;
    public ResAThread(float[] arr) {
        this.arr = arr;
    }
        @Override
        public void run() {
            for (int k = 0 ; k < arr.length; k++) {
                arr[k] = (float) (arr[k] * Math.sin(0.2f + k / 5) * Math.cos(0.2f + k / 5) * Math.cos(0.4f + k / 2));
            }
        }

}
