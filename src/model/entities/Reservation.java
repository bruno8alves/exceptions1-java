package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private int roomNumber;
	private Date checkin;
	private Date checkout;
	
	
	public long duration() {
		long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkin, Date checkout) {
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	@Override
	public String toString() {
		return "Room: "
				+ roomNumber
				+ ", check-in: "
				+ sfd.format(checkin)
				+ ", check-out: "
				+ sfd.format(checkout)
				+ ", dutation "
				+ duration()
				+ " nights.";
	}
	
	private static SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public Reservation(int roomNumber, Date checkin, Date checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Reservation() {
	}

	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Date getCheckin() {
		return checkin;
	}
	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}
	public Date getCheckout() {
		return checkout;
	}
	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}

	
}
