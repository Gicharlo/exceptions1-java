package model.entities;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer number;
	private Date checkOut;
	private Date checkIn;
	private static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public Reservation(Integer number, Date checkOut, Date checkIn) {
		this.number = number;
		this.checkOut = checkOut;
		this.checkIn = checkIn;
	}

	
	public Integer getnumber() {
		return number;
	}

	public void setnumber(Integer number) {
		this.number = number;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public Date getcheckIn() {
		return checkIn;
	}
	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		 return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		
	}
	public String upgrateDates(Date checkIn, Date checkOut) {
		
		Date now = new Date();
		
		if(checkIn.before(now) || checkOut.before(now)) {
			return "Error in reservation: Reservation dates for update must be future dates";
		}
		if (!checkOut.after(checkIn)) {
			return "Error in reservation: Check-out date must be after check-in date";
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}
	
	@Override
	public String toString() {
		return "Room" 
		+ number
		+", checkIn: "
		+ format.format(checkIn)
		+ ", checkOut:"
		+ format.format(checkOut)
		+ ", "
		+ duration()
		+ " nights";
		
	
	}
	
}
