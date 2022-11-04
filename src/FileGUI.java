import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileGUI implements ActionListener {
    //Create a new object called fileEditor of FileEditor Class
    FileEditor fileEditor = new FileEditor();
    //Create all the elements in the GUI
    static JTextField field;
    static JFrame frame;
    static JPanel panel;
    static JLabel lable_top_left,lable_instream,lable_top_right;
    static JButton button1, button2;
    static JTextArea area1, area2;


    FileGUI(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        //To adjust the panel layout to be null is vital
        panel.setLayout(null);
//create all the elements in the panel and field and add them to the display area
        lable_top_left = new JLabel("Reading File Name");
        lable_instream = new JLabel("annual.csv");
        lable_top_right = new JLabel("File name to write");
        area1 = new JTextArea();
        area2 = new JTextArea();
        area1.setLineWrap(true);
        area2.setLineWrap(true);
        field = new JTextField();
        button1 = new JButton("Click to read from file");
        button2 = new JButton("Click to write to file");
        button1.addActionListener(this);
        button2.addActionListener(this);

//adjust the format and size
        panel.setBounds(0,0,800,800);
        lable_top_left.setBounds(20,0,200,75);
        lable_instream.setBounds(20,100,200,75);
        lable_top_right.setBounds(500,0,200,75);
        area1.setBounds(20,275,400,350);
        area2.setBounds(500,275,400,350);
        field.setBounds(500,125,200,30);
        button1.setBounds(20,200,300,50);
        button2.setBounds(500,200,300,50);




        frame.setLayout(null);frame.add(panel);
        frame.setLayout(null);
        frame.setSize(900,900);
        frame.setResizable(false);//Set size
        frame.setVisible(true);
        frame.add(lable_top_left);
        frame.add(lable_instream);
        frame.add(lable_top_right);
        frame.add(button1);
        frame.add(button2);
        frame.add(area1);
        frame.add(area2);
        frame.add(field);
        frame.add(panel);
        panel.add(lable_top_left);
        panel.add(lable_instream);
        panel.add(lable_top_right);
        panel.add(button1);
        panel.add(button2);
        panel.add(area1);
        panel.add(area2);
        panel.add(field);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String fileName = field.getText();
        if(e.getSource() == button1){
            fileEditor.readbox("C:\\Users\\DELL\\IdeaProjects\\TextFile\\src\\annual.csv",area1);
            //call directly to where the file is located
        }
        if(e.getSource() == button2){
            //run two methods to write the lines from instream file
            fileEditor.writeText(fileName,area1);
            fileEditor.writebox( fileName,area2);
        }
    }
}