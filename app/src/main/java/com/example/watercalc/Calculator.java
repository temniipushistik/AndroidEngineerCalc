package com.example.watercalc;

public class Calculator {

    private int no3, so4, hardness, naClConsume, column, salt;
    private long volumeTC007;
    private double divideNO3SO4;


//todo разобрать последовательность вычисления 111
    //speed() -0
    //cationCapacityL() - 0
    // anionCapacityL()-0
    //gap125()1

    //




    public Calculator(int no3, int so4, int hardness, int naClConsume, int column) {
        this.no3 = no3;
        this.so4 = so4;
        this.hardness = hardness;
        this.naClConsume = naClConsume;
        this.column = column;

    }

    public void divideNO3SO4() {
        divideNO3SO4 = (no3 / 62) / (no3 / 62 + so4 / 48);
    }

    public int getSalt() {
        return (int) (salt * (volumePA202()) + (0.12 * volumeTC007));
    }

    public long getVolumeTC007() {
        return volumeTC007;
    }


    private int inSpeed() {
        int suAnion = no3 + so4;
        int speedAnion;
        int speedCation;

        //select speed on anion resin
        if (suAnion <= 50)
            speedAnion = 25;
        else if (suAnion > 50 & suAnion <= 100)
            speedAnion = 20;
        else if (suAnion > 100 & suAnion <= 150)
            speedAnion = 15;
        else if (suAnion > 150 & suAnion <= 200)
            speedAnion = 12;
        else speedAnion = 10;
        //select speed on cation resin
        if (hardness <= 5)
            speedCation = 25;
        else if (hardness > 5 & hardness <= 10)
            speedCation = 20;
        else if (hardness > 10 & hardness <= 14)
            speedCation = 15;
        else if (hardness > 15 & hardness <= 18)
            speedCation = 12;
        else speedCation = 10;

        return Math.min(speedAnion, speedCation);


    }

    //capacity of cation resin per l
    public double cationCapacityL() {

        return (1.2 / hardness);

    }

    //select anion capacity which depends on consume of NaCl
    public double anionCapacityL() {
        double totalAnionPerL;
        if (naClConsume == 125) {
            totalAnionPerL = anionCapacity125();
            salt = 125;
        } else {
            totalAnionPerL = anionCapacity250();
            salt = 250;
        }
        return (totalAnionPerL * 0.9) / ((no3 - gap()) / 62);
    }


    //capacity of anion resin per l

    public double gap() {
        if (naClConsume == 125)
            return gap125();
        else return gap250();
    }

    //nitrate's gap for 125
    private double gap125() {
        if (divideNO3SO4 > 0.8 && divideNO3SO4 <= 1.0) {
            return (-5 * divideNO3SO4 + 17) * no3 * 0.01;
        } else if (divideNO3SO4 > 0.6 && divideNO3SO4 <= 0.8) {
            return (-22.5 * divideNO3SO4 + 31) * no3 * 0.01;
        } else if (divideNO3SO4 > 0.5 && divideNO3SO4 <= 0.6) {
            return (-35 * divideNO3SO4 + 38.5) * no3 * 0.01;
        } else if (divideNO3SO4 > 0.4 && divideNO3SO4 <= 0.5) {
            return (-39 * divideNO3SO4 + 40) * no3 * 0.01;
        } else if (divideNO3SO4 > 0.3 && divideNO3SO4 <= 0.4) {
            return (-47 * divideNO3SO4 + 43.6) * no3 * 0.01;
        } else if (divideNO3SO4 > 0.2 && divideNO3SO4 <= 0.3) {
            return (-65 * divideNO3SO4 + 49) * no3 * 0.01;
        } else if (divideNO3SO4 > 0 && divideNO3SO4 <= 0.2) {
            return (-100 * divideNO3SO4 + 56) * no3 * 0.01;
        } else {
            return no3;
        }
    }

    //nitrate's gap for 250

    private double gap250() {
        if (divideNO3SO4 > 0.8 && divideNO3SO4 <= 1.0) {
            return (-2.5 * divideNO3SO4 + 11.5) * no3 * 0.01;
        } else if (divideNO3SO4 > 0.6 && divideNO3SO4 <= 0.8) {
            return (-7.5 * divideNO3SO4 + 15.5) * no3 * 0.01;
        } else if (divideNO3SO4 > 0.4 && divideNO3SO4 <= 0.6) {
            return (-25 * divideNO3SO4 + 26) * no3 * 0.01;
        } else if (divideNO3SO4 > 0.2 && divideNO3SO4 <= 0.4) {
            return (-45 * divideNO3SO4 + 34) * no3 * 0.01;
        } else if (divideNO3SO4 > 0 && divideNO3SO4 <= 0.2) {
            return (-75 * divideNO3SO4 + 40) * no3 * 0.01;
        } else {
            return no3;
        }
    }

    public double Capacity() {

        return Math.min(cationCapacityL() * volumeTC007, volumePA202() * anionCapacityL());
    }

    //capacity if consume 125g per l
    public double anionCapacity125() {
        divideNO3SO4();

        if (divideNO3SO4 > 0.8 && divideNO3SO4 <= 1.0) {
            return (0.6 * divideNO3SO4 + 0.01);
        } else if (divideNO3SO4 > 0.6 && divideNO3SO4 <= 0.8) {
            return (0.5 * divideNO3SO4 + 0.1);
        } else if (divideNO3SO4 > 0.4 && divideNO3SO4 <= 0.6) {
            return (0.3 * divideNO3SO4 + 0.23);
        } else if (divideNO3SO4 > 0.2 && divideNO3SO4 <= 0.4) {
            return (0.2 * divideNO3SO4 + 0.26);
        } else if (divideNO3SO4 > 0.1 && divideNO3SO4 <= 0.2) {
            return (0.1 * divideNO3SO4 + 0.28);
        } else if (divideNO3SO4 > 0 && divideNO3SO4 <= 0.1) {
            return 0.29;
        } else {
            return 0;
        }

    }

    //capacity if consume 250 g per l
    public double anionCapacity250() {
        divideNO3SO4();
        if (divideNO3SO4 > 0.8 && divideNO3SO4 <= 1.0) {
            return (0.65 * divideNO3SO4 + 0.03);
        } else if (divideNO3SO4 > 0.6 && divideNO3SO4 <= 0.8) {
            return (0.3 * divideNO3SO4 + 0.32);
        } else if (divideNO3SO4 > 0.4 && divideNO3SO4 <= 0.6) {
            return (0.25 * divideNO3SO4 + 0.35);
        } else if (divideNO3SO4 > 0.1 && divideNO3SO4 <= 0.4) {
            return (0.1 * divideNO3SO4 + 0.4);
        } else if (divideNO3SO4 > 0 && divideNO3SO4 <= 0.1) {
            return (0.05 * divideNO3SO4 + 0.415);
        } else {
            return 0;
        }
    }


    public long volumePA202() {

        long temporary;

        temporary = Math.round((anionCapacityL() * column) / (anionCapacityL() + cationCapacityL()));

        if (temporary > ((1 - (30 / 100))) * column) {
            volumeTC007 = Math.round((Math.floor((70) * column) / 100));
            return column - volumeTC007;
        } else if (temporary < ((30 / 100) * column)) {
            volumeTC007 = Math.round((Math.floor((30 / 100) * column)));
            //MessageBox.Show(valuePercentMix.ToString());
            return column - volumeTC007;
        } else

            return column - temporary;

    }
}



