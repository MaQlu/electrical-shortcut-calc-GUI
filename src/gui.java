import javax.swing.*;
import java.awt.*;

public class gui {
    JFrame f;
    JTextField counttext;
    JTextField Untext;
    JTextField Sktext;
    JTextField Uktext;
    JTextField Pntext;
    JTextField Snttext;
    JTextField Iktext;
    JTextField Xqtext;
    JTextField Rttext;
    JTextField Zttext;
    JTextField Xttext;
    JTextField Rktext;
    JTextField Zktext;
    JTextField Xktext;
    JTextField[] LineRTtext = new JTextField[variables.count];
    JTextField[] LineXTtext = new JTextField[variables.count];
    JTextField[] tfsdlugosc = new JTextField[variables.count];
    JTextField[] tfsgamma = new JTextField[variables.count];
    JTextField[] tfss = new JTextField[variables.count];
    JTextField[] tfsx = new JTextField[variables.count];
    JButton b,eq;
    JCheckBox c1,c2;

    public void guiPanel(){
        //okienko
        f = new JFrame();
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
    }
    public void guiChoice(){
        //wybór
        Label l1 = new Label("Wybierz metodę: ");
        l1.setBounds(10, 10, 200, 10);
        f.add(l1);

        c1 = new JCheckBox("Zwykła");
        c1.setBounds(10, 40, 90, 20);
        f.add(c1);

        c2 = new JCheckBox("Uproszczona");
        c2.setBounds(100, 40, 110, 20);
        f.add(c2);

    }
    public void guiVariables(){
        //zmienna Un
        Label l2 = new Label("Podaj Un: [kV]");
        l2.setBounds(10, 70, 200, 20);
        f.add(l2);

        Untext = new JTextField(17);
        f.add(Untext);
        Untext.setBounds(10, 90, 110, 20);


        //zmienna Sk
        Label l3 = new Label("Podaj S''k: [MVA]");
        l3.setBounds(10, 110, 200, 20);
        f.add(l3);

        Sktext = new JTextField(17);
        f.add(Sktext);
        Sktext.setBounds(10, 130, 110, 20);


        //zmienna Uk
        Label l4 = new Label("Podaj Uk: [%]");
        l4.setBounds(10, 150, 200, 20);
        f.add(l4);

        Uktext = new JTextField(17);
        f.add(Uktext);
        Uktext.setBounds(10, 170, 110, 20);


        //zmienna Pn
        Label l5 = new Label("Podaj Pn: [%]");
        l5.setBounds(10, 190, 200, 20);
        f.add(l5);

        Pntext = new JTextField(17);
        f.add(Pntext);
        Pntext.setBounds(10, 210, 110, 20);


        //zmienna Snt
        Label l6 = new Label("Podaj Snt: [kVA]");
        l6.setBounds(10, 230, 200, 20);
        f.add(l6);

        Snttext = new JTextField(17);
        f.add(Snttext);
        Snttext.setBounds(10, 250, 110, 20);

    }
    public void guiVariablesValue(){

        String UntextIN = Untext.getText();
        if (UntextIN != null && !UntextIN.isEmpty()) {
            variables.Un = Float.parseFloat(UntextIN);
        }

        String SktextIN = Sktext.getText();
        if (SktextIN != null && !SktextIN.isEmpty()) {
            variables.Sk = Float.parseFloat(SktextIN);
        }

        String SnttextIN = Snttext.getText();
        if (SnttextIN != null && !SnttextIN.isEmpty()) {
            variables.Snt = Float.parseFloat(SnttextIN);
        }

        String PntextIN = Pntext.getText();
        if (PntextIN != null && !PntextIN.isEmpty()) {
            variables.Pn = Float.parseFloat(PntextIN);
        }

        String UktextIN = Uktext.getText();
        if (UktextIN != null && !UktextIN.isEmpty()) {
            variables.Uk = Float.parseFloat(UktextIN);
        }

    }
    public void guiLineCount(){
        //zmienna count
        Label l7 = new Label("Podaj ilość linii: ");
        l7.setBounds(250, 10, 100, 20);
        f.add(l7);

        counttext = new JTextField(17);
        f.add(counttext);
        counttext.setBounds(250, 40, 110, 20);
    }
    public void guiLineCountValue(){
        String counttextIN = counttext.getText();
        if (counttextIN != null && !counttextIN.isEmpty()) {
            variables.count = Integer.parseInt(counttextIN);
        }
    }
    public void guiLine(){
        int y=90;

        //długość linii
        tfsdlugosc = new JTextField[variables.count];
        JLabel[] lsdlugosc = new JLabel[variables.count];
        for (int j = 0; j < tfsdlugosc.length; j++) {
            lsdlugosc[j] = new JLabel("l[m] dla linii: "+j);
            f.add(lsdlugosc[j]);
            lsdlugosc[j].setBounds(250,y+20,100,20);

            tfsdlugosc[j] = new JTextField();
            f.add(tfsdlugosc[j]);
            tfsdlugosc[j].setBounds(250,y+40,100,20);
            y+=40;
        }

        y=90;
        Label l8 = new Label("gamma: 33-al,56-cu");
        l8.setBounds(400, 90, 200, 20);
        f.add(l8);

        //gamma linii
        tfsgamma = new JTextField[variables.count];
        JLabel[] lsgamma = new JLabel[variables.count];
        for (int j = 0; j < tfsgamma.length; j++) {

            lsgamma[j] = new JLabel("gamma dla linii: "+j);
            f.add(lsgamma[j]);
            lsgamma[j].setBounds(400,y+20,100,20);

            tfsgamma[j] = new JTextField();
            f.add(tfsgamma[j]);
            tfsgamma[j].setBounds(400,y+40,100,20);
            y+=40;
        }

        //s linii
        y=90;
        tfss = new JTextField[variables.count];
        JLabel[] lss = new JLabel[variables.count];
        for (int j = 0; j < tfss.length; j++) {

            lss[j] = new JLabel("s[mm] dla linii: "+j);
            f.add(lss[j]);
            lss[j].setBounds(550,y+20,100,20);

            tfss[j] = new JTextField();
            f.add(tfss[j]);
            tfss[j].setBounds(550,y+40,100,20);
            y+=40;
        }

        //x linii
        y=90;
        tfsx = new JTextField[variables.count];
        JLabel[] lsx = new JLabel[variables.count];
        for (int j = 0; j < tfsx.length; j++) {

            lsx[j] = new JLabel("x dla linii: "+j);
            f.add(lsx[j]);
            lsx[j].setBounds(700,y+20,100,20);

            tfsx[j] = new JTextField();
            f.add(tfsx[j]);
            tfsx[j].setBounds(700,y+40,100,20);
            y+=40;
        }
    }
    public void guiLineValue(){

        for(int i=0;i< tfsdlugosc.length;i++) {
            String tfsdlugoscIN = tfsdlugosc[i].getText();
            if (tfsdlugoscIN != null && !tfsdlugoscIN.isEmpty()) {
                variables.dlugosc[i] = Float.parseFloat(tfsdlugoscIN);
            }
        }

        for(int i=0;i< tfsgamma.length;i++) {
            String tfsgammaIN = tfsgamma[i].getText();
            if (tfsgammaIN != null && !tfsgammaIN.isEmpty()) {
                variables.gamma[i] = Float.parseFloat(tfsgammaIN);
            }
        }

        for(int i=0;i< tfss.length;i++) {
            String tfssIN = tfss[i].getText();
            if (tfssIN != null && !tfssIN.isEmpty()) {
                variables.s[i] = Float.parseFloat(tfssIN);
            }
        }

        for(int i=0;i< tfsx.length;i++) {
            String tfsxIN = tfsx[i].getText();
            if (tfsxIN != null && !tfsxIN.isEmpty()) {
                variables.xprim[i] = Float.parseFloat(tfsxIN);
            }
        }

    }
    public void guiButtonLines() {
        b = new JButton("Dodaj linie");
        f.add(b);
        b.setBounds(250, 60, 110, 20);

    }
    public void guiButtonEqual(){
        eq = new JButton("Oblicz");
        f.add(eq);
        eq.setBounds(10, 300, 110, 50);
    }

    public void guiResultObwod(){
        //reaktancja
        Label l9 = new Label("Reaktancja obwodu[mΩ]:");
        l9.setBounds(10, 400, 150, 20);
        f.add(l9);

        Xqtext = new JTextField(17);
        Xqtext.setText(Float.toString(variables.xq));
        f.add(Xqtext);
        Xqtext.setBounds(10,420 , 150, 20);
    }
    public void guiResultTransformator(){
        int x=200;
        int y=360;
        //rezystancja
        Label l10 = new Label("Rezystancja transformatora[mΩ]:");
        l10.setBounds(x, y, 200, 20);
        f.add(l10);

        Rttext = new JTextField(17);
        Rttext.setText(Float.toString(variables.rt));
        f.add(Rttext);
        Rttext.setBounds(x,y+=20 , 110, 20);

        //impedancja
        Label l11 = new Label("Impedancja transformatora[mΩ]:");
        l11.setBounds(x, y+=20, 200, 20);
        f.add(l11);

        Zttext = new JTextField(17);
        Zttext.setText(Float.toString(variables.zt));
        f.add(Zttext);
        Zttext.setBounds(x,y+=20 , 110, 20);

        //reaktancja
        Label l12 = new Label("Reaktancja transformatora[mΩ]:");
        l12.setBounds(x, y+=20, 200, 20);
        f.add(l12);

        Xttext = new JTextField(17);
        Xttext.setText(Float.toString(variables.xt));
        f.add(Xttext);
        Xttext.setBounds(x,y+=20 , 110, 20);
    }
    public void guiResultLines(){

        //rezystancja linii
        int y=360;
        LineRTtext = new JTextField[variables.count];
        JLabel[] LineRezystancja = new JLabel[variables.count];
        for (int j = 0; j < variables.count; j++) {
            LineRezystancja[j] = new JLabel("<html>Rezystancja [mΩ] <br> dla linii:"+j+"</html>");
            f.add(LineRezystancja[j]);
            LineRezystancja[j].setBounds(400,y,150,40);

            LineRTtext[j] = new JTextField(17);
            LineRTtext[j].setText(Float.toString(variables.rlArray[j]));
            f.add(LineRTtext[j]);
            LineRTtext[j].setBounds(400, y+40, 110, 20);
            y+=60;
        }

        //reaktancja linii
        y=360;
        LineXTtext = new JTextField[variables.count];
        JLabel[] LineReaktancja = new JLabel[variables.count];
        for (int j = 0; j < variables.count; j++) {
            LineReaktancja[j] = new JLabel("<html>Reaktancja [mΩ] <br> dla linii:"+j+"</html>");
            f.add(LineReaktancja[j]);
            LineReaktancja[j].setBounds(550,y,150,40);

            LineXTtext[j] = new JTextField(17);
            LineXTtext[j].setText(Float.toString(variables.xlArray[j]));
            f.add(LineXTtext[j]);
            LineXTtext[j].setBounds(550, y+40, 110, 20);
            y+=60;
        }

    }
    public void guiResultObwodZwarciowy(){
        int x=700;
        int y=360;

        //rezystancja
        JLabel l10 = new JLabel("<html>Rezystancja obwodu <br> zwarciowego[mΩ]:</html>");
        l10.setBounds(x, y, 200, 40);
        f.add(l10);

        Rktext = new JTextField(17);
        Rktext.setText(Float.toString(variables.rk));
        f.add(Rktext);
        Rktext.setBounds(x,y+=40 , 110, 20);

        //reaktancja
        JLabel l11 = new JLabel("<html>Reaktancja obwodu <br> zwarciowego[mΩ]:</html>");
        l11.setBounds(x, y+20, 200, 40);
        f.add(l11);

        Xktext = new JTextField(17);
        Xktext.setText(Float.toString(variables.xk));
        f.add(Xktext);
        Xktext.setBounds(x,y+=60 , 110, 20);

        //impedancja
        JLabel l12 = new JLabel("<html>Impedancja obwodu <br> zwarciowego[mΩ]:</html>:");
        l12.setBounds(x, y+=20, 200, 40);
        f.add(l12);

        Zktext = new JTextField(17);
        Zktext.setText(Float.toString(variables.zk));
        f.add(Zktext);
        Zktext.setBounds(x,y+=40 , 110, 20);
    }
    public void guiResultIk(){
        Label l8 = new Label("Prąd zwarciowy Ik[A]:");
        l8.setBounds(10, 360, 150, 20);
        f.add(l8);

        Iktext = new JTextField(17);
        f.add(Iktext);
        Iktext.setBounds(10, 380, 150, 20);
        Iktext.setText(Float.toString(variables.ik));
    }

    public void reslutFunctionsAppear(){

        guiResultObwod();
        guiResultTransformator();
        guiResultLines();
        guiResultObwodZwarciowy();
        guiResultIk();
    }
}
