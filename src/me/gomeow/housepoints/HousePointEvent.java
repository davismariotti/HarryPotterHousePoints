package me.gomeow.housepoints;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class HousePointEvent extends Event {
	
	private static HandlerList handlers = new HandlerList();
	private final House house;
	private final boolean upDown;
	private final int points;

	public HousePointEvent(House house, int points, boolean upDown) {
		this.points = points;
		this.house = house;
		this.upDown = upDown;
	}
	
	public boolean getUpDown() {
		return upDown;
	}
	
	public int getPoints() {
		return points;
	}
	
	public House getHouse() {
		return house;
	}
	
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
	public static HandlerList getHandlerList() {
		return handlers;
	}
	
}
