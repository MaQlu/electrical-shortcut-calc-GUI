import java.text.DecimalFormat;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class functions {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public void setZero(){
        for (int i=0;i<variables.count;i++){
            variables.dlugosc[i]=0;
            variables.gamma[i]=0;
            variables.s[i]=0;
            variables.xprim[i]=0;
        }
        variables.setXq(0);
        variables.setRl(0);
        variables.setXl(0);
        variables.setRt(0);
        variables.setZt(0);
        variables.setXt(0);
        variables.setZk(0);
        variables.setIk(0);
    }
    public void obwod(){
        //obwód
        double xq=(1.1*pow(variables.Un,2))/(variables.Sk);
        xq=xq*1000;
        variables.setXq((float) xq);
        //System.out.println("xq= "+df.format(xq)+"mOM");
    }
    public void transformator(){
        //transformator
        variables.Snt=variables.Snt/1000;

        double rt = (variables.Pn*pow(variables.Un,2))/(100*variables.Snt);
        rt*=1000;
        //System.out.println("rt= "+df.format(rt));
        variables.setRt((float) rt);

        double zt = (variables.Uk*pow(variables.Un,2))/(100*variables.Snt);
        zt*=1000;
        //System.out.println("zt= "+df.format(zt));
        variables.setZt((float) zt);

        double xt = sqrt(pow(zt,2)-pow(rt,2));
        //System.out.println("xt= "+df.format(xt));
        variables.setXt((float) xt);

    }
    public void linieZwykla(){
        //linie
        for(int i=0;i<variables.count;i++){
            //System.out.println();

            variables.rl+=(variables.dlugosc[i]*1000)/(variables.gamma[i]*variables.s[i]);
            double rlx=(variables.dlugosc[i]*1000)/(variables.gamma[i]*variables.s[i]);
            //System.out.println("rl dla linii: " +i+"= "+df.format(rlx)+"mOM");

            variables.xl+=variables.xprim[i]*variables.dlugosc[i];
            double xlx=variables.xprim[i]*variables.dlugosc[i];
            //System.out.println("xl dla linii: " +i+"= "+df.format(xlx)+"mOM");

            variables.rlArray[i]=(float)rlx;
            variables.xlArray[i]=(float)xlx;

        }
        //System.out.println();

        variables.setRl(variables.rl);
        variables.setXl(variables.xl);
    }
    public void linieUproszczona(){
        //linie

        for(int i=0;i<variables.count;i++){
            //System.out.println();

            variables.rl+=2*((variables.dlugosc[i]*1000)/(variables.gamma[i]*variables.s[i]));
            double rlx=(variables.dlugosc[i]*1000)/(variables.gamma[i]*variables.s[i]);
            //System.out.println("rl dla linii: " +i+"= "+df.format(rlx)+"mOM");

            variables.xl+=2*(variables.xprim[i]*variables.dlugosc[i]);
            double xlx=variables.xprim[i]*variables.dlugosc[i];
            //System.out.println("xl dla linii: " +i+"= "+df.format(xlx)+"mOM");

            variables.rlArray[i]=(float)rlx;
            variables.xlArray[i]=(float)xlx;
        }

        //System.out.println();


        variables.setRl(variables.rl);
        variables.setXl(variables.xl);
    }
    public void obwodZwarciowyZwykla(){
        //obwod zwarciowy
        //rq=0

        //System.out.println();

        variables.rk=0 + variables.rt + variables.rl;
        //System.out.println("rk= " + df.format(variables.rk));

        variables.xk=variables.xq + variables.xt + variables.xl;
        //System.out.println("xk= " + df.format(variables.xk));
        variables.setZk((float) sqrt(pow(variables.rk, 2) + pow(variables.xk, 2)));
        //System.out.println("zk= " + df.format(variables.zk));
        variables.setZk((float) variables.zk);
    }
    public void obwodZwarciowyUproszczona(){
        //obwod zwarciowy
        //rq=0
        //System.out.println();

        double rk=0+variables.rt+1.24*variables.rl;
        //System.out.println("rk= "+df.format(rk)+"mOM");
        variables.setRk((float) rk);

        double xk=variables.xq+variables.xt+variables.xl;
        //System.out.println("xk= "+df.format(xk)+"mOM");
        variables.setXk((float) xk);

        double zk=sqrt(pow(rk,2)+pow(xk,2));
        //System.out.println("zk= "+df.format(zk)+"mOM");
        variables.setZk((float) zk);
    }
    public void zwarcieZwykla(){
        obwod();
        transformator();
        linieZwykla();
        obwodZwarciowyZwykla();

        double ikLocal=(float)(1*variables.Un)/(sqrt(3)*variables.zk);
        variables.setIk((float)ikLocal);
        variables.setIk(variables.ik*=1000000);
        //System.out.println();
        //System.out.println("ik= "+df.format(ik)+"A");
    }
    public void zwarcieUproszczona(){
        obwod();
        transformator();
        linieUproszczona();
        obwodZwarciowyUproszczona();

        //System.out.println();
        //System.out.println("Zwarcie 1 fazowe (230V)");

        double ikLocal=(0.95*230)/variables.zk;
        ikLocal*=1000;
        variables.setIk((float) ikLocal);

        //System.out.println("ik= "+df.format(ik)+"A");

        //System.out.println();
        //System.out.println("Zwarcie 3 fazowe (400V)");
        //double ik3f=(0.95*400)/variables.zk;
        //ik3f*=1000;
        //System.out.println("ik= "+df.format(ik3f)+"A");
    }
}
