import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class MyApp extends JFrame { //extending the JFrame I describe the functionality of the window

    static int[][] x;
    static int[] array;
    static int i, j, size = 5, D = 1;
    static int[] distance = new int[size];
    static String[] line;
    static String message = " ", mess1 = " ", mess2 = " ", mes = " ";
    public static JMenuBar menuBar; //menu
    public static DefaultTableModel model; //data from matrix
    public static JTable matrix; //matrix
    public static JPanel panel; //panel with table
    public static int openedFile = 0; //to not open again file
    public static Color color = (Color.WHITE); //start color

    //main
    public static void main(String[] args) {
        MyApp app = new MyApp();
        app.setVisible(true);
    }

    public void createPanel() {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(15, 15, 15, 15, new ImageIcon("images/border1.jpg")), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        panel.setVisible(false);
        add(panel);
    }

    public MyApp() {
        super("Fairy forest"); //move to the main constructor and pass the name of the form
        this.setBounds(600, 300, 500, 280);
        ImageIcon icon = new ImageIcon("images/les.png");
        setIconImage(icon.getImage());
        setLayout(new BorderLayout());
        createMenu(); //opens menu
        createPanel(); //opens matrix
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close the window and program
    }

    public void createMenu() {
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("File"); //file
        menuBar.add(fileMenu);
        JMenu openMenu = new JMenu("Open");
        fileMenu.add(openMenu);
        JMenuItem Forest = new JMenuItem("Forest.txt");
        Forest.addActionListener(new ReadForest());
        openMenu.add(Forest);
        JMenu ParCol = new JMenu("ParCol.txt");
        openMenu.add(ParCol);
        JMenuItem createParCol = new JMenuItem("create");
        createParCol.addActionListener(new ParCol());
        ParCol.add(createParCol);
        JMenuItem openParCol = new JMenuItem("open");
        openParCol.addActionListener(new ReadParCol());
        ParCol.add(openParCol);
        JMenuItem closeParCol = new JMenuItem("close");
        closeParCol.addActionListener(new Close());
        ParCol.add(closeParCol);
        JMenuItem PadureIn = new JMenuItem("PadureIn.txt");
        PadureIn.addActionListener(new ReadPadureIn());
        openMenu.add(PadureIn);
        JMenuItem PadureOut = new JMenuItem("PadureOut.txt");
        PadureOut.addActionListener(new ReadPadureOut());
        openMenu.add(PadureOut);
        JMenuItem save = new JMenuItem("Save");
        save.addActionListener(new Save());
        fileMenu.add(save);
        JMenuItem close = new JMenuItem("Close");
        close.addActionListener(new Close());
        fileMenu.add(close);
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(new Exit());
        fileMenu.add(exit);
        JMenu editMenu = new JMenu("Edit"); //edit
        editMenu.setEnabled(false);
        menuBar.add(editMenu);
        JMenuItem swap = new JMenuItem("Swap");
        swap.addActionListener(new Swap());
        editMenu.add(swap);
        JMenuItem sequence = new JMenuItem("Sequence");
        sequence.addActionListener(new Sequence());
        editMenu.add(sequence);
        JMenuItem remove = new JMenuItem("Remove column");
        remove.addActionListener(new Column());
        editMenu.add(remove);
        JMenu findMenu = new JMenu("Find"); //find
        findMenu.setEnabled(false);
        menuBar.add(findMenu);
        JMenuItem arrayB = new JMenuItem("Array");
        arrayB.addActionListener(new Array());
        findMenu.add(arrayB);
        JMenuItem percent = new JMenuItem("Percentage");
        percent.addActionListener(new Percentage());
        findMenu.add(percent);
        JMenuItem square = new JMenuItem("Square");
        square.addActionListener(new Square());
        findMenu.add(square);
        JMenuItem path = new JMenuItem("Path to castle");
        path.addActionListener(new Path());
        findMenu.add(path);
        JMenu viewMenu = new JMenu("View"); //view
        viewMenu.setEnabled(false);
        menuBar.add(viewMenu);
        JMenuItem colorize = new JMenuItem("Colorize 0");
        colorize.addActionListener(new Colorize());
        viewMenu.add(colorize);
        JMenuItem color = new JMenuItem("Change background color");
        color.addActionListener(new BackgroundColor());
        viewMenu.add(color);
        JMenu helpMenu = new JMenu("Help"); //help
        helpMenu.setEnabled(true);
        menuBar.add(helpMenu);
        JMenu htOpen = new JMenu("about files");
        helpMenu.add(htOpen);
        JMenuItem hteditForest = new JMenuItem("how to edit Forest.txt");
        hteditForest.addActionListener(new hteditForest());
        htOpen.add(hteditForest);
        JMenuItem htSave = new JMenuItem("how to save Forest.txt");
        htSave.addActionListener(new htSave());
        htOpen.add(htSave);
        JMenuItem htOpenParCol = new JMenuItem("how to open ParCol.txt");
        htOpenParCol.addActionListener(new htOpenParCol());
        htOpen.add(htOpenParCol);
        JMenuItem htChange = new JMenuItem("how to change background color");
        htChange.addActionListener(new htChange());
        htOpen.add(htChange);
        JMenuItem creator = new JMenuItem("about creator");
        creator.addActionListener(new abCreator());
        helpMenu.add(creator);
        JMenuItem program = new JMenuItem("about program");
        program.addActionListener(new abProgram());
        helpMenu.add(program);
    }

    //№1 Swap 2 rows
    static class Swap implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int nr = model.getRowCount();
            int nc = model.getColumnCount();
            int c, v, g;
            Vector<String> row = new Vector<String>(nc);
            String result1 = JOptionPane.showInputDialog("<html><h2>Input 1 row-number</h2>");
            String result2 = JOptionPane.showInputDialog("<html><h2>Input 2 row-number</h2>");
            try {
                c = Integer.parseInt(result1);
                v = Integer.parseInt(result2);
            } catch (NumberFormatException ev) {
                c = -1;
                v = -1;
            }
            if (c > nc || v > nc || c == -1 || v == -1)
                JOptionPane.showMessageDialog(null, "<html><h2>Invalid column number!</h2>", "Error!", JOptionPane.ERROR_MESSAGE);
            else {
                for (i = 0; i < nc; i++) {
                    g = x[(c - 1)][i];
                    x[c - 1][i] = x[(v - 1)][i];
                    x[v - 1][i] = g;
                }
                mes += "Matrix\n";
                for (i = 0; i < nr; i++) {
                    for (j = 0; j < nc; j++) {
                        mes += "\t";
                        mes += x[i][j];
                    }
                    mes += " ";
                    mes += "\n";
                }
                JOptionPane.showMessageDialog(null, mes, "After interchanging " + c + " and " + v, JOptionPane.INFORMATION_MESSAGE);

            }
        }
    }

    //№2 Delete a column
    static class Column implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String result = JOptionPane.showInputDialog("<html><h2>Input column number</h2>");
            int NrCol;
            try {
                NrCol = Integer.parseInt(result);
            } catch (NumberFormatException ev) {
                NrCol = -1;
            }
            if (NrCol == -1 || NrCol > model.getColumnCount())
                JOptionPane.showMessageDialog(null, "<html><h2>You can delete only west or east column!</h2>", "Error!",
                        JOptionPane.ERROR_MESSAGE);
            else if (NrCol == 1 || NrCol == model.getColumnCount()) {
                for (int i = NrCol - 1; i < model.getColumnCount() - 1; i++)
                    matrix.moveColumn(i, i + 1);
                model.setColumnCount(model.getColumnCount() - 1);
                matrix.setModel(model);
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                for (int i = 0; i < model.getColumnCount(); i++)
                    matrix.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            } else
                JOptionPane.showMessageDialog(null, "<html><h2>You can delete only west or east column!</h2>", "Error!",
                        JOptionPane.ERROR_MESSAGE);

        }
    }

    //№3 The longest non-decreasing sequence
    static class Sequence implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String result = JOptionPane.showInputDialog("<html><h2>Input column number</h2>");
            int m, count = 1, max = 0;
            int nr = model.getRowCount();
            try {
                m = Integer.parseInt(result);
                m--;
            } catch (NumberFormatException ev) {
                m = -1;
            }
            if ((m == -1) || (m > nr - 1))
                JOptionPane.showMessageDialog(null, "<html><h2>Invalid column number!</h2>", "Error!", JOptionPane.ERROR_MESSAGE);
            else {
                for (i = 0; i < nr - 1; i++) {
                    if ((x[i][m] < x[i + 1][m]) || (x[i][m] == x[i + 1][m])) {
                        count++;
                    } else if (count > max) {
                        max = count;
                        count = 1;
                    }
                }
                JOptionPane.showMessageDialog(null, Integer.toString(max), "Sequence", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    //№4 Array sort
    public static class Array implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int nr = model.getRowCount();
            int nc = model.getRowCount();
            int k = 0;
            array = new int[nc + 1];
            for (i = nc - 1; i < nr; i++) {
                for (j = 0; j < nc; j++) {
                    k += 1;
                    array[k] = x[i][j];
                }
            }
            for (k = 1; k < nc + 1; k++) {
                mess1 += array[k] + " ";
            }
            Arrays.sort(array);
            for (k = 1; k < nc + 1; k++) {
                mess2 += array[k] + " ";
            }
            JOptionPane.showMessageDialog(null, "Unsorted array: " + mess1 + "\nSorted array: " + mess2, "Last row sorting", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //№5 Zone percentage
    static class Percentage implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String result = JOptionPane.showInputDialog("<html><h2>Enter a zone-number</h2>");
            float number, r;
            int nr = model.getRowCount();
            int nc = model.getRowCount();
            int k = 0, zones = 0;
            number = Integer.parseInt(result);
            for (i = 0; i < nr; i++) {
                for (j = 0; j < nc; j++) {
                    zones = x[i].length * x[j].length;
                    if (x[i][j] == number) {
                        k++;
                    }
                }
            }
            r = zones * k / 100.f;
            JOptionPane.showMessageDialog(null, Float.toString(r) + "%", (int) number + " from " + nr * nc, JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //№6 Create ParCol
    static class ParCol implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            BufferedReader br = null;
            File f = new File("ParCol.txt");
            if (!f.exists()) {
                try {
                    f.createNewFile();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            PrintWriter pw = null;
            try {
                pw = new PrintWriter(f);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            for (int i = 0; i < x.length; i++) {
                for (int j = 0; j < x.length; j++) {
                    if (j % 2 != 0) {
                        pw.print(x[i][j] + " ");
                    }
                }
            }
            pw.close();
        }
    }

    //№7 Square
    static class Square implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int nr = model.getRowCount();
            int nc = model.getColumnCount();
            int max = x[0][0];
            for (i = 0; i < nr; i++)
                for (j = 0; j < nc; j++)
                    if (x[i][j] > max)
                        max = x[i][j];
            int min = x[0][0];
            for (i = 0; i < nr; i++)
                for (j = 0; j < nc; j++)
                    if (x[i][j] < min)
                        min = x[i][j];
            int minimum = max - min;
            for (i = 0; i < nr; i++) {
                for (j = 0; j < nc; j++) {
                    if (minimum > x[i][j]) {
                        minimum = x[i][j];
                    }
                }
            }
            String message = " ";
            message += "Side length of a square: " + nc + "\n";
            message += "Maximum difference (max - min): " + minimum + "\n";
            for (i = 0; i < 1; i++) {
                for (j = 0; j < 1; j++) {
                    message += "Coordinates of the upper left corner: mtr[" + i + "][" + j + "]\n";
                }
            }
            JOptionPane.showMessageDialog(null, message, "Square", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("images/square.png"));
        }
    }

    //№8 Path to castle
    static class Path implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader("PadureIn.txt"));
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            int size = 5;
            int[] preD = new int[size];
            int min = 999, nextNode = 0; // min holds the minimum value, nextNode holds the value for the next node.
            int[] distance = new int[size]; // the distance matrix
            int[][] matrix = {
                    {6, 5, 1, 1, 5, 4,},
                    {0, 0, 0, 5, 6},
                    {7, 7, 1, 1, 1},
                    {1, 1, 1, 3, 1},
                    {1, 1, 2, 2, 1},
                    {0, 0, 9, 0, 0},
                    {0, 0, 0, 0, 9}
            };
            int[] visited = new int[size]; // the visited array
            for (i = 0; i < distance.length; i++) {
                visited[i] = 0; //initialize visited array to zeros
                preD[i] = 0;
            }
            distance = matrix[0]; //initialize the distance array
            visited[0] = 1; //set the source node as visited
            distance[0] = 0; //set the distance from source to source to zero which is the starting point
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
                            if (distance[i] != distance[i + 1]) {
                                D++;
                            }
                        }
                    }
                }
            }
            for (i = 0; i < size; i++) {
                message += "|" + distance[i] + "|";
            }
            JOptionPane.showMessageDialog(null, " Path:\n" + message + "\nDiamonds:\n" + D, "Path to castle", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("images/castle.png"));
        }
    }

    //colorize 0
    static class Colorize implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            matrix.setVisible(false);
            for (int i = 0; i < matrix.getColumnCount(); i++)
                matrix.getColumnModel().getColumn(i).setCellRenderer(new TableInfoRenderer());
            matrix.setVisible(true);
        }
    }

    public static class TableInfoRenderer extends DefaultTableCellRenderer {
        private static final long serialVersionUID = 1L;

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            JComponent jc = (JComponent) comp;
            Object val = table.getModel().getValueAt(row, column);
            if (Integer.parseInt(val.toString()) == 0) {
                jc.setBackground(Color.green);
            } else {
                jc.setBackground(table.getBackground());
            }
            setHorizontalAlignment(CENTER);
            return jc;
        }
    }

    //background color
    class BackgroundColor implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            panel.setBackground(color);
            color = JColorChooser.showDialog(null, "pick your color", color);
            if (color == null) color = (Color.white);
            panel.setBackground(color);

        }
    }

    //read Forest
    static class ReadForest implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ReadFromFile("C:\\Users\\Daria.Stanilevici\\IdeaProjects\\FairyForest\\Forest.txt");
            for (int i = 1; i < MyApp.menuBar.getMenuCount(); i++)
                MyApp.menuBar.getMenu(i).setEnabled(true);
        }

        public void ReadFromFile(String fileName) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                File f = new File(fileName);
                Scanner sc = new Scanner(f);
                int nr = sc.nextInt();
                int nc = sc.nextInt();
                x = new int[nr][nc];
                for (int i = 0; i < nr; i++)
                    for (int j = 0; j < nc; j++)
                        x[i][j] = sc.nextInt();
                sc.close();
                //convert integer to string matrix
                String mdString[][] = new String[nr][nc];
                for (int i = 0; i < nr; i++)
                    for (int j = 0; j < nc; j++)
                        mdString[i][j] = Integer.toString(x[i][j]);
                for (int i = 0; i < nr; i++) {
                    for (int j = 0; j < nc; j++) {
                        System.out.print(x[i][j] + "\t");
                    }
                    System.out.println("");
                }
                //create tables with a title
                String[] header = new String[nc];
                for (int i = 0; i < nc; i++)
                    header[i] = Integer.toString(i + 1); //so that the numbering of columns from 1 is

                if (MyApp.openedFile == 0) { //if the matrix is ​​open, it is created once
                    model = new DefaultTableModel(mdString, header);
                    matrix = new JTable(model);
                    panel.add(new JScrollPane(matrix));
                    MyApp.openedFile++;
                } else { //when you reopen the matrix is ​​redrawn
                    model.setDataVector(mdString, header);
                    matrix.setModel(model);
                }
                //center alignment
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                for (int i = 0; i < nc; i++)
                    matrix.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);

                panel.setVisible(true);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        }
    }

    //read ParCol
    static class ReadParCol implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ReadFromFile("C:\\Users\\Daria.Stanilevici\\IdeaProjects\\FairyForest\\ParCol.txt");
            for (int i = 1; i < MyApp.menuBar.getMenuCount(); i++)
                MyApp.menuBar.getMenu(i).setEnabled(true);
        }

        public void ReadFromFile(String fileName) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                File f = new File(fileName);
                Scanner sc = new Scanner(f);
                int nr = 1;
                int nc = 10;
                x = new int[nr][nc];
                for (int i = 0; i < nr; i++)
                    for (int j = 0; j < nc; j++)
                        x[i][j] = sc.nextInt();
                sc.close();
                String mdString[][] = new String[nr][nc];
                for (int i = 0; i < nr; i++)
                    for (int j = 0; j < nc; j++)
                        mdString[i][j] = Integer.toString(x[i][j]);
                for (int i = 0; i < nr; i++) {
                    for (int j = 0; j < nc; j++) {
                        System.out.print(x[i][j] + "\t");
                    }
                    System.out.println("");
                }
                String[] header = new String[nc];
                for (int i = 0; i < nc; i++)
                    header[i] = Integer.toString(i + 1);

                if (MyApp.openedFile == 0) {
                    model = new DefaultTableModel(mdString, header);
                    matrix = new JTable(model);
                    panel.add(new JScrollPane(matrix));
                    MyApp.openedFile++;
                } else {
                    model.setDataVector(mdString, header);
                    matrix.setModel(model);
                }
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                for (int i = 0; i < nc; i++)
                    matrix.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
                panel.setVisible(true);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        }
    }

    //read PadureIn
    static class ReadPadureIn implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ReadFromFile("C:\\Users\\Daria.Stanilevici\\IdeaProjects\\FairyForest\\PadureIn.txt");
            for (int i = 1; i < MyApp.menuBar.getMenuCount(); i++)
                MyApp.menuBar.getMenu(i).setEnabled(true);
        }

        public void ReadFromFile(String fileName) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                File f = new File(fileName);
                Scanner sc = new Scanner(f);
                int nr = sc.nextInt();
                int nc = sc.nextInt();
                x = new int[nr][nc];
                for (int i = 0; i < nr; i++)
                    for (int j = 0; j < nc; j++)
                        x[i][j] = sc.nextInt();
                sc.close();
                String mdString[][] = new String[nr][nc];
                for (int i = 0; i < nr; i++)
                    for (int j = 0; j < nc; j++)
                        mdString[i][j] = Integer.toString(x[i][j]);
                for (int i = 0; i < nr; i++) {
                    for (int j = 0; j < nc; j++) {
                        System.out.print(x[i][j] + "\t");
                    }
                    System.out.println("");
                }
                String[] header = new String[nc];
                for (int i = 0; i < nc; i++)
                    header[i] = Integer.toString(i + 1);

                if (MyApp.openedFile == 0) {
                    model = new DefaultTableModel(mdString, header);
                    matrix = new JTable(model);
                    panel.add(new JScrollPane(matrix));
                    MyApp.openedFile++;
                } else {
                    model.setDataVector(mdString, header);
                    matrix.setModel(model);
                }
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                for (int i = 0; i < nc; i++)
                    matrix.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);

                panel.setVisible(true);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        }
    }

    //read PardureOut
    static class ReadPadureOut implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ReadFromFile("C:\\Users\\Daria.Stanilevici\\IdeaProjects\\FairyForest\\PadureOut.txt");
            for (int i = 1; i < MyApp.menuBar.getMenuCount(); i++)
                MyApp.menuBar.getMenu(i).setEnabled(true);
        }

        public void ReadFromFile(String fileName) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                File f = new File(fileName);
                Scanner sc = new Scanner(f);
                int nr = 1;
                int nc = 1;
                x = new int[nr][nc];
                for (int i = 0; i < nr; i++)
                    for (int j = 0; j < nc; j++)
                        x[i][j] = sc.nextInt();
                sc.close();
                String mdString[][] = new String[nr][nc];
                for (int i = 0; i < nr; i++)
                    for (int j = 0; j < nc; j++)
                        mdString[i][j] = Integer.toString(x[i][j]);
                for (int i = 0; i < nr; i++) {
                    for (int j = 0; j < nc; j++) {
                        System.out.print(x[i][j] + "\t");
                    }
                    System.out.println("");
                }
                String[] header = new String[nc];
                for (int i = 0; i < nc; i++)
                    header[0] = ("Diamonds");
                if (MyApp.openedFile == 0) {
                    model = new DefaultTableModel(mdString, header);
                    matrix = new JTable(model);
                    panel.add(new JScrollPane(matrix));
                    MyApp.openedFile++;
                } else {
                    model.setDataVector(mdString, header);
                    matrix.setModel(model);
                }
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                for (int i = 0; i < nc; i++)
                    matrix.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);

                panel.setVisible(true);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        }
    }

    //save
    static class Save implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                RewriteInfo("C:\\Users\\Daria.Stanilevici\\IdeaProjects\\FairyForest\\Forest.txt");
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }

        public static void RewriteInfo(String fileName) throws IOException {
            FileWriter writer = new FileWriter(fileName);
            String n = Integer.toString(model.getRowCount());
            String m = Integer.toString(model.getColumnCount());
            writer.write(n + " " + m + "\r\n");
            for (int i = 0; i < model.getRowCount(); ++i, writer.write("\r\n"))
                for (int j = 0; j < model.getColumnCount(); ++j)
                    if (matrix.getModel().getValueAt(i, j) != null)
                        writer.write(matrix.getModel().getValueAt(i, j) + " ");
                    else
                        writer.write("0 ");
            writer.close();
        }
    }

    //exit
    static class Exit implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    //close
    static class Close implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            panel.setVisible(false);
            for (int i = 1; i < MyApp.menuBar.getMenuCount(); i++)
                MyApp.menuBar.getMenu(i).setEnabled(false);
        }
    }

    //help
    static class htOpenParCol implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "1. Open Forest.txt\n2. Create ParCol\n3. Open ParCol", "To open ParCol.txt:", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    static class hteditForest implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "1. Open file Forest.txt\n2. Edit file", "To edit Forest.txt:", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    static class htChange implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "1. Open any file\n2. Press view\n3. Choose and press 'OK'", "To change background color:", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    static class htSave implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Pay attention!\nBefore saving file, make sure, that ParCol is closed", "To save without problems:", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    static class abCreator implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Stanilevich Daria,\nStudent of CEITI.", "Creator:", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    static class abProgram implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "The plan of the Magic Forest of rectangular shape is divided into square zones.\nApplication performs user selectable actions, that can be found in the menu.\nThank you for testing Fairy Forest program!", "About this program:", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}