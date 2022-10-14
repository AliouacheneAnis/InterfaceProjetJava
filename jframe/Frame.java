/*
  Titre      : Interface Capteur Temperature en utilisant swing 
  Auteur     : Anis Aliouachene
  Date       : 2022/10/2022
  Description: Creer une interface graphique qui va servir prochainement pour recuperer a partir de  la base de donnees 
  et les afficher 
  Version    : 0.0.2
*/


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.jdatepicker.*;

// class 
public class Frame
        extends JFrame
        implements ActionListener {

    // Declaration 
    private Container c;
    private JLabel title;
    private JLabel name;
    private JTextField tname;
    private JLabel from;
    private JLabel to;
    private JComboBox date;
    private JComboBox month;
    private JComboBox year;
    private JComboBox date2;
    private JComboBox month2;
    private JComboBox year2;
    private JButton sub;
    private JButton reset;
    private JTextArea tout;

    private String dates[] = { "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31" };
    private String months[] = { "Jan", "feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug",
            "Sup", "Oct", "Nov", "Dec" };
    private String years[] = { "1995", "1996", "1997", "1998",
            "1999", "2000", "2001", "2002",
            "2003", "2004", "2005", "2006",
            "2007", "2008", "2009", "2010",
            "2011", "2012", "2013", "2014",
            "2015", "2016", "2017", "2018",
            "2019" };

    // Fonction pour la creation de l'interface 
    public Frame() {

        setTitle("Capteur Temperature");
        setBounds(300, 90, 900, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Capteur Temperature");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        name = new JLabel("ID Capteur");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(100, 100);
        c.add(name);

        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(190, 30);
        tname.setLocation(250, 100);
        c.add(tname);

        from = new JLabel("From");
        from.setFont(new Font("Arial", Font.PLAIN, 20));
        from.setSize(100, 20);
        from.setLocation(100, 150);
        c.add(from);

        date = new JComboBox(dates);
        date.setFont(new Font("Arial", Font.PLAIN, 15));
        date.setSize(50, 20);
        date.setLocation(200, 150);
        c.add(date);

        month = new JComboBox(months);
        month.setFont(new Font("Arial", Font.PLAIN, 15));
        month.setSize(60, 20);
        month.setLocation(250, 150);
        c.add(month);

        year = new JComboBox(years);
        year.setFont(new Font("Arial", Font.PLAIN, 15));
        year.setSize(60, 20);
        year.setLocation(320, 150);
        c.add(year);

        to = new JLabel("To");
        to.setFont(new Font("Arial", Font.PLAIN, 20));
        to.setSize(100, 20);
        to.setLocation(100, 200);
        c.add(to);

        date = new JComboBox(dates);
        date.setFont(new Font("Arial", Font.PLAIN, 15));
        date.setSize(50, 20);
        date.setLocation(200, 200);
        c.add(date);

        month = new JComboBox(months);
        month.setFont(new Font("Arial", Font.PLAIN, 15));
        month.setSize(60, 20);
        month.setLocation(250, 200);
        c.add(month);

        year = new JComboBox(years);
        year.setFont(new Font("Arial", Font.PLAIN, 15));
        year.setSize(60, 20);
        year.setLocation(320, 200);
        c.add(year);

        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 350);
        sub.addActionListener(this);
        c.add(sub);

        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(270, 350);
        reset.addActionListener(this);
        c.add(reset);

        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(200, 300);
        tout.setLocation(500, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        c.add(tout);

        setVisible(true);
    }

    // Fonction avec un listner qui s'execute quand en clique sur le buttoun submit ou reset 
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sub) {
            String Data = "";
            BufferedReader reader;
            try {
                reader = new BufferedReader(new FileReader(
                        "C:/Users/21356/OneDrive - MONCCNB/Desktop/Interface/jframe/data.txt"));
                String line = reader.readLine();
                while (line != null) {
                    Data += line + "\n";
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            tout.setText(Data);

        } else if (e.getSource() == reset) {
            String def = "";
            tname.setText(def);
            tout.setText(def);
            date.setSelectedIndex(0);
            month.setSelectedIndex(0);
            year.setSelectedIndex(0);
        }
    }

}
