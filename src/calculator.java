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
            gui.guiLineRemove();
            gui.guiLine();
            gui.f.setSize(820,400);
            }

        if(e.getSource()==gui.eq){
            functions.setZero();
            gui.guiVariablesValue();
            gui.guiLineValue();

            switch(variables.wybor){
                case 1:
                    functions.zwarcieZwykla();
                    gui.c1.setSelected(false);
                    break;

                case 2:
                    functions.zwarcieUproszczona();
                    gui.c2.setSelected(false);
                    break;

                default:
                    break;
            }
            gui.reslutFunctionsAppear();
        }
    }

}



