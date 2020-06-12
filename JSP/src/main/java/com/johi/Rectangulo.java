package com.johi;

/**
 * @Author: Hilario
 * @Version: 1.0
 * Date: 03/06/2020
 **/
public class Rectangulo {

    private int base;
    private int altura;

    public Rectangulo() { }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getArea() {
        return this.base * this.altura;
    }
}
