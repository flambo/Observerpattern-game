package horseGame;

public class HorizontalRunStrategy extends RunningStrategy{

	@Override
	public void play(Horse horse) {
		horse.setInterval(Horse.INTERVAL, 0);
		
	}

	

}
