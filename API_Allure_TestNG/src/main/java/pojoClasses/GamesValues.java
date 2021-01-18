
package pojoClasses;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.print.attribute.standard.MediaSize.Other;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GamesValues implements Serializable {

	@SerializedName("id")
	@Expose
	private Integer id;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("releaseDate")
	@Expose
	private String releaseDate;
	@SerializedName("reviewScore")
	@Expose
	private Integer reviewScore;
	@SerializedName("category")
	@Expose
	private String category;
	@SerializedName("rating")
	@Expose
	private String rating;
	private final static long serialVersionUID = -4714645737710314215L;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public GamesValues() {
	}

	/**
	 *
	 * @param reviewScore
	 * @param releaseDate
	 * @param name
	 * @param rating
	 * @param id
	 * @param category
	 */
	public GamesValues(Integer id, String name, String releaseDate, Integer reviewScore, String category,
			String rating) {
		super();
		this.id = id;
		this.name = name;
		this.releaseDate = releaseDate;
		this.reviewScore = reviewScore;
		this.category = category;
		this.rating = rating;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Integer getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(Integer reviewScore) {
		this.reviewScore = reviewScore;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((releaseDate == null) ? 0 : releaseDate.hashCode());
		result = prime * result + ((reviewScore == null) ? 0 : reviewScore.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GamesValues other = (GamesValues) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;

		if (releaseDate == null) {
			if (other.releaseDate != null)
				return false;
		} else if (!checkReleaseDate(other.releaseDate, releaseDate))
			return false;
		if (reviewScore == null) {
			if (other.reviewScore != null)
				return false;
		} else if (!reviewScore.equals(other.reviewScore))
			return false;

		return true;
	}

	public boolean checkReleaseDate(String date1, String date2) {
		return getDate(date2).equals(getDate(date1));
	}

	public String getDate(String date) {
		// String date = "2021-01-13T05:37:30.804Z";

		Pattern pattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
		Matcher matcher = pattern.matcher(date);

		System.out.println(date);
		while (matcher.find()) {
			return matcher.group();
		}
		return null;
	}

	@Override
	public String toString() {
		return "UpdatingGames [id=" + id + ", name=" + name + ", releaseDate=" + releaseDate + ", reviewScore="
				+ reviewScore + ", category=" + category + ", rating=" + rating + "]";
	}

}