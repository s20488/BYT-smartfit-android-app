package com.example.smartfit.kalkulator;
    public class MetricFormula {

        private double inputKg;
        private double inputM;
        private double inputW;



        public MetricFormula(double inputKg, double inputM, double inputW) {
            this.inputKg = inputKg;
            this.inputM = inputM;
            this.inputW= inputW;


        }

        public double getInputKg() {
            return inputKg;
        }

        public double getInputM() {
            return inputM;
        }
        public double getInputW() {
            return inputW;
        }
        public double computeBMI(double kg, double m) {
            return kg/(Math.pow((m/100),2));
        }
        public double computeGKCL(double kg, double m,double w,double akt) {
            return akt*(655 + (9.6 * kg) + (1.85 * m) - (4.7 * w));
        }
        public double computeMKCL(double kg, double m, double w,double akt) {
            return akt*(665 + (13.7 * kg) + (5 * m) - (6.8 * w));
        }
    }

