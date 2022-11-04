/*
[Name:Zihao Zhang]
[Student ID: 002656320]
 */

import javax.swing.*;
import java.io.*;



public class FileEditor {
    // The content is shown in the left Jarea box
    public void readbox(String fileName,JTextArea area) {
        //
        try {

            // BufferedReader method is to read from csv file
            BufferedReader read_in = new BufferedReader(new FileReader(fileName));
            //Initialize the String to be null
            String five_lines = "<html>";
            int number =0;
            // readLine() method will read one line of the file
            while ((five_lines= read_in.readLine())!=null && number < 5) {
                //Directly append the lines to the display
                area.append(five_lines + "\n");
                five_lines = read_in.readLine();
                number++;
            }
            read_in.close();

        } catch (IOException e) {
            area.setText(e.getMessage() + "ERROR\n");
            e.printStackTrace();
        }
    }
    public void writeText(String fileName,JTextArea area) {
        try { // This method is to write into the third file
            FileWriter display = new FileWriter(fileName);
            display.write(area.getText());
            display.close();
            //Show the error everytime it meets the runtime or file loading exceptions
        } catch (IOException e) {
            area.setText(e.getMessage() + "ERROR\n");
            e.printStackTrace();
        }
    }





    public void writebox(String fileName,JTextArea area) {
        try {
            //use this method to read in the file in the left box and show in the right box
            BufferedReader read_in = new BufferedReader (new FileReader(fileName));
            String five_lines = read_in.readLine();

            //use two for loops to traverse
            for (int number =0;five_lines!= null && number != 5;number++) {
                String[] str = five_lines.split(",");
                // read the 3 columns from the first 5 lines
                for(int field = 0; field < 2;field++) {
                    area.append(str[field] + ",");
                }
                    area.append(str[2]);
                    area.append("\n");
                    five_lines = read_in.readLine();
            }
            read_in.close();
        }  catch (IOException e) {
            area.setText("ERROR\n");
            e.printStackTrace();
        }
    }
}