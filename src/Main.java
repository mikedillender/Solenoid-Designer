public class Main {

    public static void main(String[] args) {

        double[] wires=new double[]{.0154,.0256,.0315,.0675};
        for (double s:wires){
            System.out.println("For "+s+" in : ");
            getStatsOf(s);
        }

    }
    public static double getStatsOf(double size){
        double p=.0000000168;
        double crad=.011/2;
        double maxrad=.02/2;
        double maxh=(maxrad-crad)/2.0;
        double cw=.02;//coil width
        int loops=0;
        double wr=(size/2)*.0254;//wire rad
        int maxlayers= (int) Math.ceil(maxh/(wr*2));
        int loopsperlayer=(int)(Math.floor(cw/(wr*2)));
        //System.out.println("max layers "+maxlayers);
        //maxlayers=2;
        double length=0;
        for (int l=0;l<=maxlayers; l++){
            double looplength=((l+.5)*2*wr+crad)*2*3.14159;
            loops+=loopsperlayer;
            length+=looplength*loopsperlayer;
        }

        double A=(3.14159*wr*wr);
        double R=(p*length/A);
        System.out.println("R = "+R);
        System.out.println("I = "+(400/R));
        System.out.println("B/u = "+(loops*400/R));
        System.out.println("");
        return R;
    }


}
