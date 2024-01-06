import java.text.DecimalFormat;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class functions {
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
        variables.setIk3f(0);
    }
    public void obwod(){
        //obwód
        double xq=(1.1*pow(variables.Un,2))/(variables.Sk);
        xq=xq*1000;
        variables.setXq((float) xq);
    }
    public void transformator(){
        //transformator
        variables.Snt=variables.Snt/1000;

        double rt = (variables.Pn*pow(variables.Un,2))/(100*variables.Snt);
        rt*=1000;
        variables.setRt((float) rt);

        double zt = (variables.Uk*pow(variables.Un,2))/(100*variables.Snt);
        zt*=1000;
        variables.setZt((float) zt);

        double xt = sqrt(pow(zt,2)-pow(rt,2));
        variables.setXt((float) xt);

    }
    public void linieZwykla(){
        //linie
        for(int i=0;i<variables.count;i++){
            variables.rl+=(variables.dlugosc[i]*1000)/(variables.gamma[i]*variables.s[i]);
            double rlx=(variables.dlugosc[i]*1000)/(variables.gamma[i]*variables.s[i]);

            variables.xl+=variables.xprim[i]*variables.dlugosc[i];
            double xlx=variables.xprim[i]*variables.dlugosc[i];

            variables.rlArray[i]=(float)rlx;
            variables.xlArray[i]=(float)xlx;
        }
        variables.setRl(variables.rl);
        variables.setXl(variables.xl);
    }
    public void linieUproszczona(){
        //linie

        for(int i=0;i<variables.count;i++){
            variables.rl+=2*((variables.dlugosc[i]*1000)/(variables.gamma[i]*variables.s[i]));
            double rlx=(variables.dlugosc[i]*1000)/(variables.gamma[i]*variables.s[i]);

            variables.xl+=2*(variables.xprim[i]*variables.dlugosc[i]);
            double xlx=variables.xprim[i]*variables.dlugosc[i];

            variables.rlArray[i]=(float)rlx;
            variables.xlArray[i]=(float)xlx;
        }
        variables.setRl(variables.rl);
        variables.setXl(variables.xl);
    }
    public void obwodZwarciowyZwykla(){
        //obwod zwarciowy
        //rq=0
        variables.rk=0 + variables.rt + variables.rl;

        variables.xk=variables.xq + variables.xt + variables.xl;

        variables.setZk((float) sqrt(pow(variables.rk, 2) + pow(variables.xk, 2)));
        //variables.setZk((float) variables.zk);
    }
    public void obwodZwarciowyUproszczona(){
        //obwod zwarciowy
        //rq=0
        double rk=0+variables.rt+1.24*variables.rl;
        variables.setRk((float) rk);

        double xk=variables.xq+variables.xt+variables.xl;
        variables.setXk((float) xk);

        double zk=sqrt(pow(rk,2)+pow(xk,2));
        variables.setZk((float) zk);
    }
    public void zwarcieZwykla(){
        obwod();
        transformator();
        linieZwykla();
        obwodZwarciowyZwykla();

        double ikLocal=(float)(1*variables.Un)/(sqrt(3)*variables.zk);
        variables.setIk((float)ikLocal);
        variables.setIk(variables.ik1f*=1000000);

    }
    public void zwarcieUproszczona(){
        obwod();
        transformator();
        linieUproszczona();
        obwodZwarciowyUproszczona();

        double ikLocal=(0.95*230)/variables.zk;
        ikLocal*=1000;
        variables.setIk((float) ikLocal);

        double ikLocal3f=(0.95*400)/variables.zk;
        ikLocal3f*=1000;
        variables.setIk3f((float) ikLocal3f);

    }
}
