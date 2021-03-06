package com.friendlygirl.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Puntos extends Actor {

    private BitmapFont font;
    private int puntos;
    private Vector2 posicion;

    public Puntos(Vector2 posicion) {
        font = new BitmapFont(Gdx.files.internal("fuentes/font.fnt"), Gdx.files.internal("fuentes/font.png"), false);
        puntos = 0;
        this.posicion = posicion;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        font.draw(batch, "Puntos: " + puntos, posicion.x, posicion.y);
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public Vector2 getPosicion() {
        return posicion;
    }

    public void setPosicion(Vector2 posicion) {
        this.posicion = posicion;
    }
}
