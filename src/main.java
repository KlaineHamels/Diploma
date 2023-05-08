import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class main {
    //матрица связности предприятий 1 стадии со 2 стадией
    public static int[][] matrixD = {
            {0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0},
            {1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1},
            {0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1},
            {0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0},
            {1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1},
            {0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0},
            {1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1},
            {0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1},
            {0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0},
            {0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0}
    };

    //матрица связности предприятий 2 стадии с потребителем
    private static final int[][] matrixC = {
            {0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0},
            {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0},
            {1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 0},
            {1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0},
            {1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1},
            {0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1},
            {1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1},
            {0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1},
            {1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1},
            {1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1},
            {0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1},
            {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0},
            {1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0},
            {0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1},
            {0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0},
            {1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1},
            {0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1},
            {0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1}
    };

    //стоимость открытия 1 стадии
    public static int[] costA = {17, 19, 18, 17, 18, 25, 38, 74, 21, 13};

    //стоимость открытия 2 стадии
    public static int[] costB = {13, 18, 22, 12, 13, 11, 10, 13, 14, 15, 16, 17, 18, 19, 20, 22, 25, 26, 28, 30};

    //коэффицент надежности
    private static final int P = 2;

    public static void main(String[] args) throws IOException {

        int cLength=matrixC[1].length;
        System.out.println(cLength);
        int[] provX = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] provY = {0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0};
        boolean a = secondRestriction(provY);
        boolean b = firstRestriction(provX,provY);
        if(a && b){
            System.out.println();
        }


        long time = System.currentTimeMillis();
        //  writeToFile("matrix.txt", 4, 5);


        int[] vectorY = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] vectorX = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(vectorX));

        int bestObjectiveFunction = 100000;
        int[] bufferX;
      //  bufferX = Arrays.stream(shaking(vectorX)).toArray();
        int[] bufferY = Arrays.stream(maxRealY()).toArray();
        ;
        vectorY = Arrays.stream(bufferY).toArray();

        int[] bestX = Arrays.stream(vectorX).toArray();
        int[] bestY = Arrays.stream(bufferY).toArray();
        //    int bestObjectiveFunction = objectiveFunction(vectorX, vectorY);

       //System.out.println(Arrays.toString(bestX));
       // System.out.println(Arrays.toString(bestY));
       // System.out.println(bestObjectiveFunction);
       // System.out.println("______________________");


        for (int l = 0; l < 1000; l++) {
            for (int i = 0; i < 5; i++) {
                bufferX = Arrays.stream(twoFlipX(vectorX)).toArray();
               // System.out.println(Arrays.toString(bufferX));
                if (firstRestriction(bufferX, bufferY)) {
                    vectorX = Arrays.stream(bufferX).toArray();
                    break;
                }
            }

            for (int i = 0; i < 32; i++) {
                List<int[]> vectors = flip(bufferY);
//                        for (int[] vector : vectors) {
//                            System.out.println(Arrays.toString(vector));
//                        }
//                        System.out.println("=============");

                for (int[] currentY : vectors) {

                    boolean first = firstRestriction(vectorX, currentY);
                    boolean second = secondRestriction(currentY);

                    if (first && second) {
                      //  System.out.println("best here" + Arrays.toString(currentY));
                       // System.out.println("-------------------------");
                        int currentObjective = objectiveFunction(vectorX, currentY);
                        if (currentObjective < bestObjectiveFunction) {
                            bestObjectiveFunction = currentObjective;
                            bestX = Arrays.stream(vectorX).toArray();
                            bestY = Arrays.stream(currentY).toArray();
                            bufferY = Arrays.stream(bestY).toArray();
                            bufferX = Arrays.stream(bestX).toArray();
                           // System.out.println("new best" + Arrays.toString(currentY));
                          //  System.out.println("-------------------------");
                        } else {
                            break;
                        }
                        break;
                    }
                }

            }
            for (int i = 0; i < 5; i++) {
                bufferX = Arrays.stream(twoFlipX(vectorX)).toArray();
                //   System.out.println(Arrays.toString(bufferX));
                if (firstRestriction(bufferX, vectorY)) {
                    vectorX = Arrays.stream(bufferX).toArray();
                    break;
                }
            }
            for (int i = 0; i < 32; i++) {
                List<int[]> vectors = oneSwap(bufferY);
//                        for (int[] vector : vectors) {
//                            System.out.println(Arrays.toString(vector));
//                        }
//                        System.out.println("=============");

                for (int[] currentY : vectors) {

                    boolean first = firstRestriction(vectorX, currentY);
                    boolean second = secondRestriction(currentY);

                    if (first && second) {
                      //  System.out.println("best here" + Arrays.toString(currentY));
                      //  System.out.println("-------------------------");
                        int currentObjective = objectiveFunction(vectorX, currentY);
                        if (currentObjective < bestObjectiveFunction) {
                            bestObjectiveFunction = currentObjective;
                            bestX = Arrays.stream(vectorX).toArray();
                            bestY = Arrays.stream(currentY).toArray();
                            bufferY = Arrays.stream(bestY).toArray();
                            bufferX = Arrays.stream(bestX).toArray();
                          //  System.out.println("new best" + Arrays.toString(currentY));
                           // System.out.println("-------------------------");
                        } else {
                            break;
                        }
                        break;
                    }
                }
            }

            for (int i = 0; i < 5; i++) {
                bufferX = Arrays.stream(twoFlipX(vectorX)).toArray();
              //  System.out.println(Arrays.toString(bufferX));
                if (firstRestriction(bufferX, bufferY)) {
                    vectorX = Arrays.stream(bufferX).toArray();
                    break;
                }
            }

            for (int i = 0; i < 32; i++) {
                List<int[]> vectors = twoFlip(bufferY);
//                        for (int[] vector : vectors) {
//                            System.out.println(Arrays.toString(vector));
//                        }
//                        System.out.println("=============");

                for (int[] currentY : vectors) {

                    boolean first = firstRestriction(vectorX, currentY);
                    boolean second = secondRestriction(currentY);

                    if (first && second) {
                       // System.out.println("best here" + Arrays.toString(currentY));
                        //System.out.println("-------------------------");
                        int currentObjective = objectiveFunction(vectorX, currentY);
                        if (currentObjective < bestObjectiveFunction) {
                            bestObjectiveFunction = currentObjective;
                            bestX = Arrays.stream(vectorX).toArray();
                            bestY = Arrays.stream(currentY).toArray();
                            bufferY = Arrays.stream(bestY).toArray();
                            bufferX = Arrays.stream(bestX).toArray();
                          //  System.out.println("new best" + Arrays.toString(currentY));
                          //  System.out.println("-------------------------");
                        } else {
                            break;
                        }
                        break;
                    }
                }

            }

        }

        System.out.println("Answer is");
        System.out.println(Arrays.toString(bestX));
        System.out.println(Arrays.toString(bestY));
        System.out.println(bestObjectiveFunction);
        System.out.println("time is");
        System.out.println(System.currentTimeMillis() - time);
    }

    //Целевая функция
    public static int objectiveFunction(int[] vectorX, int[] vectorY) {
        int sumA = 0;
        for (int i = 0; i < vectorX.length; i++) {
            sumA += vectorX[i] * costA[i];
        }
        int sumB = 0;
        for (int i = 0; i < vectorY.length; i++) {
            sumB += vectorY[i] * costB[i];
        }
        return sumA + sumB;
    }

    //Второе ограничение
    public static boolean secondRestriction(int[] vectorY) {
        int sumOfCommunication = 0;
        for (int l = 0; l < matrixC[1].length; l++) {
            for (int j = 0; j < vectorY.length; j++) {
                sumOfCommunication += matrixC[j][l] * vectorY[j];
            }
            if (sumOfCommunication < P) {
                return false;
            }
            sumOfCommunication = 0;
        }
        return true;
    }

    //Первое ограничение
    public static boolean firstRestriction(int[] vectorX, int[] vectorY) {
        int sumOfCommunication = 0;
        for (int j = 0; j < matrixD[1].length; j++) {
            for (int i = 0; i < vectorX.length; i++) {
                sumOfCommunication += matrixD[i][j] * vectorX[i];
            }
            if (sumOfCommunication < P * vectorY[j]) {
                return false;
            }
            sumOfCommunication = 0;
        }
        return true;
    }

    //Один флип для вектора Y
    public static List<int[]> flip(int[] z) {
        List<int[]> vectors = new ArrayList<>();
        int index = oneFlip(z);
        for (int i = 0; i < z.length; i++) {
            int[] arr = Arrays.stream(z).toArray();
            if (i != index) {
                arr[i] = swapBetweenZeroAndOne(z[i]);
                vectors.add(arr);
            }
        }
        return vectors;
    }

    public static int[] shaking(int[] z) {
        int[] arr = Arrays.stream(z).toArray();
        oneFlip(arr);
        return arr;
    }

    public static int oneFlip(int[] z) {
        int index = rand(z.length);
        z[index] = swapBetweenZeroAndOne(z[index]);
        return index;
    }

    public static List<int[]> twoFlip(int[] z) {
        List<int[]> vectors = new ArrayList<>();
        int index = rand(z.length);
        z[index] = swapBetweenZeroAndOne(z[index]);
        int newIndex;
        do {
            newIndex = rand(z.length);;
        } while (newIndex == index);
        z[newIndex] = swapBetweenZeroAndOne(newIndex);
        for (int i = 0; i < z.length - 1; i++) {
            int[] arr = Arrays.stream(z).toArray();
            if (i != index && i != newIndex) {
                arr[i] = swapBetweenZeroAndOne(arr[i]);
                for (int j = i + 1; j < z.length; j++) {
                    int[] newArr = Arrays.stream(arr).toArray();
                    if (j != index && j != newIndex && j != i) {
                        newArr[j] = swapBetweenZeroAndOne(newArr[j]);
                        vectors.add(newArr);
                    }
                }
            }

        }
        return vectors;
    }

    public static int[] twoFlipX(int[] z) {
        int index = rand(z.length);
        z[index] = swapBetweenZeroAndOne(z[index]);
        int newIndex;
        do {
            newIndex = rand(z.length);
            ;
        } while (newIndex == index);
        z[newIndex] = swapBetweenZeroAndOne(newIndex);
        return z;
    }


    public static int swapBetweenZeroAndOne(int number) {
        if (number == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static List<int[]> oneSwap(int[] z) {
        int index = 0;
        for (int i = 0; i < z.length; i++) {
            index = rand(z.length);
            if (z[index] == 1) {
                z[index] = swapBetweenZeroAndOne(z[index]);
                break;
            }
        }
        List<int[]> vectors = new ArrayList<>();
        for (int i = 0; i < z.length; i++) {
            if (z[i] == 0 && z[i] != index) {
                int[] arr = Arrays.stream(z).toArray();
                arr[i] = 1;
                vectors.add(arr);
            }

        }
        return vectors;
    }

    public static int rand(int n) {
        Random random = new Random();
        return random.nextInt(n);
    }

    public static int[] maxRealY() {
        int[] arr = new int[matrixD[0].length];
        for (int i = 0; i < matrixD.length; i++) {
            arr[i] = 0;
        }

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrixD.length; j++) {
                sum += matrixD[j][i];
            }
            if (sum >= P) {
                arr[i] = 1;
            }
        }
        return arr;
    }

    public static void writeToFile(String filename, int n, int m) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                writer.write(String.valueOf(rand(2)));
                writer.write(" ");
            }
            writer.write("\r\n");
        }
        writer.flush();
    }

//    public static int[] realY()

}