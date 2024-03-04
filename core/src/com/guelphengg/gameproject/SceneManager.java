package com.guelphengg.gameproject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.guelphengg.gameproject.scenes.Scene;
import com.guelphengg.gameproject.util.AdvancedShapeRenderer;

public class SceneManager {

  private static OrthographicCamera camera;
  private static SpriteBatch batch;
  private static AdvancedShapeRenderer shapeRenderer;

  public static void init() {
    camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    camera.update();

    batch = new SpriteBatch();
    batch.setProjectionMatrix(camera.combined);

    shapeRenderer = new AdvancedShapeRenderer();
    shapeRenderer.setProjectionMatrix(camera.combined);
  }

  public static Scene getCurrentScene() {
    return Accessor.getGameManager().getState().getScene();
  }

  public static OrthographicCamera getCamera() {
    return camera;
  }

  public static AdvancedShapeRenderer getShapeRenderer() {
    return shapeRenderer;
  }

  public static SpriteBatch getSpriteBatch() {
    return batch;
  }

  public static float getViewWidth() {
    return camera.viewportWidth;
  }

  public static float getViewHeight() {
    return camera.viewportHeight;
  }

  public static void dispose() {
    shapeRenderer.dispose();
    batch.dispose();
  }
}