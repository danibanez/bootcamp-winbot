package dataparser;

import java.util.List;

public class Teamdata {

	private List<Team> teamdata;

	public List<Team> getTeamdata() {
		return teamdata;
	}

	public void setTeamdata(List<Team> teams) {
		this.teamdata = teams;
	}

	public void addTeamdata(Team team) {
		if (team != null)
			this.teamdata.add(team);
	}

	public Team getTeamdataByIndex(int id) {
		return teamdata.get(id);
	}

	@Override
	public String toString() {
		return "{teamdata\':" + teamdata.toString() + '}';
	}

}
