package unidad2;

import java.awt.*;

public class Figura {

    double fig[][], t1[][], t2[][], t3[][], t4[][], t5[][], t6[][], t7[][], t8[][], figz[][], zt1[][], zt2[][], zt3[][], zt4[][], zt5[][], zt6[][], zt7[][], zt8[][];
    double copia[][], ct1[][], ct2[][], ct3[][], ct4[][], ct5[][], ct6[][], ct7[][], ct8[][];

    public Figura(double f[][], double ti1[][], double ti2[][], double ti3[][], double ti4[][], double ti5[][]) {
        copia = f;
        ct1 = ti1;
        ct2 = ti2;
        ct3 = ti3;
        ct4 = ti4;
        ct5 = ti5;
       
        fig = new double[f.length][f[0].length];

        t1 = new double[ti1.length][ti1[0].length];

        t2 = new double[ti2.length][ti2[0].length];

        t3 = new double[ti3.length][ti3[0].length];

        t4 = new double[ti4.length][ti4[0].length];

        t5 = new double[ti5.length][ti5[0].length];

       
        restablecer();
    }

    public void restablecer() {
        for (int i = 0; i < copia.length; i++) {
            fig[i][0] = copia[i][0];
            fig[i][1] = copia[i][1];
        }

        for (int i = 0; i < ct1.length; i++) {
            t1[i][0] = ct1[i][0];
            t1[i][1] = ct1[i][1];
        }
        for (int i = 0; i < ct2.length; i++) {
            t2[i][0] = ct2[i][0];
            t2[i][1] = ct2[i][1];
        }

        for (int i = 0; i < ct3.length; i++) {
            t3[i][0] = ct3[i][0];
            t3[i][1] = ct3[i][1];
        }

        for (int i = 0; i < ct4.length; i++) {
            t4[i][0] = ct4[i][0];
            t4[i][1] = ct4[i][1];
        }

        for (int i = 0; i < ct5.length; i++) {
            t5[i][0] = ct5[i][0];
            t5[i][1] = ct5[i][1];
        }

       
    }

    public void dibujar(Graphics g) {
        for (int i = 0; i < fig.length - 1; i++) {
            g.drawLine((int) fig[i][0], (int) fig[i][1], (int) fig[i + 1][0], (int) fig[i + 1][1]);
        }

        for (int i = 0; i < t1.length - 1; i++) {
            g.drawLine((int) t1[i][0], (int) t1[i][1], (int) t1[i + 1][0], (int) t1[i + 1][1]);
        }

        for (int i = 0; i < t2.length - 1; i++) {
            g.drawLine((int) t2[i][0], (int) t2[i][1], (int) t2[i + 1][0], (int) t2[i + 1][1]);
        }

        for (int i = 0; i < t3.length - 1; i++) {
            g.drawLine((int) t3[i][0], (int) t3[i][1], (int) t3[i + 1][0], (int) t3[i + 1][1]);
        }


        for (int i = 0; i < t4.length - 1; i++) {
            g.drawLine((int) t4[i][0], (int) t4[i][1], (int) t4[i + 1][0], (int) t4[i + 1][1]);
        }

        for (int i = 0; i < t5.length - 1; i++) {
            g.drawLine((int) t5[i][0], (int) t5[i][1], (int) t5[i + 1][0], (int) t5[i + 1][1]);
        }

       
    }

    public void dibujarz(Graphics g) {
        for (int i = 0; i < figz.length - 1; i++) {
            g.drawLine((int) figz[i][0], (int) figz[i][1], (int) figz[i + 1][0], (int) figz[i + 1][1]);
        }

        for (int i = 0; i < zt1.length - 1; i++) {
            g.drawLine((int) zt1[i][0], (int) zt1[i][1], (int) zt1[i + 1][0], (int) zt1[i + 1][1]);
        }

        for (int i = 0; i < zt2.length - 1; i++) {
            g.drawLine((int) zt2[i][0], (int) zt2[i][1], (int) zt2[i + 1][0], (int) zt2[i + 1][1]);
        }

        for (int i = 0; i < zt3.length - 1; i++) {
            g.drawLine((int) zt3[i][0], (int) zt3[i][1], (int) zt3[i + 1][0], (int) zt3[i + 1][1]);
        }

        for (int i = 0; i < zt4.length - 1; i++) {
            g.drawLine((int) zt4[i][0], (int) zt4[i][1], (int) zt4[i + 1][0], (int) zt4[i + 1][1]);
        }
        for (int i = 0; i < zt5.length - 1; i++) {
            g.drawLine((int) zt5[i][0], (int) zt5[i][1], (int) zt5[i + 1][0], (int) zt5[i + 1][1]);
        }
       
    }

    public void zoom() {
        double Sx = (double) (800 - 550) / 800;
        double Sy = (double) (600 - 450) / 600;

        figz = new double[fig.length][fig[0].length];

        zt1 = new double[t1.length][t1[0].length];

        zt2 = new double[t2.length][t2[0].length];

        zt3 = new double[t3.length][t3[0].length];

        zt4 = new double[t4.length][t4[0].length];

        zt5 = new double[t5.length][t5[0].length];

        

        for (int i = 0; i < fig.length; i++) {
            figz[i][0] = (550 + fig[i][0] * Sx);
            figz[i][1] = (450 + fig[i][1] * Sy);
        }

        for (int i = 0; i < t1.length; i++) {
            zt1[i][0] = (550 + t1[i][0] * Sx);
            zt1[i][1] = (450 + t1[i][1] * Sy);
        }

        for (int i = 0; i < t2.length; i++) {
            zt2[i][0] = (550 + t2[i][0] * Sx);
            zt2[i][1] = (450 + t2[i][1] * Sy);
        }

        for (int i = 0; i < t3.length; i++) {
            zt3[i][0] = (550 + t3[i][0] * Sx);
            zt3[i][1] = (450 + t3[i][1] * Sy);
        }

        for (int i = 0; i < t4.length; i++) {
            zt4[i][0] = (550 + t4[i][0] * Sx);
            zt4[i][1] = (450 + t4[i][1] * Sy);
        }

        for (int i = 0; i < t5.length; i++) {
            zt5[i][0] = (550 + t5[i][0] * Sx);
            zt5[i][1] = (450 + t5[i][1] * Sy);
        }

       
    }

    public void escalar(double ex, double ey) {
        for (int i = 0; i < fig.length; i++) {
            fig[i][0] = (ex * fig[i][0]);
            fig[i][1] = (ey * fig[i][1]);
        }

        for (int j = 0; j < t1.length; j++) {
            t1[j][0] = (ex * t1[j][0]);
            t1[j][1] = (ey * t1[j][1]);
        }


        for (int j = 0; j < t2.length; j++) {
            t2[j][0] = (ex * t2[j][0]);
            t2[j][1] = (ey * t2[j][1]);
        }

        for (int j = 0; j < t3.length; j++) {
            t3[j][0] = (ex * t3[j][0]);
            t3[j][1] = (ey * t3[j][1]);
        }


        for (int j = 0; j < t4.length; j++) {
            t4[j][0] = (ex * t4[j][0]);
            t4[j][1] = (ey * t4[j][1]);
        }


        for (int j = 0; j < t5.length; j++) {
            t5[j][0] = (ex * t5[j][0]);
            t5[j][1] = (ey * t5[j][1]);
        }

       
    }

    public void escalar_punto(double ex, double ey) {

        double Tx = fig[0][0], Ty = fig[0][1];

        this.Trasladar(-Tx, -Ty);
        this.escalar(ex, ey);
        this.Trasladar(Tx, Ty);


        Tx = t1[0][0];
        Ty = t1[0][1];
        this.Trasladar(-Tx, -Ty);
        this.escalar(ex, ey);
        this.Trasladar(Tx, Ty);

        Tx = t2[0][0];
        Ty = t2[0][1];
        this.Trasladar(-Tx, -Ty);
        this.escalar(ex, ey);
        this.Trasladar(Tx, Ty);

        Tx = t3[0][0];
        Ty = t3[0][1];
        this.Trasladar(-Tx, -Ty);
        this.escalar(ex, ey);
        this.Trasladar(Tx, Ty);

        Tx = t4[0][0];
        Ty = t4[0][1];
        this.Trasladar(-Tx, -Ty);
        this.escalar(ex, ey);
        this.Trasladar(Tx, Ty);

        Tx = t5[0][0];
        Ty = t5[0][1];
        this.Trasladar(-Tx, -Ty);
        this.escalar(ex, ey);
        this.Trasladar(Tx, Ty);


    }

    public void Deformar(double C, double D) {
        for (int i = 0; i < fig.length; i++) {
            fig[i][0] = (fig[i][0] + C * fig[i][1]);
            fig[i][1] = (D * fig[i][0] + fig[i][1]);
        }

        for (int i = 0; i < t1.length; i++) {
            t1[i][0] = (t1[i][0] + C * t1[i][1]);
            t1[i][1] = (D * t1[i][0] + t1[i][1]);
        }

        for (int i = 0; i < t2.length; i++) {
            t2[i][0] = (t2[i][0] + C * t2[i][1]);
            t2[i][1] = (D * t2[i][0] + t2[i][1]);
        }

        for (int i = 0; i < t3.length; i++) {
            t3[i][0] = (t3[i][0] + C * t3[i][1]);
            t3[i][1] = (D * t3[i][0] + t3[i][1]);
        }

        for (int i = 0; i < t4.length; i++) {
            t4[i][0] = (t4[i][0] + C * t4[i][1]);
            t4[i][1] = (D * t4[i][0] + t4[i][1]);
        }

        for (int i = 0; i < t5.length; i++) {
            t5[i][0] = (t5[i][0] + C * t5[i][1]);
            t5[i][1] = (D * t5[i][0] + t5[i][1]);
        }

       
    }

    public void deformar_punto(double C, double D) {
        double Tx = fig[0][0], Ty = fig[0][1];
        this.Trasladar(-Tx, -Ty);
        this.Deformar(C, D);
        this.Trasladar(Tx, Ty);

        Tx = t1[0][0];
        Ty = t1[0][1];
        this.Trasladar(-Tx, -Ty);
        this.Deformar(C, D);
        this.Trasladar(Tx, Ty);

        Tx = t2[0][0];
        Ty = t2[0][1];
        this.Trasladar(-Tx, -Ty);
        this.Deformar(C, D);
        this.Trasladar(Tx, Ty);

        Tx = t3[0][0];
        Ty = t3[0][1];
        this.Trasladar(-Tx, -Ty);
        this.Deformar(C, D);
        this.Trasladar(Tx, Ty);

        Tx = t4[0][0];
        Ty = t4[0][1];
        this.Trasladar(-Tx, -Ty);
        this.Deformar(C, D);
        this.Trasladar(Tx, Ty);

        Tx = t5[0][0];
        Ty = t5[0][1];
        this.Trasladar(-Tx, -Ty);
        this.Deformar(C, D);
        this.Trasladar(Tx, Ty);

    }

    public void rotar_contra(int ang) {
        double ang_rad = Math.toRadians(ang);
        double coseno = Math.cos(ang_rad);
        double seno = Math.sin(ang_rad);
        for (int i = 0; i < fig.length; i++) {
            double x = fig[i][0];
            double y = fig[i][1];
            fig[i][0] = (x * coseno - y * seno);
            fig[i][1] = (x * seno + y * coseno);
        }

        for (int i = 0; i < t1.length; i++) {
            double x = t1[i][0];
            double y = t1[i][1];
            t1[i][0] = (x * coseno - y * seno);
            t1[i][1] = (x * seno + y * coseno);
        }

        for (int i = 0; i < t2.length; i++) {
            double x = t2[i][0];
            double y = t2[i][1];
            t2[i][0] = (x * coseno - y * seno);
            t2[i][1] = (x * seno + y * coseno);
        }

        for (int i = 0; i < t3.length; i++) {
            double x = t3[i][0];
            double y = t3[i][1];
            t3[i][0] = (x * coseno - y * seno);
            t3[i][1] = (x * seno + y * coseno);
        }

        for (int i = 0; i < t4.length; i++) {
            double x = t4[i][0];
            double y = t4[i][1];
            t4[i][0] = (x * coseno - y * seno);
            t4[i][1] = (x * seno + y * coseno);
        }

        for (int i = 0; i < t5.length; i++) {
            double x = t5[i][0];
            double y = t5[i][1];
            t5[i][0] = (x * coseno - y * seno);
            t5[i][1] = (x * seno + y * coseno);
        }

        
    }

    public void rotar_cp(int ang) {
        double Tx = fig[0][0], Ty = fig[0][1];
        this.Trasladar(-Tx, -Ty);
        this.rotar_contra(ang);
        this.Trasladar(Tx, Ty);

        Tx = t1[0][0];
        Ty = t1[0][1];
        this.Trasladar(-Tx, -Ty);
        this.rotar_contra(ang);
        this.Trasladar(Tx, Ty);

        Tx = t2[0][0];
        Ty = t2[0][1];
        this.Trasladar(-Tx, -Ty);
        this.rotar_contra(ang);
        this.Trasladar(Tx, Ty);

        Tx = t3[0][0];
        Ty = t3[0][1];
        this.Trasladar(-Tx, -Ty);
        this.rotar_contra(ang);
        this.Trasladar(Tx, Ty);

        Tx = t3[0][0];
        Ty = t3[0][1];
        this.Trasladar(-Tx, -Ty);
        this.rotar_contra(ang);
        this.Trasladar(Tx, Ty);

        Tx = t4[0][0];
        Ty = t4[0][1];
        this.Trasladar(-Tx, -Ty);
        this.rotar_contra(ang);
        this.Trasladar(Tx, Ty);

        Tx = t5[0][0];
        Ty = t5[0][1];
        this.Trasladar(-Tx, -Ty);
        this.rotar_contra(ang);
        this.Trasladar(Tx, Ty);

       
    }

    public void rotar_sentido(int ang) {
        double ang_rad = Math.toRadians(ang);
        double coseno = Math.cos(ang_rad);
        double seno = Math.sin(ang_rad);
        for (int i = 0; i < fig.length; i++) {
            double x = fig[i][0];
            double y = fig[i][1];
            fig[i][0] = (x * coseno + y * seno);
            fig[i][1] = (-x * seno + y * coseno);
        }

        for (int i = 0; i < t1.length; i++) {
            double x = t1[i][0];
            double y = t1[i][1];
            t1[i][0] = (x * coseno + y * seno);
            t1[i][1] = (-x * seno + y * coseno);
        }

        for (int i = 0; i < t2.length; i++) {
            double x = t2[i][0];
            double y = t2[i][1];
            t2[i][0] = (x * coseno + y * seno);
            t2[i][1] = (-x * seno + y * coseno);
        }

        for (int i = 0; i < t3.length; i++) {
            double x = t3[i][0];
            double y = t3[i][1];
            t3[i][0] = (x * coseno + y * seno);
            t3[i][1] = (-x * seno + y * coseno);
        }

        for (int i = 0; i < t4.length; i++) {
            double x = t4[i][0];
            double y = t4[i][1];
            t4[i][0] = (x * coseno + y * seno);
            t4[i][1] = (-x * seno + y * coseno);
        }

        for (int i = 0; i < t5.length; i++) {
            double x = t5[i][0];
            double y = t5[i][1];
            t5[i][0] = (x * coseno + y * seno);
            t5[i][1] = (-x * seno + y * coseno);
        }

       
    }

    public void rotar_sp(int ang) {
        double Tx = fig[0][0], Ty = fig[0][1];
        this.Trasladar(-Tx, -Ty);
        this.rotar_sentido(ang);
        this.Trasladar(Tx, Ty);

        Tx = t1[0][0];
        Ty = t1[0][1];
        this.Trasladar(-Tx, -Ty);
        this.rotar_sentido(ang);
        this.Trasladar(Tx, Ty);

        Tx = t2[0][0];
        Ty = t2[0][1];
        this.Trasladar(-Tx, -Ty);
        this.rotar_sentido(ang);
        this.Trasladar(Tx, Ty);

        Tx = t3[0][0];
        Ty = t3[0][1];
        this.Trasladar(-Tx, -Ty);
        this.rotar_sentido(ang);
        this.Trasladar(Tx, Ty);

        Tx = t4[0][0];
        Ty = t4[0][1];
        this.Trasladar(-Tx, -Ty);
        this.rotar_sentido(ang);
        this.Trasladar(Tx, Ty);

        Tx = t5[0][0];
        Ty = t5[0][1];
        this.Trasladar(-Tx, -Ty);
        this.rotar_sentido(ang);
        this.Trasladar(Tx, Ty);

      
    }

    public void Trasladar(double Tx, double Ty) {
        for (int i = 0; i < fig.length; i++) {
            fig[i][0] += Tx;
            fig[i][1] += Ty;
        }

        for (int i = 0; i < t1.length; i++) {
            t1[i][0] += Tx;
            t1[i][1] += Ty;
        }

        for (int i = 0; i < t2.length; i++) {
            t2[i][0] += Tx;
            t2[i][1] += Ty;
        }

        for (int i = 0; i < t3.length; i++) {
            t3[i][0] += Tx;
            t3[i][1] += Ty;
        }


        for (int i = 0; i < t4.length; i++) {
            t4[i][0] += Tx;
            t4[i][1] += Ty;
        }

        for (int i = 0; i < t5.length; i++) {
            t5[i][0] += Tx;
            t5[i][1] += Ty;
        }

       
    }

    public void reflex(double rx, double ry) {
        for (int i = 0; i < fig.length; i++) {
            fig[i][0] *= rx;
            fig[i][1] *= ry;
        }

        for (int i = 0; i < t1.length; i++) {
            t1[i][0] *= rx;
            t1[i][1] *= ry;
        }

        for (int i = 0; i < t2.length; i++) {
            t2[i][0] *= rx;
            t2[i][1] *= ry;
        }

        for (int i = 0; i < t3.length; i++) {
            t3[i][0] *= rx;
            t3[i][1] *= ry;
        }

        for (int i = 0; i < t4.length; i++) {
            t4[i][0] *= rx;
            t4[i][1] *= ry;
        }

       

        for (int i = 0; i < t5.length; i++) {
            t5[i][0] *= rx;
            t5[i][1] *= ry;
        }

        
    }

    public void reflex_punto(double rx, double ry) {
        double Tx = fig[0][0], Ty = fig[0][1];
        this.Trasladar(-Tx, -Ty);
        this.reflex(rx, ry);
        this.Trasladar(Tx, Ty);
    }

    public void escalar_H(double escx, double escy) {
        double Tx = fig[0][0];
        double Ty = fig[0][1];
        for (int i = 0; i < fig.length; i++) {
            fig[i][0] = (fig[i][0] * escx - Tx * escx + Tx);
            fig[i][1] = (fig[i][1] * escy - Ty * escy + Ty);
        }

        Tx = t1[0][0];
        Ty = t1[0][1];
        for (int i = 0; i < t1.length; i++) {
            t1[i][0] = (t1[i][0] * escx - Tx * escx + Tx);
            t1[i][1] = (t1[i][1] * escy - Ty * escy + Ty);
        }

        Tx = t2[0][0];
        Ty = t2[0][1];
        for (int i = 0; i < t2.length; i++) {
            t2[i][0] = (t2[i][0] * escx - Tx * escx + Tx);
            t2[i][1] = (t2[i][1] * escy - Ty * escy + Ty);
        }

        Tx = t3[0][0];
        Ty = t3[0][1];
        for (int i = 0; i < t3.length; i++) {
            t3[i][0] = (t3[i][0] * escx - Tx * escx + Tx);
            t3[i][1] = (t3[i][1] * escy - Ty * escy + Ty);
        }

        Tx = t4[0][0];
        Ty = t4[0][1];
        for (int i = 0; i < t4.length; i++) {
            t4[i][0] = (t4[i][0] * escx - Tx * escx + Tx);
            t4[i][1] = (t4[i][1] * escy - Ty * escy + Ty);
        }

        Tx = t5[0][0];
        Ty = t5[0][1];
        for (int i = 0; i < t5.length; i++) {
            t5[i][0] = (t5[i][0] * escx - Tx * escx + Tx);
            t5[i][1] = (t5[i][1] * escy - Ty * escy + Ty);
        }

        
    }

    public void reflex_H(double rx, double ry) {
        double Tx = fig[0][0];
        double Ty = fig[0][1];
        for (int i = 0; i < fig.length; i++) {
            fig[i][0] = fig[i][0] * rx - Tx * rx + Tx;
            fig[i][1] = fig[i][1] * ry - Ty * ry + Ty;
        }

        
        for (int i = 0; i < t1.length; i++) {
            t1[i][0] = t1[i][0] * rx - Tx * rx + Tx;
            t1[i][1] = t1[i][1] * ry - Ty * ry + Ty;
        }

       
        for (int i = 0; i < t2.length; i++) {
            t2[i][0] = t2[i][0] * rx - Tx * rx + Tx;
            t2[i][1] = t2[i][1] * ry - Ty * ry + Ty;
        }

    
        for (int i = 0; i < t3.length; i++) {
            t3[i][0] = t3[i][0] * rx - Tx * rx + Tx;
            t3[i][1] = t3[i][1] * ry - Ty * ry + Ty;
        }

       
        for (int i = 0; i < t4.length; i++) {
            t4[i][0] = t4[i][0] * rx - Tx * rx + Tx;
            t4[i][1] = t4[i][1] * ry - Ty * ry + Ty;
        }

  
        for (int i = 0; i < t5.length; i++) {
            t5[i][0] = t5[i][0] * rx - Tx * rx + Tx;
            t5[i][1] = t5[i][1] * ry - Ty * ry + Ty;
        }

       
    }

    public void rotacion_ch(int ang) {
        double rad = Math.toRadians(ang);
        double seno = Math.sin(rad);
        double coseno = Math.cos(rad);
        double Tx = fig[0][0];
        double Ty = fig[0][1];
        for (int i = 0; i < fig.length; i++) {
            double x = fig[i][0];
            double y = fig[i][1];
            fig[i][0] = (int) (x * coseno - y * seno - Tx * coseno + Ty * seno + Tx);
            fig[i][1] = (int) (x * seno + y * coseno - Tx * seno - Ty * coseno + Ty);
        }

       
        for (int i = 0; i < t1.length; i++) {
            double x = t1[i][0];
            double y = t1[i][1];
            t1[i][0] = (int) (x * coseno - y * seno - Tx * coseno + Ty * seno + Tx);
            t1[i][1] = (int) (x * seno + y * coseno - Tx * seno - Ty * coseno + Ty);
        }

       
        for (int i = 0; i < t2.length; i++) {
            double x = t2[i][0];
            double y = t2[i][1];
            t2[i][0] = (int) (x * coseno - y * seno - Tx * coseno + Ty * seno + Tx);
            t2[i][1] = (int) (x * seno + y * coseno - Tx * seno - Ty * coseno + Ty);
        }

        for (int i = 0; i < t3.length; i++) {
            double x = t3[i][0];
            double y = t3[i][1];
            t3[i][0] = (int) (x * coseno - y * seno - Tx * coseno + Ty * seno + Tx);
            t3[i][1] = (int) (x * seno + y * coseno - Tx * seno - Ty * coseno + Ty);
        }

        for (int i = 0; i < t4.length; i++) {
            double x = t4[i][0];
            double y = t4[i][1];
            t4[i][0] = (int) (x * coseno - y * seno - Tx * coseno + Ty * seno + Tx);
            t4[i][1] = (int) (x * seno + y * coseno - Tx * seno - Ty * coseno + Ty);
        }

       
        for (int i = 0; i < t5.length; i++) {
            double x = t5[i][0];
            double y = t5[i][1];
            t5[i][0] = (int) (x * coseno - y * seno - Tx * coseno + Ty * seno + Tx);
            t5[i][1] = (int) (x * seno + y * coseno - Tx * seno - Ty * coseno + Ty);
        }

       
    }

    public void rotacion_sh(int ang) {
        double rad = Math.toRadians(ang);
        double seno = Math.sin(rad);
        double coseno = Math.cos(rad);
        double Tx = fig[0][0];
        double Ty = fig[0][1];
        for (int i = 0; i < fig.length; i++) {
            double x = fig[i][0];
            double y = fig[i][1];
            fig[i][0] = (x * coseno + y * seno - Tx * coseno - Ty * seno + Tx);
            fig[i][1] = (-x * seno + y * coseno + Tx * seno - Ty * coseno + Ty);
        }

        for (int i = 0; i < t1.length; i++) {
            double x = t1[i][0];
            double y = t1[i][1];
            t1[i][0] = (x * coseno + y * seno - Tx * coseno - Ty * seno + Tx);
            t1[i][1] = (-x * seno + y * coseno + Tx * seno - Ty * coseno + Ty);
        }

        for (int i = 0; i < t2.length; i++) {
            double x = t2[i][0];
            double y = t2[i][1];
            t2[i][0] = (x * coseno + y * seno - Tx * coseno - Ty * seno + Tx);
            t2[i][1] = (-x * seno + y * coseno + Tx * seno - Ty * coseno + Ty);
        }

        for (int i = 0; i < t3.length; i++) {
            double x = t3[i][0];
            double y = t3[i][1];
            t3[i][0] = (x * coseno + y * seno - Tx * coseno - Ty * seno + Tx);
            t3[i][1] = (-x * seno + y * coseno + Tx * seno - Ty * coseno + Ty);
        }

        for (int i = 0; i < t4.length; i++) {
            double x = t4[i][0];
            double y = t4[i][1];
            t4[i][0] = (x * coseno + y * seno - Tx * coseno - Ty * seno + Tx);
            t4[i][1] = (-x * seno + y * coseno + Tx * seno - Ty * coseno + Ty);
        }

        for (int i = 0; i < t5.length; i++) {
            double x = t5[i][0];
            double y = t5[i][1];
            t5[i][0] = (x * coseno + y * seno - Tx * coseno - Ty * seno + Tx);
            t5[i][1] = (-x * seno + y * coseno + Tx * seno - Ty * coseno + Ty);
        }

       
    }

    public void deformar_h(double D, double C) {
        double Tx = fig[0][0];
        double Ty = fig[0][1];
        for (int i = 0; i < fig.length; i++) {
            double x = fig[i][0];
            double y = fig[i][1];
            fig[i][0] = (x + y * D - Ty * D);
            fig[i][1] = (x * C + y - Tx * C);
        }

        Tx = t1[0][0];
        Ty = t1[0][1];
        for (int i = 0; i < t1.length; i++) {
            double x = t1[i][0];
            double y = t1[i][1];
            t1[i][0] = (x + y * D - Ty * D);
            t1[i][1] = (x * C + y - Tx * C);
        }

        Tx = t2[0][0];
        Ty = t2[0][1];
        for (int i = 0; i < t2.length; i++) {
            double x = t2[i][0];
            double y = t2[i][1];
            t2[i][0] = (x + y * D - Ty * D);
            t2[i][1] = (x * C + y - Tx * C);
        }

        Tx = t3[0][0];
        Ty = t3[0][1];
        for (int i = 0; i < t3.length; i++) {
            double x = t3[i][0];
            double y = t3[i][1];
            t3[i][0] = (x + y * D - Ty * D);
            t3[i][1] = (x * C + y - Tx * C);
        }

        Tx = t4[0][0];
        Ty = t4[0][1];
        for (int i = 0; i < t4.length; i++) {
            double x = t4[i][0];
            double y = t4[i][1];
            t4[i][0] = (x + y * D - Ty * D);
            t4[i][1] = (x * C + y - Tx * C);
        }

        Tx = t5[0][0];
        Ty = t5[0][1];
        for (int i = 0; i < t5.length; i++) {
            double x = t5[i][0];
            double y = t5[i][1];
            t5[i][0] = (x + y * D - Ty * D);
            t5[i][1] = (x * C + y - Tx * C);
        }

       
    }
    double minx = 0, miny = 0, maxx = 0, maxy = 0;

    public void encminmax() {
        minx = fig[0][0];
        miny = fig[0][1];
        for (int i = 1; i < fig.length; i++) {
            if (fig[i][0] < minx) {
                minx = fig[i][0];
            }
            if (fig[i][1] < miny) {
                miny = fig[i][1];
            }

        }
        for (int i = 0; i < fig.length; i++) {
            if (fig[i][0] > maxx) {
                maxx = fig[i][0];
            }
            if (fig[i][1] > maxy) {
                maxy = fig[i][1];
            }
        }
    }
    
    
}