package dataparser;

import java.util.List;

public class Team {

	private int id;
	private String name;
	private List<Activity> activities;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public Activity getActivityByIndex(int id) {
		return activities.get(id);
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public int getTotalPoints() {
		int points = 0;
		for (int i = 0; i < activities.size(); i++) {
			points += activities.get(i).getPoints();
		}
		return points;
	}

	@Override
	public String toString() {
		return "{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", activities=" + activities + '}';
	}
}
