import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculator implements ActionListener {
    functions functions = new functions();
    gui gui = new gui();
    calculator(){
        gui.guiPanel();
        gui.guiChoice();
        gui.guiVariables();
        gui.guiLineCount();
        gui.guiButtonLines();
        //dodaj linie
        gui.b.addActionListener(this);
        gui.guiButtonEqual();
        //oblicz
        gui.eq.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==gui.b){
            gui.guiLineCountValue();
            gui.guiLineRemove();
            gui.guiLine();
            gui.guiLineData();
            gui.methodChoiceRemove();
            }
liczenie:

        if(e.getSource()==gui.eq){

            if (variables.ErrorMethod==1){
                gui.guiErrorMethodRemove();
            }

            if(gui.c1.isSelected()){
                variables.wybor=1;
            }else if (gui.c2.isSelected()) {
                variables.wybor=2;
            }else{
                variables.wybor=0;
                variables.ErrorMethod=1;
            }

            if (variables.counter >=1){
                gui.methodChoiceRemove();
                gui.guiResultIkRemove();
                gui.guiResultObwodRemove();
                gui.guiResultTransformatorRemove();
                gui.guiResultLinesRemove();
                gui.guiResultObwodZwarciowyRemove();
            }

            if(variables.wybor==1){
                functions.zwarcieZwykla();
                gui.c1.setSelected(false);
            } else if (variables.wybor==2) {
                functions.zwarcieUproszczona();
                gui.c2.setSelected(false);
            }else{
                gui.guiErrorMethod();
                break liczenie;
            }

            functions.setZero();
            gui.guiResultView();
            gui.guiVariablesValue();
            gui.guiLineValue();
            gui.methodChoice();
            gui.reslutFunctionsAppear();
            variables.counter+=1;

        }

    }

}



