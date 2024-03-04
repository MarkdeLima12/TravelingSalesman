package com.guelphengg.gameproject.scenes.scenecomponents;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.guelphengg.gameproject.SceneManager;

public class GameGrid {
  private final int cornerY;
  private final int cornerX;
  private final int gridHeight;
  private final int gridWidth;
  private final int boxesX;
  private final int boxesY;

  public GameGrid(int h, int w, int x, int y, int boxesX, int boxesY) {
    // Grid is 90% the height of the window
//    this.gridHeight = this.gridWidth = (int) (SceneManager.getViewHeight() * 0.9);
    this.gridHeight = h;
    this.gridWidth = w;

    // Calculate best spot for grid
    // Logic that determines where the grid should actually get displayed
    this.cornerX = x;
    this.cornerY = y;

    this.boxesX = boxesX;
    this.boxesY = boxesY;
  }

  // height of an individual box on the grid
  public int getBoxHeight() {
    return this.gridHeight / boxesY;
  }

  // width of an individual box on the grid
  public int getBoxWidth() {
    return this.gridWidth / boxesX;
  }

  public void renderTextureInGrid(int x, int y, Texture texture) {
    renderTextureInGrid(x, y, texture, 1, 0, 0);
  }

  public void renderTextureInGrid(int x, int y, Texture texture, double scale, int xOffset, int yOffset) {
    final SpriteBatch batch = SceneManager.getSpriteBatch();

    batch.begin();
    batch.draw(texture, (this.cornerX + (x * getBoxWidth())) + xOffset, (this.cornerY + (y * getBoxHeight())) + yOffset, (float) (getBoxWidth() * scale), (float) (getBoxHeight() * scale));
    batch.end();
  }

  public void renderTextureInGrid(int x, int y, TextureRegion texture) {
    renderTextureInGrid(x, y, texture, 1, 0, 0);
  }

  public void renderTextureInGrid(int x, int y, TextureRegion texture, double scale, int xOffset, int yOffset) {
    final SpriteBatch batch = SceneManager.getSpriteBatch();

    batch.begin();
    batch.draw(texture, (this.cornerX + (x * getBoxWidth())) + xOffset, (this.cornerY + (y * getBoxHeight())) + yOffset, (float) (getBoxWidth() * scale), (float) (getBoxHeight() * scale));
    batch.end();
  }

  public void renderRectInGrid(int x, int y, Color color) {
    renderRectInGrid(x, y, color, 1, 0, 0);
  }

  public void renderRectInGrid(int x, int y, Color color, double scale, int xOffset, int yOffset) {
    final ShapeRenderer shapeRenderer = SceneManager.getShapeRenderer();

    // This enables transparency
    Gdx.gl.glEnable(GL20.GL_BLEND);

    shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
    shapeRenderer.setColor(color);
    shapeRenderer.rect((this.cornerX + (x * getBoxWidth())) + xOffset ,(this.cornerY + (y * getBoxHeight())) + yOffset,  (float) (getBoxWidth() * scale), (float) (getBoxHeight() * scale));
    shapeRenderer.end();
  }

  public int getCornerX() {
    return cornerX;
  }

  public int getCornerY() {
    return cornerY;
  }

  public int getGridHeight() {
    return gridHeight;
  }

  public int getGridWidth() {
    return gridWidth;
  }

  public void renderGrid(Color color) {
    final ShapeRenderer shapeRenderer = SceneManager.getShapeRenderer();

    shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
    shapeRenderer.setColor(color);

    Gdx.gl.glLineWidth(3);


    // TODO more hard coded 10 by 10 logic
    // Horizontal Lines
    for (int i = 0; i <= boxesY; i++) {
      shapeRenderer.line(this.cornerX, this.cornerY + (getBoxHeight() * i), this.cornerX + this.gridWidth, this.cornerY + (getBoxHeight() * i));
    }

    // Vertical Lines
    for (int i = 0; i <= boxesX; i++) {
      shapeRenderer.line(this.cornerX + (getBoxWidth() * i), this.cornerY, this.cornerX + (getBoxWidth() * i), this.cornerY + this.gridHeight);
    }

    shapeRenderer.end();
  }
}