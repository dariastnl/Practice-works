import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class FairyForest {

    static public Scanner in = new Scanner(System.in);
    static int[][] x;
    static int[] array;
    static int a = 5, b = 5, i = 0, j = 0;
    static int[][] matrix = {
            {6, 5, 1, 1, 5, 4,},
            {0, 0, 0, 5, 6},
            {7, 7, 1, 1, 1},
            {1, 1, 1, 3, 1},
            {1, 1, 2, 2, 1},
            {0, 0, 9, 0, 0},
            {0, 0, 0, 0, 9}
    };

    public static void main(String[] args) throws IOException {
        Random rand = new Random();
        x = new int[a][b];
        for (i = 0; i < a; i++) {
            for (j = 0; j < b; j++) {
                x[i][j] = rand.nextInt(10);
            }
        }
        int input = 1;
        while (input != 0) {
            System.out.println();
            System.out.println((char) 27 + "[33mSelect operation:" + (char) 27 + "[0m");
            System.out.println("1 - Swap 2 rows");
            System.out.println("2 - Remove a boundary column");
            System.out.println("3 - The longest non-decreasing sequence");
            System.out.println("4 - Merge sort");
            System.out.println("5 - The percentage of zones");
            System.out.println("6 - Create a file with elements of even columns");
            System.out.println("7 - Find a square in matrix");
            System.out.println("8 - The shortest path to the castle");
            System.out.println("0 - exit");
            input = in.nextInt();
            System.out.println();

            switch (input) {
                case 1:
                    Swap();
                    break;
                case 2:
                    Delete();
                    break;
                case 3:
                    Sequence();
                    break;
                case 4:
                    Array();
                    MergeSort();
                    break;
                case 5:
                    Percent();
                    break;
                case 6:
                    File();
                    break;
                case 7:
                    Square();
                    break;
                case 8:
                    Prince();
                default:
            }
        }
        in.close();
    }


    //№ 1 Swap 2 rows
    public static void Swap() {
        int c, d, e;
        System.out.println((char) 27 + "[33mYour matrix:" + (char) 27 + "[0m");
        for (i = 0; i < a; i++) {
            for (j = 0; j < b; j++) {
                System.out.print(x[i][j] + "\t");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
        System.out.println((char) 27 + "[33mEnter 2 rows numbers:" + (char) 27 + "[0m");
        c = in.nextInt();
        d = in.nextInt();
        if (c > x.length || d > x.length || c <= 0 || d <= 0) {
            System.out.println((char) 27 + "[31mThere's only " + x.length + " rows!\nPlease, enter again!" + (char) 27 + "[0m");
            c = in.nextInt();
            d = in.nextInt();
        }
        for (i = 0; i < a; i++) {
            e = x[(c - 1)][i];
            x[c - 1][i] = x[(d - 1)][i];
            x[d - 1][i] = e;
        }
        System.out.println(" ");
        System.out.println((char) 27 + "[33mAfter interchanging " + c + " and " + d + (char) 27 + "[0m");
        for (i = 0; i < a; i++) {
            for (j = 0; j < b; j++) {
                System.out.print(x[i][j] + "\t");
            }
            System.out.println("");
        }
    }


    //№2 Delete a column
    static void Delete() {
        System.out.println((char) 27 + "[33mYour matrix:" + (char) 27 + "[0m");
        for (i = 0; i < a; i++) {
            for (j = 0; j < b; j++) {
                System.out.print(x[i][j] + "\t");
            }
            System.out.println(" ");
        }
        System.out.println(" ");

        int number;
        System.out.println((char) 27 + "[33m1 to delete west column\n5 to delete east column" + (char) 27 + "[0m");
        number = in.nextInt();
        if (number == 1 || number == 5) {
            for (i = 0; i < x.length; i++) {
                for (j = 0; j < x[0].length - 1; j++) {
                    if (j >= number - 1) {
                        x[i][j] = x[i][j + 1];
                    }
                    System.out.print(x[i][j] + "\t");
                }
                System.out.println();
            }
        } else {
            System.out.println((char) 27 + "[31mEror! Please, enter\n1 to delete west column\n5 to delete east column" + (char) 27 + "[0m");
        }
    }


    //№ 3 The longest non-decreasing sequence
    public static void Sequence() {
        int max = 0, count = 1, m;
        System.out.println((char) 27 + "[33mMatrix:" + (char) 27 + "[0m");
        for (i = 0; i < a; i++) {
            for (j = 0; j < b; j++) {
                System.out.print(x[i][j] + "\t");
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println((char) 27 + "[33mEnter column number:" + (char) 27 + "[0m");
        m = in.nextInt();
        for (i = 0; i < a - 1; i++) {
            if ((x[i][m] < x[i + 1][m]) || (x[i][m] == x[i + 1][m])) {
                count++;
            }
            else if (count > max) {
                max = count;
                count = 1;
            }
        }
        System.out.println("");
        System.out.println((char) 27 + "[33mThe longest non-decreasing sequence of column " + m + ": " + (char) 27 + "[0m\n" + max);
    }


    //№ 4 Array
    public static void Array() {
        System.out.println((char) 27 + "[33mYour matrix:" + (char) 27 + "[0m");
        for (i = 0; i < a; i++) {
            for (j = 0; j < b; j++) {
                System.out.print(x[i][j] + "\t");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
        int k = 0;
        array = new int[26];
        //System.out.println((char) 27 + "[33mNew unsorted array:" + (char) 27 + "[0m");
        for (i = 0; i < a; i++) {
            for (j = 0; j < b; j++) {
                k = k + 1;
                array[k] = x[i][j];
                //  System.out.print(array[k] + " ");
            }
        }
        System.out.println((char) 27 + "[33mSorted array:" + (char) 27 + "[0m");
    }
    public static int[] mergeSort(int[] array) {
        int[] tmp;
        int[] currentSrc = array;
        int[] currentDest = new int[array.length];

        int size = 1;
        while (size < array.length) {
            for (int i = 0; i < array.length; i += 2 * size) {
                merge(currentSrc, i, currentSrc, i + size, currentDest, i, size);
            }
            tmp = currentSrc;
            currentSrc = currentDest;
            currentDest = tmp;
            size = size * 2;
            System.out.println(arrayToString(currentSrc));
        }
        return currentSrc;
    }
    private static void merge(int[] src1, int src1Start, int[] src2, int src2Start, int[] dest, int destStart, int size) {
        int index1 = src1Start;
        int index2 = src2Start;
        int src1End = Math.min(src1Start + size, src1.length);
        int src2End = Math.min(src2Start + size, src2.length);
        int iterationCount = src1End - src1Start + src2End - src2Start;
        for (int i = destStart; i < destStart + iterationCount; i++) {
            if (index1 < src1End && (index2 >= src2End || src1[index1] < src2[index2])) {
                dest[i] = src1[index1];
                index1++;
            } else {
                dest[i] = src2[index2];
                index2++;
            }
        }
    }
    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 1; i < array.length; i++) {
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(array[i]);
        }
        sb.append("]");
        return sb.toString();
    }
    public static void MergeSort() {
        System.out.println(arrayToString(array));
        array = mergeSort(array);
    }


    //№5 Zone percentage
    public static void Percent() {
        System.out.println((char) 27 + "[33mYour matrix:" + (char) 27 + "[0m");
        for (i = 0; i < a; i++) {
            for (j = 0; j < b; j++) {
                System.out.print(x[i][j] + "\t");
            }
            System.out.println(" ");
        }
        System.out.println();
        System.out.println((char) 27 + "[33mEnter a zone-number from your matrix" + (char) 27 + "[0m");
        float number;
        int k = 0, zones = 0;
        number = in.nextInt();
        for (i = 0; i < a; i++) {
            for (j = 0; j < b; j++) {
                zones = x[i].length * x[j].length;
                if (x[i][j] == number) {
                    k++;
                }
            }
        }
        System.out.println((char) 27 + "[33m" + k + "% of the number 25: " + (char) 27 + "[0m" + zones * k / 100);
    }


    //№ 6 File with even numbers
    public static void File() throws IOException {
        //Add
        BufferedReader br = null;
        File f = new File("ParCol.txt");
        if (!f.exists()) {
            f.createNewFile();
        }
        PrintWriter pw = new PrintWriter(f);
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length; j++) {
                pw.print(x[i][j] + " ");
            }
            pw.println();
        }
        pw.close();

        //Read
        br = new BufferedReader(new FileReader("ParCol.txt")); //чтение из файла
        String[] line;
        for (int i = 0; i < x.length; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < x.length; j++) {
                x[i][j] = Integer.parseInt(line[j]);
            }
        }
        br.close();


        //Output
        System.out.println((char) 27 + "[33mEven's column elements:" + (char) 27 + "[0m");
        for (i = 0; i < x.length; i++) {
            for (j = 0; j < x.length; j++) {
                if (j % 2 != 0) {
                    System.out.print(x[i][j] + " ");
                }
            }
        }
        System.out.println();
    }


    //№7 Square
    public static void Square() {
        int R = FairyForest.x.length;
        int C = FairyForest.x[0].length;
        int S[][] = new int[R][C];
        System.out.println((char) 27 + "[33mYour matrix:" + (char) 27 + "[0m");
        for (i = 0; i < a; i++) {
            for (j = 0; j < b; j++) {
                System.out.print(x[i][j] + "\t");
            }
            System.out.println(" ");
        }
        int max = x[0][0];

        for (i = 0; i < a; i++)
            for (j = 0; j < b; j++)
                if (x[i][j] > max)
                    max = x[i][j];
        int min = x[0][0];
        for (i = 0; i < a; i++)
            for (j = 0; j < b; j++)
                if (x[i][j] < min)
                    min = x[i][j];
        int minimum = max - min;
        for (i = 0; i < a; i++) {
            for (j = 0; j < b; j++) {
                if (minimum > x[i][j]) {
                    minimum = x[i][j];
                }
            }
        }
        System.out.println();
        System.out.println((char) 27 + "[33mSide length of a square: " + (char) 27 + "[0m" + x.length);
        System.out.println((char) 27 + "[33mMaximum difference (max - min): " + (char) 27 + "[0m" + minimum);
        for (i = 0; i < 1; i++) {
            for (j = 0; j < 1; j++) {
                System.out.println((char) 27 + "[33mСoordinates of the upper left corner: " + (char) 27 + "[0m" + "x[" + i + "]" + "[" + j + "]");
            }
        }
    }


    //№8 Prince
    public static void Prince() throws IOException {
        BufferedReader br = null;
        br = new BufferedReader(new FileReader("PadureIn.txt"));
        String[] line;
        for (int i = 0; i < x.length; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < x.length; j++) {
                x[i][j] = Integer.parseInt(line[j]);
            }
        }
        br.close();
        int size = 5;
        int[] preD = new int[size];
        int min = 999, nextNode = 0;
        int[] distance = new int[size];
        int[] visited = new int[size];
        for (i = 0; i < distance.length; i++) {
            visited[i] = 0;
            preD[i] = 0;
        }
        distance = matrix[0];
        visited[0] = 1;
        distance[0] = 0;
        for (int counter = 0; counter < size; counter++) {
            for (i = 0; i < size; i++) {
                if (min > distance[i] && visited[i] != 1) {
                    min = distance[i];
                    nextNode = i;
                }
            }
            visited[nextNode] = 1;
            for (i = 0; i < size; i++) {
                if (visited[i] != 1) {
                    if (min + matrix[nextNode][i] < distance[i]) {
                        distance[i] = min + matrix[nextNode][i];
                        preD[i] = nextNode;
                    }
                }
            }
        }
        System.out.println((char) 27 + "[33mPath to castle:" + (char) 27 + "[0m");
        for (i = 0; i < size; i++) {
            System.out.print("|" + distance[i]);
            System.out.print("|");
        }
        System.out.println(" ");
        int d = 1;
        File f = new File("PadureOut.txt");
        if (!f.exists()) {
            f.createNewFile();
        }
        PrintWriter pw = new PrintWriter(f);
        if (i != i + 1) {
            d++;
        }
        pw.print(d);
        pw.println();
        pw.close();
        System.out.print("Diamonds:" + d);
    }
}