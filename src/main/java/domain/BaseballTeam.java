package domain;

import java.util.Date;

/**
 * 野球チームのドメインクラス
 * 
 * @author nonaa
 *
 */
public class BaseballTeam {
	/** 名前 */
	private String name;
	/** 本拠地 */
	private String place;
	/** 発足 */
	private Date establishmentDate;
	/** 歴史 */
	private String history;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Date getEstablishmentDate() {
		return establishmentDate;
	}

	public void setEstablishmentDate(Date establishmentDate) {
		this.establishmentDate = establishmentDate;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	@Override
	public String toString() {
		return "BaseballTeam [name=" + name + ", place=" + place + ", establishmentDate=" + establishmentDate
				+ ", history=" + history + "]";
	}

}
