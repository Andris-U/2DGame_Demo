package launcher;

import display.Display;
import gfx.Assets;
import gfx.ImageLoader;
import gfx.SpriteSheet;
import handler.Handler;
import input.KeyManager;
import states.GameState;
import states.MenuState;
import states.State;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {
    private Display display;
    public int width, height;
    public String title;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    private BufferedImage testImage;
    private SpriteSheet sheet;

    // States
    private State gameState;
    private State menuState;

    // Input
    private KeyManager keyManager;

    // Handler
    private Handler handler;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
    }

    private void init(){
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();

        // handler takes a Game object
        handler = new Handler(this);

        gameState = new GameState(handler);
        menuState = new MenuState(handler);
        State.setState(gameState);
    }


    private void tick(){
        keyManager.tick();

        if(State.getCurrentState() != null){
            State.getCurrentState().tick();
        }
    }

    // Uses bs to avoid flickering through buffering hidden screen
    // Set Graphics object. Used to 'draw' on the canvas.
    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        // Clear Screen
        g.clearRect(0,0, width, height);

        // draw here
        if(State.getCurrentState() != null){
            State.getCurrentState().render(g);
        }
        // ned drawing

        bs.show();
        g.dispose();
    }

    // Main game loop
    @Override
    public void run() {
        init();

        int fps = 60;
        // One second as NANOSECONDS divided by fps. Will set max time permitted to execute a tick()
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        // Current time in our machine measured in nanoseconds.
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while(running){
//             Ok, so... delta is the point in time between the last tick and the next according to
//             the timePerTick that we set, expressed as a double between 0 and 1. We do this to accurately
//             represent the FPS using the local machine's internal clock.
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;
            timer += now - lastTime;

            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }

            if(timer >= 1000000000){
//                System.out.println("Ticks and Frames: " + ticks);
//                ticks = 0;
//                timer = 0;
            }
        }
        stop();
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    // When executed creates a new thread for our launcher, thus separating the process into a 'sub-program.'
    // Impact on performance on larger games.
    public synchronized void start(){
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized  void stop(){
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Display getDisplay() {
        return display;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getTitle() {
        return title;
    }
}
