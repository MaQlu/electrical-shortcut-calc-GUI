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
    JLabel[] lsdlugosc = new JLabel[variables.count];
    JLabel[] lsgamma = new JLabel[variables.count];
    JLabel[] lss = new JLabel[variables.count];
    JLabel[] lsx = new JLabel[variables.count];
    JLabel[] LineRezystancja = new JLabel[variables.count];
    JLabel[] LineReaktancja = new JLabel[variables.count];
    JLabel RkLabel1 = new JLabel();
    JLabel RkLabel2 = new JLabel();
    JLabel RkLabel3 = new JLabel();
    JLabel Rtlabel = new JLabel();
    JLabel Ztlabel = new JLabel();
    JLabel Xtlabel = new JLabel();
    JLabel Xqlabel = new JLabel();
    JLabel Ik = new JLabel();
    JLabel methodChoiceLabel = new JLabel();
    JLabel methodChoiceLabelError = new JLabel();
    JTextField methodChoiceText;
    JLabel methodChoiceTextError;
    JButton b,eq;
    JCheckBox c1,c2;

    public void guiPanel(){
        //okienko
        f = new JFrame();
        f.setSize(400,320);
        f.setLayout(null);
        f.setVisible(true);
    }
    public void guiChoice(){
        //wybór
        Label l1 = new Label("Wybierz metodę: ");
        l1.setBounds(10, 20, 200, 10);
        f.add(l1);

        c1 = new JCheckBox("Zwykla");
        c1.setBounds(10, 40, 90, 20);
        f.add(c1);

        c2 = new JCheckBox("Uproszczona");
        c2.setBounds(100, 40, 140, 20);
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
        l7.setBounds(250, 20, 100, 20);
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
        lsdlugosc = new JLabel[variables.count];
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
        lsgamma = new JLabel[variables.count];
        for (int j = 0; j < tfsgamma.length; j++) {

            lsgamma[j] = new JLabel("gamma dla linii: "+j);
            f.add(lsgamma[j]);
            lsgamma[j].setBounds(400,y+20,140,20);

            tfsgamma[j] = new JTextField();
            f.add(tfsgamma[j]);
            tfsgamma[j].setBounds(400,y+40,100,20);
            y+=40;
        }

        //s linii
        y=90;
        tfss = new JTextField[variables.count];
        lss = new JLabel[variables.count];
        for (int j = 0; j < tfss.length; j++) {

            lss[j] = new JLabel("s[mm] dla linii: "+j);
            f.add(lss[j]);
            lss[j].setBounds(550,y+20,140,20);

            tfss[j] = new JTextField();
            f.add(tfss[j]);
            tfss[j].setBounds(550,y+40,100,20);
            y+=40;
        }

        //x linii
        y=90;
        tfsx = new JTextField[variables.count];
        lsx = new JLabel[variables.count];
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
    public void guiLineRemove(){
        for(int i=0;i<tfsgamma.length;i++) {
            tfsdlugosc[i].setVisible(false);
            lsdlugosc[i].setVisible(false);
            tfsgamma[i].setVisible(false);
            lsgamma[i].setVisible(false);
            tfss[i].setVisible(false);
            lss[i].setVisible(false);
            tfsx[i].setVisible(false);
            lsx[i].setVisible(false);
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
        eq.setBounds(700, 40, 100, 40);
    }
    public void methodChoice(){
        methodChoiceLabel = new JLabel("Wybrana metoda: ");
        f.add(methodChoiceLabel);
        methodChoiceLabel.setBounds(850,40,150,20);

        methodChoiceText = new JTextField(17);

        if(variables.wybor == 1){
            methodChoiceText.setText("Metoda zwykla");
        }else{
            methodChoiceText.setText("Metoda uproszczona");
        }
        f.add(methodChoiceText);
        methodChoiceText.setBounds(850,60,150,20);
    }
    public void methodChoiceRemove(){
        methodChoiceLabel.setVisible(false);
        methodChoiceText.setVisible(false);
    }
    public void guiResultObwod(){

        //reaktancja
        Xqlabel = new JLabel("<html>Reaktancja obwodu<br>(X<sub>Q</sub>) [mΩ]:</html>");
        Xqlabel.setBounds(850, 90, 150, 40);
        f.add(Xqlabel);

        Xqtext = new JTextField(17);
        Xqtext.setText(Float.toString(variables.xq));
        f.add(Xqtext);
        Xqtext.setBounds(850,130 , 150, 20);
        Xqtext.setEditable(false);
    }
    public void guiResultObwodRemove(){
        Xqlabel.setVisible(false);
        Xqtext.setVisible(false);
    }
    public void guiResultTransformator(){
        int x=1040;
        int y=90;
        int wl=200;
        int hl=40;

        int wtf=110;
        int htf=20;

        //rezystancja
        Rtlabel = new JLabel("<html>Rezystancja transformatora<br>(R<sub>T</sub>) [mΩ]:</html>");
        Rtlabel.setBounds(x, y, wl, hl);
        f.add(Rtlabel);

        Rttext = new JTextField(17);
        Rttext.setText(Float.toString(variables.rt));
        f.add(Rttext);
        Rttext.setBounds(x,y+=40 , wtf, htf);
        Rttext.setEditable(false);

        //reaktancja
        Xtlabel = new JLabel("<html>Reaktancja transformatora<br>(X<sub>T</sub>) [mΩ]:</html>");
        Xtlabel.setBounds(x, y+=20, wl, hl);
        f.add(Xtlabel);

        Xttext = new JTextField(17);
        Xttext.setText(Float.toString(variables.xt));
        f.add(Xttext);
        Xttext.setBounds(x,y+=40 , wtf, htf);
        Xttext.setEditable(false);

        //impedancja
        Ztlabel = new JLabel("<html>Impedancja transformatora<br>(Z<sub>T</sub>) [mΩ]:</html>");
        Ztlabel.setBounds(x, y+=20, wl, hl);
        f.add(Ztlabel);

        Zttext = new JTextField(17);
        Zttext.setText(Float.toString(variables.zt));
        f.add(Zttext);
        Zttext.setBounds(x,y+=40 , wtf, htf);
        Zttext.setEditable(false);

    }
    public void guiResultTransformatorRemove(){
        Rtlabel.setVisible(false);
        Rttext.setVisible(false);

        Xtlabel.setVisible(false);
        Xttext.setVisible(false);

        Ztlabel.setVisible(false);
        Zttext.setVisible(false);
    }
    public void guiResultLines(){

        //rezystancja linii
        int x=1240;
        int y=90;
        LineRTtext = new JTextField[variables.count];
        LineRezystancja = new JLabel[variables.count];

        for (int j = 0; j < variables.count; j++) {
            LineRezystancja[j] = new JLabel("<html>Rezystancja(R<sub>L</sub>) [mΩ] <br> dla linii: "+j+"</html>");
            f.add(LineRezystancja[j]);
            LineRezystancja[j].setBounds(x,y,150,40);

            LineRTtext[j] = new JTextField(17);
            LineRTtext[j].setText(Float.toString(variables.rlArray[j]));
            f.add(LineRTtext[j]);
            LineRTtext[j].setBounds(x, y+40, 110, 20);
            LineRTtext[j].setEditable(false);
            y+=60;
        }

        x=1390;
        y=90;
        //reaktancja linii
        LineXTtext = new JTextField[variables.count];
        LineReaktancja = new JLabel[variables.count];
        for (int j = 0; j < variables.count; j++) {
            LineReaktancja[j] = new JLabel("<html>Reaktancja(X<sub>L</sub>) [mΩ] <br> dla linii: "+j+"</html>");
            f.add(LineReaktancja[j]);
            LineReaktancja[j].setBounds(x,y,150,40);

            LineXTtext[j] = new JTextField(17);
            LineXTtext[j].setText(Float.toString(variables.xlArray[j]));
            f.add(LineXTtext[j]);
            LineXTtext[j].setBounds(x, y+40, 110, 20);
            LineXTtext[j].setEditable(false);
            y+=60;
        }

    }
    public void guiLineData(){
        int x=820;
        int y=320;
        if(variables.count>4){
            int aha=variables.count-4;
            variables.yBig=y+(aha*40);
            f.setSize(x,variables.yBig);
        }else{
            f.setSize(x,y);
        }
    }
    public void guiResultLinesRemove(){
        for(int i=0;i<LineRTtext.length;i++) {
            LineRezystancja[i].setVisible(false);
            LineRTtext[i].setVisible(false);
            LineReaktancja[i].setVisible(false);
            LineXTtext[i].setVisible(false);
        }
    }
    public void guiResultObwodZwarciowy(){
        int x=1540;
        int y=90;

        //rezystancja
        RkLabel1 = new JLabel("<html>Rezystancja obwodu(R<sub>K</sub>) <br> zwarciowego [mΩ]:</html>");
        RkLabel1.setBounds(x, y, 200, 40);
        f.add(RkLabel1);

        Rktext = new JTextField(17);
        Rktext.setText(Float.toString(variables.rk));
        f.add(Rktext);
        Rktext.setBounds(x,y+=40 , 110, 20);
        Rktext.setEditable(false);


        //reaktancja
        RkLabel2 = new JLabel("<html>Reaktancja obwodu(X<sub>K</sub>) <br> zwarciowego [mΩ]:</html>");
        RkLabel2.setBounds(x, y+=20, 200, 40);
        f.add(RkLabel2);

        Xktext = new JTextField(17);
        Xktext.setText(Float.toString(variables.xk));
        f.add(Xktext);
        Xktext.setBounds(x,y+=40 , 110, 20);
        Xktext.setEditable(false);

        //impedancja
        RkLabel3 = new JLabel("<html>Impedancja obwodu(Z<sub>K</sub>) <br> zwarciowego [mΩ]:</html>:");
        RkLabel3.setBounds(x, y+=20, 200, 40);
        f.add(RkLabel3);

        Zktext = new JTextField(17);
        Zktext.setText(Float.toString(variables.zk));
        f.add(Zktext);
        Zktext.setBounds(x,y+=40 , 110, 20);
        Zktext.setEditable(false);
    }
    public void guiResultObwodZwarciowyRemove(){
        RkLabel1.setVisible(false);
        Rktext.setVisible(false);

        RkLabel2.setVisible(false);
        Xktext.setVisible(false);

        RkLabel3.setVisible(false);
        Zktext.setVisible(false);
    }
    public void guiResultIk1f(){
        Ik = new JLabel("Prąd zwarciowy Ik(1~) [A]:");
        Ik.setBounds(1040, 40, 150, 20);
        f.add(Ik);

        Iktext = new JTextField(17);
        f.add(Iktext);
        Iktext.setBounds(1040, 60, 150, 20);
        Iktext.setText(Float.toString(variables.ik1f));
        Iktext.setEditable(false);
    }
    public void guiResultIkRemove(){
        Ik.setVisible(false);
        Iktext.setVisible(false);
    }
    public void guiResultView(){
        int x=1700;
        int y=400;
        if(variables.count>5){
            int aha=variables.count-4;
            int yBig=y+(aha*60);
            f.setSize(x,yBig);
        }else{
            f.setSize(x,y);
        }
    }
    public void guiErrorMethod(){
        methodChoiceLabelError = new JLabel("Wybrana metoda: ");
        f.add(methodChoiceLabelError);
        methodChoiceLabelError.setBounds(850,40,150,20);

        methodChoiceTextError = new JLabel("<html><b><font color='red'>WYBIERZ METODE!</font></b></html>");
        f.add(methodChoiceTextError);
        methodChoiceTextError.setBounds(850,60,150,20);

        if(variables.count>4){
            f.setSize(1000,variables.yBig);
        }else{
            f.setSize(1000,320);
        }
    }
    public void guiErrorMethodRemove(){
        methodChoiceLabelError.setVisible(false);
        methodChoiceTextError.setVisible(false);
        variables.ErrorMethod=0;
    }
    public void reslutFunctionsAppear(){
        guiResultObwod();
        guiResultTransformator();
        guiResultLines();
        guiResultObwodZwarciowy();
        guiResultIk1f();
        variables.wybor=0;

    }
}
