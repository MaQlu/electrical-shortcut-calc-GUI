import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculator implements ActionListener {
    functions functions = new functions();
    gui gui = new gui();
    calculator(){
        gui.guiPanel();
        gui.guiChoice();

        gui.c1.addItemListener(e -> variables.wybor =1);
        gui.c2.addItemListener(e -> variables.wybor =2);

        gui.guiVariables();
        gui.guiLineCount();
        gui.guiButtonLines();
        gui.b.addActionListener(this);
        gui.guiButtonEqual();
        gui.eq.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==gui.b){
            gui.guiLineCountValue();
            gui.guiLine();
            gui.f.setSize(820,400);
            }

        if(e.getSource()==gui.eq){
            functions.setZero();
            gui.guiVariablesValue();

            if(variables.count>3){
                int x=600;
                int y=900;
                int aha=variables.count-3;
                int xBig=x+(aha*80);
                gui.f.setSize(y,xBig);
            }else{
                gui.f.setSize(900,600);
            }

            switch(variables.wybor){
                case 1:
                    System.out.println("Metoda Zwykła: ");
                    gui.guiLineValue();
                    functions.zwarcieZwykla();
                    gui.c1.setSelected(false);
                    gui.reslutFunctionsAppear();
                    variables.wybor=0;
                    break;
                case 2:
                    System.out.println("Metoda Uproszczona: ");
                    gui.guiLineValue();
                    functions.zwarcieUproszczona();
                    gui.c2.setSelected(false);
                    gui.reslutFunctionsAppear();
                    variables.wybor=0;
                    break;
                default:
                    break;
            }
        }
    }

}



