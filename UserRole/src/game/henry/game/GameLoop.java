package game.henry.game;

/**
 * @author henry www.riabbs.com
 * 
 * @version 1.0
 */
abstract public class GameLoop {
	//暂停
	boolean loopPause;
	//统计刷屏次数，？？是否关联关次？
	int framePerSec = 0;

	public GameLoop() {
	}

	public void pauseLoop() {
		loopPause = true;
	}

	public void continueLoop() {
		loopPause = false;
	}

	/**
	 * 此方法描述的是：死循环滚屏
	 * @version 创建时间：Sep 21, 2010 3:17:14 PM 
	 * void
	 */
	public void timeloop() {
		//间隔刷新屏幕时间
		final int TimeInterval = 10;
		//移动时间
		final int elapsedTime = 10; // 这不是精确的时间只是假设每次循环后经过了elapsedTime长的时间
		try {
			long loopstart = System.currentTimeMillis();
			int framecout = 0;
			while (true) {
				//暂停
				if (loopPause) {
					Thread.sleep(TimeInterval);
					continue;
				}
				//待变化的panel
				updateModel(elapsedTime);
				Thread.sleep(TimeInterval);
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
}
