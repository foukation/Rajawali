package c.org.rajawali3d.scene;

import c.org.rajawali3d.annotations.GLThread;

/**
 * Interface for receiving frame callbacks from {@link org.rajawali3d.scene.Scene}. The timing of this interface
 * assumes that the rendering time does not affect the timing of operations before and after the frame. Pre- and
 * Post- operations are provided because of how these tie in with the animation system. Pre- tasks will be executed
 * prior to animation updates. Post- tasks will be executed after all drawing has occurred.
 *
 *
 * {@link #callPreFrame()} and {@link #callPostFrame()} frame exist to simplify interfacing to Rajawali's frame task
 * system. By default they both return {@code false}, signalling that the callback should be ignored by the scene.
 * Implementing classes must override these methods to return {@code true} as appropriate for the tasks they are
 * handling.
 *
 * @author Jared Woolston (Jared.Woolston@gmail.com)
 */
public interface SceneFrameCallback {

    /**
     * Pre frame handling callback. This will be called prior to any camera or animation updates in the scene.
     *
     * @param sceneTime {@code long} Rendering elapsed time in nanoseconds.
     * @param deltaTime {@code double} Time passed since last frame in seconds.
     */
    @GLThread
    void onPreFrame(long sceneTime, double deltaTime);

    /**
     * Pre frame render callback. This will be called after any camera or animation updates in the scene but
     * before rendering.
     *
     * @param sceneTime {@code long} Rendering elapsed time in nanoseconds.
     * @param deltaTime {@code double} Time passed since last frame in seconds.
     */
    @GLThread
    void onPreDraw(long sceneTime, double deltaTime);

    /**
     * Post frame render callback. Called after all frame drawing has completed, including plugins.
     *
     * @param sceneTime {@code long} Rendering elapsed time in nanoseconds.
     * @param deltaTime {@code double} Time passed since last frame in seconds.
     */
    @GLThread
    void onPostFrame(long sceneTime, double deltaTime);

    /**
     * Should this be registered as a pre-frame callback.
     *
     * @return {@code boolean} True if this is a pre-frame callback implementation.
     */
    boolean callPreFrame();

    /**
     * Should this be registered as a pre-draw callback.
     *
     * @return {@code boolean} True if this is a pre-draw callback implementation.
     */
    boolean callPreDraw();

    /**
     * Should this be registered as a post-frame callback.
     *
     * @return {@code boolean} True if this is a post-frame callback implementation.
     */
    boolean callPostFrame();
}