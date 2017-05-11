package model;

public class Vibration {

	private long duration;
	private long intensity;
	private long interval;
	private long repeat;

	public Vibration() {
		super();
	}

	public Vibration(long duration, long intensity, long interval, long repeat) {
		super();
		this.duration = duration;
		this.intensity = intensity;
		this.interval = interval;
		this.repeat = repeat;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public long getIntensity() {
		return intensity;
	}

	public void setIntensity(long intensity) {
		this.intensity = intensity;
	}

	public long getInterval() {
		return interval;
	}

	public void setInterval(long interval) {
		this.interval = interval;
	}

	public long getRepeat() {
		return repeat;
	}

	public void setRepeat(long repeat) {
		this.repeat = repeat;
	}
	
	public String toJson(){
		StringBuilder json = new StringBuilder();
		json.append(" { ");
		json.append("\"duration\" : "+duration+" , ");
		json.append("\"intensity\" : "+intensity+" , ");
		json.append("\"interval\" : "+interval+" , ");
		json.append("\"repeat\" : "+repeat+"");
		json.append(" } ");
		return json.toString();
	}

	@Override
	public String toString() {
		return "Vibration [duration=" + duration + ", intensity=" + intensity + ", interval=" + interval + ", repeat="
				+ repeat + "]";
	}
	
}
