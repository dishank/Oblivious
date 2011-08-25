package com.oblivous.test;

import com.jme3.app.SimpleApplication;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.material.RenderState.BlendMode;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Sphere;
import com.jme3.texture.Texture;
import com.jme3.util.TangentBinormalGenerator;
import com.jme3.renderer.queue.RenderQueue.Bucket;


public class TestCube extends SimpleApplication {
  
  @Override
  public void simpleInitApp() {
	  statsView.removeFromParent();
		
		statsView.setCullHint(Spatial.CullHint.Always);
		fpsText.setCullHint(Spatial.CullHint.Always);
		
	  flyCam.setMoveSpeed(60);
    /** A simple textured cube -- in good MIP map quality. */
    Box boxshape1 = new Box(new Vector3f(-3f,1.1f,0f), 1f,1f,1f);
    Geometry cube = new Geometry("My Textured Box", boxshape1);
    Material mat_stl = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
    Texture tex_ml = assetManager.loadTexture("res/walls.png");
    mat_stl.setTexture("ColorMap", tex_ml);
    cube.setMaterial(mat_stl);
    rootNode.attachChild(cube);
    /** A translucent/transparent texture, similar to a window frame. */
    Box boxshape3 = new Box(new Vector3f(0f,0f,0f), 1f,1f,0.01f);
    Geometry window_frame = new Geometry("window frame", boxshape3);
    Material mat_tt = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
    mat_tt.setTexture("ColorMap",
        assetManager.loadTexture("Textures/ColoredTex/Monkey.png"));
    mat_tt.getAdditionalRenderState().setBlendMode(BlendMode.Alpha);
    window_frame.setMaterial(mat_tt);
    /** Objects with transparency need to be in the render bucket for transparent objects: */
    window_frame.setQueueBucket(Bucket.Transparent);
    rootNode.attachChild(window_frame);
    /** A cube with base color "leaking" through a partially transparent texture */
    Box boxshape4 = new Box(new Vector3f(3f,-1f,0f), 1f,1f,1f);
    Geometry cube_leak = new Geometry("Leak-through color cube", boxshape4);
    Material mat_tl = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
    mat_tl.setTexture("ColorMap",
        assetManager.loadTexture("res/walls.png"));
    mat_tl.setColor("Color", new ColorRGBA(1f,0f,1f, 1f)); // purple
    cube_leak.setMaterial(mat_tl);
    rootNode.attachChild(cube_leak);
    /** A bumpy rock with a shiny light effect */
    Sphere rock = new Sphere(32,32, 2f);
    Geometry shiny_rock = new Geometry("Shiny rock", rock);
    rock.setTextureMode(Sphere.TextureMode.Projected); // better quality on spheres
    TangentBinormalGenerator.generate(rock);           // for lighting effect
    Material mat_lit = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
   // mat_lit.setTexture("DiffuseMap",        assetManager.loadTexture("Textures/Terrain/Pond/Pond.png"));
  //  mat_lit.setTexture("NormalMap",        assetManager.loadTexture("Textures/Terrain/Pond/Pond_normal.png"));
    mat_lit.setFloat("Shininess", 5f); // [0,128]
    shiny_rock.setMaterial(mat_lit);
    shiny_rock.setLocalTranslation(0,2,-2); // Move it a bit
    shiny_rock.rotate(1.6f, 0, 0);          // Rotate it a bit
    rootNode.attachChild(shiny_rock);
    /** Must add a light to make the lit object visible! */
    DirectionalLight sun = new DirectionalLight();
    sun.setDirection(new Vector3f(1,0,-2).normalizeLocal());
    sun.setColor(ColorRGBA.White);
    rootNode.addLight(sun);
  }
}
