package UASPL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;


public class ProgramAntrianQueue {
    private JPanel rootPanel;
    private JTextArea textAntrian;
    private JTextField JmlhAntrian;
    private JTextField TotAntrian;
    private JTextField PglAntrian;
    private JButton prosesAntrianButton;
    private JButton ambilNomorAntrianButton;
    private JLabel txtAtas2;
    private JLabel txtAtas1;
    private JLabel txtAtas3;
    private JLabel txtAtas4;
    private JButton keluarButton;


    Queue<Object> antrian = new LinkedList<>();
    int nomor = 0;

    public ProgramAntrianQueue() {
        prosesAntrianButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prosesAntrian();
            }
        });
        ambilNomorAntrianButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tambahAntrian();
            }
        });
        keluarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }

    public void queue() {

        inisialisasi();
    }

    private void inisialisasi(){
        JmlhAntrian.setText("0");
        TotAntrian.setText("0");
        PglAntrian.setText("-----");


        txtAtas1.setText("Nomor Antrian");
        txtAtas2.setText("--------");
        txtAtas3.setText("Silahkan menunggu");
        txtAtas4.setText("--------");
    }
    private void tambahAntrian(){
        nomor++;
        String antr = "Antrian "+nomor;
        antrian.add(antr);
        String cvt = String.valueOf(antrian.size());
        JmlhAntrian.setText(cvt);
        PglAntrian.setText(""+antrian.peek());
        TotAntrian.setText(""+nomor);
        textAntrian.append(antr + "\n");


        txtAtas1.setText("Nomor Antrian");
        txtAtas2.setText("  " + nomor);
        txtAtas3.setText("Silahkan menunggu " + cvt + " Antrian Lagi ");
        txtAtas4.setText("Mohon untuk bersabar");
    }
    private void prosesAntrian(){
        if(antrian.isEmpty()){
            JOptionPane.showMessageDialog(null, "Ambil Nomor antrian terlebih dahulu !");
        }
        textAntrian.setText("");
        antrian.poll();
        antrian.forEach((Object element) -> {
            textAntrian.append("" + element + "\n");
        });
        if(antrian.isEmpty()){
            PglAntrian.setText("-----");
        }else{
            PglAntrian.setText(""+antrian.peek());
        }
    }

    public JPanel getRootPanel () {
        return rootPanel;
    }

}
