package game.henry.game;

/**
 * @author henry www.riabbs.com
 * 
 * @version 1.0
 */
abstract public class GameLoop {

	boolean loopPause;
	long startTime;
	long currTime;
	boolean paintting = true;

	int framePerSec = 0;

	public GameLoop() {
	}

	public void pauseLoop() {
		loopPause = true;
	}

	public void continueLoop() {
		currTime = System.currentTimeMillis();
		loopPause = false;
	}

	public void timeloop() {
		final int TimeInterval = 10;
		startTime = System.currentTimeMillis();
		currTime = startTime;
		final int elapsedTime = 10; // 这不是精确的时间只是假设每次循环后经过了elapsedTime长的时间
		try {
			long loopstart = System.currentTimeMillis();
			int framecout = 0;
			while (true) {
				if (loopPause) {
					Thread.sleep(TimeInterval);
					continue;
				}
				// elapsedTime = System.currentTimeMillis() -
				// currTime;//这样是精确的时间但在cpu较慢的情况下容易出错
				// currTime = System.currentTimeMillis();
				updateModel(elapsedTime);
				//
				// if (!paintting) {
				// Thread.sleep(TimeInterval);
				// continue;
				// }
				// if (paintListener != null) {
				// paintListener.updatePaint();
				// }
				Thread.sleep(TimeInterval);
				// --------------------------------------
				framecout++; // 用于frame计数统计
				if (System.currentTimeMillis() - loopstart > 1000) {
					this.framePerSec = framecout;
					framecout = 0;
					loopstart = System.currentTimeMillis();
				}
				// --------------------------------------
			}
		} catch (InterruptedException ex) {
		}
	}

	public int getFramePerSec() {
		return framePerSec;
	}

	protected abstract void updateModel(long elapsedTime);

	public boolean isLoopPause() {
		return loopPause;
	}

	// public void setPaintting(boolean paintting) {
	// this.paintting = paintting;
	// }
	//
	// public boolean isPaintting() {
	// return paintting;
	// }
}
