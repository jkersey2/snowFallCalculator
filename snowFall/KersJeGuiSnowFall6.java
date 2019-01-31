/*
 *Program Name: KersJeGuiHighLowTemp
 * Author: Jeff Kersey
 * Date Written: 6/14/2017
 * Class Name: CIT 149 Java 1
 * Description: This program uses a gui to present the user with a JComboBox from which they may select a year
 * between 1951 - 2016. The program then displays an average daily temp for that year in the month of January,
 * as well as a total average for all years for the month of January.
 * The user may click the exit button to end the program. 
 */


import static java.util.Arrays.asList;
//import java.util.ArrayList;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.DoubleStream;

    public class KersJeGuiSnowFall6 extends JFrame 
    {
    
     private int row;
     private double[][] allMonths;
     private String[] years;
     private int[][] yearLargest;
     private double[][] snowJan;
     private double[][] snowFeb;
     private double snowMar[][];
     public String myAvg;
     JTextField snowOne;
     JTextField snowTwo;
     JTextField snowThree;
     JTextField totalSnow;
     JTextField greatestSnow;
     JTextField snowYear;
     JTextField periodAvg;
     JButton exitButton;
     private JComboBox comboBox;  
     private double avg1; 
     
    public static void main(final String args[]) {
       //   A main routine allows this class to be run as an application.
        KersJeGuiSnowFall6 content = new KersJeGuiSnowFall6();
          
    }
    public KersJeGuiSnowFall6(){
         

        years = new String[]
           {"1952", "1953", "1954", "1955", 
            "1956", "1957", "1958", "1959", 
            "1960", "1961", "1962", "1963", 
            "1964", "1965", "1966", "1967",
            "1968", "1969", "1970", "1971",
            "1972", "1973", "1974", "1975", 
            "1976", "1977", "1978", "1979",
            "1980", "1981", "1982", "1983",
            "1984", "1985", "1986", "1987", 
            "1988", "1989", "1990", "1991", 
            "1992", "1993", "1994", "1995",
            "1996", "1997", "1998", "1999",
            "2000", "2001", "2002", "2003",
            "2004", "2005", "2006", "2007",
            "2008", "2009", "2010", "2011",
            "2012", "2013", "2014", "2015", 
            "2016"};

        snowJan = new double[][] {
             {3.9}, {0.0}, {0.0}, {2.8}, 
             {0.0}, {0.0}, {0.0}, {0.0},
             {0.0}, {0.0}, {0.0}, {0.0},
             {0.0}, {5.3}, {0.0}, {2.0},
             {0.5}, {7.2}, {4.5}, {8.5},
             {6.0}, {1.0}, {1.3}, {0.3},
             {1.5}, {0.0}, {8.0}, {17.5},
             {0.0}, {3.5}, {1.0}, {3.0},
             {3.3}, {30.5}, {0.0},{0.0},
             {0.0}, {4.6}, {0.0}, {1.8},
             {0.0}, {2.5}, {2.1}, {0.0},
             {0.0}, {0.0}, {0.0}, {0.0},
             {0.0}, {0.0}, {0.0}, {0.0},
             {0.7}, {0.0}, {7.2}, {1.1},
             {0.2}, {0.3}, {5.2}, {2.0},
             {1.2}, {0.4}, {0.0}, {11.5},
             {9.9}
            };
            
       snowFeb =  new double[][] {
             {0.0}, {0.0}, {0.0}, {5.5},
             {0.0}, {0.0}, {0.0}, {0.0},
             {0.0}, {0.0}, {0.0}, {0.0},
             {0.0}, {5.3}, {0.0}, {2.0},
             {0.5}, {7.2}, {4.5}, {8.5},
             {6.0}, {1.0}, {1.3}, {0.3},
             {1.5}, {0.0}, {8.0},{17.5},
             {0.0}, {3.5}, {1.0}, {3.0},
             {3.3}, {30.5},{0.0}, {0.0},
             {0.0}, {4.6}, {0.0}, {1.8},
             {0.0}, {2.5}, {2.1}, {0.0},
             {0.0}, {0.0}, {0.0}, {0.0},
             {0.0}, {0.0}, {0.0}, {0.0},
             {0.7}, {0.0}, {7.2}, {1.1},
             {0.2}, {0.3}, {5.2}, {2.0},
             {1.2}, {0.4}, {0.0}, {11.5},
             {9.9}
    };
            
     snowMar = new double[][] {
             {2.9}, {0.0}, {0.0}, {0.0},
             {0.0}, {0.0}, {0.0}, {0.0},
             {0.0}, {0.0}, {0.0}, {3.5},
             {0.0}, {0.6}, {0.0}, {0.0},
             {2.0}, {0.0}, {0.0}, {0.6},
             {2.0}, {0.5}, {0.0}, {0.0},
             {4.0}, {0.0}, {0.0}, {4.0},
             {0.0}, {2.5}, {0.0}, {0.0},
             {0.0}, {0.0}, {0.0}, {0.0},
             {0.0}, {0.0}, {0.0}, {0.0},
             {0.8}, {0.0}, {1.7}, {3.5},
             {2.5}, {0.0}, {0.0}, {0.0},
             {0.0}, {0.0}, {0.0}, {0.0},
             {0.0}, {0.8}, {0.0}, {0.0},
             {3.2}, {0.3}, {0.0}, {0.0},
             {0.0}, {1.3}, {3.1}, {4.0},
             {0.0} 
    };
       allMonths = new double[][] { 
             {3.9, 0.0, 2.9}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {2.8, 5.5, 0.0},
             {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0},
             {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 3.5}, 
             {0.0, 0.0, 0.0}, {5.3, 5.3, 0.6}, {0.0, 0.0, 0.0}, {2.0, 2.0, 0.0}, 
             {0.5, 0.5, 2.0}, {7.2, 7.2, 0.0}, {4.5, 4.5, 0.0}, {8.5, 8.5, 0.6},
             {6.0, 6.0, 2.0}, {1.0, 1.0, 0.5}, {1.3, 1.3, 0.0}, {0.3, 0.3, 0.0},
             {1.5, 1.5, 4.0}, {0.0, 0.0, 0.0}, {8.0, 8.0, 0.0}, {17.5, 17.5, 4.0},
             {0.0, 0.0, 0.0}, {3.5, 3.5, 2.5}, {1.0, 1.0, 0.0}, {3.0, 3.0, 0.0},
             {3.3, 3.3, 0.0}, {30.5, 30.5, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0},
             {0.0, 0.0, 0.0}, {4.6, 4.6, 0.0}, {0.0, 0.0, 0.0}, {1.8, 1.8, 0.0}, 
             {0.0, 0.0, 0.0}, {2.5, 2.5, 0.0}, {2.1, 2.1, 1.7}, {0.0, 0.0, 3.5},
             {0.0, 0.0, 2.5}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0},
             {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0},
             {0.7, 0.7, 0.0}, {0.0, 0.0, 0.8}, {7.2, 7.2, 0.0}, {1.1, 1.1, 0.0},
             {0.2, 0.2, 3.2}, {0.3, 0.3, 0.3}, {5.2, 5.2, 0.0}, {2.0, 2.0, 0.0},
             {1.2, 1.2, 0.0}, {0.4, 0.4, 1.3}, {0.0, 0.0, 3.1}, {11.5, 11.5, 4.0},
             {9.9, 9.9, 0.0}
        };
            
      yearLargest  = new int[][] {
             {1952}, {1953}, {1954}, {1955}, 
            {1956}, {1957}, {1958}, {1959}, 
            {1960}, {1961}, {1962}, {1963}, 
            {1964}, {1965}, {1966}, {1967},
            {1968}, {1969}, {1970}, {1971},
            {1972}, {1973}, {1974}, {1975}, 
            {1976}, {1977}, {1978}, {1979},
            {1980}, {1981}, {1982}, {1983},
            {1984}, {1985}, {1986}, {1987}, 
            {1988}, {1989}, {1990}, {1991}, 
            {1992}, {1993}, {1994}, {1995},
            {1996}, {1997}, {1998}, {1999},
            {2000}, {2001}, {2002}, {2003},
            {2004}, {2005}, {2006}, {2007},
            {2008}, {2009}, {2010}, {2011},
            {2012}, {2013}, {2014}, {2015}, 
            {2016}
      };
             
        
      ArrayList<String> yearList = new ArrayList<>(asList(
            "1952", "1953", "1954", "1955", 
            "1956", "1957", "1958", "1959", 
            "1960", "1961", "1962", "1963", 
            "1964", "1965", "1966", "1967",
            "1968", "1969", "1970", "1971",
            "1972", "1973", "1974", "1975", 
            "1976", "1977", "1978", "1979",
            "1980", "1981", "1982", "1983",
            "1984", "1985", "1986", "1987", 
            "1988", "1989", "1990", "1991", 
            "1992", "1993", "1994", "1995",
            "1996", "1997", "1998", "1999",
            "2000", "2001", "2002", "2003",
            "2004", "2005", "2006", "2007",
            "2008", "2009", "2010", "2011",
            "2012", "2013", "2014", "2015", 
            "2016"));
      
      
            JFrame frame = new JFrame("Average Snowfall");
            frame.pack();
            JPanel panelOne = new JPanel();
            
            frame.setLayout(new BorderLayout());
            
            JPanel panelTwo = new JPanel();
           
            panelOne.add(new JLabel("Average January Temps for Somerset KY"));
            
            panelTwo.add(new JLabel("Select a Year"));
            
            JPanel panelThree = new JPanel();
           
           
            JLabel resultTemp = new JLabel();
            JLabel tempNum = new JLabel();
            
            JButton exitButton = new JButton("Exit");
            panelThree.add(exitButton);
            exitButton.addActionListener(new ButtonListener());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(panelOne, BorderLayout.CENTER);
            
            JComboBox<String> comboBox = new JComboBox<>(years); // Added String type to the declaration  to match the array data. 
            comboBox.setMaximumRowCount(5);                     // Without it a cast will be necessary every time a value is retrieved from comboBox.
            panelTwo.add(comboBox);
            
            panelTwo.add(new JLabel("Snowfall that year in Jan:"));
            snowOne = new JTextField(3); //Uneditable text field
            snowOne.setEditable(false); 
            panelTwo.add(snowOne); 
            
            panelTwo.add(new JLabel("Snowfall that year in Feb: "));
            snowTwo = new JTextField (3);
            snowTwo.setEditable(false);
            panelTwo.add(snowTwo);
            
            
            panelTwo.add(new JLabel ("Snowfall that year in March: "));
            snowThree = new JTextField (3);
            snowThree.setEditable(false);
            panelTwo.add(snowThree);
            
            
            panelTwo.add(new JLabel("Total snowfall for all three months: "));
            totalSnow = new JTextField (3);
            totalSnow.setEditable(false);
            panelTwo.add(totalSnow);
            
            panelTwo.add(new JLabel("The greatest total snowfall for this period was: "));
            greatestSnow = new JTextField (3);
            greatestSnow.setEditable(false);
            panelTwo.add(greatestSnow);
            
            panelTwo.add(new JLabel ("This occurred in the year: "));
            snowYear = new JTextField (4);
            snowYear.setEditable(false);
            panelTwo.add(snowYear);
            
            panelTwo.add(new JLabel ("Average snowfall for all years this period: "));
            periodAvg = new JTextField (2);
            periodAvg.setEditable(false);
            panelTwo.add(periodAvg);
            
            panelTwo.add(new JLabel("All Measurements In Inches"));
            
            
            frame.setSize(350, 300);
            frame.setLocation(350, 420);
            frame.setVisible(true);
            frame.getRootPane().setDefaultButton(exitButton); // This allows you to exit by pressing enter.
            frame.add(panelOne, BorderLayout.NORTH);
            frame.add(panelTwo, BorderLayout.CENTER);
            frame.add(panelThree, BorderLayout.SOUTH);
                                 
            comboBox.addActionListener(new ActionListener()                           
            {
            @Override
            
    public void actionPerformed(ActionEvent e) 
    {
       
        int menuChoice =  comboBox.getSelectedIndex(); // 
        double dOne = DoubleStream.of(snowJan[menuChoice]).sum(); // Calls same comboBox index value from highLowTemp array
        double dTwo = DoubleStream.of(snowFeb[menuChoice]).sum();
        double dThree = DoubleStream.of(snowMar[menuChoice]).sum();
         
        double sum = (dOne + dTwo + dThree);
        
        snowOne.setText(String.format("%.1f", dOne));                                     
        snowTwo.setText(String.format("%.1f", dTwo));
        snowThree.setText(String.format("%.1f", dThree));
        totalSnow.setText(String.format("%.1f", sum));
     /*         
        double maxSum = 0;
        int maxRow;
        for (int row = 0; row < allMonths.length; row++){
            double rowSum = 0;
            for (int column = 0; column < allMonths[row].length; column++){
        rowSum += allMonths[row][column];
        }
            if (rowSum > maxSum)
                maxSum = rowSum;
                maxRow = row;*/
        
        double maxVal = -99999;
for(int row = 0; row < allMonths.length; row++)
    {
        for(int col = 0; col < allMonths[row].length; col++)
        {
            if(allMonths[row][col] > maxVal)
            {
                maxVal = allMonths[row][col];
                allMonths[0] = row;
                allMonths[1] = col;
            }
        }
    }
       greatestSnow.setText(String.format("%.1f", maxIndex));
       
       //snowYear.setText(String.format());
       System.out.println(String.format(".1f",maxIndex));
       double totalAvg = Arrays.stream(allMonths).flatMapToDouble(Arrays::stream).average().getAsDouble(); 
       periodAvg.setText(String.format("%.1f", totalAvg));
     }
    
});
    }
    private class ButtonListener implements ActionListener { // inner class ActionListener for exit button.
        
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
       